#include<iostream>
#include<map>
#include<string>
using namespace std;
struct student{
    string name;
    int marks;

};

    map<int,student>students;

  void addstudents(int id,string name,int marks){

    if(students.find(id)!=students.end()){
       cout<<"student is alrady exist,,,!"<<endl;
       return;
    }
      students[id] = {name, marks};
      cout << "Student added successfully!\n";
  }
  void displaystudents(){
     if(students.empty()){
        cout<<"students record not found"<<endl;
        return;
     }
     for(auto &a:students){
        cout<<"id: "<<a.first;
        cout<< ", Name: " << a.second.name ;
        cout<< ", Marks: " << a.second.marks << endl;
     }
 }
     void updatestudents(int id ,int newmarks){
        auto it = students.find(id);
        if (it != students.end()){
            it->second.marks= newmarks;
        }
     }
     void deleteStudent(int id) {
    if (students.erase(id))
        cout << "Student deleted successfully!\n";
    else
        cout << "Student with ID " << id << " not found.\n";
     }

     int main() {
    int choice;
    do {
        cout << "\n==== Student CRUD Menu (map) ====\n";
        cout << "1. Add Student\n";
        cout << "2. Display Students\n";
        cout << "3. Update Student Marks\n";
        cout << "4. Delete Student\n";
        cout << "5. Exit\n";
        cout << "Enter choice: ";
        cin >> choice;

        if (choice == 1) {
            int id, marks;
            string name;
            cout << "Enter ID: "; cin >> id;
            cout << "Enter Name: "; cin >> name;
            cout << "Enter Marks: "; cin >> marks;
            addstudents(id, name, marks);
        }
        else if (choice == 2) {
           displaystudents();
        }
        else if (choice == 3) {
            int id, marks;
            cout << "Enter ID to update: "; cin >> id;
            cout << "Enter new Marks: "; cin >> marks;
            updatestudents(id, marks);
        }
        else if (choice == 4) {
            int id;
            cout << "Enter ID to delete: "; cin >> id;
            deleteStudent(id);
        }
        else if (choice == 5) {
            cout << "Exiting...\n";
        }
        else {
            cout << "Invalid choice!\n";
        }
    } while (choice != 5);

    return 0;
}



