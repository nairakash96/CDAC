/*Create a class Circle, it will have only one constructor which accepts radius as an argument. 
Write two methods in the class - calcuateArea(), calculatePermiter(). 
Write test class to test method calls.*/

import java.util.*;
class Circle{
	int rad;
	float PI=3.142f;
	float area;
	float peri;
	Circle(int rad){
	this.rad=rad;
	}

float findArea(){
	this.area=(PI*rad*rad);
	return area;
}

float FindPeri(){
	this.peri=(2*PI*rad);
	return peri;
}
}