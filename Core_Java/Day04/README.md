# Day 04 – Core Java

## Topics Covered

### 1. Array Memory Representation

An **array** in Java is an object that stores multiple values of the same declared element type. Arrays are created dynamically and their elements are accessed using indexes.

Understanding array memory representation helps explain how array variables, references, and elements are stored and accessed during program execution.

#### Array Memory Allocation

- Arrays are objects created in the heap memory.
- A local array variable generally stores a reference to the array object in the stack frame of the executing method.
- The reference points to the array object in heap memory.
- Array elements are stored as part of the array object.
- Each element is accessed using its index, starting from `0`.
- The `length` field represents the total number of elements in the array.

#### Memory Representation of a Primitive Array

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        System.out.println(arr[0]);
        System.out.println(arr[2]);
    }
}
```

**Output:**

```text
10
30
```

**Conceptual Memory Representation:**

```text
          Stack                         Heap
    +---------------+           +----------------------+
    | arr           |---------->| Array Object         |
    | Reference     |           |                      |
    +---------------+           | Index | Value        |
                                |-------|--------------|
                                |   0   |    10        |
                                |   1   |    20        |
                                |   2   |    30        |
                                |   3   |    40        |
                                +----------------------+
```

The local variable `arr` holds a reference to the array object. The actual array elements belong to the array object.

#### Memory Representation of a Reference Type Array

A reference type array stores references to objects rather than storing the objects themselves inside its elements.

**Example:**

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {

        Student[] students = new Student[2];

        students[0] = new Student(101, "Amit");
        students[1] = new Student(102, "Suraj");
    }
}
```

**Conceptual Memory Representation:**

```text
           Stack                         Heap

    +----------------+          +----------------------+
    | students       |--------->| Student[] Array      |
    | Reference      |          |                      |
    +----------------+          | Index | Reference    |
                                |-------|--------------|
                                |   0   | Ref to Obj 1 |
                                |   1   | Ref to Obj 2 |
                                +----------------------+
                                           |
                            +--------------+--------------+
                            |                             |
                            v                             v
                    +---------------+             +---------------+
                    | Student Obj 1 |             | Student Obj 2 |
                    | id = 101      |             | id = 102      |
                    | name = Amit   |             | name = Suraj  |
                    +---------------+             +---------------+
```

#### Important Points

- An array variable stores a reference, not the complete array object.
- Two reference variables can point to the same array object.
- Changes made through one reference are visible through another reference to the same array.
- Primitive arrays store primitive values in their elements.
- Reference arrays store object references in their elements.
- An array of objects must have its individual objects created separately.
- Uninitialized reference array elements contain `null`.

**Example of Two References Pointing to the Same Array:**

```java
public class Main {

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30};

        int[] arr2 = arr1;

        arr2[0] = 100;

        System.out.println(arr1[0]);
        System.out.println(arr2[0]);
    }
}
```

**Output:**

```text
100
100
```

Both variables refer to the same array object. Therefore, changing an element through `arr2` also affects the value observed through `arr1`.

Practiced drawing memory diagrams for primitive and reference-type arrays, identifying stack references and heap objects, and understanding how array references access elements.

---

### 2. Dynamic Initialization

**Dynamic initialization** means assigning values to variables or array elements during program execution rather than specifying all values directly in the source code.

The values may come from user input, calculations, method calls, or runtime conditions.

#### Dynamic Initialization of Variables

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int sum = a + b;

        System.out.println("Sum = " + sum);
    }
}
```

**Output:**

```text
Sum = 30
```

The value of `sum` is calculated and assigned during program execution.

#### Dynamic Initialization of Arrays

An array can be created with a size determined at runtime.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int size = 5;

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1) * 10;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
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

Here, the array size is determined by the value of the `size` variable, and its elements are initialized using a loop.

#### Dynamic Initialization Using User Input

The `Scanner` class can be used to accept array size and values from the user at runtime.

**Example:**

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter array elements:");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array elements:");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        sc.close();
    }
}
```

**Sample Input:**

```text
Enter array size: 3
Enter array elements:
10
20
30
```

**Output:**

```text
Array elements:
10
20
30
```

#### Static Initialization vs Dynamic Initialization

| Static Initialization | Dynamic Initialization |
|---|---|
| Values are specified directly in the source code | Values are assigned during execution |
| Values are known while writing the program | Values can depend on runtime conditions or input |
| Example: `int[] a = {10, 20, 30};` | Example: `int[] a = new int[size];` |
| Suitable for fixed values | Suitable for flexible runtime values |

