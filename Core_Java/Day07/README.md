# Day 07 – Core Java

## Topics Covered

### 1. Extending and Implementing Interfaces

In Java, interfaces can extend other interfaces, and classes can implement one or more interfaces.

The `extends` and `implements` keywords are used for different purposes.

#### a. Extending an Interface

An interface can extend another interface using the `extends` keyword.

An interface can also extend multiple interfaces.

**Syntax:**

```java
interface A {
    void methodA();
}

interface B extends A {
    void methodB();
}
```

Here, interface `B` inherits the abstract method declarations of interface `A`.

**Example:**

```java
interface Printable {

    void print();
}

interface Showable extends Printable {

    void show();
}

class Demo implements Showable {

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

#### b. Implementing Multiple Interfaces

A class can implement multiple interfaces using the `implements` keyword.

**Syntax:**

```java
class ClassName implements InterfaceA, InterfaceB {
    // Implement interface methods
}
```

**Example:**

```java
interface A {
    void displayA();
}

interface B {
    void displayB();
}

class Demo implements A, B {

    public void displayA() {
        System.out.println("Interface A");
    }

    public void displayB() {
        System.out.println("Interface B");
    }
}
```

#### Important Rules

- An interface extends another interface using `extends`.
- An interface can extend multiple interfaces.
- A class implements an interface using `implements`.
- A class can implement multiple interfaces.
- A class can extend one class and implement multiple interfaces.
- A class implementing an interface must provide implementations for all inherited abstract methods unless it is declared abstract.
- An interface cannot extend a class.

Practiced extending interfaces, implementing multiple interfaces, and understanding how interface inheritance allows common method declarations to be shared across different classes.

---

### 2. Implementing Multiple Interfaces with Same Method Names and Data Members

When a class implements multiple interfaces, situations can arise where the interfaces contain methods or variables with identical names.

The compiler handles these situations according to Java's method overriding, overloading, and field-access rules.

#### a. Two Interfaces with the Same Method Name, Same Signature, and Same Return Type

When two interfaces declare methods with the same name, same parameters, and compatible return types, a single implementation in the implementing class can satisfy both interfaces.

**Example:**

```java
interface A {

    void display();
}

interface B {

    void display();
}

class Demo implements A, B {

    @Override
    public void display() {
        System.out.println("Common Display Method");
    }
}

public class Main {

    public static void main(String[] args) {

        Demo d = new Demo();

        d.display();
    }
}
```

**Output:**

```text
Common Display Method
```

**Explanation:**

- Interface `A` declares `display()`.
- Interface `B` also declares `display()`.
- Both methods have the same signature and return type.
- The `Demo` class provides one implementation.
- This single implementation satisfies both interface contracts.

**Important Point:**

A single method implementation can satisfy multiple interface declarations when their method signatures and return types are compatible.

#### b. Two Interfaces with the Same Method Name, Same Signature, but Different Return Types

When two interfaces declare methods with the same name and parameter list but incompatible return types, a class generally cannot implement both methods with one method.

Java does not allow method overloading based only on return type.

**Example:**

```java
interface A {

    int display();
}

interface B {

    String display();
}

class Demo implements A, B {

    // Compilation error:
    // Cannot implement both methods with
    // incompatible return types.
}
```

**Why Does This Happen?**

Both methods have the same signature:

```java
display()
```

But their return types are different:

```java
int display();
String display();
```

A class cannot provide two methods with identical names and parameter lists that differ only by return type.

<badge color="danger">Compilation error</badge> This combination is not supported when the return types are incompatible.

**Important Exception – Covariant Return Types**

Java allows a method to use a more specific reference return type when overriding another method.

For example:

```java
interface A {

    Number getValue();
}

interface B {

    Integer getValue();
}

class Demo implements A, B {

    @Override
    public Integer getValue() {
        return 100;
    }
}
```

**Output:**

```text
100
```

`Integer` is a subtype of `Number`, so the return types are compatible through covariant return types.

#### c. Two Interfaces with the Same Method Name, Different Signatures, and Same Return Type

When two interfaces declare methods with the same name but different parameter lists, the implementing class must implement both methods.

This is an example of method overloading.

**Example:**

```java
interface A {

    void display(int a);
}

interface B {

    void display(String name);
}

class Demo implements A, B {

    @Override
    public void display(int a) {
        System.out.println("Integer: " + a);
    }

    @Override
    public void display(String name) {
        System.out.println("String: " + name);
    }
}

public class Main {

