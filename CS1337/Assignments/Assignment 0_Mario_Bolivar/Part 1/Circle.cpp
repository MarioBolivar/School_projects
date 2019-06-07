#include <iostream>
#include <iomanip>

using namespace std;

/*  Mario Bolivar - Mjb 160330   
            CE 1337.501
    This program demonstrates how to calculate a circle area and circumference
*/

const double PI = 3.14;


void findArea(float, float&);
void findCircumference(float, float&);


int main()

{
	
    cout << fixed << showpoint << setprecision(2);
    float radius = 0, area=0, circumference=0;
	
    // -- TODO 2-- Get the radius as a user input, then calculate

    cout << "Please input the radius of the circle:";
    cin >> radius;

    area = radius * radius * PI;

    circumference = 2 * PI * radius;

        
    cout << "The radius of the circle is:  " << radius << endl;
    cout << "The area  of the circle is:  " << area << endl;
    cout << "The circumference of the circle is:  " << circumference << endl << endl;

	   
    return 0;
}

//  *********************************************************************
//                           findArea
//   
//   task:     This function finds the area of a circle given its radius
//   data in:  radius of a circle
//   data out: answer (which alters the corresponding actual parameter)
//
//   ********************************************************************


void findArea(float rad, float& answer)
{
	
    cout << "AREA FUNCTION" << endl << endl;
	
    //  -- TODO 3-- FILL in the code, given that parameter rad contains the radius, that
    // will find the area to be stored in answer

    answer = rad * rad * PI;


	
}

//  ******************************************************************************
//                           findCircumference
//   
//   task:     This function finds the circumference of a circle given its radius
//   data in:  radius of a circle
//   data out: distance (which alters the corresponding actual parameter)
//
//   *****************************************************************************




void findCircumference(float length, float& distance)

{
    cout << "CIRCUMFERENCE FUNCTION" << endl << endl;

	
    //  -- TODO 4 -- FILL in the code, given that parameter length contains the radius, 
    // that will find the circumference to be stored in distance

    distance = 2 * PI * length;
	
}