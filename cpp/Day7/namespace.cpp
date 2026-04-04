// 7: Create Student class in namespace CDAC namespace.
// Create another Student class in IACSD namespace.
// Try to access both student classes using namespace

#include <iostream>
using namespace std;

namespace CDAC {
    class Student {
    public:
        void display() {
            cout << "CDAC Student class\n";
        }
    };
}

namespace IACSD {
    class Student {
    public:
        void display() {
            cout << "IACSD Student class\n";
        }
    };
}

int main() {
    CDAC::Student s1;
    IACSD::Student s2;

    s1.display();
    s2.display();

    return 0;
}
