#DEFINE
RISCV = riscv32-unknown-elf
CC = ${RISCV}-gcc
CFLAGS = -march=rv32im

.PHONY: all
all: main 

main: main.o libhacl.a
	${CC} ${CFLAGS} -O -o  main main.o -L. -lhacl

main.o: main.c
	${CC} ${CFLAGS} -O -c main.c

libhacl.o:  hacl-c/Hacl_HMAC_SHA2_256.c hacl-c/Hacl_HMAC_SHA2_256.h
	${CC} ${CFLAGS} -O -c hacl-c/Hacl_HMAC_SHA2_256.c 

libhacl.a: libhacl.o
	ar crs libhacl.a Hacl_HMAC_SHA2_256.o
# 	rm Hacl_HMAC_SHA2_256.o 

libs: libhacl.a


.PHONY: clean
clean:
	rm -f *.o *.a *.gch

