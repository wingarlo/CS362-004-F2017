/***
*Logan Wingard
*11/1/2017 
*  _
*|o o\ 
*| ^  \
* \    \
*  `~~~'
*sad ghost gets no love in November
*
*randomtestcard2.c
*
*	VILLAGE
*
*Add to make file:
*randomtestcard2: randomtestcard2.c dominion.o rngs.o
*      gcc -o randomtestcard2 -g  randomtestcard2.c dominion.o rngs.o $(CFLAGS)
***/

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "rngs.h"

int main(){
	int t, p, r;
	succ = 0;
	fal = 0;
	int seed = 1000;
	srand(seed);
	int numPlayer = (rand()%3)+2;//2-4 players
	struct gameState G;
	int k[10] = {adventurer, council_room, feast, gardens, mine
			   , remodel, smithy, village, baron, great_hall};
			   
	for(t=0;t<2000;t++){
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
		p = rand()%numPlayer; //choses random player
		vil(&G,p,0);

	}
	printf("\nCode did not break\n");
	return 0;
}
