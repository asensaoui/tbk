package eap

import chisel3._
import chisel3.util._
import scala.collection.mutable.ArrayBuffer




/* Execution Aware Protection
 * 
 * This module is a PC based memory protection, its main goal is to isolate the security monitor and to create other zones 
 *
 * 0xAAAA0000 config address
 * 0xAAAA1000 Key address
 *
 */

 object State extends Enum {
  val sInit :: sRomEnt :: sRomIn :: sMonitorEnt :: sMonitorIn :: sDzoneEnt :: sDzoneIn :: sNone :: sKill :: Nil = Enum(9)
}

 trait ToubkalCoreParams {
    // General Params
  def archiWidth: Int     = 32
  def dataWidth: Int     = 32
  def isoMAddrWidth: Int  = 27
  // def bit_protection: Int = 0

  // Masters Params
  def nMasters: Int       = 4
  def masterIdWidth: Int  = nMasters
  def nMlb: Int           = 4
  def mlbWidth: Int       = log2Ceil(nMlb)
}


 class eap extends Module  with ToubkalCoreParams{
  val io = IO(new Bundle {
    // inputs
    val pc 											= Input(UInt(isoMAddrWidth.W))
    // val execMode 								= Input(UInt(1.W))
    val dAddr 									= Input(UInt(isoMAddrWidth.W))
    // val Ddata 									= Input(UInt(dataWidth.W))
    // val write                   = Input(UInt(1.W))

    // outputs TestOnly
    val securityMonitorMode 		= Output(UInt(1.W))
    val out           					= Output(Bool())
  })

  // Rom Config
  val romEntry 	      = 0.U
  val romStart 	      = "h4".U
  val romEnd	 	      = "h200".U
  
  // val romMemoryStart  = RegInit(UInt(27.W), 0.U)
  // val romMemoryEnd    = RegInit(UInt(27.W), 0.U)

  // Security Monitor Config
  val monitorEntry 	= RegInit(UInt(27.W), "h200".U)
  val monitorStart 	= RegInit(UInt(27.W), "h300".U)
  val monitorEnd	 	= RegInit(UInt(27.W), "h800".U)
  val monitorEn 	 	= RegInit(UInt(1.W), 1.U)

  val smMemoryStart = RegInit(UInt(27.W), "h8000".U)
  val smMemoryEnd   = RegInit(UInt(27.W), "hA000".U)

  // D-zones Config
  val secureZoneEntry 	= RegInit(UInt(27.W), "h800".U)
  val secureZoneStart 	= RegInit(UInt(27.W), "hA00".U)
  val secureZoneEnd		 	= RegInit(UInt(27.W), "h1000".U)
  val secureZoneEn      = RegInit(UInt(1.W), 0.U)

  val szMemoryStart     = RegInit(UInt(27.W), "hA000".U)
  val szMemoryEnd       = RegInit(UInt(27.W), "h10000".U)

  // Attestation Key Ksm
  val attestationKey = 0.U

  // God mode Signal
  val fAuthSignal = RegInit(UInt(1.W), 0.U)


  // addr memory mapping Signal
  val ioaddr = io.dAddr// >> 16.U
  val pc = io.pc

  val runState  = RegInit(State.sRomEnt)
  val oldState    = WireInit(UInt(),0.U)
  val state     = WireInit(UInt(),0.U)


  // modules def 
  val transtate = Module(new transtate)

  // Comparator
  def addrMatch(addrIn: UInt, addrConf: UInt, addrEnd: UInt): Bool = {
    (addrIn >= addrConf) && (addrIn < addrEnd) 
  }


  // printf(p"pc = $pc\n")
  // printf(p"mem access = $ioaddr\n")

  when(addrMatch(pc, romEntry, romStart)) {
    state := State.sRomEnt
  }.elsewhen (addrMatch(pc, romStart, romEnd)) {
    state := State.sRomIn
  }.elsewhen(addrMatch(pc, monitorEntry, monitorStart)) {
    state := State.sMonitorEnt
  }.elsewhen(addrMatch(pc, monitorStart, monitorEnd)) {
    state := State.sMonitorIn
  }.elsewhen(addrMatch(pc, secureZoneEntry, secureZoneStart)) {
    state := State.sDzoneEnt
  }.elsewhen(addrMatch(pc, secureZoneStart, secureZoneEnd)) {
    state := State.sDzoneIn
  }.otherwise {
    state := State.sNone
  }
  

  // Call transtate to detect non-authorized transitions
  transtate.io.currentState := runState
  transtate.io.transtate    := state
  transtate.io.monitorEn    := monitorEn
  val tempostate            = transtate.io.newState

  oldState    := runState 
  runState    := tempostate




  // Data access control

  // dAddr is in szMemory
  val dAddr_is_smMem            = addrMatch(ioaddr, smMemoryStart, smMemoryEnd)
  val dAddr_is_not_smMem        = !dAddr_is_smMem

  // is in szMemory
  val dAddr_is_szMem            = addrMatch(ioaddr, szMemoryStart, szMemoryEnd)
  val dAddr_is_not_szMem        = !dAddr_is_szMem

  // security monitor confidentiality
  val dAddr_is_rootCode          = addrMatch(pc, romStart, romEnd)
  val dAddr_is_not_rootCode      = !dAddr_is_rootCode
  val dAddr_is_monitorCode       = addrMatch(pc, monitorStart, monitorEnd)
  val dAddr_is_not_monitorCode   = !dAddr_is_monitorCode

  // SZ code confidentiality
  val dAddr_is_szCode            = addrMatch(pc, secureZoneStart, secureZoneEnd)
  val dAddr_is_not_szCode        = !dAddr_is_szMem

  // Disabled by default
  io.securityMonitorMode := false.B
  io.out := false.B


  printf(p"tempostate = $tempostate\n")

  switch (tempostate) {
    // No need to add sKill case, we only process sucess cases, otherwise not success
    // is (State.sKill) {
    //   io.out := false.B
    //   io.securityMonitorMode := false.B
    // }
    is (State.sRomEnt) {
      io.out := true.B
      io.securityMonitorMode := true.B
    }
    is (State.sRomIn) {
      io.out := true.B
      io.securityMonitorMode := true.B
    }
    is (State.sMonitorIn) {
      io.out := true.B
      io.securityMonitorMode := true.B
    }
    is (State.sDzoneIn) {
      when (dAddr_is_szMem && dAddr_is_not_rootCode && dAddr_is_not_monitorCode) {
        io.out := true.B
      }
    }
    is (State.sMonitorEnt) {
      when(dAddr_is_not_szMem && dAddr_is_not_smMem && (oldState === State.sNone)) {
        io.out := true.B
      }.elsewhen(dAddr_is_szMem && dAddr_is_not_smMem && (oldState === State.sDzoneIn)) {
        io.out := true.B
      }.elsewhen(dAddr_is_not_smMem && (oldState === State.sMonitorIn)){
        io.out := true.B
      }
    }
    is (State.sDzoneEnt) {
      when(dAddr_is_not_szMem && dAddr_is_not_smMem && (oldState === State.sNone)) {
        io.out := true.B
      }.elsewhen(dAddr_is_szMem && dAddr_is_not_smMem && (oldState === State.sDzoneIn)) {
        io.out := true.B
      }
    }
    is (State.sNone) {
      when(dAddr_is_not_smMem && dAddr_is_not_szMem && dAddr_is_not_rootCode && dAddr_is_not_monitorCode &&dAddr_is_not_szCode) {
        io.out := true.B
      }
    }
  }

  when(io.out === false.B) {
    runState := State.sKill
  }


  // Data memory access control
  /* pc = sKill -> reset here, require hard reset, now just io.out -> 0 */

  /* Security monitor has access to everthing */

  

  // pcIn to know where are we rom 3, monitor 2, or D-zones 1, otherwise 0 

  // Data Agent
  // def Dagent(pcIn: UInt, addr: UInt, data: UInt) = {

  //   when((ioaddr === "0xAAAA".U) && ((pcIn === 3.U))) {
  //     when (addr === "0xAAAA0000".U) { // SMEntry
  //       // start 
  //       when (io.write === true.B) {
  //         monitorEntry := data
  //       }.elsewhen (io.write === false.B) {
  //         data := monitorEntry
  //       }
  //       // end
  //     }.elsewhen (addr === "0xAAAA0004".U) { // SMStart
  //       // start 
  //       when (io.write === true.B) {
  //         monitorStart := data
  //       }.elsewhen (io.write === false.B) {
  //         data := monitorStart
  //       }
  //       // end
  //     }.elsewhen (addr === "0xAAAA0008".U) { // SMEnd
  //       // start 
  //       when (io.write === true.B) {
  //         monitorEnd := data
  //       }.elsewhen (io.write === false.B) {
  //         data := monitorEnd
  //       }
  //       // end
  //     }.elsewhen (addr === "0xAAAA000C".U) { // SMEn
  //       // start 
  //       when (io.write === true.B) {
  //         monitorEn := data
  //       }.elsewhen (io.write === false.B) {
  //         data := monitorEn
  //       }
  //       // end
  //     }.elsewhen (addr === "0xAAAA0010".U) { // SZEntry
  //       // start 
  //       when (io.write === true.B) {
  //         secureZoneEntry := data
  //       }.elsewhen (io.write === false.B) {
  //         data := secureZoneEntry
  //       }
  //       // end
  //     }.elsewhen (addr === "0xAAAA0014".U) { // SZStart
  //       // start 
  //       when (io.write === true.B) {
  //         secureZoneStart := data
  //       }.elsewhen (io.write === false.B) {
  //         data := secureZoneStart
  //       }
  //       // end
  //     }.elsewhen (addr === "0xAAAA0018".U) { // SZEnd
  //       // start 
  //       when (io.write === true.B) {
  //         secureZoneEnd := data
  //       }.elsewhen (io.write === false.B) {
  //         data := secureZoneEnd
  //       }
  //       // end
  //     }.elsewhen (addr === "0xAAAA001C".U) { // SZEn
  //       // start 
  //       when (io.write === true.B) {
  //         secureZoneEn := data
  //       }.elsewhen (io.write === false.B) {
  //         data := secureZoneEn
  //       }
  //       // end
  //     }  
  //     // End of configuration
  //   }.otherwise { // check if there is a non-authorized data access
  //     // TODO
  //     when (((addrMatch(addr, smMemoryStart, smMemoryEnd) && (pcIn != 2 || pcIn != 3)) || (addrMatch(addr, romMemoryStart, romMemoryEnd && pcIn != 3))) 
  //       || (addrMatch(addr, szMemoryStart, szMemoryEnd) && pcIn === 0)) {
  //       io.out := 0.U
  //     }
  //   }

  // }


  


  // Start EAP processing




}


object eapDriver extends App {

  chisel3.Driver.execute(args, () => new eap) 
}