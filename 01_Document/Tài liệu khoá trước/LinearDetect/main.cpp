/*
De tai: Xac dinh duong thang tu mot tap hop diem cho truoc bang 3 phuong phap: Least Mean Squares, RANSAC va Adaptive RANSAC
- Buoc 1: Nhap du lieu bang file, du lieu thu duoc luu vao mang Vector
- Buoc 2: Viet cac ham thuc hien cho 3 thuat toan
	* Least Mean Squares: Duyet tat ca cac phan tu de tinh toan cac tong can thiet tu do thiet lap phuong trinh
	* RANSAC: Lay lan luot 2 diem trong n diem de tao 1 duong thang. Tinh khoang cach cac diem con lai den duong thang do va
			  tien hanh loc cac diem nhieu. Duong thang duoc tao boi nhieu diem nhat duoc coi la best_model.
	* Adaptive RANSAC: Y tuong thuc hien giong nhu RANSAC tuy nhien dua vao cong thuc N = log(1-p)/log(1-(1-e)^2) ma voi moi lan xac dinh
			  duoc mot best_model thi so lan lap can thiet se giam xuong. Dua vao so sanh N voi so lan lap da thuc hien ma best_model tuong doi se
			  duoc lua chon.
- Buoc 3: Tao Menu de user lua chon thuat toan su dung 
*/
#include "Point2D.h"
#include<iostream>
#include<vector>
#include<cmath>
#include<string>
#include <cstdlib>
#include <ctime>
#include<conio.h>
#include<fstream>
using namespace std;

vector<Point2D> insertInput(ifstream &Input);		//Ham de xu ly file luu du lieu vao mang Vector
vector<Point2D> checkModel(vector<Point2D> arr,float T,Dothi mdodel);	//Ham kiem tra khoang cach cac diem con lai voi mot model xac dinh
float calculateT(vector<Point2D> arr,Dothi model);	//Ham xac dinh tham so T de tien hanh so sanh
void print(vector<Point2D>  arr);					//Ham in mot mang vector bat ky
int random(int n);									//Tao random 1 so nguyen trong khoang 0-n
void showMenu();									//Hien thi menu cho user
void leastSquareFitting(vector<Point2D> intialData);//Thuat toan LeastMeanSquare
void ransac(vector<Point2D> intialData);			//Thuat toan RANSAC
void adaptiveRansac(vector<Point2D> intialData);	//Thuat toan Adaptive RANSAC
void output(Dothi best_model);

int main(){
	vector<Point2D> intialData;
	
	ifstream Input ("Input_100.txt");
	intialData = insertInput(Input);
	
	showMenu();
	while(1){
		char c = getch();
		switch(c){
			case '1': cout<<"Least Mean Square:"<<endl;
					 leastSquareFitting(intialData);cout<<endl; break;
			case '2': cout<<"RANSAC:"<<endl;
					 ransac(intialData);cout<<endl; break;
			case '3': cout<<"Adaptive RANSAC:"<<endl;
					 adaptiveRansac(intialData);cout<<endl; break;
			default: cout<<"Da thoat chuong trinh";return 0;
		}
	}	
}

void adaptiveRansac(vector<Point2D> intialData){
	//Adaptive RANSAC
	//Thuc hien N vong lap
	Dothi best_model;
	vector<Point2D> best_consensus_set;
	int n;
	int best_num_point = 0;
	float T=1;
	int N = 10000,sample_count=0;
	float e;
	float p = 0.99;
	n = intialData.size();
	srand((int)time(0));
	while(N > sample_count){
		vector<Point2D> copyData(intialData);
		int rand_1 =  random(n);
		int rand_2 =  random(n);
		while(rand_2 == rand_1) rand_2 = random(n);
		Point2D p1 = copyData.at(rand_1);
		Point2D p2 = copyData.at(rand_2);
		copyData.erase(copyData.begin()+ rand_1);
		copyData.erase(copyData.begin()+ rand_2);
		Dothi model = p1.calcuLine(p2);
		
		T = calculateT(copyData,model);
		
		vector<Point2D> consensus_set = checkModel(copyData,T,model);
		if(consensus_set.size()>best_num_point){
			best_num_point = consensus_set.size();
			best_consensus_set.clear();
			consensus_set.push_back(p1);
			consensus_set.push_back(p2);
			best_consensus_set = consensus_set;
			best_model = model;
			e = 1 - ((float)consensus_set.size()/n);
			N = log10(1-p)/log10(1-pow((1-e),2));
		}
		sample_count++;
	}
	cout<<"So lan lap thuc hien: "<<sample_count<<endl;
	print(best_consensus_set);
	output(best_model);
}