    public static void main(String[] args) {

        Demo d = new Demo();

        d.display(100);
        d.display("Suraj");
    }
}
```

**Output:**

```text
Integer: 100
String: Suraj
```

**Explanation:**

- Interface `A` declares `display(int)`.
- Interface `B` declares `display(String)`.
- The method names are the same, but their parameter lists differ.
- The `Demo` class implements both methods.
- The compiler selects the appropriate overloaded method based on the supplied argument.

#### d. Two Interfaces with the Same Data Member Name

Interface variables are implicitly `public static final`.

If two interfaces declare variables with the same name, a class implementing both interfaces must use the interface name to access the required variable unambiguously.

**Example:**

```java
interface A {

    int VALUE = 100;
}

interface B {

    int VALUE = 200;
}

class Demo implements A, B {

    void display() {

        System.out.println(A.VALUE);
        System.out.println(B.VALUE);
    }
}

public class Main {

    public static void main(String[] args) {

        Demo d = new Demo();

        d.display();
    }
}
```

**Output:**

```text
100
200
```

**Explanation:**

- Both interfaces declare a constant named `VALUE`.
- The implementing class inherits access to both interface constants.
- Using only `VALUE` can cause an ambiguous reference.
- `A.VALUE` accesses the constant from interface `A`.
- `B.VALUE` accesses the constant from interface `B`.

**Important Points:**

- Interface variables are constants.
- They cannot be reassigned.
- Interface variables are not overridden by implementing classes.
- Use `InterfaceName.variableName` to resolve duplicate field names.

#### Summary of Multiple Interface Scenarios

| Scenario | Result |
|---|---|
| Same method name, same signature, compatible return type | One implementation can satisfy both |
| Same method name, same signature, incompatible return types | Compilation error |
| Same method name, different signatures | Implement both overloaded methods |
| Same data member name | Use interface name to access each constant |

Practiced implementing multiple interfaces with identical and different method declarations, understanding return-type compatibility, method overloading, and resolving duplicate interface constants.

---

### 3. Combining Interfaces, Abstract Classes, and Concrete Classes

This topic combines multiple OOP concepts:

- Interfaces
- Multiple interface implementation
- Abstract classes
- Concrete classes
- Inheritance
- Method overriding
- Constructors
- `toString()` method

The following example is based on the geometry class diagram from the classroom image.

#### Problem Structure

We create two interfaces:

1. `AreaComputation`
   - Data member: `PI`
   - Method: `calcArea()`

2. `PerimeterComputation`
   - Method: `calcPerimeter()`

An abstract class named `BoundedShape` implements both interfaces.

It contains:

- Integer instance variables `x` and `y`.
- A parameterized constructor with two arguments.
- A `toString()` method.
- Abstract methods inherited from the interfaces, which are implemented by its concrete subclasses.

Two concrete classes extend `BoundedShape`:

- `Circle`
- `Rectangle`

#### Class Structure

```text
       AreaComputation          PerimeterComputation
       + PI                     + calcPerimeter()
       + calcArea()
                \                /
                 \              /
                  BoundedShape
                  (abstract class)
                  + int x, y
                  + constructor(x, y)
                  + toString()
                  + implements both interfaces
                         |
                  +------+------+
                  |             |
                Circle       Rectangle
                (concrete)   (concrete)
```

#### Step 1: Create AreaComputation Interface

```java
interface AreaComputation {

    double PI = 3.14159;

    double calcArea();
}
```

**Explanation:**

- `AreaComputation` is an interface.
- `PI` is implicitly `public static final`.
- `calcArea()` is implicitly `public abstract`.

#### Step 2: Create PerimeterComputation Interface

```java
interface PerimeterComputation {

    double calcPerimeter();
}
```

This interface declares the method required to calculate the perimeter of a shape.

#### Step 3: Create Abstract Class BoundedShape

```java
abstract class BoundedShape
        implements AreaComputation, PerimeterComputation {

    protected int x;
    protected int y;

    BoundedShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y;
    }
}
```

**Explanation:**

- `BoundedShape` is an abstract class.
- It implements both interfaces.
- It contains two protected instance variables, `x` and `y`.
- Its constructor initializes the dimensions.
- It provides a concrete implementation of `toString()`.
- It does not implement `calcArea()` and `calcPerimeter()`, so it remains abstract.

A class can implement interfaces without implementing all their abstract methods if the class itself is declared abstract.

#### Step 4: Create Circle Class

For a circle, `x` represents the radius. The second constructor argument is set to `0` because the circle does not require a second dimension.

```java
class Circle extends BoundedShape {

    Circle(int radius) {
        super(radius, 0);
    }

    @Override
    public double calcArea() {
        return AreaComputation.PI * x * x;
    }

