#include<iostream>
#include<cmath>
#include "Point2D.h"

using namespace std;

Point2D::Point2D(){
	x = 0.0;
	y = 0.0;
}

Point2D::Point2D(float a,float b){
	x = a;
	y = b;
}
float Point2D::getX(){
	return x;
}
float Point2D::getY(){
	return y;
}
void Point2D::setX(float a){
	x = a;
}
void Point2D::setY(float b){
	y = b;
}
Dothi Point2D::calcuLine(Point2D &p1){
	float a,b,c;
	if(x == p1.getX() && y != p1.getY()){
		a = 1;
		b = 0;
		c = (-1)*x;
	} else if(y == p1.getY() && x !=p1.getX()){
		a = 0;
		b = 1;
		c = (-1)*y;
	} else if(y == p1.getY() && x == p1.getX()){
		//continue;
	} else {
		a = (-1)*(y - p1.getY())/(x - p1.getX());
		b = 1;
		c = ((-1)*y - a*x);
	}
	Dothi dt;
	dt.a = a;
	dt.b = b;
	dt.c = c;
	return dt;
}
float Point2D::distanceLine(Dothi dt){
	float temp = dt.a*x + dt.b*y +dt.c;
	return abs(temp)/sqrt(dt.a * dt.a + dt.b * dt.b);
}

void Point2D::show(){
	cout<<"(x,y) = ("<<x<<","<<y<<")"<<endl;
}

float Point2D::offset(float a){
	float subb = y - a;
	return subb * subb;
}
float Point2D::squareX(){
	return x*x;
}
float Point2D::squareY(){
	return y*y;
}
float Point2D::mulXY(){
	return x*y;
}