void ransac(vector<Point2D> intialData){
	Dothi best_model;
	vector<Point2D> best_consensus_set;
	int best_num_point = 0;
	float T = 1;
	int n;
	int count = 0;
	n = intialData.size();
	//RANSAC
	//Thuc hien n(n-1)/2 lan lap
	for(int i=0;i<n-1;i++){
		for(int j=i+1;j<n;j++){
			vector<Point2D> copyData(intialData);
			Point2D p1 = copyData.at(i);
			Point2D p2 = copyData.at(j);
			Dothi model = p1.calcuLine(p2);
			copyData.erase(copyData.begin()+ i);
			copyData.erase(copyData.begin()+ j);
			
			T = calculateT(copyData,model);
			
			vector<Point2D> consensus_set = checkModel(copyData,T,model);
			if(consensus_set.size() > best_num_point){
				best_num_point = consensus_set.size();
				best_consensus_set.clear();
				consensus_set.push_back(p1);
				consensus_set.push_back(p2);
				best_consensus_set = consensus_set;
				best_model = model;
			}
			count++;
		}
	}
	cout<<"So lan lap: "<<count<<endl;
	print(best_consensus_set);
	output(best_model);
}

void leastSquareFitting(vector<Point2D> intialData){
	float sumX=0,sumY=0,sumXY=0,sumX2=0,sumY2=0;
	float sumDistance=0,sumError=0;
	int n;
	Dothi measureLine;
	for(Point2D x : intialData){
		float para_x = x.getX();
		float para_y = x.getY();
		float para_xy = x.mulXY();
		float para_x2 = x.squareX();
		float para_y2 = x.squareY();
		sumX  += para_x;
		sumY  += para_y;
		sumXY += para_xy;
		sumX2 += para_x2;
		sumY2 += para_y2;
	}
	n = intialData.size();
	measureLine.a =(-1)*(n*sumXY - sumX*sumY) / (n*sumX2 - sumX*sumX); 
	measureLine.b = 1;
	measureLine.c =(-1)*(sumY*sumX2 - sumX*sumXY) / (n*sumX2 - sumX*sumX);
	cout<<measureLine.a<<"x+ "<<measureLine.b<<"y+ "<<measureLine.c<<" = 0"<<endl;
}

void showMenu(){
	cout<<"Chon phuong phap ban muon su dung:"<<endl;
	cout<<"Least Mean Squares : Nhan phim 1"<<endl;
	cout<<"RANSAC : Nhan phim 2 "<<endl;
	cout<<"Adaptive RANSAC : Nhan phim 3"<<endl;
	cout<<"Thoát : Nhan bat ky phim nao khac"<<endl;
	cout<<endl;
}

vector<Point2D> insertInput(ifstream &Input){
	vector<Point2D> data;
	int n = 0;
	float* pArr;
	if(!Input.is_open()){
		cout<<"Khong the mo file"<<endl;
	} else {
		pArr = (float*) malloc(sizeof(float));
		while(1){
			Input >>*(pArr+n);
			n++;
			pArr = (float*) realloc(pArr,(n+1)*sizeof(float));
			if(Input.eof()) break;
		}
		Input.close();
	}

	//Chuyen tu mang du lieu sang mang cac diem 2D
	for(int i = 0;i<n;i = i+2){
		Point2D p1 = Point2D();
		p1.setX(*(pArr+i));
		p1.setY(*(pArr+i+1));
		data.push_back(p1);
	}
	return data;
}

void print(vector<Point2D>  arr){
	int count = 0;
	//cout<<"(x,y): "<<endl;
	for (Point2D elem : arr){
		//cout <<"(" <<elem.getX()<<","<<elem.getY()<<"); ";
		count++;
		//if(count%5==0) cout<<endl;
	}
	//cout<<endl;	
	cout<<"So diem thoa man:"<<count<<endl;
}

vector<Point2D> checkModel(vector<Point2D> arr,float T,Dothi model){
	vector<Point2D> consensus_set;
	for (Point2D x : arr){
		if(x.distanceLine(model)<T){
			consensus_set.push_back(x);
		}
	}
	return consensus_set;
}

int random(int n){
	return rand()%n;
}

float calculateT(vector<Point2D> arr,Dothi model){
	float sumDis,mean = 0,s =0,sumOff = 0;
	int n = arr.size();
	for(Point2D point: arr){
		sumDis += (float)point.distanceLine(model);
	}
	mean = (float)sumDis/n;
	for (Point2D point : arr){
		sumOff += (point.distanceLine(model) - mean) * (point.distanceLine(model) - mean);
	}
	s = sqrt((float)sumOff/(n-1));
	return 2.34 * s/sqrt(n);
}

void output(Dothi best_model){
	if(best_model.c <0)
	cout<<best_model.a<<"x + y "<<best_model.c<<" = 0"<<endl;
	else cout<<best_model.a<<"x + y + "<<best_model.c<<" = 0"<<endl;
}



