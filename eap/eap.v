module transtate( // @[:@3.2]
  input  [3:0] io_currentState, // @[:@6.4]
  input  [3:0] io_transtate, // @[:@6.4]
  output [3:0] io_newState // @[:@6.4]
);
  wire  _T_14; // @[Conditional.scala 37:30:@10.4]
  wire  _T_15; // @[Conditional.scala 37:30:@12.6]
  wire  _T_16; // @[Conditional.scala 37:30:@17.8]
  wire [3:0] _GEN_0; // @[Conditional.scala 39:67:@18.8]
  wire [3:0] _GEN_1; // @[Conditional.scala 40:58:@13.6]
  wire  _T_17; // @[Conditional.scala 37:30:@23.6]
  wire  _T_18; // @[Conditional.scala 37:30:@25.8]
  wire  _T_20; // @[Conditional.scala 37:30:@35.12]
  wire [3:0] _GEN_4; // @[Conditional.scala 39:67:@31.10]
  wire [3:0] _GEN_5; // @[Conditional.scala 40:58:@26.8]
  wire  _T_23; // @[Conditional.scala 37:30:@44.8]
  wire  _T_25; // @[Conditional.scala 37:30:@51.12]
  wire  _T_27; // @[Conditional.scala 37:30:@61.16]
  wire [3:0] _GEN_6; // @[Conditional.scala 39:67:@62.16]
  wire [3:0] _GEN_7; // @[Conditional.scala 39:67:@57.14]
  wire [3:0] _GEN_8; // @[Conditional.scala 39:67:@52.12]
  wire [3:0] _GEN_9; // @[Conditional.scala 40:58:@47.10]
  wire  _T_28; // @[Conditional.scala 37:30:@67.10]
  wire [3:0] _GEN_10; // @[Conditional.scala 39:67:@80.16]
  wire [3:0] _GEN_11; // @[Conditional.scala 39:67:@75.14]
  wire [3:0] _GEN_12; // @[Conditional.scala 40:58:@70.12]
  wire  _T_32; // @[Conditional.scala 37:30:@85.12]
  wire  _T_35; // @[Conditional.scala 37:30:@97.18]
  wire [3:0] _GEN_13; // @[Conditional.scala 39:67:@98.18]
  wire [3:0] _GEN_14; // @[Conditional.scala 39:67:@93.16]
  wire [3:0] _GEN_15; // @[Conditional.scala 40:58:@88.14]
  wire  _T_36; // @[Conditional.scala 37:30:@103.14]
  wire [3:0] _GEN_17; // @[Conditional.scala 39:67:@111.18]
  wire [3:0] _GEN_18; // @[Conditional.scala 40:58:@106.16]
  wire  _T_40; // @[Conditional.scala 37:30:@121.16]
  wire [3:0] _GEN_19; // @[Conditional.scala 39:67:@134.22]
  wire [3:0] _GEN_20; // @[Conditional.scala 39:67:@129.20]
  wire [3:0] _GEN_21; // @[Conditional.scala 40:58:@124.18]
  wire [3:0] _GEN_22; // @[Conditional.scala 39:67:@122.16]
  wire [3:0] _GEN_23; // @[Conditional.scala 39:67:@104.14]
  wire [3:0] _GEN_24; // @[Conditional.scala 39:67:@86.12]
  wire [3:0] _GEN_25; // @[Conditional.scala 39:67:@68.10]
  wire [3:0] _GEN_26; // @[Conditional.scala 39:67:@45.8]
  wire [3:0] _GEN_27; // @[Conditional.scala 39:67:@24.6]
  assign _T_14 = 4'h1 == io_currentState; // @[Conditional.scala 37:30:@10.4]
  assign _T_15 = 4'h2 == io_transtate; // @[Conditional.scala 37:30:@12.6]
  assign _T_16 = 4'h1 == io_transtate; // @[Conditional.scala 37:30:@17.8]
  assign _GEN_0 = _T_16 ? 4'h1 : 4'h8; // @[Conditional.scala 39:67:@18.8]
  assign _GEN_1 = _T_15 ? 4'h2 : _GEN_0; // @[Conditional.scala 40:58:@13.6]
  assign _T_17 = 4'h2 == io_currentState; // @[Conditional.scala 37:30:@23.6]
  assign _T_18 = 4'h4 == io_transtate; // @[Conditional.scala 37:30:@25.8]
  assign _T_20 = 4'h7 == io_transtate; // @[Conditional.scala 37:30:@35.12]
  assign _GEN_4 = _T_15 ? 4'h4 : 4'h8; // @[Conditional.scala 39:67:@31.10]
  assign _GEN_5 = _T_18 ? 4'h4 : _GEN_4; // @[Conditional.scala 40:58:@26.8]
  assign _T_23 = 4'h3 == io_currentState; // @[Conditional.scala 37:30:@44.8]
  assign _T_25 = 4'h6 == io_transtate; // @[Conditional.scala 37:30:@51.12]
  assign _T_27 = 4'h3 == io_transtate; // @[Conditional.scala 37:30:@61.16]
  assign _GEN_6 = _T_27 ? 4'h3 : 4'h8; // @[Conditional.scala 39:67:@62.16]
  assign _GEN_7 = _T_20 ? 4'h7 : _GEN_6; // @[Conditional.scala 39:67:@57.14]
  assign _GEN_8 = _T_25 ? 4'h6 : _GEN_7; // @[Conditional.scala 39:67:@52.12]
  assign _GEN_9 = _T_18 ? 4'h4 : _GEN_8; // @[Conditional.scala 40:58:@47.10]
  assign _T_28 = 4'h4 == io_currentState; // @[Conditional.scala 37:30:@67.10]
  assign _GEN_10 = _T_15 ? 4'h2 : 4'h8; // @[Conditional.scala 39:67:@80.16]
  assign _GEN_11 = _T_27 ? 4'h3 : _GEN_10; // @[Conditional.scala 39:67:@75.14]
  assign _GEN_12 = _T_18 ? 4'h4 : _GEN_11; // @[Conditional.scala 40:58:@70.12]
  assign _T_32 = 4'h5 == io_currentState; // @[Conditional.scala 37:30:@85.12]
  assign _T_35 = 4'h5 == io_transtate; // @[Conditional.scala 37:30:@97.18]
  assign _GEN_13 = _T_35 ? 4'h5 : 4'h8; // @[Conditional.scala 39:67:@98.18]
  assign _GEN_14 = _T_20 ? 4'h7 : _GEN_13; // @[Conditional.scala 39:67:@93.16]
  assign _GEN_15 = _T_25 ? 4'h6 : _GEN_14; // @[Conditional.scala 40:58:@88.14]
  assign _T_36 = 4'h6 == io_currentState; // @[Conditional.scala 37:30:@103.14]
  assign _GEN_17 = _T_25 ? 4'h6 : _GEN_6; // @[Conditional.scala 39:67:@111.18]
  assign _GEN_18 = _T_35 ? 4'h5 : _GEN_17; // @[Conditional.scala 40:58:@106.16]
  assign _T_40 = 4'h7 == io_currentState; // @[Conditional.scala 37:30:@121.16]
  assign _GEN_19 = _T_20 ? 4'h7 : 4'h8; // @[Conditional.scala 39:67:@134.22]
  assign _GEN_20 = _T_35 ? 4'h5 : _GEN_19; // @[Conditional.scala 39:67:@129.20]
  assign _GEN_21 = _T_27 ? 4'h3 : _GEN_20; // @[Conditional.scala 40:58:@124.18]
  assign _GEN_22 = _T_40 ? _GEN_21 : 4'h8; // @[Conditional.scala 39:67:@122.16]
  assign _GEN_23 = _T_36 ? _GEN_18 : _GEN_22; // @[Conditional.scala 39:67:@104.14]
  assign _GEN_24 = _T_32 ? _GEN_15 : _GEN_23; // @[Conditional.scala 39:67:@86.12]
  assign _GEN_25 = _T_28 ? _GEN_12 : _GEN_24; // @[Conditional.scala 39:67:@68.10]
  assign _GEN_26 = _T_23 ? _GEN_9 : _GEN_25; // @[Conditional.scala 39:67:@45.8]
  assign _GEN_27 = _T_17 ? _GEN_5 : _GEN_26; // @[Conditional.scala 39:67:@24.6]
  assign io_newState = _T_14 ? _GEN_1 : _GEN_27; // @[transtate.scala 138:19:@138.4]
