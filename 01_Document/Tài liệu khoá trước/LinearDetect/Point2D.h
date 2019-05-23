#ifndef _HEADER_POINT2D_
#define _HEADER_POINT2D_

//Do thi ax+by+c = 0
struct Dothi{
	float a;
	float b;
	float c;
};

class Point2D {
	private:
		float x,y;
	
	public:
		Point2D();   //Constructor mac dinh
		Point2D(float a,float b);  //Secondary Contructor                 
		float getX();        //Tao setter-getter
		float getY();
		void setX(float a);
		void setY(float b);
		void show();
		Dothi calcuLine(Point2D &p1);		//Xac dinh duong thang di qua 2 diem
		float distanceLine(Dothi dt);		//Tinh khoang cach tu mot diem den duong thang bat ky
		
		float squareX();     //Tinh binh phuong X
		float squareY();	  //Tinh binh phuong Y
		float mulXY();       //Tinh tich XY
		float offset(float a);  // Tinh sai lech so voi duong tuyen tinh 
};

#endif
