# Day 06 – Core Java

## Topics Covered

### 1. Abstraction in Java

**Abstraction** is an Object-Oriented Programming (OOP) concept that hides implementation details and exposes only the essential functionality to the user.

It helps reduce complexity and allows developers to focus on what an object does rather than how it performs the operation.

In Java, abstraction is mainly achieved using:

1. Abstract classes
2. Interfaces

#### a. Abstract Class

An **abstract class** is a class declared using the `abstract` keyword. It provides a common base for related classes and can contain both abstract and concrete methods.

**Syntax:**

```java
abstract class ClassName {
    // Abstract and concrete methods
}
```

**Important Characteristics:**

- Declared using the `abstract` keyword.
- Cannot be instantiated directly.
- Can contain abstract methods and concrete methods.
- Can contain instance variables, static variables, and constructors.
- Can contain static and final methods.
- Can be extended by another class using `extends`.
- A concrete subclass must implement all inherited abstract methods.
- An abstract class can extend another abstract class.

#### b. Abstract Method

An **abstract method** is a method declared without a method body. Its implementation is provided by a concrete subclass.

**Syntax:**

```java
abstract returnType methodName();
```

**Important Points:**

- Declared using the `abstract` keyword.
- Does not contain a method body.
- Must be declared inside an abstract class or an interface.
- A concrete subclass must implement the inherited abstract method.
- An abstract method cannot be `private`, `static`, or `final` because it must be implemented through overriding.

#### c. Concrete Method

A **concrete method** is a method that contains a complete implementation or method body.

**Example:**

```java
abstract class Animal {

    abstract void sound();

    void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound();
        d.eat();
    }
}
```

**Output:**

```text
Dog barks
Animal eats food
```

**Explanation:**

- `Animal` is an abstract class.
- `sound()` is an abstract method because it has no body.
- `eat()` is a concrete method because it contains an implementation.
- `Dog` extends the `Animal` class.
- The `Dog` class provides the implementation of the `sound()` method.
- The inherited `eat()` method can be used directly by the `Dog` object.

#### d. Abstract Class Reference

An abstract class cannot be instantiated directly, but its reference can point to an object of its concrete subclass.

**Example:**

```java
abstract class Shape {

    abstract void draw();
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Main {

    public static void main(String[] args) {

        Shape s = new Circle();

        s.draw();
    }
}
```

**Output:**

```text
Drawing Circle
```

Here, `Shape` is the reference type, while `Circle` is the actual object type. The overridden method is selected at runtime.

#### Abstract Class vs Concrete Class

| Abstract Class | Concrete Class |
|---|---|
| Declared using `abstract` | Declared without `abstract` |
| Cannot be instantiated directly | Can be instantiated |
| Can contain abstract and concrete methods | Cannot contain abstract methods |
| Can provide incomplete functionality | Provides implementations for its methods |
| Can be extended by another class | Can extend another class |

#### Important Rules of Abstraction

- An abstract class can have zero or more abstract methods.
- An abstract method cannot have a body.
- A concrete class must implement all inherited abstract methods.
- An abstract class can have constructors, which execute when a subclass object is created.
- An abstract class can contain instance and static members.
- Abstract classes are useful when related classes share common state or implementation.

Practiced creating abstract classes, defining abstract and concrete methods, implementing abstract methods in subclasses, and accessing child objects through abstract class references.

---

### 2. Interface in Java

An **interface** is a reference type in Java that defines a contract that implementing classes agree to follow.

It is used to achieve abstraction, establish common behaviour, and support multiple inheritance of type.

An interface is declared using the `interface` keyword.

**Syntax:**

```java
interface InterfaceName {
    // Constants and method declarations
}
```

#### a. Data Members in an Interface

Variables declared inside an interface are implicitly:

- `public`
- `static`
- `final`

This means interface variables are constants shared at the interface level.

**Example:**

```java
interface College {

    int CODE = 101;
}

public class Main {

    public static void main(String[] args) {

        System.out.println(College.CODE);
    }
}
```

**Output:**

