#Makefile for "Assignment 7"
#Created by Mario Bolivar - mjb160330 12/5/17
#CE - 1337.501

PROG1 = C:\Users\mario\Dropbox\School\CS1337\Assignments\Assignment_7_Mario_Bolivar\Part_1\Assignment_7_P1_Mario_Bolivar.exe 
PROG2 = C:\Users\mario\Dropbox\School\CS1337\Assignments\Assignment_7_Mario_Bolivar\Part_2\Assignment_7_P2_Mario_Bolivar.exe
CC = g++ 
CPPFLAGS = -g -Wall
ZIPPROG = 7z
ZIPVAR = $(ZIPPROG) a -tzip $(ZIP) $(ZIPPATH)
ZIPPATH = C:\Users\mario\Dropbox\School\CS1337\Assignments\Assignment_7_Mario_Bolivar
ZIP = Assignment_7_Mario_Bolivar.zip 
OBJS = main.o Calculator.o StackClass.o
HDRS = Calculator.h StackClass.h 
CPPS = main.cpp Calculator.cpp StackClass.cpp


$(PROG1) : $(OBJS1)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
$(PROG2) : $(OBJS1)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
main.o : $(CPPS)
	$(CC) $(CPPFLAGS) -c main.cpp
Calculator.o : Calculator.h
	$(CC) $(CPPFLAGS) -c Calculator.cpp
StackClass.o : StackClass.h
	$(CC) $(CPPFLAGS) -c StackClass.cpp
clean : 
	del /f $(PROG) $(OBJS)
package : 
	$(ZIPVAR)