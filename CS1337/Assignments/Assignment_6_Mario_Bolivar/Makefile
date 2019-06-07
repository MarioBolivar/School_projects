#Makefile for "Assignment 6"
#Created by Mario Bolivar - mjb160330 11/19/17
#CE - 1337.501

PROG = Assignment_6_Mario_Bolivar.exe 
CC = g++ 
CPPFLAGS = -g -Wall
ZIPPROG = 7z
ZIPVAR = $(ZIPPROG) a -tzip $(ZIP) $(ZIPPATH)
ZIPPATH = C:\Users\mario\Dropbox\School\CS1337\Assignments\Assignment_6_Mario_Bolivar
ZIP = Assignment_6_Mario_Bolivar.zip 
OBJS = main.o ship.o cruiseShip.o cargoShip.o
HDRS = ship.h cruiseShip.h cargoShip.h
CPPS = main.cpp ship.cpp cruiseShip.cpp cargoShip.cpp


$(PROG) : $(OBJS)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
main.o : $(CPPS)
	$(CC) $(CPPFLAGS) -c main.cpp
ship.o : ship.h
	$(CC) $(CPPFLAGS) -c ship.cpp
cruiseShip.o : cruiseShip.h
	$(CC) $(CPPFLAGS) -c cruiseShip.cpp
cargoShip.o : cargoShip.h
	$(CC) $(CPPFLAGS) -c cargoShip.cpp
clean : 
	del /f $(PROG) $(OBJS)
package : 
	$(ZIPVAR)