#Makefile for "Assignment 1"
#Created by Mario Bolivar - mjb160330 9/8/17

PROG = Assignment_1_Mario_Bolivar_Mjb160330.exe
CC = g++
CPPFLAGS = -g -Wall
ZIPPROG = 7z
ZIPPATH =  %USERPROFILE%\Desktop\Assignment_1_Mario_Bolivar.zip
ZIPVAR = a -tzip 
PROGPATH = %USERPROFILE%\Desktop\School\CS1337\Assignments\Assignment_1_Mario_Bolivar
OBJS = main.o sort.o search.o mean.o
HDRS = search.h sort.h mean.h
CPPS = main.cpp search.cpp mean.cpp sort.cpp

$(PROG) : $(OBJS)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
main.o : $(HDRS) $(CPPS)
	$(CC) $(CPPFLAGS) -c main.cpp 
sort.o :sort.h
	$(CC) $(CPPFLAGS) -c sort.cpp
search.o: search.h
	$(CC) $(CPPFLAGS) -c search.cpp
mean.o : mean.h
	$(CC) $(CPPFLAGS) -c mean.cpp
clean:
	del /f $(PROG) $(OBJS)
package:
	$(ZIPPROG) $(ZIPVAR) $(ZIPPATH) $(PROGPATH)