endmodule
module eap( // @[:@140.2]
  input         clock, // @[:@141.4]
  input         reset, // @[:@142.4]
  input  [26:0] io_pc, // @[:@143.4]
  input  [26:0] io_dAddr, // @[:@143.4]
  output        io_securityMonitorMode, // @[:@143.4]
  output        io_out // @[:@143.4]
);
  wire [3:0] transtate_io_currentState; // @[eap.scala 95:25:@163.4]
  wire [3:0] transtate_io_transtate; // @[eap.scala 95:25:@163.4]
  wire [3:0] transtate_io_newState; // @[eap.scala 95:25:@163.4]
  reg [3:0] runState; // @[eap.scala 89:26:@158.4]
  reg [31:0] _RAND_0;
  wire  _T_54; // @[eap.scala 99:37:@167.4]
  wire  _T_56; // @[eap.scala 99:13:@173.6]
  wire  _T_57; // @[eap.scala 99:37:@174.6]
  wire  _T_58; // @[eap.scala 99:26:@175.6]
  wire  _T_59; // @[eap.scala 99:13:@180.8]
  wire  _T_60; // @[eap.scala 99:37:@181.8]
  wire  _T_61; // @[eap.scala 99:26:@182.8]
  wire  _T_62; // @[eap.scala 99:13:@187.10]
  wire  _T_63; // @[eap.scala 99:37:@188.10]
  wire  _T_64; // @[eap.scala 99:26:@189.10]
  wire  _T_65; // @[eap.scala 99:13:@194.12]
  wire  _T_66; // @[eap.scala 99:37:@195.12]
  wire  _T_67; // @[eap.scala 99:26:@196.12]
  wire  _T_68; // @[eap.scala 99:13:@201.14]
  wire  _T_69; // @[eap.scala 99:37:@202.14]
  wire  _T_70; // @[eap.scala 99:26:@203.14]
  wire [3:0] _GEN_0; // @[eap.scala 116:61:@204.14]
  wire [3:0] _GEN_1; // @[eap.scala 114:63:@197.12]
  wire [3:0] _GEN_2; // @[eap.scala 112:55:@190.10]
  wire [3:0] _GEN_3; // @[eap.scala 110:57:@183.8]
  wire [3:0] _GEN_4; // @[eap.scala 108:48:@176.6]
  wire  _T_71; // @[eap.scala 99:13:@215.4]
  wire  _T_72; // @[eap.scala 99:37:@216.4]
  wire  dAddr_is_smMem; // @[eap.scala 99:26:@217.4]
  wire  dAddr_is_not_smMem; // @[eap.scala 139:28:@218.4]
  wire  _T_74; // @[eap.scala 99:13:@219.4]
  wire  _T_75; // @[eap.scala 99:37:@220.4]
  wire  dAddr_is_szMem; // @[eap.scala 99:26:@221.4]
  wire  dAddr_is_not_szMem; // @[eap.scala 143:28:@222.4]
  wire  _T_81; // @[eap.scala 150:9:@226.4]
  wire  _T_82; // @[Conditional.scala 37:30:@230.4]
  wire  _T_85; // @[Conditional.scala 37:30:@236.6]
  wire  _T_88; // @[Conditional.scala 37:30:@242.8]
  wire  _T_91; // @[Conditional.scala 37:30:@248.10]
  wire  _T_93; // @[Conditional.scala 37:30:@255.12]
  wire  _T_94; // @[eap.scala 176:31:@257.14]
  wire  _T_95; // @[eap.scala 176:66:@258.14]
  wire  _T_96; // @[eap.scala 176:53:@259.14]
  wire  _T_98; // @[eap.scala 178:33:@264.16]
  wire  _T_99; // @[eap.scala 178:68:@265.16]
  wire  _T_100; // @[eap.scala 178:55:@266.16]
  wire  _T_102; // @[eap.scala 180:50:@271.18]
  wire  _T_103; // @[eap.scala 180:37:@272.18]
  wire  _GEN_8; // @[eap.scala 178:89:@267.16]
  wire  _GEN_9; // @[eap.scala 176:84:@260.14]
  wire  _T_105; // @[Conditional.scala 37:30:@278.14]
  wire  _GEN_11; // @[eap.scala 185:84:@283.16]
  wire  _T_114; // @[Conditional.scala 37:30:@295.16]
  wire  _T_115; // @[eap.scala 192:31:@297.18]
  wire  _GEN_13; // @[Conditional.scala 39:67:@296.16]
  wire  _GEN_14; // @[Conditional.scala 39:67:@279.14]
  wire  _GEN_15; // @[Conditional.scala 39:67:@256.12]
  wire  _GEN_16; // @[Conditional.scala 39:67:@249.10]
  wire  _GEN_17; // @[Conditional.scala 39:67:@243.8]
  wire  _GEN_19; // @[Conditional.scala 39:67:@237.6]
  wire  _GEN_20; // @[Conditional.scala 39:67:@237.6]
  wire  _T_118; // @[eap.scala 198:15:@302.4]
  wire [3:0] _GEN_23; // @[eap.scala 198:28:@303.4]
  transtate transtate ( // @[eap.scala 95:25:@163.4]
    .io_currentState(transtate_io_currentState),
    .io_transtate(transtate_io_transtate),
    .io_newState(transtate_io_newState)
  );
  assign _T_54 = io_pc < 27'h4; // @[eap.scala 99:37:@167.4]
  assign _T_56 = io_pc >= 27'h4; // @[eap.scala 99:13:@173.6]
  assign _T_57 = io_pc < 27'h200; // @[eap.scala 99:37:@174.6]
  assign _T_58 = _T_56 & _T_57; // @[eap.scala 99:26:@175.6]
  assign _T_59 = io_pc >= 27'h200; // @[eap.scala 99:13:@180.8]
  assign _T_60 = io_pc < 27'h300; // @[eap.scala 99:37:@181.8]
  assign _T_61 = _T_59 & _T_60; // @[eap.scala 99:26:@182.8]
  assign _T_62 = io_pc >= 27'h300; // @[eap.scala 99:13:@187.10]
  assign _T_63 = io_pc < 27'h800; // @[eap.scala 99:37:@188.10]
  assign _T_64 = _T_62 & _T_63; // @[eap.scala 99:26:@189.10]
  assign _T_65 = io_pc >= 27'h800; // @[eap.scala 99:13:@194.12]
  assign _T_66 = io_pc < 27'ha00; // @[eap.scala 99:37:@195.12]
  assign _T_67 = _T_65 & _T_66; // @[eap.scala 99:26:@196.12]
  assign _T_68 = io_pc >= 27'ha00; // @[eap.scala 99:13:@201.14]
  assign _T_69 = io_pc < 27'h1000; // @[eap.scala 99:37:@202.14]
  assign _T_70 = _T_68 & _T_69; // @[eap.scala 99:26:@203.14]
  assign _GEN_0 = _T_70 ? 4'h6 : 4'h7; // @[eap.scala 116:61:@204.14]
  assign _GEN_1 = _T_67 ? 4'h5 : _GEN_0; // @[eap.scala 114:63:@197.12]
  assign _GEN_2 = _T_64 ? 4'h4 : _GEN_1; // @[eap.scala 112:55:@190.10]
  assign _GEN_3 = _T_61 ? 4'h3 : _GEN_2; // @[eap.scala 110:57:@183.8]
  assign _GEN_4 = _T_58 ? 4'h2 : _GEN_3; // @[eap.scala 108:48:@176.6]
  assign _T_71 = io_dAddr >= 27'h8000; // @[eap.scala 99:13:@215.4]
  assign _T_72 = io_dAddr < 27'ha000; // @[eap.scala 99:37:@216.4]
  assign dAddr_is_smMem = _T_71 & _T_72; // @[eap.scala 99:26:@217.4]
  assign dAddr_is_not_smMem = dAddr_is_smMem == 1'h0; // @[eap.scala 139:28:@218.4]
  assign _T_74 = io_dAddr >= 27'ha000; // @[eap.scala 99:13:@219.4]
  assign _T_75 = io_dAddr < 27'h10000; // @[eap.scala 99:37:@220.4]
  assign dAddr_is_szMem = _T_74 & _T_75; // @[eap.scala 99:26:@221.4]
  assign dAddr_is_not_szMem = dAddr_is_szMem == 1'h0; // @[eap.scala 143:28:@222.4]
  assign _T_81 = reset == 1'h0; // @[eap.scala 150:9:@226.4]
  assign _T_82 = 4'h1 == transtate_io_newState; // @[Conditional.scala 37:30:@230.4]
  assign _T_85 = 4'h2 == transtate_io_newState; // @[Conditional.scala 37:30:@236.6]
  assign _T_88 = 4'h4 == transtate_io_newState; // @[Conditional.scala 37:30:@242.8]
  assign _T_91 = 4'h6 == transtate_io_newState; // @[Conditional.scala 37:30:@248.10]
  assign _T_93 = 4'h3 == transtate_io_newState; // @[Conditional.scala 37:30:@255.12]
  assign _T_94 = dAddr_is_not_szMem & dAddr_is_not_smMem; // @[eap.scala 176:31:@257.14]
  assign _T_95 = runState == 4'h7; // @[eap.scala 176:66:@258.14]
  assign _T_96 = _T_94 & _T_95; // @[eap.scala 176:53:@259.14]
  assign _T_98 = dAddr_is_szMem & dAddr_is_not_smMem; // @[eap.scala 178:33:@264.16]
  assign _T_99 = runState == 4'h6; // @[eap.scala 178:68:@265.16]
  assign _T_100 = _T_98 & _T_99; // @[eap.scala 178:55:@266.16]
  assign _T_102 = runState == 4'h4; // @[eap.scala 180:50:@271.18]
  assign _T_103 = dAddr_is_not_smMem & _T_102; // @[eap.scala 180:37:@272.18]
  assign _GEN_8 = _T_100 ? 1'h1 : _T_103; // @[eap.scala 178:89:@267.16]
  assign _GEN_9 = _T_96 ? 1'h1 : _GEN_8; // @[eap.scala 176:84:@260.14]
  assign _T_105 = 4'h5 == transtate_io_newState; // @[Conditional.scala 37:30:@278.14]
  assign _GEN_11 = _T_96 ? 1'h1 : _T_100; // @[eap.scala 185:84:@283.16]
  assign _T_114 = 4'h7 == transtate_io_newState; // @[Conditional.scala 37:30:@295.16]
  assign _T_115 = dAddr_is_not_smMem & dAddr_is_not_szMem; // @[eap.scala 192:31:@297.18]
  assign _GEN_13 = _T_114 ? _T_115 : 1'h0; // @[Conditional.scala 39:67:@296.16]
  assign _GEN_14 = _T_105 ? _GEN_11 : _GEN_13; // @[Conditional.scala 39:67:@279.14]
  assign _GEN_15 = _T_93 ? _GEN_9 : _GEN_14; // @[Conditional.scala 39:67:@256.12]
  assign _GEN_16 = _T_91 ? dAddr_is_szMem : _GEN_15; // @[Conditional.scala 39:67:@249.10]
  assign _GEN_17 = _T_88 ? 1'h1 : _GEN_16; // @[Conditional.scala 39:67:@243.8]
  assign _GEN_19 = _T_85 ? 1'h1 : _GEN_17; // @[Conditional.scala 39:67:@237.6]
  assign _GEN_20 = _T_85 ? 1'h1 : _T_88; // @[Conditional.scala 39:67:@237.6]
  assign _T_118 = io_out == 1'h0; // @[eap.scala 198:15:@302.4]
  assign _GEN_23 = _T_118 ? 4'h8 : transtate_io_newState; // @[eap.scala 198:28:@303.4]
  assign io_securityMonitorMode = _T_82 ? 1'h1 : _GEN_20; // @[eap.scala 146:26:@223.4 eap.scala 160:30:@233.6 eap.scala 164:30:@239.8 eap.scala 168:30:@245.10]
  assign io_out = _T_82 ? 1'h1 : _GEN_19; // @[eap.scala 147:10:@224.4 eap.scala 159:14:@232.6 eap.scala 163:14:@238.8 eap.scala 167:14:@244.10 eap.scala 172:16:@251.14 eap.scala 177:16:@261.16 eap.scala 179:16:@268.18 eap.scala 181:16:@274.20 eap.scala 186:16:@284.18 eap.scala 188:16:@291.20 eap.scala 193:16:@299.20]
  assign transtate_io_currentState = runState; // @[eap.scala 124:29:@210.4]
  assign transtate_io_transtate = _T_54 ? 4'h1 : _GEN_4; // @[eap.scala 125:29:@211.4]
