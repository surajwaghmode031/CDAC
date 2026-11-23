# Day 07 – Core Java

## Topics Covered

### 1. Extending and Implementing Interfaces

In Java, interfaces can extend other interfaces, and classes can implement one or more interfaces.

#### a. Extending an Interface

An interface uses the `extends` keyword to inherit another interface. It can also extend multiple interfaces.

```java
interface A {
    void methodA();
}

interface B extends A {
    void methodB();
}

class Demo implements B {

    public void methodA() {
        System.out.println("Method A");
    }

    public void methodB() {
        System.out.println("Method B");
    }
}
```

#### b. Implementing Multiple Interfaces

A class can implement multiple interfaces using the `implements` keyword.

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
```

**Important Rules:**

- An interface extends another interface using `extends`.
- An interface can extend multiple interfaces.
- A class implements an interface using `implements`.
- A class can implement multiple interfaces.
- A class can extend one class and implement multiple interfaces.
- A concrete class must implement all inherited abstract methods.

Practiced extending interfaces, implementing multiple interfaces, and understanding interface inheritance.

---

### 2. Implementing Multiple Interfaces with Same Method Names and Data Members

When a class implements multiple interfaces, situations can arise where interfaces contain methods or variables with identical names.

#### a. Same Method Name, Same Signature, Same Return Type

A single implementation can satisfy both interface declarations.

```java
interface A {
    void display();
}

interface B {
    void display();
}

class Demo implements A, B {

    public void display() {
        System.out.println("Common Display Method");
    }
}
```

**Output:**

```text
Common Display Method
```

#### b. Same Method Name, Same Signature, Different Return Types

When return types are incompatible, the implementing class cannot satisfy both declarations.

```java
interface A {
    int display();
}

interface B {
    String display();
}
```

This causes a compilation error because Java does not allow methods to be overloaded only by changing their return types.

**Covariant Return Type Exception:**

Compatible reference return types are allowed when one return type is a subtype of the other.

```java
interface A {
    Number getValue();
}

interface B {
    Integer getValue();
}

class Demo implements A, B {

    public Integer getValue() {
        return 100;
    }
}
```

Here, `Integer` is a subtype of `Number`.

#### c. Same Method Name, Different Signatures, Same Return Type

The class must implement both methods. This is method overloading.

```java
interface A {
    void display(int a);
}

interface B {
    void display(String name);
}

class Demo implements A, B {

    public void display(int a) {
        System.out.println("Integer: " + a);
    }

    public void display(String name) {
        System.out.println("String: " + name);
    }
}
```

**Output:**

```text
Integer: 100
String: Suraj
```

#### d. Same Data Member Name in Two Interfaces

Interface variables are implicitly `public static final`.

When two interfaces declare the same variable name, use the interface name to access each constant.

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
```

**Output:**

```text
100
200
```

**Summary:**

| Scenario | Result |
|---|---|
| Same method name, signature and compatible return type | One implementation can satisfy both |
| Same method name and signature, incompatible return types | Compilation error |
| Same method name, different signatures | Implement both overloaded methods |
| Same data member name | Use interface name to access the constant |

Practiced handling duplicate method declarations, return-type compatibility, method overloading, and duplicate interface constants.

---

### 3. Combining Interfaces, Abstract Classes, and Concrete Classes

This example is based on the classroom diagram using `AreaComputation`, `PerimeterComputation`, and the abstract class `BoundedShape`. It also includes `Circle` and `Rectangle` concrete classes.

#### Class Structure

```text
AreaComputation          PerimeterComputation
     |                            |
     +-------------+--------------+
                   |
              BoundedShape
              (Abstract Class)
              int x, y
              Constructor(x, y)
              toString()
                   |
             +-----+-----+
             |           |
           Circle     Rectangle
```

#### a. AreaComputation Interface

```java
interface AreaComputation {

    double PI = 3.14159;

    double calcArea();
}
```

#### b. PerimeterComputation Interface

