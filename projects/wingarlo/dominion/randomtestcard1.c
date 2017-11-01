/***
*Logan Wingard
*10/31/2017 
*happy halloween
*  _
*|o o\ boo!
*| O  \
* \    \
*  `~~~'
*randomtestcard1.c
*
*	SMITHY
*
*Add to make file:
*randomtestcard1: randomtestcard1.c dominion.o rngs.o
*      gcc -o randomtestcard1 -g  randomtestcard1.c dominion.o rngs.o $(CFLAGS)
***/

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "rngs.h"

int main(){
	int t, p, r, succ, fal;
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

		smith(&G,p,0);
		if(G.handCount[p] == 8)
			succ++;
		else
			fal++;
	}
	printf("\nCode did not break\n");
	printf("\nThe function worked correctly %i times\nAnd failed %i times\n\n",succ,fal);
	return 0;
}
