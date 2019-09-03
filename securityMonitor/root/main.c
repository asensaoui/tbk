
#include <stdio.h>
#include <stdlib.h>
#include <string.h>






#define KEY_LEN 256
#define RAMSTART 0x20000000
#define MAGICW1 0X5C5C5C5C
#define MAGICW2 0X3F3F3F3F

#define bool _Bool

#define ERROR 0

/* cycle test only */
#define read_csr(reg) ({ unsigned long __tmp; \
asm volatile ("csrr %0, " #reg : "=r"(__tmp)); \
__tmp; })
#define CSR_CYCLE 0xc00
#define CSR_TIME 0xc01
#define CSR_INSTRET 0xc02
#define CSR_MCYCLE 0xb00

/* Key and Gen */
const unsigned char magicKey[64] = {0x79, 0x37, 0xa1, 0x16, 0xa5, 0x73, 0x49, 0x2b, 
																0x7f, 0x59, 0x14, 0x5d, 0x3e, 0xed, 0x9c, 0x55, 
																0xcb, 0x58, 0x08, 0xc0, 0x71, 0x84, 0x02, 0xa8, 
																0x35, 0x03, 0x23, 0x80, 0x71, 0x0e, 0xa0, 0x72,
															0x79, 0x37, 0xa1, 0x16, 0xa5, 0x73, 0x49, 0x2b, 
																0x7f, 0x59, 0x14, 0x5d, 0x3e, 0xed, 0x9c, 0x55, 
																0xcb, 0x58, 0x08, 0xc0, 0x71, 0x84, 0x02, 0xa8, 
																0x35, 0x03, 0x23, 0x80, 0x71, 0x0e, 0xa0, 0x72};
const unsigned char smKey[32] = {	0x21, 0x75, 0x94, 0x0f, 0x70, 0x4d, 0x30, 0xdb, 
														0x7e, 0x08, 0x31, 0x6f, 0xf9, 0x66, 0x73, 0xd2, 
														0x54, 0xc8, 0x26, 0xf9, 0xbc, 0x2b, 0x65, 0x89, 
														0xe5, 0x28, 0x0a, 0x2c, 0xdd, 0x24, 0x00, 0x87};

const unsigned char testhmac[32] = {0x08, 0xa1, 0x47, 0x9c, 0x4c, 0x81, 0x21, 0x16, 0xbf, 0xfb, 0xa2, 0xc5, 0xb0, 0xe5, 0xf1, 0x62, 0xdd, 0x33, 0xa8, 0xc3, 0x51, 0xa3, 0xdc, 0x25, 0xa0, 0x8f, 0xf, 0xa9, 0x6b, 0xbb, 0x9d, 0xd};


/* monitor header section */
extern char __section_monitor_header_start;
extern char __section_monitor_header_end;
extern char __section_ram_root_start;

/* hmac hacl-lib function */
extern void
Hacl_HMAC_SHA2_256_hmac(
  unsigned char *mac,
  unsigned char *key,
  unsigned int keylen,
  unsigned char *data,
  unsigned int datalen
);



typedef struct  {
	unsigned char magicWord[2];
	bool smEn;
	unsigned char * start;
	unsigned int len;
	unsigned int startMem;
	unsigned int endMem;
	bool jumpEn;
	void * jump;
	unsigned char * hmac;
}header_t;


/* Header decryption function */
int headerDecrypt(unsigned char * headerStart, unsigned int len, unsigned char * key, header_t * header) {
	return 0;
}

/* attestation function */
int attestMem(unsigned char * startAddr, unsigned int len, unsigned char * key, unsigned char * hmac) {
	unsigned char * hmacRes = (unsigned char *)malloc(32);
	Hacl_HMAC_SHA2_256_hmac(hmacRes, key, 32, startAddr, len);

	// int result = memcmp(hmacRes, hmac, 32);

	return memcmp(hmacRes, hmac, 32);
}

/* Generate key */
int generateKey(unsigned char * hmac, unsigned char * key, unsigned char * magic, unsigned char * result) {
	unsigned int i = 0;
	for(i = 0; i < 32; i++) {
		result[i] = (hmac[i] ^ key[i]) ^ magic[i]; 
	}
	return 0;
}

/* Swap A B regions and clean&release buffer*/
int swapAB(unsigned char * dst, unsigned char * src, unsigned int len, unsigned int reset) {

	return 0;
}



int main (void) {
	unsigned int result = 0;
	header_t * header = (header_t *)malloc(sizeof(header_t));
	unsigned char generatedKey[32];

	long c1 = read_csr(cycle);

	/* Init core */
	// printf("\nInit Core ... !\n");

	// printf("Decrypt Header !\n");
	/* decrypt monitor header to retrieve its configuration */
	// headerDecrypt();
	if(result) {
		/* loop here */
		while(1);
	}
	// printf("monitor attest !\n");
	/* check monitor integrity */
	// test value
	header->start = magicKey;
	header->len = sizeof(magicKey);
	header->hmac = testhmac;

	


	result = attestMem(header->start, header->len, smKey, header->hmac);


	

	if(result) {
		/* loop here */
		while(1);
	}

	/* configure eap/mmp*/

	if(result) {
		/* loop here */
		while(1);
	}
	// printf("Generate Key !\n");
	/* generate keys */
	result = generateKey(smKey, smKey, magicKey, (unsigned char *)generatedKey);
	if(result) {
		/* loop here */
		while(1);
	}

	/* clean memory */


	/* go to monitor */

	long cycles = read_csr(cycle) - c1;
	printf(" %ld\n", cycles);

	return 0;
}