```java
interface PerimeterComputation {

    double calcPerimeter();
}
```

#### c. Abstract BoundedShape Class

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

The class implements both interfaces but does not implement their abstract methods, so it is declared abstract.

#### d. Circle Class

Here, `x` represents the radius.

```java
class Circle extends BoundedShape {

    Circle(int radius) {
        super(radius, 0);
    }

    public double calcArea() {
        return AreaComputation.PI * x * x;
    }

    public double calcPerimeter() {
        return 2 * AreaComputation.PI * x;
    }

    @Override
    public String toString() {
        return "Circle: Radius = " + x;
    }
}
```

#### e. Rectangle Class

Here, `x` represents length and `y` represents width.

```java
class Rectangle extends BoundedShape {

    Rectangle(int length, int width) {
        super(length, width);
    }

    public double calcArea() {
        return x * y;
    }

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

#### f. Tester Class

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

**Concepts Demonstrated:**

- Multiple interface implementation.
- Abstract class.
- Concrete classes.
- Inheritance using `extends`.
- Constructor chaining using `super()`.
- Method overriding.
- Implementation of interface methods.
- Overriding `toString()`.

Practiced designing the geometry class hierarchy and testing area and perimeter calculations for Circle and Rectangle.

---

### 4. Protected Access Specifier

The `protected` access specifier controls the visibility of class members.

A protected member is accessible:

- Within the same class.
- Within other classes in the same package.
- In subclasses located in different packages, subject to Java's protected-access rules.

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

**Important Points:**

- Protected members are accessible throughout the same package.
- Subclasses in other packages can access inherited protected members subject to additional rules.
- Protected members support inheritance.
- A top-level class cannot be declared `protected`.

Practiced accessing protected variables and methods through inheritance and understanding protected access across packages.

---

### 5. Object Class and equals() Method

The `Object` class is the root class of the Java class hierarchy. Every Java class directly or indirectly inherits from it.

Some important methods of the `Object` class are:

- `equals()`
- `hashCode()`
- `toString()`
- `getClass()`
- `clone()`
- `wait()`
- `notify()`
- `notifyAll()`

#### a. Reference Equality vs Content Equality

**Reference Equality:** Checks whether two references point to the same object.

**Content Equality:** Checks whether two objects contain equivalent data.

#### b. `==` Operator

For reference variables, `==` checks whether both references point to the same object.

```java
Student s1 = new Student(101, "Suraj");
Student s2 = new Student(101, "Suraj");

System.out.println(s1 == s2);
```

**Output:**

```text
false
```

The two objects are different objects even though their data is identical.

#### c. Changing Reference Equality to Content Equality

Override the `equals()` method to compare object data.

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

#### Important Rules of equals()

1. Reflexive: An object must be equal to itself.
2. Symmetric: If `a.equals(b)` is true, then `b.equals(a)` must be true.
3. Transitive: If `a.equals(b)` and `b.equals(c)` are true, then `a.equals(c)` must be true.
4. Consistent: Repeated calls should return the same result if the compared information has not changed.
5. Non-null: A non-null object must not be equal to `null`.

Practiced comparing references using `==` and overriding `equals()` to implement content-based equality.

---

### 6. hashCode() Method

The `hashCode()` method is defined in the `Object` class and returns an integer hash code associated with an object.

**Syntax:**

```java
public int hashCode()
```

It is commonly used by hash-based collections:

- `HashMap`
- `HashSet`
- `Hashtable`

#### Why Is hashCode() Used?

Hash-based collections use hash codes to determine the bucket where an object should be stored or searched for.

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

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Student other = (Student) obj;

        return id == other.id && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name);
    }
}
```

#### Important Rules

- `hashCode()` returns an integer.
- Equal objects must have the same hash code.
- Objects with the same hash code are not necessarily equal.
- Unequal objects can have the same hash code. This is called a hash collision.
- When overriding `equals()`, override `hashCode()` as well.

