/*2.Vehicle Management System

Design a class Vehicle representing general information about vehicles with members like vehicle_id and vehicle_type.

Derive two specialized classes:

ElectricVehicle with members battery_capacity and charging_time, and a method chargeBattery().

DieselVehicle with member fuel_capacity, and a method refuelDiesel().

The system should:

Allow dynamic addition of vehicles using polymorphism.

Accept & Display information using a virtual function.

Use RTTI (e.g., dynamic_cast or instanceof) to invoke vehicle-specific behavior.*/

#include<iostream>
#include<vector>
#include<string>
using namespace std;

class Vehicle{
    protected:
    int vehicle_id;
    string vehicle_type;
    public:
    Vehicle(){
        this->vehicle_id = 0;
        this->vehicle_type = 'null';
    }
       int getvehicleid() const { 
        return vehicle_id;
     }
    virtual void Accept(){
        cout<<"enter vehicle type:"<<endl;
        cin>>vehicle_type;


    }
    virtual void display(){
        cout<<"vehicle_id:"<<vehicle_id<<endl;
        cout<<"vehicle_type:"<<vehicle_type<<endl;
    }
      virtual ~Vehicle(){};
};
class ElectricVehicle: public Vehicle{
   private:
   double battery_capacity;
   double charging_time;

   public:
       ElectricVehicle():Vehicle(){
          battery_capacity=0;
           charging_time=0;

       }
       public:
       void Accept()override{
        Vehicle::Accept();
        cout<<"enter vehicle battery capacity:"<<endl;
        cin>>battery_capacity;
        cout<<"enter vehicle charging time:"<<endl;
        cin>>charging_time;

       }
       void display()override{
        Vehicle::display();
        cout<<"battery capacity:"<<battery_capacity<<endl;
        cout<<"charging time:"<<charging_time<<endl;
       }
            
    void chargeBattery() {
        cout << "Charging battery of " << vehicle_type<<"vehicle." ;
        }

};

class Dieselvehicle : public Vehicle{
    double fuel_capacity;

    public:
    Dieselvehicle():Vehicle(){
        this->fuel_capacity= fuel_capacity;
    }

    void Accept()override{
        Vehicle::Accept();
        cout<<"enter vehicle fuel capacity:"<<endl;
        cin>>fuel_capacity;

    }
    void display() override{
        Vehicle::display();
         cout<<"fule capacity:"<<fuel_capacity<<endl;

    }
    void refuelDiesel() {
        cout << "Refueling diesel for " << vehicle_type ;

}
};
int main(){
    vector<Vehicle*>Vehicles;
    int choice;
    int id;
    Vehicle* v = nullptr;
    do{
         cout << "\n--- Vehicle Management System ---\n";
        cout << "1. Add Electric Vehicle\n";
        cout << "2. Add Diesel Vehicle\n";
        cout << "3. Display All Vehicles\n";
        cout << "4. Perform Specific Operations (RTTI)\n";
        cout << "0. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        switch(choice){
            case 1:
                  cout<<"enter vhecle id:"<<endl;
                  cin>>id;
                  bool flag = false;
                   v= new ElectricVehicle();
                   for(Vehicle* v:Vehicles){
                   if(v->getvehicleid()==id);{
                   cout<<"vehicle is alrady exist...!";
                   flag=true;
                   break;
                   }
                     }
                     if(flag)


        }
    }while(choice!=0)
}