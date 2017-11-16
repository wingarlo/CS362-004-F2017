CFLAGS = -Wall -fpic -coverage -lm

rngs.o: rngs.h rngs.c
	gcc -c rngs.c -g  $(CFLAGS)

dominion.o: dominion.h dominion.c rngs.o
	gcc -c dominion.c -g  $(CFLAGS)

playdom: dominion.o playdom.c
	gcc -o playdom playdom.c -g dominion.o rngs.o $(CFLAGS)
#To run playdom you need to entere: ./playdom <any integer number> like ./playdom 10*/
testDrawCard: testDrawCard.c dominion.o rngs.o
	gcc  -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

badTestDrawCard: badTestDrawCard.c dominion.o rngs.o
	gcc -o badTestDrawCard -g  badTestDrawCard.c dominion.o rngs.o $(CFLAGS)

testBuyCard: testDrawCard.c dominion.o rngs.o
	gcc -o testDrawCard -g  testDrawCard.c dominion.o rngs.o $(CFLAGS)

testAll: dominion.o testSuite.c
	gcc -o testSuite testSuite.c -g  dominion.o rngs.o $(CFLAGS)

interface.o: interface.h interface.c
	gcc -c interface.c -g  $(CFLAGS)
	
unit1: dominion.o unittest1.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o unittest1.c rngs.c -o unittest1 -lm -g

unit2: dominion.o unittest2.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o unittest2.c rngs.c -o unittest2 -lm -g

unit3: dominion.o unittest3.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o unittest3.c rngs.c -o unittest3 -lm -g

unit4: dominion.o unittest4.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o unittest4.c rngs.c -o unittest4 -lm -g

card1: dominion.o cardtest1.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o cardtest1.c rngs.c -o cardtest1 -lm -g

card2: dominion.o cardtest2.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o cardtest2.c rngs.c -o cardtest2 -lm -g

card3: dominion.o cardtest3.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o cardtest3.c rngs.c -o cardtest3 -lm -g

card4: dominion.o cardtest4.c
	gcc -fprofile-arcs -ftest-coverage -Wall -std=c99 dominion.o cardtest4.c rngs.c -o cardtest4 -lm -g

unittestresults.out: card1 card2 card3 card4 unit1 unit2 unit3 unit4 dominion.o
	./unittest1 >> unittestresults.out 2>&1
	./unittest2 >> unittestresults.out 2>&1
	./unittest3 >> unittestresults.out 2>&1
	./unittest4 >> unittestresults.out 2>&1
	./cardtest1 >> unittestresults.out 2>&1
	./cardtest2 >> unittestresults.out 2>&1
	./cardtest3 >> unittestresults.out 2>&1
	./cardtest4 >> unittestresults.out 2>&1
	gcov -b -c -f dominion >> unittestresults.out 2>&1
	cat dominion.c.gcov >> unittestresults.out 2>&1

randomtestcard1: dominion.h rngs.h dominion_helpers.h dominion.o rngs.o
	gcc -o randomtestcard1 randomtestcard1.c -g dominion.o rngs.o $(CFLAGS)
	./randomtestcard1
	gcov -b -c -f randomtestcard1.c >> randomtestcard1.out
	cat randomtestcard1.c.gcov >> randomtestcard1.out
	gcov -b -c -f dominion.c >> randomtestcard1.out
	cat dominion.c.gcov >> randomtestcard1.out

randomtestcard2: dominion.h rngs.h dominion_helpers.h dominion.o rngs.o
	gcc -o randomtestcard2 randomtestcard2.c -g dominion.o rngs.o $(CFLAGS)
	./randomtestcard2
	gcov -b -c -f randomtestcard2.c >> randomtestcard2.out
	cat randomtestcard2.c.gcov >> randomtestcard2.out
	gcov -b -c -f dominion.c >> randomtestcard2.out
	cat dominion.c.gcov >> randomtestcard2.out

randomtestadventurer: dominion.h rngs.h dominion_helpers.h dominion.o rngs.o
	gcc -o randomtestadventurer randomtestadventurer.c -g dominion.o rngs.o $(CFLAGS)
	./randomtestadventurer
	gcov -b -c -f randomtestadventurer.c >> randomtestadventurer.out
	cat randomtestadventurer.c.gcov >> randomtestadventurer.out
	gcov -b -c -f dominion.c >> randomtestadventurer.out
	cat dominion.c.gcov >> randomtestadventurer.out

runtests: testDrawCard 
	./testDrawCard &> unittestresult.out
	gcov dominion.c >> unittestresult.out
	cat dominion.c.gcov >> unittestresult.out


player: player.c interface.o
	gcc -o player player.c -g  dominion.o rngs.o interface.o $(CFLAGS)

all: playdom player testDrawCard testBuyCard badTestDrawCard

clean:
	rm -f *.o playdom.exe playdom player player.exe  *.gcov *.gcda *.gcno *.so *.out testDrawCard testDrawCard.exe