    @Override
    public double calcPerimeter() {
        return 2 * AreaComputation.PI * x;
    }

    @Override
    public String toString() {
        return "Circle: Radius = " + x;
    }
}
```

**Explanation:**

- `Circle` extends `BoundedShape`.
- It inherits the fields and constructor initialization.
- It implements `calcArea()` and `calcPerimeter()`.
- It overrides `toString()` to display circle-specific information.

#### Step 5: Create Rectangle Class

For a rectangle:

- `x` represents length.
- `y` represents width.

```java
class Rectangle extends BoundedShape {

    Rectangle(int length, int width) {
        super(length, width);
    }

    @Override
    public double calcArea() {
        return x * y;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (x + y);
    }

    @Override
    public String toString() {
        return "Rectangle: Length = " + x
                + ", Width = " + y;
    }
}
```

**Explanation:**

- `Rectangle` extends `BoundedShape`.
- It initializes the length and width through the parent constructor.
- It implements area and perimeter calculations.
- It overrides `toString()` to display rectangle-specific information.

#### Step 6: Create Tester Class

```java
public class TestShape {

    public static void main(String[] args) {

        Circle c = new Circle(5);

        System.out.println(c);
        System.out.println("Area = " + c.calcArea());
        System.out.println("Perimeter = " + c.calcPerimeter());

        System.out.println("-------------------");

        Rectangle r = new Rectangle(10, 5);

        System.out.println(r);
        System.out.println("Area = " + r.calcArea());
        System.out.println("Perimeter = " + r.calcPerimeter());
    }
}
```

**Output:**

```text
Circle: Radius = 5
Area = 78.53975
Perimeter = 31.4159
-------------------
Rectangle: Length = 10, Width = 5
Area = 50.0
Perimeter = 30.0
```

#### Important Concepts Demonstrated

| Concept | Implementation |
|---|---|
| Interface | `AreaComputation`, `PerimeterComputation` |
| Interface constant | `PI` |
| Abstract class | `BoundedShape` |
| Multiple interface implementation | `BoundedShape implements AreaComputation, PerimeterComputation` |
| Inheritance | `Circle extends BoundedShape` |
| Inheritance | `Rectangle extends BoundedShape` |
| Abstract method implementation | `calcArea()`, `calcPerimeter()` |
| Concrete method | `toString()` in `BoundedShape` |
| Method overriding | Subclass implementations of `toString()` |
| Constructor chaining | `super(radius, 0)` and `super(length, width)` |

Practiced designing a class hierarchy using multiple interfaces and an abstract class, implementing concrete classes for Circle and Rectangle, and testing area and perimeter calculations.

---

### 4. Protected Access Specifier

The `protected` access specifier controls the visibility of class members.

A protected member is accessible:

- Within the same class.
- Within other classes in the same package.
- In subclasses located in different packages, subject to Java's protected-access rules.

It is mainly used when a parent class wants to allow its subclasses to access certain members.

#### Example: Protected Member in Inheritance

```java
class Parent {

    protected int number = 100;
}

class Child extends Parent {

    void display() {
        System.out.println(number);
    }
}

public class Main {

    public static void main(String[] args) {

        Child c = new Child();

        c.display();
    }
}
```

**Output:**

```text
100
```

The child class can access the protected variable inherited from the parent class.

#### Protected Access Across Packages

When a subclass belongs to a different package:

- It can access an inherited protected member through itself or an appropriate subclass reference.
- It cannot generally access that protected member through an arbitrary parent-class object.
- The protected member is not freely accessible to unrelated classes in another package.

**Example:**

```java
// File: pack1/Parent.java
package pack1;

public class Parent {

    protected int number = 100;
}
```

```java
// File: pack2/Child.java
package pack2;

import pack1.Parent;

public class Child extends Parent {

