#Makefile for "Assignment 2"
#Created by Mario Bolivar - mjb160330 9/14/17
#CE - 1337.501

PROG = Assignment_2_Mario_Bolivar.exe 
CC = g++ 
CPPFLAGS = -g -Wall
ZIPPROG = 7z
ZIPVAR = $(ZIPPROG) a -tzip $(ZIP) $(ZIPPATH)
ZIPPATH = C:\Users\mario\Desktop\School\CS1337\Assignments\Assignment_2_Mario_Bolivar
ZIP = Assignment_2_Mario_Bolivar.zip 
OBJS = main.o YearlySum.o Average.o 
HDRS = YearlySum.h Average.H
CPPS = YearlySum.cpp Average.cpp


$(PROG) : $(OBJS)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
main.o : $(CPPS)
	$(CC) $(CPPFLAGS) -c main.cpp
YearlySum.o : Yearlysum.h
	$(CC) $(CPPFLAGS) -c YearlySum.cpp
Average.o : Average.h 
	$(CC) $(CPPFLAGS) -c Average.cpp
clean : 
	del /f $(PROG) $(OBJS)
package : 
	$(ZIPVAR)