**Important Points**

- Array length is fixed after an array is created.
- The size can be determined using a variable or expression at runtime.
- Array elements can be assigned using loops.
- Runtime input can be used to initialize array elements.
- Invalid or negative array sizes can cause `NegativeArraySizeException`.

Practiced creating arrays with runtime-determined sizes, assigning values using loops, and accepting array elements through user input.

---

### 3. `static` Keyword

The `static` keyword in Java is used to define members that belong to the class rather than individual objects.

Static members are associated with the class and can generally be accessed using the class name.

The `static` keyword can be applied to variables, methods, initialization blocks, and nested classes.

#### a. Static Data Members

A **static variable** is a class-level variable shared by all objects of that class.

#### Characteristics of Static Variables

- Declared using the `static` keyword.
- Belongs to the class rather than individual objects.
- Only one class-level copy exists for a particular class.
- Shared among all instances of that class.
- Can be accessed using the class name.
- Receives a default value if not explicitly initialized.

**Example:**

```java
class Student {

    int id;
    String name;

    static String college = "CDAC";

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println(id + " " + name + " " + college);
    }
}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(101, "Amit");
        Student s2 = new Student(102, "Suraj");

        s1.display();
        s2.display();

        System.out.println(Student.college);
    }
}
```

**Output:**

```text
101 Amit CDAC
102 Suraj CDAC
CDAC
```

Both objects share the same static variable `college`.

#### Static Variable vs Instance Variable

| Static Variable | Instance Variable |
|---|---|
| Belongs to the class | Belongs to an object |
| Shared among objects | Each object has its own copy |
| Declared using `static` | Declared without `static` |
| Can be accessed using the class name | Accessed through an object reference |
| Class-level data | Object-level data |

#### b. Static Methods

A **static method** is a method that belongs to the class rather than an individual object.

It can be called using the class name without creating an object.

#### Characteristics of Static Methods

- Declared using the `static` keyword.
- Can be called using the class name.
- Can directly access static members of the class.
- Cannot directly access instance variables or instance methods.
- Can access instance members through an object reference.
- Static methods do not use `this` or `super` as current-instance references.

**Example:**

```java
class Calculator {

    static int add(int a, int b) {
        return a + b;
    }

    static void display() {
        System.out.println("Static Method");
    }
}

public class Main {

    public static void main(String[] args) {

        int result = Calculator.add(10, 20);

        System.out.println(result);

        Calculator.display();
    }
}
```

**Output:**

```text
30
Static Method
```

#### Why Is the `main()` Method Static?

```java
public static void main(String[] args)
```

- The JVM needs an entry point to start program execution.
- A static method can be invoked without creating an object.
- Therefore, the JVM can invoke `main()` without first creating an instance of the class.

#### Important Points About Static Members

- Static variables are shared among objects of the same class.
- Static methods can directly access static members.
- Static methods cannot directly access instance members.
- Static members are commonly accessed using the class name.
- A static method can use an object reference to access instance members.
- Static methods are resolved using the class or reference type rather than runtime object dispatch.

Practiced creating static variables and static methods, accessing them through class names, and comparing static members with instance members.

---

### 4. `this` Keyword

The `this` keyword is a reference variable that refers to the current object of a class.

It is mainly used inside instance methods and constructors to access members of the current object.

#### Uses of `this` Keyword

**a. Referring to Current Class Instance Variables**

When local variables or constructor parameters have the same names as instance variables, `this` distinguishes the instance variables.

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

        System.out.println(this.id);
        System.out.println(this.name);
    }
}

public class Main {

    public static void main(String[] args) {

        Student s = new Student(101, "Suraj");

        s.display();
    }
}
```

**Output:**

```text
101
Suraj
```

Here:

- `this.id` refers to the instance variable.
- `id` refers to the constructor parameter.
- `this.name` refers to the instance variable.
- `name` refers to the constructor parameter.

**b. Calling Current Class Methods**

The `this` keyword can be used to call another instance method of the same object.

```java
class Student {

    void display() {
        System.out.println("Display Method");
    }

    void show() {
        this.display();
    }
}
```

**c. Passing the Current Object as an Argument**

The current object can be passed as an argument to another method.

```java
class Student {

    void display(Student s) {
        System.out.println("Student Object Received");
    }

    void show() {
        display(this);
    }
}
```

**d. Returning the Current Object**

A method can return `this` to return the current object reference.

```java
class Student {

