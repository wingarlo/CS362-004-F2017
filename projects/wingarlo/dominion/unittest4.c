/***
*Logan Wingard
*10/19/2017
*unittest4.c
*
*This will test the dominion.c function int getCost(int cardNumber)
*
*Each test will pass in a different value and expect the correct cost in return
*
*Add to make file:
*unittest4: unittest4.c dominion.o rngs.o
*      gcc -o unittest4 -g  unittest4.c dominion.o rngs.o $(CFLAGS)
***/

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int main(){
	int i;
	unsigned int score;
	int seed = 1000;
	int numPlayer = 2;
	unsigned int t;
	int r;
	int k[10] = {adventurer, council_room, feast, gardens, mine
			   , remodel, smithy, village, baron, great_hall};
	struct gameState G;
	int costval;
	for(t = 0; t<27;t++){
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new gameprintf 
		costval = getCost(t);
		switch( t ){
			case 0:
			  assert(costval == 0);
			  break;
			case 1:
			  assert(costval == 2);
			  break;
			case 2:
			  assert(costval == 5);
			  break;
			case 3:
			  assert(costval == 8);
			  break;
			case 4:
			  assert(costval == 0);
			  break;
			case 5:
			  assert(costval == 3);
			  break;
			case 6:
			  assert(costval == 6);
			  break;
			case 7:
			  assert(costval == 6);
			  break;
			case 8:
			  assert(costval == 5);
			  break;
			case 9:
			  assert(costval == 4);
			  break;
			case 10:
			  assert(costval == 4);
			  break;
			case 11:
			  assert(costval == 5);
			  break;
			case 12:
			  assert(costval == 4);
			  break;
			case 13:
			  assert(costval == 4);
			  break;
			case 14:
			  assert(costval == 3);
			  break;
			case 15:
			  assert(costval == 4);
			  break;
			case 16:
			  assert(costval == 3);
			  break;
			case 17:
			  assert(costval == 5);
			  break;
			case 18:
			  assert(costval == 3);
			  break;
			case 19:
			  assert(costval == 5);
			  break;
			case 20:
			  assert(costval == 3);
			  break;
			case 21:
			  assert(costval == 4);
			  break;
			case 22: 
			  assert(costval == 2);
			  break;
			case 23:
			  assert(costval == 5);
			  break;
			case 24:
			  assert(costval == 4);
			  break;
			case 25:
			  assert(costval == 4);
			  break;
			case 26:
			  assert(costval == 4);
			  break;
		}
		
	}
	printf("All tests passed\n");
	return 0;
}