`ifdef RANDOMIZE_GARBAGE_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_INVALID_ASSIGN
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_REG_INIT
`define RANDOMIZE
`endif
`ifdef RANDOMIZE_MEM_INIT
`define RANDOMIZE
`endif
`ifndef RANDOM
`define RANDOM $random
`endif
`ifdef RANDOMIZE
  integer initvar;
  initial begin
    `ifdef INIT_RANDOM
      `INIT_RANDOM
    `endif
    `ifndef VERILATOR
      #0.002 begin end
    `endif
  `ifdef RANDOMIZE_REG_INIT
  _RAND_0 = {1{`RANDOM}};
  runState = _RAND_0[3:0];
  `endif // RANDOMIZE_REG_INIT
  end
`endif // RANDOMIZE
  always @(posedge clock) begin
    if (reset) begin
      runState <= 4'h1;
    end else begin
      if (_T_118) begin
        runState <= 4'h8;
      end else begin
        runState <= transtate_io_newState;
      end
    end
    `ifndef SYNTHESIS
    `ifdef PRINTF_COND
      if (`PRINTF_COND) begin
    `endif
        if (_T_81) begin
          $fwrite(32'h80000002,"tempostate = %d\n",transtate_io_newState); // @[eap.scala 150:9:@228.6]
        end
    `ifdef PRINTF_COND
      end
    `endif
    `endif // SYNTHESIS
  end
endmodule
