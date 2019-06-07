#Makefile for "Assignment 3"
#Created by Mario Bolivar - mjb160330 10/01/17
#CE - 1337.501

PROG = Assignment_3_Mario_Bolivar.exe 
CC = g++ 
CPPFLAGS = -g -Wall
ZIPPROG = 7z
ZIPVAR = $(ZIPPROG) a -tzip $(ZIP) $(ZIPPATH)
ZIPPATH = C:\Users\mario\Desktop\School\CS1337\Assignments\Assignment_3_Mario_Bolivar
ZIP = Assignment_3_Mario_Bolivar.zip 
OBJS = main.o avgPlanesDeparted.o avgPlanesLanded.o leastAndGreatest.o total.o 
HDRS = main.h airportStruct.h avgPlanesDeparted.h avgPlanesLanded.h leastAndGreatest.h total.h
CPPS = main.cpp avgPlanesDeparted.cpp avgPlanesLanded.cpp leastAndGreatest.cpp total.cpp


$(PROG) : $(OBJS)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
main.o : $(CPPS)
	$(CC) $(CPPFLAGS) -c main.cpp
avgPlanesDeparted.o : avgPlanesDeparted.h
	$(CC) $(CPPFLAGS) -c avgPlanesDeparted.cpp
avgPlanesLanded.o : avgPlanesLanded.h 
	$(CC) $(CPPFLAGS) -c avgPlanesLanded.cpp
leastAndGreatest.o : leastAndGreatest.h
	$(CC) $(CPPFLAGS) -c leastAndGreatest.cpp
total.o : total.h
	$(CC) $(CPPFLAGS) -c total.cpp
clean : 
	del /f $(PROG) $(OBJS)
package : 
	$(ZIPVAR)