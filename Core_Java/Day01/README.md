# Day 01 – Core Java Fundamentals

## 1. Why Java?

- Java is a high-level, object-oriented, class-based programming language.
- Developed by James Gosling and his team at Sun Microsystems.
- Java follows the principle **Write Once, Run Anywhere (WORA)**.
- Java source code is compiled into bytecode, which can run on any system with a compatible JVM.

### Features of Java

- **Platform Independent:** Java bytecode can run on different operating systems with a compatible JVM.
- **Object-Oriented:** Java supports classes, objects, inheritance, polymorphism, encapsulation, and abstraction.
- **Simple:** Java provides easy-to-understand syntax and removes several complex features such as explicit pointer manipulation.
- **Secure:** Java provides bytecode verification, class loading mechanisms, and runtime security features.
- **Robust:** Supports exception handling, strong type checking, and automatic memory management.
- **Portable:** Java programs behave consistently across supported platforms.
- **Multithreaded:** Supports executing multiple threads concurrently.
- **Automatic Memory Management:** Garbage Collection automatically reclaims memory occupied by unreachable objects.
- **Distributed:** Provides networking APIs for developing distributed applications.
- **High Performance:** Uses Just-In-Time (JIT) compilation to improve execution performance.

### Applications of Java

- Web application development.
- Enterprise applications.
- Desktop applications.
- Backend development.
- Banking and financial systems.
- Android application development.
- Distributed and network-based applications.

- Explored why Java is widely used in software development and understood its major features and real-world applications.

## 2. Java Development and Execution

- Studied the complete process of developing, compiling, and executing a Java program.
- Understood the difference between source code, bytecode, and machine code.
- Learned that Java source code is written in files with the `.java` extension.
- The Java compiler (`javac`) converts source code into bytecode stored in `.class` files.
- The JVM executes the bytecode using its execution engine.

### Java Execution Flow

```text
Java Source Code (.java)
          |
          v
Java Compiler (javac)
          |
          v
Bytecode (.class)
          |
          v
JVM
          |
          v
Machine Code / Execution
          |
          v
        Output
```

### Creating a Java Program

```java
class Hello {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

### Compilation

```powershell
javac Hello.java
```

- Compiles the source code and generates `Hello.class`.
- Compilation errors are reported if the source code contains syntax or type errors.

### Execution

```powershell
java Hello
```

**Output:**

```text
Hello Java
```

### Important Points

- `javac` is used to compile Java source files.
- `java` is used to launch Java applications.
- The JVM executes Java bytecode.
- Java bytecode is platform independent, while JVM implementations are platform dependent.
- Practised writing, compiling, and executing Java programs using command-line commands and an IDE.

## 3. JDK, JRE, and JVM

Studied the three important components of the Java development and execution environment.

### A. JDK (Java Development Kit)

- JDK provides the tools required to develop, compile, debug, and run Java applications.
- It includes the Java compiler (`javac`), Java launcher, development tools, and runtime components.
- Used by Java developers to create Java applications.

### B. JRE (Java Runtime Environment)

- JRE provides the environment required to run Java applications.
- Traditionally includes the JVM and supporting runtime libraries.
- Does not provide the standard Java compiler for application development.

### C. JVM (Java Virtual Machine)

- JVM is an abstract machine responsible for executing Java bytecode.
- Converts bytecode into machine instructions through the interpreter and JIT compiler.
- Manages memory and performs garbage collection.
- Provides platform-independent bytecode execution.

### Relationship Between JDK, JRE, and JVM

```text
JDK
 |
 |-- Development Tools
 |      |-- javac
 |      |-- javadoc
 |      |-- debugger
 |
 |-- Runtime Components
        |
        |-- JVM
        |-- Runtime Libraries