| equals() | hashCode() |
|---|---|
| Compares objects for equality | Returns an integer hash code |
| Returns `boolean` | Returns `int` |
| Checks logical equality when overridden | Helps hash-based collections locate objects |

Practiced overriding `hashCode()` along with `equals()` and understanding their relationship.

---

### 7. Why Do We Override toString() of Object Class?

The `toString()` method returns a string representation of an object.

**Syntax:**

```java
public String toString()
```

By default, the `Object.toString()` implementation returns a string containing the class name and a hash-code-based hexadecimal representation.

**Example Without Overriding:**

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
    }
}
```

Output resembles:

```text
Student@5acf9800
```

The exact hexadecimal portion is not fixed.

#### Why Override toString()?

- To display object data in a readable format.
- To simplify debugging.
- To make logging more meaningful.
- To avoid manually printing every object field.

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

When an object is passed to `System.out.println()`, Java uses its `toString()` method to obtain the string representation.

Practiced overriding `toString()` to display meaningful object information.

---

### 8. Why Do We Override equals() of Object Class?

The default `Object.equals()` method compares object identity.

When two separate objects contain the same data, the default implementation generally returns `false`.

We override `equals()` when we want to compare objects based on their contents or logical identity.

**Example:**

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

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Employee other = (Employee) obj;

        return id == other.id && name.equals(other.name);
    }
}
```

**Why Override equals()?**

- To compare objects using their field values.
- To define logical equality for user-defined classes.
- To make object comparisons meaningful.
- To support correct equality behaviour in collections.
- To avoid relying only on reference equality.

**Important:** Overriding `equals()` does not change the behaviour of `==`. Always consider overriding `hashCode()` when implementing value-based equality.

Practiced comparing objects before and after overriding `equals()` and implementing field-based equality.

---

### 9. Types of Errors in Java

An **error** is a problem in a program that prevents it from compiling correctly or executing as expected.

Java programming problems can be broadly classified into three categories:

#### a. Compile-Time Errors

Compile-time errors are detected by the compiler before the program executes.

Common causes:

- Missing semicolon.
- Incorrect variable declaration.
- Missing brackets.
- Type mismatch.
- Undefined variable or method.
- Incorrect method arguments.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int a = "Hello";

        System.out.println(a);
    }
}
```

**Result:** Compilation error because a String value cannot be assigned to an `int` variable.

#### b. Runtime Errors

Runtime errors occur while a program is executing.

Examples:

- `ArithmeticException`
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `ClassCastException`

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        System.out.println(a / b);
    }
}
```

**Result:** `ArithmeticException` because integer division by zero is not allowed.

#### c. Logical Errors

Logical errors occur when a program executes without a compilation or runtime error but produces an incorrect result because of incorrect logic.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int length = 10;
        int width = 5;

        int area = 2 * (length + width);

        System.out.println("Area = " + area);
    }
}
```

The program executes, but the formula calculates the perimeter instead of the area.

Correct formula:

```java
int area = length * width;
```

#### Types of Errors – Comparison

| Error Type | When Detected | Example |
|---|---|---|
| Compile-time error | During compilation | Missing semicolon |
| Runtime error | During execution | Division by zero |
| Logical error | While checking program results | Incorrect formula |

Practiced identifying compile-time, runtime, and logical errors in Java programs.

---

### 10. Exception in Java

An **exception** is an event that occurs during program execution and disrupts the normal flow of instructions.

Exceptions represent conditions that a program may be able to handle.

Examples:

- Dividing an integer by zero.
- Accessing an invalid array index.
- Accessing a method or field through a null reference.
- Opening a file that does not exist.
- Converting an invalid String into a number.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        int result = a / b;

        System.out.println(result);
    }
}
```