```text
101
```

The declaration:

```java
int CODE = 101;
```

is equivalent to:

```java
public static final int CODE = 101;
```

**Important Points:**

- Interface variables are public by default.
- They are static, so they belong to the interface.
- They are final, so their values cannot be reassigned.
- They must be initialized when declared.
- They are generally accessed using the interface name.

#### b. Methods in an Interface

In a traditional interface declaration, methods without a body are implicitly:

- `public`
- `abstract`

**Example:**

```java
interface Printable {

    void print();
}
```

The method declaration:

```java
void print();
```

is equivalent to:

```java
public abstract void print();
```

**Important Points:**

- Abstract interface methods are public by default.
- They do not contain method bodies.
- The implementing class must provide public implementations unless it is abstract.
- An interface can also contain default, static, and private methods with implementations in modern Java.
- A private interface method is used internally by other interface methods; it is not implemented by the implementing class.

#### c. Implementing an Interface

A class uses the `implements` keyword to implement an interface.

**Example:**

```java
interface Printable {

    void print();
}

class Document implements Printable {

    @Override
    public void print() {
        System.out.println("Printing Document");
    }
}

public class Main {

    public static void main(String[] args) {

        Document d = new Document();

        d.print();
    }
}
```

**Output:**

```text
Printing Document
```

**Explanation:**

- `Printable` is an interface.
- `print()` is an abstract method.
- `Document` implements the `Printable` interface.
- The `Document` class provides the implementation of `print()`.
- The implemented method must be public because the interface method is public.

#### d. Multiple Inheritance Using Interfaces

Java does not support multiple inheritance through classes, but a class can implement multiple interfaces.

**Example:**

```java
interface Printable {

    void print();
}

interface Showable {

    void show();
}

class Demo implements Printable, Showable {

    @Override
    public void print() {
        System.out.println("Print Method");
    }

    @Override
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

#### e. Extending Interfaces

An interface can extend another interface using the `extends` keyword.

An interface can extend multiple interfaces.

**Example:**

```java
interface A {

    void methodA();
}

interface B {

    void methodB();
}

interface C extends A, B {

    void methodC();
}

class Demo implements C {

    public void methodA() {
        System.out.println("Method A");
    }

    public void methodB() {
        System.out.println("Method B");
    }

    public void methodC() {
        System.out.println("Method C");
    }
}

public class Main {

    public static void main(String[] args) {

        Demo d = new Demo();

        d.methodA();
        d.methodB();
        d.methodC();
    }
}
```

**Output:**

```text
Method A
Method B
Method C
```

#### Abstract Class vs Interface

| Abstract Class | Interface |
|---|---|
| Declared using `abstract class` | Declared using `interface` |
| Can have instance variables | Fields are implicitly `public static final` |
| Can have constructors | Cannot have constructors |
| Can contain abstract and concrete methods | Can contain abstract and implemented methods |
| A class can extend only one class | A class can implement multiple interfaces |
| Uses `extends` | Uses `implements` for classes |

Practiced declaring interfaces, using interface constants, implementing abstract interface methods, implementing multiple interfaces, and extending interfaces.

---

### 3. Interface Type of Reference

An **interface type reference** is a reference variable declared using an interface name that can hold the object reference of a class implementing that interface.

It is commonly used to achieve runtime polymorphism and loose coupling.

**Syntax:**

```java
InterfaceName reference = new ImplementingClass();
```

#### Example: Interface Reference

```java
interface Vehicle {

    void start();
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car Started");
    }

    void drive() {
        System.out.println("Car is Driving");
    }
}

class Bike implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bike Started");
    }
}

public class Main {

