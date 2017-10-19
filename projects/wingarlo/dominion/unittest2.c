/***
*Logan Wingard
*10/18/2017
*unittest2.c
*
*This will test the dominion.c function int scoreFor (int player, struct gameState *state)
*
*Each test will add several numbers of victory cards to the 3 different piles: hand, deck, and discard
*
*Add to make file:
*unittest2: unittest2.c dominion.o rngs.o
*      gcc -o unittest2 -g  unittest2.c dominion.o rngs.o $(CFLAGS)
***/

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int main(){
	int i, score;
	int seed = 1000;
	int numPlayer = 2;
	int t, r;
	int k[10] = {adventurer, council_room, feast, gardens, mine
			   , remodel, smithy, village, baron, great_hall};
	struct gameState G;
	for(t = 0; t<3;t++){
		printf("Test player %d by adding %d victory cards in their hand, discard, or deck.\n", 0, t);
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
		for(i = 1; i<=t; i++){//itterates 1 then 2 then 3 times
			gainCard(0,&G,t,0); //(curse, gamestate G, pile, player 0)
			gainCard(1,&G,t,0); //(estate, gamestate G, pile, player 0)
			gainCard(2,&G,t,0); //(duchy, gamestate G, pile, player 0)
			gainCard(3,&G,t,0); //(province, gamestate G, pile, player 0)
		}
		for (i = 0; i < G.discardCount[0]; i++){
			printf("test%d\n",G.deck[0][i]);
		}
		score = scoreFor(0,&G);
		printf("score = %d, expected = %d\n", score, (-1 + 1 + 3 + 6)*t);
		//assert(score == ((-1 + 1 + 3 + 6)*t));
	}

	return 0;
}