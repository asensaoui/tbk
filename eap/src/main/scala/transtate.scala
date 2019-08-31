package eap

import chisel3._
import chisel3.util._
import scala.collection.mutable.ArrayBuffer


class transtate extends Module  with ToubkalCoreParams{
  val io = IO(new Bundle {
    // inputs
    val currentState								= Input(UInt(4.W))
    val transtate										= Input(UInt(4.W))
    val monitorEn 									= Input(UInt(1.W))
    // val execMode 								= Input(UInt(1.W))
    // val Daddr 									= Input(UInt(isoMAddrWidth.W))
    // val Ddata 									= Input(UInt(dataWidth.W))
    // val write                   = Input(UInt(1.W))

    // outputs TestOnly
    val newState 								= Output(UInt(4.W))
    // val out           					= Output(Bool())
  })



  val oldstate = io.currentState
  val state = io.transtate
  val nextstate = Wire(UInt())



  nextstate := State.sKill


  switch (oldstate) {
        is (State.sRomEnt) {
          switch (state) {
            is (State.sRomIn) {
              nextstate := State.sRomIn
            }
            is (State.sRomEnt) {
              nextstate := State.sRomEnt
            } 
          }
        }

        is (State.sRomIn) {
          switch(state) {
            is (State.sMonitorIn) {
              nextstate := State.sMonitorIn
            }
            is (State.sRomIn) {
              nextstate := State.sMonitorIn
            }
            is (State.sNone) {
              when (!io.monitorEn) {
                nextstate := State.sNone
              }
            }
          }
        }

        is (State.sMonitorEnt) {
          switch(state) {
            is (State.sMonitorIn) {
              nextstate := State.sMonitorIn
            }
            is (State.sDzoneIn) {
                nextstate := State.sDzoneIn
            }
            is (State.sNone) {
                nextstate := State.sNone
            }
            is (State.sMonitorEnt) {
              nextstate := State.sMonitorEnt
            }
          }
        }

        is (State.sMonitorIn) {
          switch(state) {
            is (State.sMonitorIn) {
              nextstate := State.sMonitorIn
            }
            is (State.sMonitorEnt) {
                nextstate := State.sMonitorEnt
            }
            is (State.sRomIn) {
                nextstate := State.sRomIn
            }
          }
        }

        is (State.sDzoneEnt) {
          switch(state) {
            is (State.sDzoneIn) {
                nextstate := State.sDzoneIn
            }
            is (State.sNone) {
                nextstate := State.sNone
            }
            is (State.sDzoneEnt) {
                nextstate := State.sDzoneEnt
            }
          }
        }

        is (State.sDzoneIn) {
          switch(state) {
            is (State.sDzoneEnt) {
              nextstate := State.sDzoneEnt
            }
            is (State.sDzoneIn) {
                nextstate := State.sDzoneIn
            }
            is (State.sMonitorEnt) {
                nextstate := State.sMonitorEnt
            }
          }
        }

        is (State.sNone) {
          switch(state) {
            is (State.sMonitorEnt) {
              nextstate := State.sMonitorEnt
            }
            is (State.sDzoneEnt) {
                nextstate := State.sDzoneEnt
            }
            is (State.sNone) {
                nextstate := State.sNone
            }
          }
        }
      }


      io.newState := nextstate



  
  def debugstate (pstate: UInt) = {
      switch (pstate) {
        is (State.sRomEnt) {
          printf(p"sRomEnt\n")
        }

        is (State.sRomIn) {
          printf(p"sRomIn\n")
        }

        is (State.sMonitorEnt) {
          printf(p"sMonitorEnt\n")
        }

        is (State.sMonitorIn) {
          printf(p"sMonitorIn\n")
        }

        is (State.sDzoneEnt) {
          printf(p"sDzoneEnt\n")
        }

        is (State.sDzoneIn) {
          printf(p"sDzoneIn\n")
        }

        is (State.sNone) {
          printf(p"sNone\n")
        }

        is (State.sKill) {
          printf(p"sKill\n")
        }
      }
  } 
  
  // printf(p"oldstate = ")
  // debugstate(oldstate)
  // printf(p"attempt state = ")
  // debugstate(state)
  // printf(p"next state = ")
  // debugstate(nextstate)


  // Data memory access control
  /* pc = sKill -> reset here, require hard reset, now just io.out -> 0 */

  /* Security monitor has access to everthing */

  


}