    public void display() {
        System.out.println(number);
    }
}
```

The `Child` class can access the inherited protected member even though it is in another package.

#### Access Specifier Comparison

| Access Level | Same Class | Same Package | Subclass in Different Package | Unrelated Class in Different Package |
|---|---|---|---|---|
| `public` | Yes | Yes | Yes | Yes |
| `protected` | Yes | Yes | Yes, with restrictions | No |
| Default | Yes | Yes | No | No |
| `private` | Yes | No | No | No |

#### Important Points

- `protected` members are accessible throughout the same package.
- Subclasses in other packages can access inherited protected members subject to additional rules.
- Protected members support inheritance and controlled access.
- A top-level class cannot be declared `protected`.

Practiced accessing protected variables and methods from child classes and understanding protected access within the same package and across different packages.

---

### 5. Object Class and equals() Method

In Java, the `Object` class is the root class of the Java class hierarchy.

Every class directly or indirectly inherits from `Object`, unless it is an interface.

The `Object` class provides several commonly used methods:

- `equals()`
- `hashCode()`
- `toString()`
- `getClass()`
- `clone()`
- `wait()`
- `notify()`
- `notifyAll()`

#### a. Reference Equality vs Content Equality

**Reference Equality**

Reference equality checks whether two reference variables point to the same object in memory.

It is checked using the `==` operator.

**Content Equality**

Content equality checks whether two different objects contain equivalent data.

It is commonly implemented by overriding the `equals()` method.

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

        Student s1 = new Student(101, "Suraj");
        Student s2 = new Student(101, "Suraj");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

**Output:**

```text
false
false
```

**Explanation:**

- `s1` and `s2` refer to two different objects.
- Their contents are the same.
- `==` returns `false` because the references point to different objects.
- `equals()` also returns `false` because the `Student` class has not overridden the default `Object.equals()` implementation.
- The default implementation of `Object.equals()` compares object identity.

#### b. `==` Operator

For reference types, the `==` operator checks whether two references identify the same object.

**Example:**

```java
Student s1 = new Student(101, "Suraj");

Student s2 = s1;

System.out.println(s1 == s2);
```

**Output:**

```text
true
```

Both references point to the same object.

For primitive types, `==` compares the actual primitive values.

#### c. How to Change Reference Equality to Content Equality

To compare object contents, override the `equals()` method from the `Object` class.

**Example:**

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student other = (Student) obj;

        return id == other.id && name.equals(other.name);
    }
}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(101, "Suraj");
        Student s2 = new Student(101, "Suraj");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

**Output:**

```text
false
true
```

**Explanation:**

1. `this == obj` checks whether both references point to the same object.
2. `obj == null` checks whether the supplied reference is null.
3. `getClass()` checks whether both objects belong to the same runtime class.
4. The object is typecast to `Student`.
5. The `id` and `name` values are compared.
6. If both fields match, `equals()` returns `true`.

#### Important Rules of equals()

The `equals()` method should follow these properties:

1. **Reflexive:** An object must be equal to itself.
2. **Symmetric:** If `a.equals(b)` is true, then `b.equals(a)` must also be true.
3. **Transitive:** If `a.equals(b)` and `b.equals(c)` are true, then `a.equals(c)` must also be true.
4. **Consistent:** Repeated calls should return the same result if the compared information has not changed.
5. **Non-null:** For any non-null reference `a`, `a.equals(null)` must return false.

**Important:** When overriding `equals()`, you should also override `hashCode()` to maintain the required contract.

Practiced comparing object references using `==`, understanding the default `equals()` implementation, and overriding `equals()` to compare object data.

---

### 6. hashCode() Method

The `hashCode()` method is defined in the `Object` class.

It returns an integer hash code associated with an object.

**Syntax:**

```java
public int hashCode()
```

The hash code is commonly used by hash-based collections such as:

- `HashMap`
- `HashSet`
- `Hashtable`

#### Why Is hashCode() Used?

Hash-based collections use hash codes to identify the bucket where an object should be stored or searched for.

The `hashCode()` method helps collections perform efficient insertion, searching, and retrieval.

#### Example: Default hashCode()

```java
class Student {

    int id;

    Student(int id) {
        this.id = id;
    }
}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(101);
        Student s2 = new Student(101);

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
```

The output contains integer hash codes. Their exact values are not guaranteed and may differ between executions.

#### Overriding hashCode()

When two objects are considered equal according to `equals()`, they must return the same hash code.

**Example:**

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Student) {
        Student other = (Student) obj;
        return id == other.id && name.equals(other.name);
    }
     return false;

    @Override
    public int hashCode() {

        return java.util.Objects.hash(id, name);
    }
}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(101, "Suraj");
        Student s2 = new Student(101, "Suraj");

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}
```

**Output:**

```text
true
true
```

#### Important Rules of hashCode()

- `hashCode()` returns an integer.
- If two objects are equal according to `equals()`, they must have the same hash code.
- Two objects with the same hash code are not necessarily equal.
- Unequal objects may have the same hash code. This is called a hash collision.
- If information used in `equals()` changes, the hash code may also change.
- Always override `hashCode()` when overriding `equals()` for value-based equality.

#### Relationship Between equals() and hashCode()