**Output:**

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
```

The exception interrupts the normal execution of the program.

#### Exception vs Error

Java provides the `Throwable` class as the root of exception-related and error-related conditions.

- **Exception:** Represents conditions applications may handle.
- **Error:** Represents serious problems that applications generally are not expected to handle, such as certain JVM failures.

Examples of errors include `OutOfMemoryError` and `StackOverflowError`.

---

### 11. Exception Handling

**Exception handling** is the mechanism used to handle runtime exceptions so that a program can respond to abnormal situations and continue executing when appropriate.

Java provides the following keywords:

- `try`
- `catch`
- `finally`
- `throw`
- `throws`

It also provides try-with-resources for automatic resource management.

#### Example Without Exception Handling

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        System.out.println(a / b);

        System.out.println("Program End");
    }
}
```

The exception prevents the final statement from executing.

#### Example With Exception Handling

```java
public class Main {

    public static void main(String[] args) {

        try {

            int a = 10;
            int b = 0;

            System.out.println(a / b);

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program End");
    }
}
```

**Output:**

```text
Cannot divide by zero
Program End
```

Exception handling allows the program to handle the exception and continue with the statements after the try-catch construct.

#### Advantages of Exception Handling

- Prevents abnormal termination when an exception is properly handled.
- Maintains normal program flow where possible.
- Separates error-handling code from normal logic.
- Helps identify and report problems.
- Supports resource cleanup.

---

### 12. Exception Handling Flow

When an exception occurs inside a `try` block, Java searches for a matching `catch` block.

#### Exception Handling Execution Flow

1. Statements inside the `try` block execute.
2. If no exception occurs, the `catch` blocks are skipped.
3. If an exception occurs, the remaining statements in the `try` block are skipped.
4. JVM searches for a matching `catch` block.
5. If a matching handler is found, its code executes.
6. The `finally` block executes if present, subject to exceptional JVM termination or other circumstances that prevent it.
7. Execution continues after the try-catch-finally construct if the exception was handled.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        try {

            System.out.println("Inside try");

            int result = 10 / 0;

            System.out.println(result);

        } catch (ArithmeticException e) {

            System.out.println("Inside catch");

        } finally {

            System.out.println("Inside finally");
        }

        System.out.println("Main Over");
    }
}
```

**Output:**

```text
Inside try
Inside catch
Inside finally
Main Over
```

#### Flow When No Exception Occurs

```text
          try block
              |
       No exception
              |
        Skip catch
              |
        finally block
              |
        Next statement
```

#### Flow When Exception Occurs

```text
          try block
              |
       Exception occurs
              |
      Skip remaining try
              |
      Find matching catch
              |
       Execute catch
              |
        finally block
              |
        Next statement
```

If no matching `catch` block is found, the exception propagates to the caller. The `finally` block still executes during normal stack unwinding when present.

Practiced observing normal and exceptional execution flows using `try`, `catch`, and `finally`.

---

### 13. Exception Inheritance Hierarchy

Java exception classes follow an inheritance hierarchy rooted in the `Throwable` class.

#### Exception Hierarchy

```text
                  Object
                     |
                 Throwable
                /         \
             Error       Exception
             /              |
     OutOfMemoryError       |
     StackOverflowError     |
                            |
                 RuntimeException
                    /       |       \
                   /        |        \
        ArithmeticException |  NullPointerException
                             |
                 ArrayIndexOutOfBoundsException

                 Other Exception subclasses
                 IOException
                 SQLException
                 ClassNotFoundException
