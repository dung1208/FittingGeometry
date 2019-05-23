//Chuong trinh tinh bo tham so a va b cua dung thang y= ax+ b
//NGUYEN HUU XUAN
//Mssv: 20164742

#include<iostream>
#include<fstream>
using namespace std;

//Khai bao kieu du lieu:
struct point
{
	float x;
	float y;
}; 

// Lay du lieu tu file text:
void ReadFromFile(point p[], int n, ifstream &ifs)
{
	for (int i = 0; i < n; i++)
	{
		ifs >> p[i].x;
		ifs >> p[i].y;
		cout << "point " << i+1<< ": x= " << p[i].x << ";y= " << p[i].y << endl;
	};
}

// Xuat du lieu ra file text:
void WriteToFile(point p[], int n, ofstream &ofs)
{
	ofs << n << endl;
	for (int i = 0; i < n; i++)
	{
		ofs << p[i].x << " " << p[i].y << endl;
	}
}

// Thuat toan loc trung binh: 
void MeanFilter(point P[], int n)
{
	//Mo rong mang :
	point *extendP = new point[n + 4];
	extendP[0] = P[2];
	extendP[1] = P[1];
	extendP[n + 2] = P[n - 2];
	extendP[n + 3] = P[n - 3];
	memcpy_s(extendP + 2, n * sizeof(point), P, n * sizeof(point));
	
	//Loc:
	for (int i = 0; i < n; i++)
	{
		P[i].x = (extendP[i].x + extendP[i + 1].x + extendP[i + 2].x + extendP[i + 3].x + extendP[i + 4].x) / 5;
		P[i].y = (extendP[i].y + extendP[i + 1].y + extendP[i + 2].y + extendP[i + 3].y + extendP[i + 4].y) / 5;
	};
	delete extendP;
}

// Thuat toan loc trung vi:
void MedianFilter(point P[], int n)
{
	//Mo rong mang:
	point *extendP = new point[n + 4];
	extendP[0] = P[2];
	extendP[1] = P[1];
	extendP[n + 2] = P[n - 2];
	extendP[n + 3] = P[n - 3];
	memcpy_s(extendP + 2, n * sizeof(point), P, n * sizeof(point));
	
	//Loc: 
	for (int i = 0; i < n; i++)
	{
		for (int j = i; j < i + 3; j++)
		{
			for (int k = i + 1; k < i + 4; k++)
			{
				if (extendP[j].x > extendP[k].x)
				{
					float temp1 = extendP[j].x;
					extendP[j].x = extendP[k].x;
					extendP[k].x = temp1;
				};
				if (extendP[j].y > extendP[k].y)
				{
					float temp2 = extendP[j].y;
					extendP[j].y = extendP[k].y;
					extendP[k].y = temp2;
				};
			};
		};

		P[i] = extendP[i + 2];
	};
}

// Thuat toan binh phuong cuc tieu tim tham so a va b:
void LeastMeanSquare(point P[], int n)
{
	float a1 = 0, b1 = 0, c1 = 0, a2 = 0, b2 = 0, c2 = 0, a, b;
	for (int i = 0; i < n; i++)
	{
		a1 = a1 + P[i].x*P[i].x;
		b1 = b1 + P[i].x;
		c1 = c1 + P[i].x*P[i].y;
		a2 = a2 + P[i].x;
		b2 = n;
		c2 = c2 + P[i].y;
	};
	a = (float)(c1*b2 - b1 * c2) / (float)(a1*b2 - a2 * b1);
	b = (float)(a1*c2 - a2 * c1) / (float)(a1*b2 - a2 * b1);
	cout << "a= " << a << endl;
	cout << "b= " << b << endl;
}

int main()
{
	//Lay du lieu tu file text vao xu li:
	ifstream InFile("nhap.txt");
	ofstream OutFile("xuatmean.txt"), OutFile1("xuatmedian.txt");
	int n;
	InFile >> n;
	point *P = new point[n];
	ReadFromFile(P, n, InFile);
	InFile.close();

	//Loc nhieu salt& peper va xuat du lieu sau khi loc: 
	MedianFilter(P, n);
	WriteToFile(P, n, OutFile1);
	OutFile1.close();

	//loc nhieu gauss va xuat du lieu sau khi loc:
	MeanFilter(P, n);
	WriteToFile(P, n, OutFile);
	OutFile.close();
	
	//Tim duong thang:
	LeastMeanSquare(P, n);
	
	system("pause");
	return 0;
}

