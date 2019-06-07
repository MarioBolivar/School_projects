#ifndef DATA_H
#define DATA_H

#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>

using namespace std;

struct student{ 
    int studentID;
    string firstName;
    string lastName;
    short yearInSchool;
    double GPA;
};


student* fileInput(fstream&,int&);

void enterStudent(student*,int&);

void showStudentList(student*,int);

void searchStudent(student*,int);

void writeFile(student* studentArray,int arraySize);



#endif