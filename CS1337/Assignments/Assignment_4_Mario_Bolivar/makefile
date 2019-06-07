#Makefile for "Assignment 3"
#Created by Mario Bolivar - mjb160330 10/01/17
#CE - 1337.501

PROG = Assignment_4_Mario_Bolivar.exe 
CC = g++ 
CPPFLAGS = -g -Wall
ZIPPROG = 7z
ZIPVAR = $(ZIPPROG) a -tzip $(ZIP) $(ZIPPATH)
ZIPPATH = C:\Users\mario\Desktop\School\CS1337\Assignments\Assignment_4_Mario_Bolivar
ZIP = Assignment_4_Mario_Bolivar.zip 
OBJS = main.o data.o
HDRS = data.h
CPPS = main.cpp data.cpp


$(PROG) : $(OBJS)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
main.o : $(CPPS)
	$(CC) $(CPPFLAGS) -c main.cpp
data.o : data.h
	$(CC) $(CPPFLAGS) -c data.cpp
clean : 
	del /f $(PROG) $(OBJS)
package : 
	$(ZIPVAR)