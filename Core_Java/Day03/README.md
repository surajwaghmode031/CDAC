# Day 03 – Core Java

## Topics Covered

### 1. Constructor Chaining

**Constructor chaining** is the process of calling one constructor from another constructor within the same class or between a parent class and a child class.

It is used to reuse initialization logic, reduce code duplication, and maintain a proper object initialization sequence.

#### Types of Constructor Chaining

**a. Constructor Chaining Using `this()`**

- The `this()` statement calls another constructor of the same class.
- It is commonly used with constructor overloading.
- It helps avoid repeating initialization code.
- A constructor cannot call itself directly or indirectly in a cycle.
- In traditional Java syntax, `this()` must be the first statement of the constructor.

**Example:**

```java
class Student {

    int id;
    String name;

    Student() {
        this(101, "Suraj");
        System.out.println("Default Constructor");
    }

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("Parameterized Constructor");
    }

    void display() {
        System.out.println(id + " " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}
```

**Output:**

```text
Parameterized Constructor
Default Constructor
101 Suraj
```

**Execution Flow:**

1. `new Student()` invokes the no-argument constructor.
2. `this(101, "Suraj")` invokes the parameterized constructor.
3. The parameterized constructor initializes the instance variables.
4. Control returns to the no-argument constructor.
5. The remaining statements execute.
6. The `display()` method prints the initialized values.

**b. Constructor Chaining Using `super()`**

- The `super()` statement invokes a constructor of the immediate parent class.
- It is used during inheritance.
- It ensures that the parent portion of an object is initialized before the child constructor body executes.
- In traditional Java syntax, `super()` must be the first statement of the constructor.
- If neither `this()` nor `super()` is explicitly used, Java normally inserts an implicit `super()` call, subject to the language rules.

**Example:**

```java
class Parent {

    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {

    Child() {
        super();
        System.out.println("Child Constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
    }
}
```

**Output:**

```text
Parent Constructor
Child Constructor
```

#### Important Rules of Constructor Chaining

- Constructors are not inherited by subclasses.
- A constructor can be overloaded.
- `this()` invokes another constructor in the same class.
- `super()` invokes a constructor of the immediate parent class.
- In the traditional syntax used in these examples, a constructor cannot contain both an explicit `this()` and an explicit `super()` invocation.
- A `this()` constructor invocation cannot create a recursive constructor chain.
- If a parent class has no accessible no-argument constructor, the child constructor must explicitly invoke an appropriate accessible parent constructor.
- Parent constructors execute before the corresponding child constructor bodies.

**Difference Between `this()` and `super()`**

| `this()` | `super()` |
|---|---|
| Calls another constructor of the same class | Calls a constructor of the parent class |
| Used for constructor chaining within a class | Used for constructor chaining through inheritance |
| Supports reuse of initialization logic | Initializes the parent-class portion of an object |
| Can pass arguments to an overloaded constructor | Can pass arguments to a parameterized parent constructor |

Practiced constructor overloading, calling constructors using `this()` and `super()`, and observing constructor execution order in parent-child relationships.

---

### 2. Packages in Java

A **package** is a namespace that groups related classes, interfaces, and other Java types.

Packages are used to organize source code, improve maintainability, prevent naming conflicts, and support access control.

#### Types of Packages

**a. Built-in Packages**

These are packages provided by the Java API.

Examples:

- `java.lang` – Contains fundamental classes such as String, Math, and System.
- `java.util` – Contains utility classes such as Scanner, ArrayList, and HashMap.
- `java.io` – Provides input and output functionality.
- `java.sql` – Provides database-related classes and interfaces.

**b. User-defined Packages**

These packages are created by developers to organize application classes.

#### Creating a User-defined Package

**File: `Student.java`**

```java
package college;

public class Student {

    public void display() {
        System.out.println("Student from college package");
    }
}
```

**File: `Main.java`**

```java
import college.Student;

public class Main {

    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}
```

**Compilation and Execution:**

```bash
javac -d . Student.java
javac -cp . Main.java
java -cp . Main
```

**Output:**

```text
Student from college package
```

#### Package Declaration

The `package` keyword declares the package to which a class belongs.

**Syntax:**

```java
package packageName;
```

A package declaration, when present, appears before import statements and type declarations.

#### Import Statement

The `import` keyword allows classes from another package to be referred to by their simple names.

**Example:**

```java
import java.util.Scanner;
```

Multiple classes from the same package can be made available using:

```java
import java.util.*;
```

The wildcard import does not automatically import classes from sub-packages.

#### Advantages of Packages

- Organize related classes and interfaces.
- Prevent class-name conflicts.
- Improve code readability and maintainability.
- Support code reusability.
- Provide package-level access control.
- Make large projects easier to manage.