```

### Comparison

| Component | Main Purpose |
|---|---|
| JDK | Develop and run Java applications |
| JRE | Provide the runtime environment |
| JVM | Execute Java bytecode |

- Understood how JDK, JRE, and JVM work together during Java development and execution.
- Practised identifying Java development and runtime tools.

## 4. Access Specifiers

- Access specifiers control the visibility and accessibility of classes, variables, methods, and constructors.
- Java provides four access levels.

### A. Public

- Accessible from anywhere, provided the declaring type is accessible.
- Used when members need to be available across packages.

```java
public int number = 10;
```

### B. Protected

- Accessible within the same package.
- Also accessible in subclasses outside the package, subject to Java's protected-access rules.

```java
protected int number = 20;
```

### C. Default (Package-Private)

- When no access specifier is declared, default access is applied.
- Accessible only within the same package.

```java
int number = 30;
```

### D. Private

- Accessible only within the declaring class.
- Commonly used to achieve data hiding and encapsulation.

```java
private int number = 40;
```

### Access Specifier Comparison

| Access Specifier | Same Class | Same Package | Subclass Outside Package | Other Package |
|---|---|---|---|---|
| public | Yes | Yes | Yes | Yes |
| protected | Yes | Yes | Yes* | No |
| default | Yes | Yes | No | No |
| private | Yes | No | No | No |

<text color="secondary" size="xs">*Protected access outside the package is subject to subclass and reference-type restrictions.</text>

### Important Points

- Top-level classes can use `public` or package-private access, not `private` or `protected`.
- Access specifiers help implement encapsulation and control access to class members.
- Practised declaring variables and methods with different access specifiers and understanding their accessibility.

## 5. Java Data Types

- A data type specifies the type of value a variable can store.
- Java is a statically typed language, meaning variable types are checked at compile time.
- Java data types are divided into primitive and reference types.

### A. Primitive Data Types

Java provides eight primitive data types.

| Data Type | Size | Description |
|---|---:|---|
| byte | 8 bits | Small integer |
| short | 16 bits | Short integer |
| int | 32 bits | Integer |
| long | 64 bits | Large integer |
| float | 32 bits | Single-precision decimal |
| double | 64 bits | Double-precision decimal |
| char | 16 bits | UTF-16 code unit |
| boolean | JVM-dependent representation | True or false |

### Integer Types

- `byte`: Stores integer values from -128 to 127.
- `short`: Stores integer values from -32,768 to 32,767.
- `int`: Commonly used for integer values.
- `long`: Used for larger integer values. Long literals can use the `L` suffix.

### Floating-Point Types

- `float`: Stores single-precision floating-point values. Use the `f` suffix for floating-point literals.
- `double`: Stores double-precision floating-point values and is the default type for decimal literals.

### Character Type

- `char` stores a single UTF-16 code unit.
- Character values are written using single quotes.

### Boolean Type

- `boolean` stores either `true` or `false`.
- Commonly used in conditional statements and logical expressions.

### B. Reference Data Types

- Reference variables store references to objects rather than primitive values.
- Examples include:
  - Classes
  - Arrays
  - Strings
  - Interfaces
  - Enums

### Example

```java
class Student {
    public static void main(String[] args) {

        int age = 22;
        double percentage = 85.5;
        char grade = 'A';
        boolean isPassed = true;

        String name = "Suraj";

        System.out.println(age);
        System.out.println(percentage);
        System.out.println(grade);
        System.out.println(isPassed);
        System.out.println(name);
    }
}
```

### Important Points

- Primitive variables store primitive values.
- Reference variables hold references to objects or `null`.
- Instance variables and array elements receive default values when not explicitly initialized.
- Local variables must be initialized before they are used.
- Practised declaring variables, assigning values, and working with primitive and reference data types.

## 6. Type Casting

- Type casting is the process of converting a value from one data type into another.
- Studied widening and narrowing conversions in Java.

### A. Widening Casting (Implicit Casting)

- Converts a smaller compatible primitive type into a larger type.
- Performed automatically by Java.
- Generally does not lose numeric magnitude, although floating-point conversion can lose precision.

**Conversion order:**

```text
byte → short → int → long → float → double
             char → int