    Student getStudent() {
        return this;
    }
}
```

**e. Constructor Chaining Using `this()`**

The `this()` statement is used to invoke another constructor of the same class.

```java
class Student {

    Student() {
        this(101);
        System.out.println("Default Constructor");
    }

    Student(int id) {
        System.out.println("Parameterized Constructor: " + id);
    }
}
```

**Output:**

```text
Parameterized Constructor: 101
Default Constructor
```

#### Difference Between `this` and `this()`

| `this` | `this()` |
|---|---|
| Refers to the current object | Calls another constructor of the same class |
| Used to access current object members | Used for constructor chaining |
| Used in instance contexts | Used only in constructor invocation |
| Example: `this.id` | Example: `this(101)` |

#### Important Rules

- `this` refers to the current object.
- It cannot be used in a static context because static methods do not belong to an individual object.
- `this()` must be the first statement in a constructor under traditional Java constructor syntax.
- `this()` and `super()` cannot both be explicit constructor invocations in the same constructor under traditional syntax.
- `this` can be used to remove ambiguity between instance variables and local variables or parameters.

Practiced using `this` to access instance variables, call current-object methods, pass object references, and implement constructor chaining.

---

### 5. Inheritance

**Inheritance** is an OOP concept in which one class acquires accessible fields and methods from another class.

It supports code reusability and allows developers to establish relationships between classes.

#### Important Terminology

- **Parent Class / Superclass:** The class whose accessible members are inherited.
- **Child Class / Subclass:** The class that extends another class.
- **`extends` Keyword:** Used to establish inheritance between classes.
- **Inherited Members:** Accessible superclass members available to the subclass.

#### Syntax

```java
class Parent {
    // Parent class members
}

class Child extends Parent {
    // Child class members
}
```

#### a. Single Inheritance

A single child class inherits from one parent class.

**Example:**

```java
class Parent {

    void display() {
        System.out.println("Parent Class");
    }
}

class Child extends Parent {

    void show() {
        System.out.println("Child Class");
    }
}

public class Main {

    public static void main(String[] args) {

        Child c = new Child();

        c.display();
        c.show();
    }
}
```

**Output:**

```text
Parent Class
Child Class
```

#### b. Multilevel Inheritance

A class inherits from another child class, forming a chain of inheritance.

**Example:**

```java
class Grandparent {

    void showGrandparent() {
        System.out.println("Grandparent Class");
    }
}

class Parent extends Grandparent {

    void showParent() {
        System.out.println("Parent Class");
    }
}

class Child extends Parent {

    void showChild() {
        System.out.println("Child Class");
    }
}

public class Main {

    public static void main(String[] args) {

        Child c = new Child();

        c.showGrandparent();
        c.showParent();
        c.showChild();
    }
}
```

**Output:**

```text
Grandparent Class
Parent Class
Child Class
```

#### c. Hierarchical Inheritance

Multiple child classes inherit from the same parent class.

**Example:**

```java
class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    void meow() {
        System.out.println("Cat meows");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();
        d.eat();
        d.bark();

        Cat c = new Cat();
        c.eat();
        c.meow();
    }
}
```

**Output:**

```text
Animal eats
Dog barks
Animal eats
Cat meows
```

#### Types of Inheritance in Java

| Inheritance Type | Description | Supported Through Classes |
|---|---|---|
| Single | One child inherits from one parent | Yes |
| Multilevel | A class inherits through a chain of classes | Yes |
| Hierarchical | Multiple children inherit from one parent | Yes |
| Multiple | One child inherits from multiple parent classes | No |
| Hybrid | Combination of multiple inheritance patterns | Not directly through classes |

#### Multiple Inheritance Using Interfaces

Java does not support multiple inheritance through classes because it can create ambiguity when parent classes define the same methods.

However, a class can implement multiple interfaces.

**Example:**

```java
interface Printable {

    void print();
}

interface Showable {

    void show();
}

class Demo implements Printable, Showable {

    public void print() {
        System.out.println("Print Method");
    }

    public void show() {
        System.out.println("Show Method");
    }
}

public class Main {

