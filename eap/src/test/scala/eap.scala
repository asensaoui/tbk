package eap



import chisel3._
import java.io.File

import chisel3.iotesters
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}


class eapTester(c: eap) extends PeekPokeTester(c) {
  
  
    poke(c.io.pc,     0.U)
    poke(c.io.dAddr, "h8000".U)
    step(1)
    expect(c.io.out, true.B)

    poke(c.io.pc,     "h150".U)
    poke(c.io.dAddr, "h8000".U)
    step(1)
    expect(c.io.out, true.B)
    
    poke(c.io.pc,     "h310".U)
    poke(c.io.dAddr, "h20000".U)
    step(1)
    expect(c.io.out, true.B)
    
    poke(c.io.pc,     "h210".U)
    step(1)
    poke(c.io.pc,     "h2000".U)
    poke(c.io.dAddr, "h8000".U)
    step(1)
    poke(c.io.pc,     "h3000".U)
    step(1)
    poke(c.io.pc,     "h230".U)
    step(1)
    poke(c.io.pc,     "h150".U)
    step(1)
    expect(c.io.out, false.B)
  
}


class eapT extends ChiselFlatSpec {

	iotesters.Driver.execute(Array("--no-check-comb-loops"), () => new eap) {
      c => new eapTester(c)
    } 
}