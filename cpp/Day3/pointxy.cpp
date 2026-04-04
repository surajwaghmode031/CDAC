// Create a class Point with data members as x,y. Create Default and Parameterized constructors. Write 
// getters and setters for all the data members. Also add the display function. Create the object of this 
// class in main method and invoke all the methods in that class. 

#include<iostream>
#include<string>
using namespace std;
class point {
    int x;
    int y;
    public:
    //non parameterised constructor
    point (){
       x=0;
       y=0;
    }
    //parameterised constructor
    point (int x,int y){
        this ->x=x;
        this ->y=y;
       }
       //setter
    void setter(int x,int y){
        this->x=x;
        this->y=y;
    }
    //display function
   void display(){
    cout<<"point x:"<<x<<endl;
    cout<<"point y:"<<y<<endl;
   }
};
int main()
{
    point p1;
    p1.display();
    point p2(10,20);
    p2.display();
    p2.setter(15,45);
    p2.display();

  return 0;  
} 