```

#### Important Classes

**a. Throwable**

- Root class of Java's exception and error hierarchy.
- Provides methods such as `getMessage()`, `toString()`, and `printStackTrace()`.

**b. Error**

Represents serious problems generally outside the normal application recovery process.

Examples:

- `OutOfMemoryError`
- `StackOverflowError`

**c. Exception**

Represents conditions that an application may handle.

Examples:

- `IOException`
- `SQLException`
- `ClassNotFoundException`

**d. RuntimeException**

Represents unchecked exceptions that generally occur because of programming mistakes or invalid operations.

Examples:

- `ArithmeticException`
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `ClassCastException`

Practiced understanding the inheritance relationship between `Throwable`, `Error`, `Exception`, and `RuntimeException`.

---

### 14. Checked vs Unchecked Exceptions

Java exceptions are broadly classified into checked and unchecked exceptions.

#### a. Checked Exceptions

Checked exceptions are checked by the compiler at compile time.

The programmer must handle them using `try-catch` or declare them using `throws`, unless the exception is already handled by an enclosing construct.

Examples:

- `IOException`
- `SQLException`
- `ClassNotFoundException`
- `FileNotFoundException`

**Example:**

```java
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {

            FileReader fr = new FileReader("data.txt");

            fr.close();

        } catch (IOException e) {

            System.out.println("File handling error");
        }
    }
}
```

#### b. Unchecked Exceptions

Unchecked exceptions are not checked by the compiler for mandatory handling.

They are subclasses of `RuntimeException`.

Examples:

- `ArithmeticException`
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `NumberFormatException`

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        System.out.println(a / b);
    }
}
```

The compiler does not require the programmer to catch or declare `ArithmeticException`.

#### Checked vs Unchecked Comparison

| Checked Exception | Unchecked Exception |
|---|---|
| Checked by compiler | Not checked for mandatory handling |
| Must be caught or declared | Catching or declaring is optional |
| Subclasses of `Exception`, excluding `RuntimeException` subclasses | Subclasses of `RuntimeException` |
| Often related to external conditions | Often related to programming mistakes or invalid operations |
| Example: `IOException` | Example: `NullPointerException` |

**Important:** `Error` subclasses are also unchecked in Java's exception-handling terminology, but they are not exceptions to be treated as ordinary application exceptions.

---

### 15. Exception Handling Keywords

Java provides several keywords to handle and propagate exceptions.

#### a. try

The `try` block contains statements that may generate an exception.

```java
try {
    int result = 10 / 0;
}
```

A `try` block must be followed by at least one `catch` block or a `finally` block, except in try-with-resources, where the resource construct can also be used.

#### b. catch

The `catch` block handles an exception thrown from its associated `try` block.

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Division by zero");
}
```

Multiple catch blocks can be used to handle different exception types.

**Example:**

```java
try {

    int[] arr = {10, 20, 30};

    System.out.println(arr[5]);

} catch (ArithmeticException e) {

    System.out.println("Arithmetic Exception");

} catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid Array Index");
}
```

More specific exception types should appear before their broader parent exception types.

#### c. finally

The `finally` block is used to execute cleanup code after a try-catch construct.

It normally executes whether an exception occurs or not.

```java
try {

    System.out.println("Inside try");

} catch (Exception e) {

    System.out.println("Inside catch");

} finally {

    System.out.println("Inside finally");
}
```

**Output:**

```text
Inside try
Inside finally
```

Common uses:

- Closing resources.
- Releasing connections.
- Performing cleanup operations.

A `finally` block is not guaranteed to execute if the JVM terminates abruptly, for example through `System.exit()` or a process crash.

#### d. throw

The `throw` keyword is used to explicitly throw an exception object.

**Syntax:**

```java
throw new ExceptionType("Error message");
```

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        int age = 15;

        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }

        System.out.println("Eligible");
    }
}
```

The exception is thrown explicitly when the condition is not satisfied.

#### e. throws

The `throws` keyword is used in a method declaration to indicate exceptions that may be propagated to the caller.

**Example:**

```java
import java.io.IOException;

class Demo {

    void readFile() throws IOException {

        throw new IOException("File reading failed");
    }
}

public class Main {

    public static void main(String[] args) {

        try {

            Demo d = new Demo();
            d.readFile();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
```

**Output:**

```text
File reading failed
```

#### Difference Between throw and throws

| throw | throws |
|---|---|
| Used to explicitly throw an exception | Used to declare possible exceptions |
| Used inside a method or block | Used in a method or constructor declaration |
| Followed by an exception object | Followed by exception class names |
| Throws one exception object at a time | Can declare multiple exception types |

Practiced using `try`, `catch`, `finally`, `throw`, and `throws` in Java programs.

---

### 16. Built-in and Custom Exceptions

