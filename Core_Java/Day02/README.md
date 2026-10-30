# Day 02 – Core Java

## Topics Covered

### 1. JVM Architecture

The **Java Virtual Machine (JVM)** is an abstract machine that provides the runtime environment for executing Java bytecode. It acts as an intermediate layer between compiled Java code and the operating system.

Java source code (`.java`) is compiled by the Java compiler into bytecode (`.class`). The JVM loads and executes this bytecode, allowing Java programs to run on different platforms.

#### Working of JVM

1. **Compilation:** The Java compiler (`javac`) converts source code into bytecode.
2. **Class Loading:** The Class Loader loads the required `.class` files into memory.
3. **Bytecode Verification:** The Bytecode Verifier checks the bytecode for validity and security.
4. **Execution:** The Execution Engine executes the verified bytecode.
5. **Memory Management:** The Garbage Collector manages memory by removing objects that are no longer reachable.

#### Major Components of JVM Architecture

**a. Class Loader Subsystem**

The Class Loader loads Java class files into JVM memory when they are required.

Its main phases are:

- **Loading:** Loads the `.class` file and creates the corresponding class representation in memory.
- **Linking:** Verifies and prepares the class before execution.
  - Verification – Checks the correctness of bytecode.
  - Preparation – Allocates memory for static variables and assigns default values.
  - Resolution – Converts symbolic references into direct references.
- **Initialization:** Executes static initializers and assigns explicit values to static variables.

Types of Class Loaders:

- **Bootstrap Class Loader:** Loads core Java classes.
- **Platform Class Loader:** Loads platform-specific Java libraries.
- **Application Class Loader:** Loads classes from the application classpath.

**b. Runtime Data Areas**

The JVM divides memory into different runtime areas to manage program execution.

- **Heap Area:** Stores objects and arrays created during program execution. It is shared among threads.
- **Java Stack:** Stores stack frames containing local variables, method calls, and intermediate results. Each thread has its own stack.
- **Method Area:** Stores class-level information, runtime constant pools, and method-related data. Its implementation in modern HotSpot JVMs is associated with Metaspace.
- **PC Register:** Stores the address of the current or next JVM instruction being executed by a thread.
- **Native Method Stack:** Supports the execution of native methods written in languages such as C and C++.

**c. Execution Engine**

The Execution Engine executes the bytecode loaded into the JVM.

Its major components include:

- **Interpreter:** Reads and executes bytecode instructions one by one.
- **JIT Compiler (Just-In-Time Compiler):** Compiles frequently executed bytecode into native machine code to improve performance.
- **Garbage Collector:** Automatically reclaims heap memory occupied by objects that are no longer reachable.

**d. Java Native Interface (JNI)**

JNI provides a mechanism through which Java code can interact with native applications and libraries written in languages such as C and C++.

**e. Native Method Libraries**

These are libraries containing native code that can be accessed by Java applications through JNI.

#### Platform Independence

Java follows the principle of **Write Once, Run Anywhere (WORA)**.

- Java source code is compiled into platform-independent bytecode.
- A compatible JVM on each operating system executes that bytecode.
- The JVM handles platform-specific execution.

Studied the complete JVM execution flow, understood its memory areas, and explored how the Class Loader and Execution Engine work together to execute Java programs.

---

### 2. Object-Oriented Programming (OOP)

Object-Oriented Programming is a programming approach based on classes and objects. It helps organize code into reusable, maintainable, and modular components.

Studied the fundamental OOP concepts in Java, including classes, objects, encapsulation, and abstraction.

#### a. Class and Object

**Class:**

A class is a blueprint or template used to define the properties and behaviours of objects.

- Properties are represented by variables.
- Behaviours are represented by methods.
- A class defines the structure of objects but does not create individual object instances by itself.

**Object:**

An object is an instance of a class. It has its own state and can perform behaviours defined by its class.

An object generally consists of:

- **State:** Values stored in instance variables.
- **Behaviour:** Operations performed through methods.
- **Identity:** Distinguishes one object from another.

**Syntax:**

```java
class Student {
    int id;
    String name;

    void display() {
        System.out.println(id + " " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.id = 101;
        s1.name = "Suraj";

        s1.display();
    }
}
```

**Output:**

```text
101 Suraj
```

Practiced creating classes, declaring instance variables, defining methods, and creating objects using the `new` keyword. Also accessed object members using the dot (`.`) operator.

#### b. Encapsulation

Encapsulation is the process of wrapping data and the methods that operate on that data into a single unit (class).

It is commonly implemented using private variables and public getter and setter methods.

**Important points:**

- Data members are declared `private` to restrict direct access from outside the class.
- Getter methods are used to retrieve private variable values.
- Setter methods are used to update private variable values.
- Validation can be added inside setter methods to control the values assigned to an object.
- Encapsulation supports data hiding and controlled access.

**Example:**

```java
class Student {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();

        s1.setId(101);
        s1.setName("Suraj");

        System.out.println(s1.getId());
        System.out.println(s1.getName());
    }
}
```

**Output:**

```text
101
Suraj
```

Practiced implementing encapsulation by declaring private data members and accessing or modifying them through public getter and setter methods.

#### c. Abstraction

Abstraction is the process of hiding internal implementation details and exposing only the essential functionality to the user.

In Java, abstraction can be achieved using:

1. Abstract classes
2. Interfaces

**Abstract Class:**