| equals() | hashCode() |
|---|---|
| Compares objects for equality | Returns an integer hash code |
| Returns `boolean` | Returns `int` |
| Used to check logical equality | Used by hash-based collections |
| Can be overridden | Can be overridden |
| Equal objects must have equal hash codes | Same hash codes do not guarantee equal objects |

Practiced overriding `hashCode()` along with `equals()` and understanding how hash-based collections use hash codes.

---

### 7. Why Do We Override toString() of Object Class?

The `toString()` method is defined in the `Object` class.

It returns a string representation of an object.

**Syntax:**

```java
public String toString()
```

#### Default toString() Behaviour

If a class does not override `toString()`, the default implementation returns a string containing the class name and a hash-code-based hexadecimal representation.

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

        Student s = new Student(101, "Suraj");

        System.out.println(s);
        System.out.println(s.toString());
    }
}
```

The output is similar to:

```text
Student@5acf9800
Student@5acf9800
```

The exact hexadecimal portion depends on the object's hash code and is not fixed.

#### Why Override toString()?

We override `toString()` to provide a meaningful and readable string representation of an object.

It helps:

- Display object data in a readable format.
- Debug Java programs easily.
- Print object information without manually accessing each field.
- Make logging and error messages more meaningful.

#### Example: Overriding toString()

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {

        return "Student [id=" + id + ", name=" + name + "]";
    }
}

public class Main {

    public static void main(String[] args) {

        Student s = new Student(101, "Suraj");

        System.out.println(s);
    }
}
```

**Output:**

```text
Student [id=101, name=Suraj]
```

**Important Point:**

When an object is passed to `System.out.println()`, Java calls its `toString()` method to obtain the string representation.

Practiced overriding `toString()` to display object data in a readable format and understood its importance in debugging and object representation.

---

### 8. Why Do We Override equals() of Object Class?

The `equals()` method in the `Object` class performs reference-based equality by default.

When two separate objects contain the same data, the default implementation generally returns `false`.

We override `equals()` when we want to compare objects based on their content or logical identity instead of their memory identity.

#### Example Without Overriding equals()

```java
class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Suraj");
        Employee e2 = new Employee(101, "Suraj");

        System.out.println(e1.equals(e2));
    }
}
```

**Output:**

```text
false
```

Both objects contain the same values, but the default `equals()` method compares their identities.

#### Example After Overriding equals()

```java
class Employee {

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Employee) {
        Employee other = (Employee) obj;
        return id == other.id && name.equals(other.name);
      }
      return false;
    }
}

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Suraj");
        Employee e2 = new Employee(101, "Suraj");

        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));
    }
}
```

**Output:**

```text
false
true
```

#### Why Override equals()?

- To compare objects based on their field values.
- To define logical equality for user-defined classes.
- To make object comparisons meaningful.
- To support correct behaviour in collections such as `ArrayList`, `HashSet`, and `HashMap`.
- To avoid relying only on reference equality.

#### == vs equals()

| `==` Operator | `equals()` Method |
|---|---|
| Operator | Method |
| Compares primitive values | Compares objects according to its implementation |
| For references, checks object identity | Default implementation checks identity |
| Cannot be overridden | Can be overridden |
| Used for reference equality | Can be used for content equality |

**Important:** Overriding `equals()` does not change the behaviour of `==`. The two operations have different purposes.

Practiced comparing objects before and after overriding `equals()`, implementing field-based equality, and understanding why `hashCode()` must be overridden along with `equals()`.

---

## Learning Outcomes

- Understood how interfaces can extend other interfaces and how classes implement multiple interfaces.
- Learned how Java handles identical method names and signatures across multiple interfaces.
- Understood compatible and incompatible return types in interface method declarations.
- Practiced method overloading through different interface method signatures.
- Learned how to access duplicate interface constants using interface names.
- Understood how interfaces, abstract classes, and concrete classes work together.
- Implemented the `BoundedShape`, `Circle`, and `Rectangle` geometry example.
- Learned protected access control within the same package and across packages.
- Understood the role of the `Object` class in Java.
- Learned the difference between reference equality and content equality.
- Practiced overriding `equals()` for logical object comparison.
- Understood the relationship between `equals()` and `hashCode()`.
- Learned why `toString()` is overridden to provide meaningful object representations.

## Repository Contents

- Interface inheritance and multiple interface implementation examples.
- Same-name method and data member conflict examples.
- Abstract class and interface integration programs.
- BoundedShape, Circle, and Rectangle implementation.
- Protected access specifier examples.
- Object class method examples.
- Reference equality and content equality programs.
- `equals()` and `hashCode()` overriding examples.
- `toString()` implementation examples.
- Class notes and supporting learning materials.
