Mario Bolivar
Mjb160330
CE 3345.001 -- Data Structures and Algorithms

IDE Used: NetBeans



This program examines the run-time of the Quicksort algorithm 
by choosing different initial pivot points from user input.

Program loops, prompting user for the array size of an array that will
be filled with pseudo-random numbers generated using the Random Java class (java.util.Random)
program exits on input of -1. Unsorted array will be outputted to file (unsorted.txt).

After user inputs the array size and array is filled with pseudo-random numbers,
the program will perform a Quicksort 4 different times on the same array and output results
to console & output file (sorted.txt).

Results: 

(After running the experiment 5 different times using array sizes of 100, 5000 and 10000 results are below:

Pivot 1				Pivot 2				Pivot 3				Pivot 4				
Run	Array Size	Runtime		Run	Array Size	Runtime		Run	Array Size	Runtime		Run	Array Size	Runtime		
1	100	141037		1	100	3235158		1	100	206617		1	100	163161		
2	100	41481		2	100	77037		2	100	83753		2	100	24494		
3	100	25284		3	100	36345		3	100	40296		3	100	29235		
4	100	24494		4	100	32790		4	100	32395		4	100	28445		
5	100	35556		5	100	39901		5	100	45827		5	100	32790		
	Average	53570.4			Average	3421231			Average	408888			Average	278125	Max Time:	Pivot 2
1	5000	5507946		1	5000	2725134		1	5000	5762366		1	5000	10173621		
2	5000	1132641		2	5000	3132837		2	5000	6326513		2	5000	7314562		
3	5000	1537579		3	5000	3653528		3	5000	7266365		3	5000	9196635		
4	5000	1333727		4	5000	3215405		4	5000	5940143		4	5000	7875549		
5	5000	1018073		5	5000	1363357		5	5000	1822813		5	5000	1745776		
	Average	10529966			Average	14090261			Average	27118200			Average	36306143	Max Time:	Pivot 4
1	10000	1759998		1	10000	3207503		1	10000	3158121		1	10000	3696590		
2	10000	1744591		2	10000	3013924		2	10000	3401084		2	10000	4540441		
3	10000	1304493		3	10000	2413825		3	10000	3406219		3	10000	3240689		
4	10000	1608295		4	10000	2000196		4	10000	6074069		4	10000	4030416		
5	10000	1540740		5	10000	2347060		5	10000	3258071		5	10000	3397528		
	Average	7958117			Average	12982508			Average	19297564			Average	18905664	Max Time:	Pivot 3