- Declared using the `abstract` keyword.
- Can contain abstract methods as well as concrete methods.
- Cannot be instantiated directly.
- Can contain constructors, instance variables, and static methods.
- A subclass must implement inherited abstract methods unless the subclass is also abstract.

**Example:**

```java
abstract class Vehicle {

    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car started");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();

        v.start();
        v.stop();
    }
}
```

**Output:**

```text
Car started
Vehicle stopped
```

**Interface:**

- Declared using the `interface` keyword.
- Defines a contract that implementing classes agree to follow.
- A class uses the `implements` keyword to implement an interface.
- Interfaces can contain abstract methods, default methods, static methods, and private methods.
- A class can implement multiple interfaces.

**Example:**

```java
interface Printable {
    void print();
}

class Document implements Printable {

    @Override
    public void print() {
        System.out.println("Printing document");
    }
}

public class Main {
    public static void main(String[] args) {
        Printable p = new Document();
        p.print();
    }
}
```

**Output:**

```text
Printing document
```

Practiced defining abstract classes, abstract methods, and interfaces, then implementing their functionality in concrete classes.

---

### 3. Packages in Java

A **package** is a group of related classes, interfaces, and sub-packages. Packages help organize Java applications and provide a structured way to manage code.

#### Types of Packages

**a. Built-in Packages**

Packages provided by Java API.

Examples:

- `java.lang` – Contains fundamental classes such as String, System, and Math. It is imported automatically.
- `java.util` – Contains utility classes such as Scanner, ArrayList, and HashMap.
- `java.io` – Provides classes for input and output operations.
- `java.sql` – Provides classes and interfaces for database connectivity.

**b. User-defined Packages**

Packages created by developers to organize application classes.

#### Creating a User-defined Package

The `package` keyword is used to declare a package. The package declaration must appear before import statements and type declarations in a Java source file.

**Example:**

File: `Student.java`

```java
package mypack;

public class Student {
    public void display() {
        System.out.println("Student class from mypack");
    }
}
```

Using the package in another class:

File: `Main.java`

```java
import mypack.Student;

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
Student class from mypack
```

#### Importing Classes

The `import` keyword allows a class to use classes from another package without writing their fully qualified names every time.

Examples:

```java
import java.util.Scanner;
import java.util.ArrayList;
```

The wildcard import can also be used:

```java
import java.util.*;
```

A wildcard import makes types in that package available by their simple names; it does not automatically import classes from its sub-packages.

#### Advantages of Packages

- Organize related classes and interfaces.
- Avoid naming conflicts between classes.
- Improve code reusability and maintainability.
- Provide package-level access control.
- Make large applications easier to manage.

Practiced creating user-defined packages, declaring package names, importing classes, and compiling and executing programs that use package structures.

---

### 4. Classpath in Java

**Classpath** is the path used by Java tools and the JVM to locate user-defined classes, compiled `.class` files, and required libraries.

It tells the Java compiler and runtime where to search for classes that are needed by a program.

#### Why Classpath Is Required

- Helps locate compiled class files.
- Allows programs to use classes from different directories.
- Supports the use of external JAR libraries.
- Helps compile and execute programs that use packages.

#### Setting Classpath

**a. Using the `-cp` or `-classpath` option**

The `-cp` option specifies the classpath directly while compiling or executing a program.

Example:

```bash
javac -cp . Main.java
java -cp . Main
```

Here, `.` represents the current directory.

**b. Using a Custom Directory**

If compiled classes are stored in a directory named `classes`, specify that directory:

```bash
java -cp classes Main
```

**c. Using a JAR File**

A JAR file can be included in the classpath to access external libraries.

```bash
java -cp "classes;lib/example.jar" Main
```

On Windows, use a semicolon (`;`) to separate classpath entries. On Linux and macOS, use a colon (`:`).

#### Current Directory (`.`)

- Represents the current working directory.
- Can be included in the classpath to locate classes from that directory.
- If no classpath is specified, Java normally uses the current directory as the default classpath.

#### CLASSPATH Environment Variable

The `CLASSPATH` environment variable can specify locations where Java tools search for classes and libraries.

The `-cp` or `-classpath` option can be used to specify the classpath for an individual command and takes precedence over the `CLASSPATH` environment variable.

#### Common Classpath Error

**ClassNotFoundException:** Occurs when an application tries to load a class by name at runtime but the class cannot be found in the configured classpath.

Other class-loading or compilation problems can occur when class files are missing or the classpath is configured incorrectly.

Practiced compiling and executing Java programs using the `-cp` option, specifying the current directory and package locations, and understanding how classpath configuration affects class loading.

---

## Learning Outcomes

- Understood JVM architecture and the complete Java bytecode execution process.
- Learned the responsibilities of the Class Loader, Runtime Data Areas, Execution Engine, and Garbage Collector.
- Understood the role of JIT compilation and JNI.
- Learned the fundamentals of OOP concepts: classes, objects, encapsulation, and abstraction.
- Practiced implementing encapsulation using private variables and getter/setter methods.
- Understood abstraction using abstract classes and interfaces.
- Learned how to create, organize, and use built-in and user-defined packages.
- Understood classpath configuration and how Java locates compiled classes and libraries.
- Practiced compiling and executing Java programs using package structures and classpath options.

## Repository Contents

- Java programs demonstrating JVM and OOP concepts.
- Class and object implementation examples.
- Encapsulation and abstraction programs.
- User-defined package examples.
- Classpath-based compilation and execution examples.
- Class notes and supporting learning materials.
