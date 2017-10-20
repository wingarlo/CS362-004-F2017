/***
*Logan Wingard
*10/19/2017
*unittest3.c
*
*This will test the dominion.c function int getWinners(int players[MAX_PLAYERS], struct gameState *state)
*
*Each test will add several numbers of victory cards to each player, and test for the winner
*
*Add to make file:
*unittest3: unittest3.c dominion.o rngs.o
*      gcc -o unittest3 -g  unittest3.c dominion.o rngs.o $(CFLAGS)
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
	int players[2];
	for(t = 0; t<numPlayer;t++){
		printf("Giving player %d 4 duchys\n",t);
		memset(&G, 23, sizeof(struct gameState));   // clear the game state
		r = initializeGame(numPlayer, k, seed, &G); // initialize a new game
		gainCard(2,&G,0,t);
		if(t){
			gainCard(2,&G,0,t);
		}
		printf("\n1=%d\n2=%d\n", scoreFor(0,&G),scoreFor(1,&G));
		printf("Winner = %d, expected = %d\n", getWinners(players, &G),t);//bug that always says the winner 
		assert(getWinners(players,&G) == t);
	}

	return 0;
}