```

**Example:**

```java
class Widening {
    public static void main(String[] args) {

        int number = 100;
        double result = number;

        System.out.println(result);
    }
}
```

**Output:**

```text
100.0
```

### B. Narrowing Casting (Explicit Casting)

- Converts a wider numeric type into a narrower numeric type.
- Requires explicit casting.
- May result in data loss or overflow.

**Example:**

```java
class Narrowing {
    public static void main(String[] args) {

        double number = 100.75;
        int result = (int) number;

        System.out.println(result);
    }
}
```

**Output:**

```text
100
```

### Comparison

| Widening | Narrowing |
|---|---|
| Smaller to wider compatible type | Wider to narrower type |
| Automatic | Explicit |
| Usually preserves numeric magnitude | May lose information |
| No cast operator required | Cast operator required |

### Important Points

- Boolean values cannot be converted to or from numeric types.
- Widening conversions involving floating-point types can lose precision.
- Narrowing a floating-point value to an integer removes the fractional part.
- Practised converting values between different primitive data types and observing the results.

## 7. Operators in Java

- Operators are symbols used to perform operations on variables and values.
- Studied different categories of Java operators and practised using them in expressions.

### A. Arithmetic Operators

Used to perform mathematical calculations.

| Operator | Description |
|---|---|
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `%` | Modulus (remainder) |

**Example:**

```java
int a = 10;
int b = 3;

System.out.println(a + b);
System.out.println(a % b);
```

### B. Relational Operators

Used to compare two values.

| Operator | Description |
|---|---|
| `==` | Equal to |
| `!=` | Not equal to |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater than or equal to |
| `<=` | Less than or equal to |

- Relational expressions return a boolean value.

### C. Logical Operators

Used to combine or reverse boolean expressions.

| Operator | Description |
|---|---|
| `&&` | Logical AND |
| `||` | Logical OR |
| `!` | Logical NOT |

- `&&` and `||` use short-circuit evaluation.

### D. Assignment Operators

Used to assign or update variable values.

| Operator | Description |
|---|---|
| `=` | Assignment |
| `+=` | Addition assignment |
| `-=` | Subtraction assignment |
| `*=` | Multiplication assignment |
| `/=` | Division assignment |
| `%=` | Modulus assignment |

### E. Unary Operators

Operate on a single operand.

| Operator | Description |
|---|---|
| `+` | Unary plus |
| `-` | Unary minus |
| `++` | Increment |
| `--` | Decrement |
| `!` | Logical complement |
| `~` | Bitwise complement |

- Studied pre-increment and post-increment behaviour.
- Understood the difference between `++a` and `a++`.

### F. Bitwise Operators

Perform operations on individual bits of integer values.

| Operator | Description |
|---|---|
| `&` | Bitwise AND |
| `|` | Bitwise OR |
| `^` | Bitwise XOR |
| `~` | Bitwise complement |

### G. Shift Operators

Used to shift the bits of integer values.

| Operator | Description |
|---|---|
| `<<` | Left shift |
| `>>` | Signed right shift |
| `>>>` | Unsigned right shift |

### H. Ternary Operator

- A conditional operator that provides a shorter alternative to a simple `if-else` expression.

**Syntax:**

```java
condition ? expression1 : expression2;
```

**Example:**

```java
int a = 10;
int b = 20;

int max = (a > b) ? a : b;

System.out.println(max);
```

**Output:**

```text
20
```

### Operator Precedence and Associativity

- Operator precedence determines which operator is evaluated first in an expression.
- Associativity determines the evaluation direction when operators have the same precedence.
- Parentheses can be used to control the order of evaluation.
- Practised arithmetic, relational, logical, assignment, unary, bitwise, shift, and ternary operators in Java programs.

## Learning Outcomes

- Understood Java features and its importance in software development.
- Learned the complete Java development, compilation, and execution process.
- Understood the relationship between JDK, JRE, and JVM.
- Learned the four access levels and their accessibility rules.
- Gained knowledge of primitive and reference data types.
- Understood widening and narrowing type conversions.
- Learned different categories of Java operators, precedence, and associativity.
- Built a foundation for object-oriented programming in Java.

## Repository Contents

- Java basic programs and practical examples.
- Data type and type casting programs.
- Access specifier examples.
- Operator-based programs.
- Class notes and supporting learning materials.