Practiced creating user-defined packages, importing classes, accessing classes across packages, and compiling package-based Java programs.

---

### 3. Access Specifiers in Java

**Access specifiers** are keywords used to control the visibility and accessibility of classes, variables, methods, and constructors.

Java provides four access levels.

#### a. `public`

- Accessible from any class where the declaring type is accessible.
- Used when a member needs to be available across packages.
- A top-level class can be declared `public`.

**Example:**

```java
public class Student {

    public int id = 101;

    public void display() {
        System.out.println(id);
    }
}
```

#### b. `protected`

- Accessible within the same package.
- Accessible to subclasses in other packages, subject to Java's protected-access rules.
- Commonly used in inheritance.
- Cannot be applied to a top-level class.

**Example:**

```java
class Parent {

    protected int number = 100;
}

class Child extends Parent {

    void display() {
        System.out.println(number);
    }
}
```

#### c. Default (Package-private)

When no access modifier is specified, the member has package-private access.

- Accessible only within the same package.
- Not directly accessible from unrelated packages.
- Can be applied to top-level classes.

**Example:**

```java
class Student {

    int id = 101;

    void display() {
        System.out.println(id);
    }
}
```

#### d. `private`

- Accessible only within the declaring class, subject to Java's nested-class access rules.
- Commonly used for data hiding.
- Supports encapsulation.
- Cannot be applied to a top-level class.

**Example:**

```java
class Student {

    private int id = 101;

    public int getId() {
        return id;
    }
}
```

#### Access Specifier Comparison

| Access Level | Same Class | Same Package | Subclass in Different Package | Other Package |
|---|---|---|---|---|
| `public` | Yes | Yes | Yes | Yes |
| `protected` | Yes | Yes | Yes, with restrictions | No |
| Default | Yes | Yes | No | No |
| `private` | Yes | No | No | No |

*The table summarizes ordinary member access. Protected access across packages has additional rules, and nested classes have special access provisions.*

#### Important Rules

- Top-level classes can be `public` or package-private.
- Fields, methods, and constructors can use all four access levels.
- Access specifiers help restrict unwanted access to class members.
- Private variables are commonly accessed through public methods.
- Access control is an important part of encapsulation.
- A subclass cannot directly access private members inherited from its parent class.

**Example Using Multiple Access Specifiers:**

```java
class Employee {

    public int id = 101;
    protected String department = "IT";
    int salary = 30000;
    private String password = "abc123";

    public void display() {
        System.out.println(id);
        System.out.println(department);
        System.out.println(salary);
        System.out.println(password);
    }
}

public class Main {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.display();
    }
}
```

**Output:**

```text
101
IT
30000
abc123
```

Practiced declaring variables, methods, and constructors with different access specifiers and understanding accessibility within the same class, the same package, and different packages.

---

### 4. Introduction to IDE

An **Integrated Development Environment (IDE)** is a software application that provides tools for writing, compiling, executing, testing, and debugging programs.

An IDE simplifies software development by combining multiple development tools into one environment.

#### Features of a Java IDE

**a. Code Editor**

- Provides an interface for writing Java programs.
- Supports syntax highlighting.
- Helps organize and edit source code.

**b. Code Completion**

- Suggests class names, methods, and variables while typing.
- Reduces typing effort.
- Helps identify available methods and properties.

**c. Project Management**

- Allows creation of Java projects.
- Organizes packages, classes, and resources.
- Helps manage source files and project dependencies.

**d. Compilation and Execution**

- Provides tools to compile Java source code.
- Allows programs to be executed directly from the IDE.
- Displays program output in a console.

**e. Debugging**

Debugging is the process of identifying and fixing errors in a program.

Common debugging features include:

- **Breakpoints:** Pause program execution at selected lines.
- **Step Into:** Execute the next statement and enter a method call when applicable.
- **Step Over:** Execute the next statement without stepping into a called method.
- **Step Return/Step Out:** Continue execution until the current method returns.
- **Variable Inspection:** Examine variable values during execution.

#### Common Java IDEs

- Eclipse
- IntelliJ IDEA
- NetBeans
- Visual Studio Code with Java extensions

#### Basic Java Development Workflow

1. Open the IDE.
2. Create a Java project.
3. Create a package if required.
4. Create a Java class.
5. Write the Java program.
6. Compile or build the program.
7. Run the program.
8. Check the console output.
9. Debug and correct errors if necessary.

**Example:**

```java
public class HelloJava {

    public static void main(String[] args) {
        System.out.println("Welcome to Java IDE");
    }
}
```

**Output:**

```text
Welcome to Java IDE
```

Practiced creating Java projects, organizing packages and classes, writing programs in the code editor, running Java applications, and using basic debugging features.

