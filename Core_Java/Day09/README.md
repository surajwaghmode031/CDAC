# Day 09 – Core Java

This folder contains notes and practical programs covering **Variable Arguments (Varargs)** and **Enum (Enumeration)** in Java.

# 1. Variable Arguments (Varargs) in Java

## 1.1 What are Variable Arguments?

Variable Arguments, also known as **Varargs**, allow a method to accept zero or more arguments of the same data type.

Instead of creating multiple overloaded methods to handle different numbers of arguments, we can use a single method with varargs.

Varargs were introduced in **Java 5 (JDK 1.5)**.

## 1.2 Syntax

```java
returnType methodName(dataType... variableName) {
    // method body
}
```

Example:

```java
public class VarArgsDemo {

    static void display(int... numbers) {

        for (int num : numbers) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {

        display(10);
        display(10, 20);
        display(10, 20, 30);
    }
}
```

**Output:**

```text
10
10
20
10
20
30
```

The same `display()` method accepts different numbers of arguments.

## 1.3 How Varargs Work Internally

- The `...` operator indicates that a method accepts a variable number of arguments.
- Internally, Java treats the varargs parameter as an array.
- We can access individual values using an array index or an enhanced for loop.
- We can pass zero, one, or multiple arguments.

Example:

```java
static void calculate(int... values) {

    System.out.println("Number of arguments: " + values.length);

    for (int i = 0; i < values.length; i++) {
        System.out.println(values[i]);
    }
}
```

## 1.4 Varargs with Zero Arguments

A varargs method can be called without passing any arguments.

```java
public class Test {

    static void show(int... values) {
        System.out.println(values.length);
    }

    public static void main(String[] args) {

        show();
        show(10);
        show(10, 20, 30);
    }
}
```

**Output:**

```text
0
1
3
```

## 1.5 Varargs with Other Parameters

A method can contain normal parameters along with a varargs parameter.

However, the varargs parameter must be the **last parameter** in the method declaration.

Example:

```java
public class Test {

    static void display(String name, int... marks) {

        System.out.println("Name: " + name);

        for (int mark : marks) {
            System.out.println(mark);
        }
    }

    public static void main(String[] args) {

        display("Suraj", 80, 85, 90);
    }
}
```

**Output:**

```text
Name: Suraj
80
85
90
```

## 1.6 Rules of Varargs

1. A method can have only one varargs parameter.
2. The varargs parameter must be the last parameter.
3. Varargs can accept zero or more arguments.
4. Varargs can be used with primitive and reference data types.
5. Internally, varargs are handled as arrays.
6. A varargs method can be overloaded.

## 1.7 Varargs Method Overloading

We can overload methods using different parameter types or combinations of normal and varargs parameters.

Example:

```java
public class Test {

    static void display(int a) {
        System.out.println("Single argument method");
    }

    static void display(int... a) {
        System.out.println("Varargs method");
    }

    public static void main(String[] args) {

        display(10);
        display(10, 20);
    }
}
```

**Output:**

```text
Single argument method
Varargs method
```

When one argument is passed, Java prefers the exact fixed-parameter match over the varargs method.

---

# 2. Enum (Enumeration) in Java

## 2.1 What is Enum?

Enum stands for **Enumeration**.

Enumeration in Java is supported by the `enum` keyword. It is a special type of class used to represent a fixed set of related constants.

Enums were introduced in **Java 5 (JDK 1.5)**.

An enum extends `java.lang.Enum` implicitly.

Examples:

- Departments: RND, FINANCE, MARKETING, HR, PRODUCTION
- Days: MONDAY, TUESDAY, WEDNESDAY
- Directions: NORTH, SOUTH, EAST, WEST
- Traffic signals: RED, YELLOW, GREEN
- Ticket categories: SILVER, GOLD, PLATINUM

## 2.2 Why Do We Use Enum?

Enums are useful for defining constants that belong to a particular category or type.

