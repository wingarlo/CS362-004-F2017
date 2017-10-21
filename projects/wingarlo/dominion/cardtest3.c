/***
 * Logan Wingard
 * 10/21/2017
 * cardtest3.c
 *
 * This tests the function int conrom(struct gameState *state, int currentPlayer, int handPos)
 *
 * Include the following lines in your makefile:
 *
 * cardtest3: cardtest3.c dominion.o rngs.o
 *      gcc -o cardtest3 -g  cardtest3.c dominion.o rngs.o $(CFLAGS)
 */
 
#include "dominion.h"
#include "dominion_helpers.h"
#include <string.h>
#include <stdio.h>
#include <assert.h>
#include "rngs.h"
#include <stdlib.h>

#define TESTCARD "council_room"

int main() {
    int newCards = 0;
    int discarded = 1;
    int shuffledCards = 0;
	int xtraBuys = 1;
    int i;
    int seed = 1000;
	int handpos = 0;
    int numPlayers = 2;
    int thisPlayer = 0;
	struct gameState G, testG;
	int k[10] = {adventurer, embargo, village, minion, mine, cutpurse,
			sea_hag, tribute, smithy, council_room};

	// initialize a game state and player cards
	initializeGame(numPlayers, k, seed, &G);

	printf("----------------- Testing Card: %s ----------------\n", TESTCARD);

	// ----------- TEST 1: +4 cards --------------
	printf("TEST 1: +4 cards\n");

	// copy the game state to a test case
	memcpy(&testG, &G, sizeof(struct gameState));
	conrom(&testG, thisPlayer, handpos);

	newCards = 4;
	printf("hand count = %d, expected = %d\n", testG.handCount[thisPlayer], G.handCount[thisPlayer] + newCards - discarded);
	printf("deck count = %d, expected = %d\n", testG.deckCount[thisPlayer], G.deckCount[thisPlayer] - newCards + shuffledCards);
	printf("buys = %d, expected = %d\n", testG.numBuys, G.numBuys + xtraBuys);
	assert(testG.numBuys == G.numBuys + xtraBuys);
	assert(testG.handCount[thisPlayer] == G.handCount[thisPlayer] + newCards - discarded);
	assert(testG.deckCount[thisPlayer] == G.deckCount[thisPlayer] - newCards + shuffledCards);

	// ----------- TEST 2: +1 card to all other players --------------
	printf("TEST 1: +1 card to all other players\n");
	for(i=1;i<numPlayers;i++){ // start at 1 because player 0 played the card
		printf("hand count = %d, expected = %d\n", testG.handCount[i], G.handCount[i] + 1 - discarded);
		printf("deck count = %d, expected = %d\n", testG.deckCount[i], G.deckCount[i] - 1 + shuffledCards);
		assert(testG.handCount[i] == G.handCount[i] + 1 - discarded);
		assert(testG.deckCount[i] == G.deckCount[i] - 1 + shuffledCards);
	}
	printf("\n >>>>> SUCCESS: Testing complete %s <<<<<\n\n", TESTCARD);


	return 0;
}
