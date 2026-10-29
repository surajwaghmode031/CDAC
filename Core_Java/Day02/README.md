# Day 02 – Core Java

## Topics Covered

### 1. JVM Architecture

- Studied the architecture and working of the Java Virtual Machine (JVM).
- Understood how the JVM loads, verifies, and executes Java bytecode.
- Learned the major components of JVM architecture:
  - **Class Loader Subsystem** – Loads class files into memory.
  - **Runtime Data Areas** – Includes Heap, Java Stack, Method Area, PC Registers, and Native Method Stacks.
  - **Execution Engine** – Executes bytecode using the interpreter and Just-In-Time (JIT) compiler.
  - **Garbage Collector (GC)** – Reclaims memory occupied by objects that are no longer reachable.
  - **Java Native Interface (JNI)** – Enables interaction with native code.
- Understood the role of JVM in platform-independent Java execution.

### 2. Object-Oriented Programming (OOP)

Studied the fundamental concepts of object-oriented programming in Java.

#### a. Class and Object

- **Class:** A blueprint that defines the properties and behaviours of objects.
- **Object:** An instance of a class containing state and behaviour.
- Practiced creating classes, declaring instance variables, defining methods, and creating objects using the `new` keyword.

#### b. Encapsulation

- Learned how to combine data and methods within a class.
- Understood data hiding using `private` variables and controlled access through public getter and setter methods.
- Practiced protecting object data and maintaining controlled access to class members.

#### c. Abstraction

- Learned how to hide implementation details and expose essential functionality.
- Studied abstraction using abstract classes and interfaces.
- Practiced defining abstract methods and implementing them in concrete classes.

### 3. Packages in Java

- Understood the purpose of packages in organizing related classes and interfaces.
- Studied built-in packages and user-defined packages.
- Practiced declaring packages using the `package` keyword.
- Learned how to import classes using the `import` statement.
- Understood how packages help prevent naming conflicts and support access control.
- Practiced compiling and executing Java programs that use packages.

### 4. Classpath in Java

- Learned the meaning and purpose of the Java classpath.
- Understood how Java locates compiled class files and required libraries.
- Studied the use of the `CLASSPATH` environment variable and the `-cp` / `-classpath` command-line options.
- Practiced compiling and executing Java programs with packages using an appropriate classpath.
- Understood the difference between the current directory (`.`) and other classpath locations.
- Learned how an incorrect classpath can cause errors such as `ClassNotFoundException`.

## Practical Work

- Explored JVM architecture and Java bytecode execution.
- Implemented examples using classes and objects.
- Practiced encapsulation and abstraction with Java programs.
- Created and used user-defined packages.
- Compiled and executed Java programs by specifying the classpath.

## Learning Outcomes

- Gained an understanding of JVM internals and bytecode execution.
- Learned the fundamentals of classes, objects, encapsulation, and abstraction.
- Understood how to organize Java programs using packages.
- Learned how to configure and use the classpath to compile and execute Java applications.

## Repository Contents

- Java programs and practical examples
- Package-based programs
- Classpath examples
- Class notes and supporting learning materials