---

### 5. Arrays in Java

An **array** is an object that stores a fixed number of values of a single declared element type.

Arrays allow multiple values to be stored and accessed using a common variable name and an index.

#### Characteristics of Arrays

- Arrays have a fixed length after creation.
- Array indexing starts from `0`.
- The last valid index is `length - 1`.
- Arrays can store primitive values or object references.
- Array elements are stored in indexed positions.
- The `length` field provides the size of an array.
- Accessing an invalid index causes `ArrayIndexOutOfBoundsException`.

#### Array Declaration

**Syntax:**

```java
dataType[] arrayName;
```

**Example:**

```java
int[] numbers;
```

#### Array Creation

```java
numbers = new int[5];
```

This creates an integer array with five elements.

#### Array Initialization

**Static Initialization:**

```java
int[] numbers = {10, 20, 30, 40, 50};
```

**Dynamic Initialization:**

```java
int[] numbers = new int[5];

numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;
```

#### Accessing Array Elements

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[0]);
System.out.println(numbers[2]);
```

**Output:**

```text
10
30
```

#### Array Traversal Using a Loop

```java
public class Main {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
```

**Output:**

```text
10
20
30
40
50
```

#### a. Primitive Type Arrays

A primitive type array stores primitive values directly in its elements.

Examples of primitive types:

- `int`
- `char`
- `double`
- `float`
- `boolean`
- `byte`
- `short`
- `long`

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int[] marks = {80, 85, 90, 95};

        for (int i = 0; i < marks.length; i++) {
            System.out.println(marks[i]);
        }
    }
}
```

**Output:**

```text
80
85
90
95
```

#### Default Values of Primitive Arrays

When a primitive array is created using `new`, its elements receive default values.

| Data Type | Default Value |
|---|---|
| `byte`, `short`, `int`, `long` | `0` |
| `float`, `double` | `0.0` |
| `char` | `'\u0000'` |
| `boolean` | `false` |

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[3];

        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
    }
}
```

**Output:**

```text
0
0
0
```

Practiced creating primitive arrays, assigning values, accessing elements using indexes, and traversing arrays using loops.

#### b. Reference Type Arrays

A reference type array stores references to objects rather than primitive values.

Examples:

- `String[]`
- `Student[]`
- `Employee[]`

When a reference type array is created, its elements initially contain `null` unless explicitly initialized.

**Example Using String Array:**

```java
public class Main {

    public static void main(String[] args) {

        String[] names = {"Amit", "Rahul", "Suraj"};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
```

**Output:**

```text
Amit
Rahul
Suraj
```

#### Array of Objects

An array of objects stores references to instances of a user-defined class.

**Example:**

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name);
    }
}

public class Main {

    public static void main(String[] args) {

        Student[] students = new Student[3];

        students[0] = new Student(101, "Amit");
        students[1] = new Student(102, "Rahul");
        students[2] = new Student(103, "Suraj");

        for (int i = 0; i < students.length; i++) {
            students[i].display();
        }
    }
}
```

**Output:**

```text
101 Amit
102 Rahul
103 Suraj
```

#### Important Points About Reference Arrays

- Creating an array of object references does not automatically create the individual objects.
- Each element initially contains `null`.
- Objects must be created separately using `new` or assigned from existing references.
- Attempting to access a member through a `null` reference causes `NullPointerException`.
- Multiple array elements can refer to the same object.

#### Primitive Arrays vs Reference Arrays

| Primitive Arrays | Reference Arrays |
|---|---|
| Store primitive values | Store object references |
| Example: `int[]` | Example: `Student[]` |
| Numeric elements default to zero | Elements default to `null` |
| Store values directly in array elements | Store references to separately allocated objects |
| No object creation required for individual primitive elements | Objects generally need to be created or assigned separately |

Practiced creating primitive arrays, String arrays, and arrays of user-defined objects. Also explored default values, object creation, array traversal, and accessing object members through array references.

---

## Learning Outcomes

- Understood constructor chaining using `this()` and `super()`.
- Learned constructor overloading and constructor execution order.
- Practiced creating and accessing classes through user-defined packages.
- Understood the four access levels in Java and their role in encapsulation.
- Became familiar with Java IDE features, project creation, execution, and debugging.
- Learned array declaration, creation, initialization, indexing, and traversal.
- Understood the differences between primitive type arrays and reference type arrays.
- Practiced creating arrays of objects and accessing their properties and methods.
- Understood default array values and common array-related runtime exceptions.

## Repository Contents

- Constructor chaining and constructor overloading examples.
- User-defined package programs.
- Access specifier implementation examples.
- Java IDE practice programs.
- Primitive type array examples.
- Reference type and object array programs.
- Class notes and supporting learning materials.