Java provides built-in exception classes for common exceptional situations.

Developers can also create their own exception classes to represent application-specific conditions.

#### a. Built-in Exceptions

Some commonly used built-in exceptions are:

| Exception | Description |
|---|---|
| `ArithmeticException` | Arithmetic operation is invalid, such as integer division by zero |
| `NullPointerException` | Attempt to use a null reference in an operation that requires an object |
| `ArrayIndexOutOfBoundsException` | Accessing an invalid array index |
| `NumberFormatException` | Invalid String-to-number conversion |
| `ClassCastException` | Invalid reference type casting |
| `IOException` | Input/output operation failure |
| `FileNotFoundException` | Required file cannot be found |
| `SQLException` | Database access error |

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        try {

            int number = Integer.parseInt("ABC");

        } catch (NumberFormatException e) {

            System.out.println("Invalid Number Format");
        }
    }
}
```

**Output:**

```text
Invalid Number Format
```

#### b. Custom Exceptions

A **custom exception** is a user-defined exception class created to represent a specific application error.

Custom exceptions are useful when built-in exceptions do not clearly represent a business rule or application-specific condition.

There are two common types:

1. Custom checked exception – Extends `Exception`.
2. Custom unchecked exception – Extends `RuntimeException`.

#### Custom Checked Exception

```java
class InvalidAgeException extends Exception {

    InvalidAgeException(String message) {
        super(message);
    }
}

public class Main {

    static void checkAge(int age) throws InvalidAgeException {

        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {

        try {

            checkAge(15);

        } catch (InvalidAgeException e) {

            System.out.println(e.getMessage());
        }
    }
}
```

**Output:**

```text
Age must be 18 or above
```

**Explanation:**

- `InvalidAgeException` is a custom exception.
- It extends `Exception`, so it is a checked exception.
- `super(message)` passes the message to the parent `Exception` constructor.
- `throws` declares that the method may propagate the exception.
- `throw` creates and throws the custom exception object.
- `catch` handles the exception.

#### Custom Unchecked Exception

```java
class InvalidAmountException extends RuntimeException {

    InvalidAmountException(String message) {
        super(message);
    }
}

public class Main {

    static void withdraw(double amount) {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount");
        }

        System.out.println("Withdrawal successful");
    }

    public static void main(String[] args) {

        try {

            withdraw(-500);

        } catch (InvalidAmountException e) {

            System.out.println(e.getMessage());
        }
    }
}
```

**Output:**

```text
Invalid withdrawal amount
```

**Checked vs Unchecked Custom Exceptions**

| Custom Checked Exception | Custom Unchecked Exception |
|---|---|
| Extends `Exception` | Extends `RuntimeException` |
| Must be caught or declared | No mandatory catch or declaration |
| Suitable for conditions callers may be expected to handle | Suitable for invalid operations or programming conditions |

Practiced creating custom checked and unchecked exception classes and using `throw`, `throws`, `try`, and `catch`.

---

### 17. Throwable Class API

The `Throwable` class is the root class of Java's exception and error hierarchy.

It provides methods that help obtain exception information and display error details.

Important methods include:

1. `toString()`
2. `getMessage()`
3. `printStackTrace()`

#### a. toString()

The `toString()` method returns a string representation of the exception.

It normally includes the exception class name and its detail message, if present.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            System.out.println(e.toString());
        }
    }
}
```

**Output:**

```text
java.lang.ArithmeticException: / by zero
```

#### b. getMessage()

The `getMessage()` method returns the detail message associated with the exception.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        try {

            throw new ArithmeticException("Invalid arithmetic operation");

        } catch (ArithmeticException e) {

            System.out.println(e.getMessage());
        }
    }
}
```

**Output:**

```text
Invalid arithmetic operation
```

#### c. printStackTrace()

The `printStackTrace()` method prints the exception information and the sequence of method calls that led to the exception.

It is useful for debugging.

**Example:**

```java
public class Main {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        } catch (ArithmeticException e) {

