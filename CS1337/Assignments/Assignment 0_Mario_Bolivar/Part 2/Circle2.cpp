#include <iostream>
#include <iomanip>
#include "circle_functions.h"

using namespace std;



int main()


{
       
    cout << fixed << showpoint << setprecision(2);
    float radius = 0, area=0, circumference=0;
	
    cout << "Enter the radius of the circle: ";
    cin  >> radius;

    // Calling functions
    findArea(radius, area);
    findCircumference(radius,circumference);
        
    cout << "The radius of the circle is:  " << radius << endl;
    cout << "The area  of the circle is:  " << area << endl;
    cout << "The circumference of the circle is:  " << circumference << endl << endl;

    return 0;
}

