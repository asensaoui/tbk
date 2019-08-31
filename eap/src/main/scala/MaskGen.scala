/* 
 * Generate Mask for address match 
 */
package eap


import chisel3._

class maskGen extends Module {
  val io = IO(new Bundle { 
    val region_size = Input(UInt(5.W))
    val mask        = Output(UInt(27.W))
  })


       when (io.region_size === "b00000".U(27.W)) {io.mask := "b111111111111111111111111111".U(27.W)} 
  .elsewhen (io.region_size === "b00001".U(27.W)) {io.mask := "b111111111111111111111111111".U(27.W)} 
  .elsewhen (io.region_size === "b00010".U(27.W)) {io.mask := "b111111111111111111111111111".U(27.W)} 
  .elsewhen (io.region_size === "b00011".U(27.W)) {io.mask := "b111111111111111111111111111".U(27.W)} 
  .elsewhen (io.region_size === "b00100".U(27.W)) {io.mask := "b111111111111111111111111111".U(27.W)} 
  .elsewhen (io.region_size === "b00101".U(27.W)) {io.mask := "b111111111111111111111111110".U(27.W)} 
  .elsewhen (io.region_size === "b00110".U(27.W)) {io.mask := "b111111111111111111111111100".U(27.W)} 
  .elsewhen (io.region_size === "b00111".U(27.W)) {io.mask := "b111111111111111111111111000".U(27.W)} 
  .elsewhen (io.region_size === "b01000".U(27.W)) {io.mask := "b111111111111111111111110000".U(27.W)} 
  .elsewhen (io.region_size === "b01001".U(27.W)) {io.mask := "b111111111111111111111100000".U(27.W)} 
  .elsewhen (io.region_size === "b01010".U(27.W)) {io.mask := "b111111111111111111111000000".U(27.W)} 
  .elsewhen (io.region_size === "b01011".U(27.W)) {io.mask := "b111111111111111111110000000".U(27.W)} 
  .elsewhen (io.region_size === "b01100".U(27.W)) {io.mask := "b111111111111111111100000000".U(27.W)} 
  .elsewhen (io.region_size === "b01101".U(27.W)) {io.mask := "b111111111111111111000000000".U(27.W)} 
  .elsewhen (io.region_size === "b01110".U(27.W)) {io.mask := "b111111111111111110000000000".U(27.W)} 
  .elsewhen (io.region_size === "b01111".U(27.W)) {io.mask := "b111111111111111100000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10000".U(27.W)) {io.mask := "b111111111111111000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10001".U(27.W)) {io.mask := "b111111111111110000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10010".U(27.W)) {io.mask := "b111111111111100000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10011".U(27.W)) {io.mask := "b111111111111000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10100".U(27.W)) {io.mask := "b111111111110000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10101".U(27.W)) {io.mask := "b111111111100000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10110".U(27.W)) {io.mask := "b111111111000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b10111".U(27.W)) {io.mask := "b111111110000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b11000".U(27.W)) {io.mask := "b111111100000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b11001".U(27.W)) {io.mask := "b111111000000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b11010".U(27.W)) {io.mask := "b111110000000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b11011".U(27.W)) {io.mask := "b111100000000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b11100".U(27.W)) {io.mask := "b111000000000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b11101".U(27.W)) {io.mask := "b110000000000000000000000000".U(27.W)} 
  .elsewhen (io.region_size === "b11110".U(27.W)) {io.mask := "b100000000000000000000000000".U(27.W)}
  .otherwise                                      {io.mask := "b000000000000000000000000000".U(27.W)}

} 