Important advantages:

**1. Helps to define constants**

We can define a fixed set of related constant values.

For example:

```java
enum Department {
    RND,
    FINANCE,
    MARKETING,
    HR,
    PRODUCTION
}
```

**2. Provides type safety to constants**

Consider defining constants using an interface:

```java
interface MovieConstants {

    int AGE_MINOR = 16;
    int AGE_MIN = 10;
    int AGE_MAX = 70;

    int TKT_COST_SILVER = 100;
    int TKT_COST_GOLD = 200;
    int TKT_COST_PLATINUM = 300;
}
```

Here, both age-related values and ticket-cost values are represented using `int`.

A programmer might accidentally compare an age with a ticket cost.

```java
if (userAge == MovieConstants.TKT_COST_GOLD) {
    // Incorrect comparison
}
```

The compiler cannot identify this mistake based only on the data type because both values are integers.

With enums, we can define separate types:

```java
enum AgeCategory {
    MINOR, ADULT, SENIOR
}

enum TicketCategory {
    SILVER, GOLD, PLATINUM
}
```

Now an `AgeCategory` value cannot accidentally be assigned to a `TicketCategory` variable.

This provides **type safety**.

**3. Easy iteration over constants**

With interface constants, there is no built-in method to iterate over all constants.

With enums, we can use `values()` to get all enum constants.

```java
for (Department d : Department.values()) {
    System.out.println(d);
}
```

**4. Can associate additional data with constants**

Enums can have constructors, instance variables and methods.

For example, a menu item can have both a name and a price.

```java
enum Menu {

    SOUP("Tomato Soup", 100),
    DOSA("Mysore Dosa", 80),
    RICE("Fried Rice", 120);

    private String itemName;
    private int price;

    Menu(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }
}
```

An enum can therefore represent related constants along with their associated data.

## 2.3 Declaring an Enum

The `enum` keyword is used to declare an enumeration.

Syntax:

```java
enum EnumName {
    CONSTANT1,
    CONSTANT2,
    CONSTANT3
}
```

Example based on the classroom Department example:

```java
public enum Department {

    RND,
    FINANCE,
    MARKETING,
    HR,
    PRODUCTION
}
```

Here, `Department` represents a fixed set of department constants.

## 2.4 Using Enum Variables

We can create a variable of an enum type and assign one of its predefined constants.

```java
enum Department {

    RND, FINANCE, MARKETING, HR, PRODUCTION
}

public class Test {

    public static void main(String[] args) {

        Department dept = Department.RND;

        System.out.println(dept);
    }
}
```

**Output:**

```text
RND
```

To access an enum constant, use:

```java
EnumName.CONSTANT_NAME
```

For example:

```java
Department.FINANCE
Department.HR
Department.PRODUCTION
```

## 2.5 Enum with Switch Statement

Enum values can be used with a `switch` statement.

```java
enum Department {

    RND, FINANCE, MARKETING, HR, PRODUCTION
}

public class Test {

    public static void main(String[] args) {

        Department dept = Department.FINANCE;

        switch (dept) {

            case RND:
                System.out.println("Research and Development");
                break;

            case FINANCE:
                System.out.println("Finance Department");
                break;

            case HR:
                System.out.println("Human Resources");
                break;

            default:
                System.out.println("Other Department");
        }
    }
}
```

**Output:**

```text
Finance Department
```

## 2.6 Important Methods of Enum

The Java compiler implicitly provides two important static methods for every enum:

### 1. values()

Returns an array containing all enum constants in their declaration order.

Syntax:

```java
EnumName[] values()
```

Example:

```java
enum Department {

    RND, FINANCE, MARKETING, HR, PRODUCTION
}

public class Test {

    public static void main(String[] args) {

        Department[] departments = Department.values();

        for (Department d : departments) {
            System.out.println(d);
        }
    }
}
```

**Output:**

