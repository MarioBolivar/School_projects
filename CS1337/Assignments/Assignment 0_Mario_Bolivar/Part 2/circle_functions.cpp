#include <iostream>
#include "circle_functions.h"



using namespace std;



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