#include "data.h"

student* fileInput(fstream &file,int &arraySize){
    

    file.read(reinterpret_cast<char*>(&arraySize),sizeof(arraySize));
    
    student *studentArray = new student[arraySize];

    int index = 0;
    do{

        file.read(reinterpret_cast<char*>(&studentArray[index]),sizeof(student));
        index++;


    }while(!file.eof());

    file.close();

    return studentArray;
}


void enterStudent(student* studentArray,int &arraySize){

    string firstName,lastName;
    double GPA,yearInSchool;
    char choice;
    int newArrSize = arraySize, studentID;
    
    do{
        newArrSize++;
        student *temp = new student[newArrSize];
        
        for(int i = 0; i < arraySize; i++){
            
            temp[i].firstName = studentArray[i].firstName;
            temp[i].lastName = studentArray[i].lastName;
            temp[i].GPA = studentArray[i].GPA;
            temp[i].yearInSchool = studentArray[i].yearInSchool;

        }


        cout << "Enter student ID: ";
        cin >> studentID;

        while(cin.fail()){
            cin.clear();
            cin.ignore();
            cin.clear(); 
            cout << "\nPlease enter a correct input!\n";
            cout << "Enter student ID: "; 
            cin >> studentID;
        }
        
        temp[newArrSize - 1].studentID = studentID;
        

        cout << "Enter student first name: ";
        cin >> firstName;

        while(cin.fail()){
            cin.clear();
            cin.ignore();
            cin.clear(); 
            cout << "\nPlease enter a correct input!\n";
            cout << "Enter student first name: "; 
            cin >> firstName;
        }
        
        temp[newArrSize - 1].firstName = firstName;

        cout << "Enter student last name: ";
        cin >> lastName;
        
        while(cin.fail()){
            cin.clear();
            cin.ignore();
            cin.clear(); 
            cout << "\nPlease enter a correct input!\n";
            cout << "Enter student last name: "; 
            cin >> lastName;
        }

        temp[newArrSize - 1].lastName = lastName;

        cout << "Enter student year in school (1-4): ";
        cin >> yearInSchool;

        while(cin.fail() || yearInSchool < 1 || yearInSchool > 4){
            cin.clear();
            cin.ignore();
            cin.clear(); 
            cout << "\nPlease enter a correct input!\n";
            cout << "Enter student year in school: "; 
            cin >> yearInSchool;
        }

        temp[newArrSize - 1].yearInSchool = yearInSchool;

        cout << "Enter student GPA: ";
        cin >> GPA;

        while(cin.fail()){
            cin.clear();
            cin.ignore();
            cin.clear(); 
            cout << "\nPlease enter a correct input!\n";
            cout << "Enter student GPA: "; 
            cin >> GPA;
        }
            
        temp[newArrSize - 1].GPA = GPA;

        cout << "Enter new student data (Y/N)?: ";
        cin >> choice;
        while(cin.fail() || choice != 'Y' && choice != 'y' && choice != 'N' && choice != 'n'){
            cin.clear();
            cin.ignore();
            cin.clear(); 
            cout << "\nPlease enter a correct input!\n";
            cout << "Enter student new student data (Y/N)?: "; 
            cin >> choice;
        }
        
        
        delete [] studentArray;

        studentArray = new student[newArrSize];

        for(int j = 0; j < arraySize; j++){
            
            studentArray[j].firstName = temp[j].firstName;
            studentArray[j].lastName = temp[j].lastName;
            studentArray[j].GPA = temp[j].GPA;
            studentArray[j].yearInSchool = temp[j].yearInSchool;

        }

        delete [] temp;

    }while(choice == 'y' || choice == 'Y');

    arraySize = newArrSize;

}

void searchStudent(student* studentArray,int arraySize){

    int studentID;

    cout << "Enter student ID: ";
    cin >> studentID;

    while(cin.fail()){
        cin.clear();
        cin.ignore();
        cin.clear();
        cout << "\nPlease enter a correct input!\n";
        cout << "Enter student ID: ";
        cin >> studentID;

    }

    int count = 0;
    bool found = false;
    for(int i = 0; i < arraySize; i++){
        
        if(studentArray[i].studentID == studentID){
            count = i;
            cout << "Record for Student is: \n";
            cout << "First Name: " << studentArray[count].firstName << endl;
            cout << "Last Name: " << studentArray[count].lastName << endl;
            cout << "Year in School: " << studentArray[count].yearInSchool << endl;
            cout << "GPA: " << studentArray[count].GPA << endl;
            found = true;
            break;
        }
    }

    if(!found){
        cout << "Student not found!\n\n";
    }

    

}

void showStudentList(student* studentArray,int arraySize){

    cout << setw(5) << left << "ID" << setw(20) << left << "First Name" << setw(20) << left << "Last Name" << setw(20) << left << "Year In School" << setw(20) << left << "GPA\n";
    cout << "________________________________________________________________________________________________________\n\n";

    for(int i = 1; i < arraySize; i++){

        cout << setw(5) << left << studentArray[i].studentID << setw(20) << left << studentArray[i].firstName << setw(20) << left << studentArray[i].lastName << setw(20) << left << studentArray[i].yearInSchool << setw(20) << left << studentArray[i].GPA << endl;
        
    }

}

void writeFile(student *studentArray,int arraySize){

    fstream outputfile;

    outputfile.open("data.db", ios::out | ios::binary);
    outputfile.write(reinterpret_cast<char*>(&arraySize),sizeof(arraySize));

    if(outputfile){
     
        for(int i = 0; i < arraySize;)
        {
            outputfile.write(reinterpret_cast<char*>(&studentArray[i]),sizeof(student));
        }
    }
    else{

        cout << "ERROR: Unable to write file 'data.db'!\n";
    }

    delete [] studentArray;
    outputfile.close();

}