    public static void main(String[] args) {

        Vehicle v;

        v = new Car();
        v.start();

        v = new Bike();
        v.start();
    }
}
```

**Output:**

```text
Car Started
Bike Started
```

**Explanation:**

- `Vehicle` is an interface.
- `Car` and `Bike` implement the `Vehicle` interface.
- `Vehicle v` declares an interface type reference.
- The reference can point to a `Car` object or a `Bike` object.
- The overridden implementation is selected according to the actual object at runtime.

#### Important Rules of Interface References

- An interface cannot be instantiated directly.
- An interface reference can point to an object of any class that implements that interface.
- An interface reference can directly access only members available through the interface type.
- The actual object's overridden method implementation executes at runtime.
- A class-specific method cannot be called directly through an interface reference unless it is declared in the interface.
- Type casting can be used when access to class-specific members is required, after checking the object's type.

**Example:**

```java
interface Vehicle {

    void start();
}

class Car implements Vehicle {

    public void start() {
        System.out.println("Car Started");
    }

    void drive() {
        System.out.println("Car Driving");
    }
}

public class Main {

    public static void main(String[] args) {

        Vehicle v = new Car();

        v.start();

        Car c = (Car) v;
        c.drive();
    }
}
```

**Output:**

```text
Car Started
Car Driving
```

Practiced declaring interface type references, assigning objects of implementing classes, and understanding how interface references support runtime polymorphism.

---

### 4. Interface Type of Array

An **interface type array** is an array declared using an interface as its element type.

It can store references to objects of different classes, provided those classes implement the same interface.

This allows different object types to be handled through a common interface.

**Syntax:**

```java
InterfaceName[] arrayName = new InterfaceName[size];
```

#### Example: Interface Type Array

```java
interface Animal {

    void sound();
}

class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog Barks");
    }
}

class Cat implements Animal {

    @Override
    public void sound() {
        System.out.println("Cat Meows");
    }
}

class Cow implements Animal {

    @Override
    public void sound() {
        System.out.println("Cow Moos");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[3];

        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Cow();

        for (int i = 0; i < animals.length; i++) {
            animals[i].sound();
        }
    }
}
```

**Output:**

```text
Dog Barks
Cat Meows
Cow Moos
```

#### Explanation

- `Animal` is an interface.
- `Dog`, `Cat`, and `Cow` implement the `Animal` interface.
- `Animal[]` creates an array that can store references to implementing objects.
- Each array element refers to an object of a different implementing class.
- The `sound()` method is called using the interface reference.
- Java executes the appropriate implementation based on the actual object.

#### Memory Representation (Conceptual)

```text
          Stack                         Heap

    +----------------+         +------------------------+
    | animals        |-------->| Animal[] Array         |
    | Reference      |         |                        |
    +----------------+         | Index | Object Ref     |
                               |-------|----------------|
                               |   0   | Dog Object      |
                               |   1   | Cat Object      |
                               |   2   | Cow Object      |
                               +------------------------+
```

#### Important Points

- Interface type arrays store object references, not interface objects.
- An interface cannot be instantiated.
- Each element can refer to any object whose class implements the interface.
- Array elements initially contain `null`.
- The array length is fixed after creation.
- Calling an interface method through an array element invokes the implementation of the actual object.
- This approach supports polymorphism and makes code easier to extend.

Practiced creating interface type arrays, storing different implementing class objects, traversing the array using loops, and invoking overridden methods through interface references.

---

## Learning Outcomes

- Understood abstraction and its importance in Object-Oriented Programming.
- Learned the difference between abstract classes, abstract methods, and concrete methods.
- Practiced implementing abstract methods in concrete subclasses.
- Understood interface declarations and their default member characteristics.
- Learned that interface variables are implicitly `public static final`.
- Understood that traditional interface abstract methods are implicitly `public abstract`.
- Practiced implementing one or multiple interfaces in Java classes.
- Learned how one interface can extend multiple interfaces.
- Understood interface type references and their role in runtime polymorphism.
- Practiced creating interface type arrays containing objects of different implementing classes.
- Learned how polymorphism allows different objects to be accessed through a common interface.

## Repository Contents

- Abstract class and abstract method programs.
- Concrete method implementation examples.
- Interface declaration and implementation programs.
- Interface constant examples.
- Multiple interface implementation examples.
- Interface inheritance examples.
- Interface type reference programs.
- Interface type array programs.
- Class notes and supporting learning materials.