```text
RND
FINANCE
MARKETING
HR
PRODUCTION
```

Important: `values()` returns an array of references to the enum constants.

### 2. valueOf()

Converts a string containing an enum constant's exact name into the corresponding enum value.

Syntax:

```java
EnumName valueOf(String name)
```

Example:

```java
enum Department {

    RND, FINANCE, MARKETING, HR, PRODUCTION
}

public class Test {

    public static void main(String[] args) {

        Department dept = Department.valueOf("FINANCE");

        System.out.println(dept);
    }
}
```

**Output:**

```text
FINANCE
```

If the supplied name does not match any constant exactly, `valueOf()` throws `IllegalArgumentException`.

For example:

```java
Department.valueOf("ABC");
```

This throws an `IllegalArgumentException`.

The name is case-sensitive.

**Important:** `values()` and `valueOf()` are implicitly generated by the Java compiler for enum types.

## 2.7 Methods Inherited from java.lang.Enum

Every enum implicitly extends `java.lang.Enum`.

Some important methods inherited from this superclass are:

| Method | Purpose |
|---|---|
| `name()` | Returns the declared name of the enum constant as a String |
| `ordinal()` | Returns the zero-based position of the constant |
| `toString()` | Returns the string representation of the constant |
| `compareTo()` | Compares enum constants based on declaration order |
| `equals()` | Checks whether two enum references represent the same constant |
| `hashCode()` | Returns the hash code of the enum constant |
| `getDeclaringClass()` | Returns the enum class that declared the constant |

Example:

```java
enum Department {

    RND, FINANCE, MARKETING, HR, PRODUCTION
}

public class Test {

    public static void main(String[] args) {

        Department dept = Department.MARKETING;

        System.out.println(dept.name());
        System.out.println(dept.ordinal());
        System.out.println(dept.toString());
    }
}
```

**Output:**

```text
MARKETING
2
MARKETING
```

### Understanding ordinal()

`ordinal()` returns the zero-based position of a constant in the enum declaration.

For example:

```java
enum Color {
    RED, GREEN, BLUE
}
```

| Constant | ordinal() |
|---|---:|
| RED | 0 |
| GREEN | 1 |
| BLUE | 2 |

Do not use ordinal values as permanent database IDs or business identifiers. Reordering constants changes their ordinal values.

## 2.8 Enum with Constructor, Data Members and Methods

An enum can contain:

- Instance variables
- Constructors
- Methods
- Enum constants

Example:

```java
enum Department {

    RND("Research and Development", 101),
    FINANCE("Finance Department", 102),
    MARKETING("Marketing Department", 103),
    HR("Human Resources", 104),
    PRODUCTION("Production Department", 105);

    private String departmentName;
    private int departmentId;

    Department(String departmentName, int departmentId) {

        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }
}

public class Test {

    public static void main(String[] args) {

        Department dept = Department.FINANCE;

        System.out.println(dept);
        System.out.println(dept.getDepartmentName());
        System.out.println(dept.getDepartmentId());
    }
}
```

**Output:**

```text
FINANCE
Finance Department
102
```

Important points:

1. Enum constructors cannot be public or protected.
2. Enum constructors are invoked automatically when enum constants are initialized.
3. We cannot create enum objects using the `new` keyword.
4. Each enum constant represents a predefined instance.
5. An enum can contain multiple constructors, provided they are properly overloaded.

## 2.9 How Enum Works Internally

An enum is a special class.

Consider:

```java
public enum Department {

    RND,
    FINANCE,
    MARKETING,
    HR,
    PRODUCTION
}
```

Conceptually, the compiler generates a class similar to the following:

