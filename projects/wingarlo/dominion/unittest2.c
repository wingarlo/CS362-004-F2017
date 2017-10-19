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
	int i;
	unsigned int score;
	int seed = 1000;
	int numPlayer = 2;
	unsigned int t;
	int r;
	int k[10] = {adventurer, council_room, feast, gardens, mine
			   , remodel, smithy, village, baron, great_hall};
	struct gameState G;
	int curses[5];
    int estates[5];
    int duchys[5];
	for (i = 0; i < 5; i++)
    {
        curses[i] = curse;
        estates[i] = estate;
        duchys[i] = duchy;
    }
	for(t = 0; t<5;t++){
		printf("Test player %d by adding %d victory cards in their hand, discard, or deck.\n", 0, t);
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
		memcpy(G.hand[0], curses, sizeof(int) * t); // set t cards to curse
		score = scoreFor(0,&G);
		printf("score = %d, expected = %d\n", score, ((-1)*t)+1);
		assert(score == 1+((-1)*t));
		memcpy(G.hand[0], estates, sizeof(int) * t); // set t cards to estate
		score = scoreFor(0,&G);
		printf("score = %d, expected = %d\n", score, 1+t);
		assert(score == 1+t);
		memcpy(G.deck[0], estates, sizeof(int) * t); // set t cards to estate
		score = scoreFor(0,&G);
		printf("score = %d, expected = %d\n", score, 1+((2)*t));
		assert(score == (t)+1+t);
		memcpy(G.discard[0], duchys, sizeof(int) * t); // set t cards to duchy
		score = scoreFor(0,&G);
		printf("score = %d, expected = %d\n", score, ((-1 + 1 + 3 + 6)*t)+1);
		assert(score == (t+(3*t)+1+t));
	}

	return 0;
}