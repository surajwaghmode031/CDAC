// Create a class Book with data members as bname,id,author,price. Write getters and setters for all the 
// data members. Also add the display function. Create Default and Parameterized constructors. Create 
// the object of this class in main method and invoke all the methods in that class.
// Create a class Person with data members as name, age, city. Write getters and setters for all the data 
// members. Also add the display function. Create Default and Parameterized constructors. Create the 
// object of this class in main method and invoke all the methods in that class. 


#include<iostream>
#include<string>
using namespace std;
class book {
    string bname;
    int id;
    string author;
    double price;
    public:
    book (){
        bname="xyz";
        id=0;
        author="xyz";
        price=0.0;
    
    }
    book (string bname,int id,string author,double price){
        this ->bname=bname;
        this ->id=id;
        this -> author=author;
        this ->price=price;
    }
    void setter(string name,int id,string author ,double price){
        this->bname=name;
        this->id=id;
        this->author=author;
        this->price=price;
    }
   void display(){
    cout<<"bname :"<<bname<<endl;
    cout<<"id :"<<id<<endl;
    cout<<"author :"<<author<<endl;
    cout<<"price :"<<price<<endl;
   }
};
int main()
{
    book p1;
    p1.display();
    book p2("match",30,"wani",20);
    p2.display();
    p2.setter("komal",40,"amol",30);
    p2.display();

  return 0;  
} 