```java
public final class Department extends Enum<Department> {

    public static final Department RND;
    public static final Department FINANCE;
    public static final Department MARKETING;
    public static final Department HR;
    public static final Department PRODUCTION;

    private static final Department[] ENUM_VALUES;

    static {

        RND = new Department("RND", 0);
        FINANCE = new Department("FINANCE", 1);
        MARKETING = new Department("MARKETING", 2);
        HR = new Department("HR", 3);
        PRODUCTION = new Department("PRODUCTION", 4);

        ENUM_VALUES = new Department[] {
            RND, FINANCE, MARKETING, HR, PRODUCTION
        };
    }

    private Department(String name, int ordinal) {
        super(name, ordinal);
    }
}
```

This is a simplified conceptual representation, not the exact source code generated by every compiler.

Important observations:

- The enum is internally represented as a class.
- It extends `java.lang.Enum`.
- Each enum constant is a `public static final` instance.
- The constructor is private.
- The compiler maintains the enum constants in declaration order.
- The constants are initialized as predefined instances.

This explains why we cannot create additional enum objects using `new`.

## 2.10 Why Is Enum Considered a Combination of Class and Interface Features?

In classroom explanations, an enum is described as a combination of class and interface features.

This means an enum provides features commonly associated with both classes and interfaces.

It is important to understand that **an enum is technically a special class, not a mixture of two Java types**.

### Class-like Features of Enum

An enum supports many features of a normal class:

1. It can contain instance variables.
2. It can contain constructors.
3. It can contain instance methods.
4. It can contain static methods.
5. It can have different constant-specific implementations.
6. It can maintain data associated with each constant.

Example:

```java
enum Direction {

    NORTH,
    SOUTH,
    EAST,
    WEST;

    public void display() {
        System.out.println("Direction: " + this);
    }
}

public class Test {

    public static void main(String[] args) {

        Direction.NORTH.display();
    }
}
```

**Output:**

```text
Direction: NORTH
```

### Interface-like Features of Enum

An enum can implement one or more interfaces.

Example:

```java
interface Printable {

    void print();
}

enum Department implements Printable {

    RND,
    FINANCE,
    HR;

    public void print() {
        System.out.println(this);
    }
}

public class Test {

    public static void main(String[] args) {

        Department.RND.print();
    }
}
```

**Output:**

```text
RND
```

Here, the enum has its own constants and class features while also implementing an interface contract.

**Important clarification:**

- An enum is a special class.
- An enum implicitly extends `java.lang.Enum`.
- An enum can implement interfaces.
- An enum cannot extend another user-defined class.
- An enum cannot be declared as an interface.

Therefore, the phrase "combination of class and interface features" describes its capabilities, not its actual inheritance structure.

## 2.11 If Enum Has Class and Interface Features, Why Not Use a Class and Interface Instead?

A normal class or interface can define constants, but neither provides all the built-in guarantees and facilities of an enum.

Consider three approaches.

### A. Using an Interface for Constants

```java
interface DepartmentConstants {

    int RND = 1;
    int FINANCE = 2;
    int MARKETING = 3;
}
```

Problems:

- Interface variables are implicitly `public static final`.
- All constants are represented by the same primitive type.
- The compiler cannot distinguish a department ID from another unrelated integer.
- There is no built-in `values()` method.
- There is no built-in enum-style iteration.
- It is not possible to associate separate instance data with each constant in the same way as an enum.

### B. Using a Normal Class

```java
class Department {

    public static final int RND = 1;
    public static final int FINANCE = 2;
    public static final int MARKETING = 3;
}
```

Problems:

- These are ordinary integer constants, not a separate department type.
- A variable can still receive an unrelated integer.
- There is no built-in restriction that only the declared constants can be used.
- We must implement iteration and validation ourselves.
- A normal class can create additional objects unless its design prevents it.

### C. Using Enum

```java
enum Department {

    RND,
    FINANCE,
    MARKETING,
    HR,
    PRODUCTION
}
```

Advantages:

