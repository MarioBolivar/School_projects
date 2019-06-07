#include <iostream>
#include <fstream>
#include "data.h"

using namespace std;

int mainmenu();

int main(){


    fstream file;
    int arraySize = 1;
    student *studentArray;

    file.open("data.db", ios::in | ios::binary);
    
    if(file){
        studentArray = fileInput(file,arraySize);
    }
    else{
        cout << "\n\n'Data.db' not found, new file will be created.\n";
        studentArray = new student[arraySize];
    }

    int choice;
    do{
    
        choice = mainmenu();
    
        
        if(choice == 1){
            enterStudent(studentArray,arraySize);
        }
        else if(choice == 2){
            if(arraySize == 1){
                cout << "\n\nNo student information available!\n";
            }
            else{
                searchStudent(studentArray,arraySize);
            }
        }
        else if(choice == 3){
            if(arraySize == 1){
                cout << "\n\nNo student information available!\n";
            }
            else{
                showStudentList(studentArray,arraySize);
            }
            
        }
        else if(choice == 4){

            cout << "\n\nExiting... Thank you for using this program!\n";
            writeFile(studentArray,arraySize);
        }
    }while(choice != 4);


    return 0;
}


int mainmenu(){

    int choice;
    
        cout << "1- Enter data manually" << endl;
        cout << "2- Find student by ID" << endl;
        cout << "3- Show student list" << endl;
        cout << "4- Exit program" << endl;
        cout << ">Please select from the following options: ";
        cin >> choice;
    
        while(cin.fail() || choice > 4 || choice < 1){
            cin.clear();
            cin.ignore();
            cin.clear();  
            cout << "\n >Please enter a correct choice.\n";
            cout << "1- Enter data manually" << endl;
            cout << "2- Find student by ID" << endl;
            cout << "3- Show student list" << endl;
            cout << "4- Exit program" << endl;
            cout << ">Please select from the following options: ";
            cin >> choice;
            
        }

        return choice;


}