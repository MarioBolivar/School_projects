Mario Bolivar
Mjb160330
CE 3345.001

Project 3 Submission

/**
*
* This program reads an input file specified via argument passed in
* and interacts with an implemented LazyBinarySearchTree class. 
* For every command read from input file, the results of the command
* are outputted to an outputfile also specified through console arguments.
*
*/


IDE Used: Netbeans

Sample tested input:

Insert:98
Insert:67
Insert:55
Insert:45
PrintTree
Delete:84
Delete:45
Contains:45
FindMin
FindMax
PrintTree
Height
Size
Insert:84
Insert:32
Insert:132
PrintTree
Insert:980
Insert
hih

Sample tested output:

true
true
true
true
98 67 55 45 
false
true
false
55
98
98 67 55 *45 
3
4
true
true
Error in insertion: IllegalArgumentException raised
98 67 55 *45 32 84 
Error in insertion: IllegalArgumentException raised
Error in Line: Insert
Error in Line: hih