            e.printStackTrace();
        }
    }
}
```

**Output resembles:**

```text
java.lang.ArithmeticException: / by zero
    at Main.main(Main.java:7)
```

The file name and line number depend on the actual program.

#### Comparison of Throwable Methods

| Method | Purpose |
|---|---|
| `toString()` | Returns exception class name and detail message |
| `getMessage()` | Returns only the detail message |
| `printStackTrace()` | Prints exception details and stack trace |

Practiced using Throwable API methods to display exception messages and trace the source of errors.

---

### 18. Try-with-Resources

**Try-with-resources** is a Java feature used to automatically close resources after they are no longer needed.

It was introduced in Java 7.

It is useful for resources such as:

- File readers and writers.
- Input and output streams.
- Database connections.
- Statements and result sets.

Resources used in try-with-resources must implement `AutoCloseable` (or `Closeable`, which extends `AutoCloseable`).

#### Syntax

```java
try (ResourceType resource = new ResourceType()) {

    // Resource operations

} catch (Exception e) {

    // Exception handling
}
```

The resource is automatically closed when the try block finishes, whether it completes normally or because of an exception.

#### Example Using FileReader

```java
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try (FileReader fr = new FileReader("data.txt")) {

            int ch;

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}
```

The `FileReader` is automatically closed after the try block completes.

#### Example Using Multiple Resources

Multiple resources can be declared inside the same try-with-resources statement.

```java
try (
    FileReader fr = new FileReader("input.txt");
    java.io.BufferedReader br = new java.io.BufferedReader(fr)
) {

    System.out.println(br.readLine());

} catch (IOException e) {

    System.out.println(e.getMessage());
}
```

Resources are closed automatically in the reverse order of their initialization.

#### Traditional try-finally vs Try-with-Resources

**Traditional Approach:**

```java
FileReader fr = null;

try {

    fr = new FileReader("data.txt");

    System.out.println(fr.read());

} catch (IOException e) {

    System.out.println(e.getMessage());

} finally {

    if (fr != null) {

        try {
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

**Try-with-Resources Approach:**

```java
try (FileReader fr = new FileReader("data.txt")) {

    System.out.println(fr.read());

} catch (IOException e) {

    System.out.println(e.getMessage());
}
```

#### Important Points

- Automatically closes resources.
- Reduces the need for manual cleanup in `finally`.
- Resources must implement `AutoCloseable`.
- Multiple resources can be declared in one statement.
- Resources are closed in reverse order of initialization.
- A `catch` or `finally` block is optional for try-with-resources.
- A resource can be declared inside the parentheses or, in supported Java versions, an effectively final existing variable can be used.

Practiced reading files using try-with-resources and understanding automatic resource management and resource-closing order.

---

## Learning Outcomes

- Understood the different types of programming errors.
- Learned what exceptions are and why exception handling is required.
- Understood Java's exception handling execution flow.
- Learned the inheritance hierarchy of `Throwable`, `Error`, and `Exception`.
- Understood checked and unchecked exceptions.
- Practiced using `try`, `catch`, `finally`, `throw`, and `throws`.
- Learned the difference between built-in and custom exceptions.
- Practiced creating custom checked and unchecked exceptions.
- Understood the `toString()`, `getMessage()`, and `printStackTrace()` methods of `Throwable`.
- Learned how try-with-resources automatically closes resources.
- Practiced resource management using `FileReader` and try-with-resources.

## Repository Contents

- Interface inheritance and multiple interface implementation examples.
- Same-name method and data member conflict examples.
- Abstract class, Circle, and Rectangle implementation.
- Protected access specifier examples.
- Object class method examples.
- Reference equality and content equality programs.
- `equals()`, `hashCode()`, and `toString()` examples.
- Compile-time, runtime, and logical error examples.
- Exception handling and execution flow programs.
- Checked and unchecked exception examples.
- Built-in and custom exception programs.
- Throwable API method examples.
- Try-with-resources file handling examples.
- Class notes and supporting learning materials.