    public static void main(String[] args) {

        Demo d = new Demo();

        d.print();
        d.show();
    }
}
```

**Output:**

```text
Print Method
Show Method
```

#### Constructor Execution in Inheritance

When a child-class object is created, the parent constructor executes before the child constructor body.

**Example:**

```java
class Parent {

    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {

    Child() {
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

#### Important Points About Inheritance

- Java uses the `extends` keyword for class inheritance.
- A class can directly extend only one class.
- Constructors are not inherited.
- Private members are not directly accessible in subclasses.
- Public and protected members can be inherited, subject to accessibility rules.
- Package-private members are accessible only when the subclass is in the same package.
- A child class can add its own fields and methods.
- A child class can override inherited instance methods when overriding rules are satisfied.
- The `super` keyword can be used to access superclass members and invoke superclass constructors.

Practiced implementing single, multilevel, and hierarchical inheritance, accessing inherited members, and understanding parent-child constructor execution order.

---

### 6. Polymorphism

**Polymorphism** means one name or reference can represent different behaviours depending on the context.

In Java, polymorphism allows the same method name or a common superclass reference to work with different implementations.

The two main forms of polymorphism are:

1. Compile-Time Polymorphism
2. Runtime Polymorphism

#### a. Compile-Time Polymorphism

Compile-time polymorphism is achieved through **method overloading**.

Method overloading means defining multiple methods in the same class with the same name but different parameter lists.

Methods can differ by:

- Number of parameters.
- Type of parameters.
- Order of parameter types.

The compiler determines which overloaded method to call based on the arguments supplied.

**Example:**

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {

    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println(c.add(10, 20));
        System.out.println(c.add(10, 20, 30));
        System.out.println(c.add(10.5, 20.5));
    }
}
```

**Output:**

```text
30
60
31.0
```

#### Important Rules of Method Overloading

- Method names must be the same.
- Parameter lists must be different.
- Changing only the return type does not create valid overloading.
- Changing parameter names does not create overloading.
- Changing access modifiers alone does not create overloading.
- Static methods can also be overloaded.

#### b. Runtime Polymorphism

Runtime polymorphism is achieved through **method overriding**.

Method overriding occurs when a subclass provides its own implementation of an inherited instance method with a compatible method signature.

The method implementation is selected at runtime based on the actual object.

**Example:**

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal a;

        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();
    }
}
```

**Output:**

```text
Dog barks
Cat meows
```

#### Dynamic Method Dispatch

Dynamic method dispatch is the mechanism through which an overridden instance method is selected at runtime.

- A parent-class reference can refer to a child-class object.
- The compiler checks method accessibility and compatibility using the reference type.
- At runtime, Java selects the overridden implementation according to the actual object type.
- This behaviour supports runtime polymorphism.

**Example:**

```java
class Parent {

    void display() {
        System.out.println("Parent Display");
    }
}

class Child extends Parent {

    @Override
    void display() {
        System.out.println("Child Display");
    }
}

public class Main {

    public static void main(String[] args) {

        Parent p = new Child();

        p.display();
    }
}
```

**Output:**

```text
Child Display
```

Although the reference type is `Parent`, the actual object is `Child`, so the overridden child method executes.

#### Compile-Time vs Runtime Polymorphism

| Compile-Time Polymorphism | Runtime Polymorphism |
|---|---|
| Achieved through method overloading | Achieved through method overriding |
| Method selection is determined at compile time | Overridden method selection occurs at runtime |
| Does not require inheritance | Requires inheritance or interface implementation |
| Same method name with different parameters | Same compatible method signature with a different implementation |
| Also called static polymorphism | Also called dynamic polymorphism |

Practiced implementing overloaded methods, overriding parent-class methods, and using parent references to access child-class objects through dynamic method dispatch.

---

## Learning Outcomes

- Understood how Java arrays are represented in memory and how references access array objects.
- Learned the difference between primitive arrays and reference-type arrays in memory.
- Practiced dynamic initialization of variables and arrays using runtime values.
- Understood static variables and static methods and how they differ from instance members.
- Learned how to use the `this` keyword to refer to the current object.
- Understood the difference between `this` and `this()`.
- Practiced inheritance using single, multilevel, and hierarchical class relationships.
- Understood constructor execution order in parent-child relationships.
- Learned how Java supports multiple inheritance through interfaces.
- Understood compile-time polymorphism through method overloading.
- Learned runtime polymorphism through method overriding and dynamic method dispatch.

## Repository Contents

- Array memory representation diagrams.
- Dynamic initialization programs.
- Static variable and static method examples.
- `this` keyword and constructor chaining examples.
- Single, multilevel, and hierarchical inheritance programs.
- Method overloading and method overriding examples.
- Runtime polymorphism and dynamic method dispatch programs.
- Class notes and supporting learning materials.
