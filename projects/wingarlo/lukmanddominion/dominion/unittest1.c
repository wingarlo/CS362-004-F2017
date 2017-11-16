/***
*Logan Wingard
*10/15/2017
*unittest1.c
*
*This will test the dominion.c function int gainCard(int supplyPos, struct gameState *state, int toFlag, int player)
*
*Each test will add between 0 and 4 cards to the 3 different piles: hand, deck, and discard
*
*Add to make file:
*unittest1: unittest1.c dominion.o rngs.o
*      gcc -o unittest1 -g  unittest1.c dominion.o rngs.o $(CFLAGS)
***/

#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"

int main(){
	int i;
	int seed = 1000;
	int numPlayer = 2;
	int t, r, handCount, deckCount, discardCount;
	int k[10] = {adventurer, council_room, feast, gardens, mine
			   , remodel, smithy, village, baron, great_hall};
	struct gameState G;
	handCount = 5;
	deckCount = 5;
	discardCount = 0;
	for(t = 0; t<5;t++){
		printf("Test player %d with %d card(s) in their hand.\n", 0, handCount);
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
		for(i = 0; i<t; i++){
			gainCard(0,&G,2,0); //(curse, gamestate G, hand, player 0)
		}
		printf("player 0 drew %d cards into their hand\n",t);
		printf("G.handCount = %d, expected = %d\n", G.handCount[0], handCount + t);
		assert(G.handCount[0] == (handCount+t)); //checks to make sure card was added to hand.
	}

	
	for(t = 0; t<5;t++){
		printf("Test player %d with %d card(s) in their deck.\n", 0, deckCount);
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
		for(i = 0; i<t; i++){
			gainCard(0,&G,1,0); //(curse, gamestate G, deck, player 0)
		}
		printf("player 0 drew %d cards into their deck\n",t);
		printf("G.deckCount = %d, expected = %d\n", G.deckCount[0], deckCount + t);
		assert(G.deckCount[0] == (deckCount+t)); //checks to make sure card was added to deck.
	}
	
	
	for(t = 0; t<5;t++){
		printf("Test player %d with %d card(s) in their discard.\n", 0, discardCount);
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
		for(i = 0; i<t; i++){
			gainCard(0,&G,0,0); //(curse, gamestate G, discard, player 0)
		}
		printf("player 0 placed %d cards into their discard\n",t);
		printf("G.discardCount = %d, expected = %d\n", G.discardCount[0], discardCount + t);
		assert(G.discardCount[0] == (discardCount+t)); //checks to make sure card was added to deck.
	}
	return 0;
}