1. **Type safety:** Only valid `Department` constants can be assigned to a `Department` variable.
2. **Fixed set of instances:** The enum defines a controlled set of constants.
3. **Easy iteration:** `values()` returns all constants.
4. **Built-in conversion:** `valueOf()` converts a name to its enum constant.
5. **Switch support:** Enums can be used directly in switch statements.
6. **Associated data:** Constructors, instance variables and methods can be used.
7. **Interface implementation:** An enum can implement interfaces.

### Comparison

| Feature | Interface constants | Normal class constants | Enum |
|---|---|---|---|
| Define constants | Yes | Yes | Yes |
| Separate type safety | No, if using primitive constants | No, if using primitive constants | Yes |
| Fixed set of valid values | Not enforced | Not enforced | Yes |
| Built-in `values()` | No | No | Yes |
| Built-in `valueOf()` | No | No | Yes |
| Associated instance data | No | Possible with objects | Yes |
| Constructors | No | Yes | Yes, restricted |
| Implement interfaces | Not applicable | Yes | Yes |

**Conclusion:** We use enums when we want a fixed, well-defined set of related values with type safety and additional functionality. A class or interface can define constants, but an enum provides a purpose-built solution for this requirement.

## 2.12 Enum with Abstract Methods

An enum can declare an abstract method. Each enum constant must provide its implementation.

Example:

```java
enum Operation {

    ADD {
        int calculate(int a, int b) {
            return a + b;
        }
    },

    SUBTRACT {
        int calculate(int a, int b) {
            return a - b;
        }
    };

    abstract int calculate(int a, int b);
}

public class Test {

    public static void main(String[] args) {

        System.out.println(Operation.ADD.calculate(10, 5));

        System.out.println(Operation.SUBTRACT.calculate(10, 5));
    }
}
```

**Output:**

```text
15
5
```

This demonstrates how different enum constants can provide different implementations of the same abstract method.

## 2.13 Nested Enum

An enum can be declared inside a class. Such an enum is a nested enum and is implicitly static.

Example:

```java
class TestOuter {

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }
}

public class Test {

    public static void main(String[] args) {

        TestOuter.Direction direction =
                TestOuter.Direction.NORTH;

        System.out.println(direction);
    }
}
```

**Output:**

```text
NORTH
```

To access the nested enum constant:

```java
OuterClassName.EnumName.CONSTANT_NAME
```

## 2.14 Important Characteristics of Enum

1. Enum was introduced in Java 5.
2. Enum is a special class-like type.
3. Every enum implicitly extends `java.lang.Enum`.
4. Enum constants are implicitly `public static final`.
5. Enum constructors cannot be public or protected.
6. Enum objects cannot be created using the `new` keyword.
7. An enum can contain variables, constructors and methods.
8. An enum can implement one or more interfaces.
9. An enum cannot extend another class.
10. An enum can be used with a switch statement.
11. `values()` returns all enum constants.
12. `valueOf()` converts an exact constant name into an enum value.
13. Enum constants are singleton instances within their enum type.

---

# Learning Outcomes

After completing Day09, the following concepts were covered:

- Understanding Variable Arguments (Varargs).
- Defining methods with variable numbers of arguments.
- Using varargs with normal parameters.
- Understanding varargs method overloading and its rules.
- Understanding Enum and its purpose.
- Defining a fixed set of related constants.
- Understanding type safety and why enums are preferred over ordinary constants.
- Using enum with switch statements.
- Working with `values()`, `valueOf()`, `name()` and `ordinal()`.
- Understanding the `java.lang.Enum` superclass.
- Creating enums with constructors, data members and methods.
- Understanding how enum constants are represented internally.
- Understanding class-like and interface-like features of enums.
- Understanding why enums are preferred over normal classes and interfaces for fixed sets of constants.
- Using nested enums and enums with abstract methods.

# Repository Contents

```text
Day09/
│
├── README.md
│
└── code/
    ├── varargs/
    └── enum/
```

This day focuses on flexible method arguments using Varargs and defining type-safe, fixed sets of constants using Enum.
