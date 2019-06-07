#Makefile for "Assignment 5"
#Created by Mario Bolivar - mjb160330 11/6/17
#CE - 1337.501

PROG = Assignment_5_Mario_Bolivar.exe 
CC = g++ 
CPPFLAGS = -g -Wall
ZIPPROG = 7z
ZIPVAR = $(ZIPPROG) a -tzip $(ZIP) $(ZIPPATH)
ZIPPATH = C:\Users\mario\Dropbox\School\CS1337\Assignments\Assignment_5_Mario_Bolivar
ZIP = Assignment_5_Mario_Bolivar.zip 
OBJS = main.o InventoryClass.o CashRegisterClass.o
HDRS = InventoryClass.h CashRegister.h
CPPS = main.cpp InventoryClass.cpp CashRegisterClass.cpp


$(PROG) : $(OBJS)
	$(CC) $(CPPFLAGS) -o $(PROG) $(OBJS)
main.o : $(CPPS)
	$(CC) $(CPPFLAGS) -c main.cpp
CashRegister.o : CashRegisterClass.h
	$(CC) $(CPPFLAGS) -c CashRegisterClass.cpp
InventoryClass.o : InventoryClass.h
	$(CC) $(CPPFLAGS) -c InventoryClass.cpp
clean : 
	del /f $(PROG) $(OBJS)
package : 
	$(ZIPVAR)