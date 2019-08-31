  // state machine
  // switch (oldstate) {
  //   is (State.sRomEnt) {
  //     when (addrMatch(pc, romStart, romEnd)) {
  //       state := State.sRomIn
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, romEntry, romStart)){
  //       state := oldstate
  //     }.otherwise{
  //       state := State.sKill
  //       oldstate := state
  //     }
      
  //   }

  //   is (State.sRomIn) {
  //     when (addrMatch(pc, romStart, romEnd)) {
  //       state := oldstate
  //     }.elsewhen ( (addrMatch(pc, monitorStart, monitorEnd))) {
  //       state := State.sMonitorIn
  //       oldstate := state
  //     }.elsewhen (!monitorEn && !addrMatch(pc, romEntry, romEnd)) {
  //       state := State.sNone
  //       oldstate := state
  //     }.otherwise{
  //       state := State.sKill
  //       oldstate := state
  //     }
      
  //   }

  //   is (State.sMonitorEnt) {
  //     when (addrMatch(pc, monitorEntry, monitorStart)) {
  //       state := oldstate
  //     }.elsewhen (addrMatch(pc, monitorStart, monitorEnd)) {
  //       state := State.sMonitorIn
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, secureZoneStart, secureZoneEnd)) {
  //       state := State.sDzoneEnt
  //       oldstate := state
  //     }.elsewhen (!addrMatch(pc, romEntry, romEnd) && !addrMatch(pc, secureZoneEntry, secureZoneEnd) && !addrMatch(pc, monitorEntry, monitorEnd)) {
  //       state := State.sNone
  //       oldstate := state
  //     }.otherwise{
  //       state := State.sKill
  //       oldstate := state
  //     }
      
  //   }

  //   is (State.sMonitorIn) {
  //     when (addrMatch(pc, romStart, romEnd)) {
  //       state := State.sRomIn
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, secureZoneStart, secureZoneEnd)) {
  //       state := State.sDzoneIn
  //       oldstate := state
  //     }.elsewhen (!addrMatch(pc, romEntry, romEnd) && !addrMatch(pc, monitorEntry, monitorEnd)) {
  //       state := State.sKill
  //       oldstate := state
  //     }.elsewhen(addrMatch(pc, monitorEntry, monitorStart)) {
  //       state := State.sMonitorEnt
  //       oldstate := state
  //     }.otherwise{
  //       state := oldstate
  //     }
      
  //   }

  //   is (State.sDzoneEnt) {
  //     when (addrMatch(pc, secureZoneStart, secureZoneEnd)) {
  //       state := State.sDzoneIn
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, romStart, romEnd) || addrMatch(pc, monitorStart, monitorEnd)) {
  //       state := State.sKill
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, monitorEntry, monitorStart)){
  //       state := State.sMonitorEnt
  //       oldstate := state
  //     }.elsewhen (!addrMatch(pc, romEntry, romEnd) && !addrMatch(pc, secureZoneEntry, secureZoneEnd) && !addrMatch(pc, monitorEntry, monitorEnd)) {
  //       state := State.sNone
  //       oldstate := state
  //     }.otherwise{
  //       state := oldstate
  //     }
      
  //   }

  //   is (State.sDzoneIn) {
  //     when (addrMatch(pc, romStart, romEnd) || addrMatch(pc, monitorStart, monitorEnd)) {
  //       state := State.sKill
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, monitorEntry, monitorStart)) {
  //       state := State.sMonitorEnt
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, secureZoneStart, secureZoneEnd)) {
  //       state := State.sDzoneEnt
  //       oldstate := state
  //     }.otherwise{
  //       state := oldstate
  //     }
      
  //   }

  //   is (State.sNone) {
  //     when (addrMatch(pc, romEntry, romEnd) || addrMatch(pc, monitorStart, monitorEnd) || addrMatch(pc, secureZoneStart, secureZoneEnd)) {
  //       state := State.sKill
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, monitorEntry, monitorStart)) {
  //       state := State.sMonitorEnt
  //       oldstate := state
  //     }.elsewhen (addrMatch(pc, secureZoneStart, secureZoneEnd)) {
  //       state := State.sDzoneEnt
  //       oldstate := state
  //     }.otherwise{
  //       state := oldstate
  //     }
      
  //   }

  //   is (State.sKill) {
  //     state := State.sKill;
  //     oldstate := state
  //   }
  // }