# Day 05 – Core Java

## 1. Method Overloading

- Method overloading allows a class to have multiple methods with the same name but different parameter lists.
- It is an example of compile-time polymorphism (static polymorphism).
- Method overloading can be achieved by changing:
  - Number of parameters.
  - Data types of parameters.
  - Order of parameters.
- Changing only the return type does not achieve method overloading.
- The compiler determines which overloaded method to execute based on the arguments passed.
- Implemented overloaded methods using different parameter types and numbers of arguments.

**Example:**

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

## 2. Method Overriding

- Method overriding occurs when a child class provides its own implementation of an inherited instance method with the same signature.
- It is an important feature of inheritance and runtime polymorphism.
- **Overridden Method:** The method defined in the parent class.
- **Overriding Method:** The method redefined in the child class.
- Implemented method overriding using parent and child classes and tested method execution through parent-class references.

**Example:**

```java
class Parent {
    void display() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child class");
    }
}
```

### A. Private Method

- Private methods are accessible only within the class in which they are declared.
- Private methods are not inherited and cannot be overridden.
- If a child class declares a method with the same signature as a private parent method, it is treated as a separate method.
- Practised accessing private methods within their declaring class and testing methods with the same signature in child classes.

### B. Static Method

- Static methods belong to the class rather than individual objects.
- Static methods cannot be overridden.
- When a child class declares a static method with the same signature as the parent class, it is called **method hiding**.
- Static method resolution depends on the reference type, not the actual object type.
- Implemented examples to understand the difference between static method hiding and instance method overriding.

### C. Final Method

- A method declared using the `final` keyword cannot be overridden by a child class.
- The `final` keyword prevents modification of the inherited method implementation through overriding.
- Practised declaring final methods and understanding compiler restrictions when attempting to override them.

**Example:**

```java
class Parent {
    final void display() {
        System.out.println("Parent method");
    }
}
```

### D. Access Specifiers in Method Overriding

- Access specifiers control the visibility of class members.
- Java provides four access levels:
  - `public`
  - `protected`
  - Default (package-private)
  - `private`
- An overriding method cannot reduce the visibility of the overridden method.
- A `public` method must remain public when overridden.
- A `protected` method can be overridden with protected or public access.
- A default-access method can be overridden with default, protected, or public access, subject to package rules.
- Private methods cannot be overridden.
- Practised overriding methods with different access levels and understanding their visibility rules.

## 3. Method Binding and Method Binding Resolution

- Method binding is the process of connecting a method call to its actual method implementation.
- Studied two types of method binding: static binding and dynamic binding.

### A. Static Binding (Early Binding)

- Method resolution takes place at compile time.
- Common examples include static, private, and final methods.
- Method overloading is also resolved at compile time.
- Method calls are resolved based on compile-time information, including the reference type and declared method signature.
- Practised identifying method calls resolved during compilation.

### B. Dynamic Binding (Late Binding)

- Method resolution takes place at runtime.
- It applies to overridden instance methods.
- The actual object type determines which overridden method implementation executes.
- It is also known as dynamic method dispatch.
- Implemented examples using parent-class references and child-class objects to understand runtime method resolution.

**Example:**

```java
class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child");
    }
}

class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.show();
    }
}
```

**Output:**

```text
Child
```

## 4. Virtual Keyword

- Studied the concept of virtual methods in object-oriented programming.
- In C++, the `virtual` keyword is used to achieve runtime polymorphism through method overriding.
- Java does not require an explicit `virtual` keyword.
- Java instance methods are dynamically dispatched by default when overridden.
- Static methods, private methods, and final methods do not participate in runtime method overriding.
- Compared virtual method behaviour in C++ with dynamic method dispatch in Java.

## 5. Polymorphism

- Polymorphism means one name having multiple forms or behaviours.
- It allows the same method name or reference to represent different behaviours depending on the context.
- Studied two major types of polymorphism in Java.

### A. Static Polymorphism (Compile-Time Polymorphism)

- Achieved through method overloading.
- The compiler determines which method to execute during compilation.
- Method selection depends on the method signature and arguments passed.
- Implemented overloaded methods with different parameter counts and data types.

### B. Dynamic Polymorphism (Runtime Polymorphism)

- Achieved through method overriding.
- Method execution is determined at runtime based on the actual object type.
- Requires inheritance and overridden instance methods.
- Supports dynamic method dispatch.
- Implemented parent-child class examples using parent references to hold child-class objects.

## 6. Annotations

- Annotations provide metadata about Java code.
- They give additional information to the compiler, development tools, and runtime frameworks.
- Studied commonly used built-in Java annotations:

| Annotation | Purpose |
|---|---|
| `@Override` | Indicates that a method overrides a parent-class method. |
| `@Deprecated` | Marks an element as outdated or discouraged for use. |
| `@SuppressWarnings` | Suppresses specified compiler warnings. |
| `@FunctionalInterface` | Indicates that an interface is intended to have one abstract method. |

- Practised using the `@Override` annotation while implementing method overriding.
- Understood how annotations help identify incorrect method declarations and provide metadata.

**Example:**

```java
class Parent {
    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child");
    }
}
```

## 7. Upcasting and Downcasting

- Studied type casting between parent-class and child-class references.
- Understood how upcasting and downcasting work with inheritance and runtime polymorphism.

### A. Upcasting

- Upcasting means converting a child-class reference into a parent-class reference.
- It happens automatically and does not require explicit casting.
- It is commonly used to achieve runtime polymorphism.
- Through a parent reference, directly accessible members are limited to those declared or inherited by the parent type.
- Overridden instance methods still execute according to the actual object type.
- Practised assigning child-class objects to parent-class references.

**Example:**

```java
class Parent {
    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child");
    }
}

Parent obj = new Child();
obj.display();
```

### B. Downcasting

- Downcasting means converting a parent-class reference into a child-class reference.
- It requires explicit type casting.
- It allows access to members specific to the child class.
- The actual object must be compatible with the target child type.
- Invalid downcasting results in `ClassCastException`.
- Practised converting parent references back into child references and accessing child-specific methods.

**Example:**

```java
Parent obj = new Child();

Child c = (Child) obj;
c.show();
```

## 8. instanceof Operator

- The `instanceof` operator checks whether an object is an instance of a particular class or implements a particular interface.
- It returns a boolean value: `true` or `false`.
- It is useful for checking object types before performing downcasting.
- It supports type checking with inheritance and interfaces.
- Checking a null reference using `instanceof` returns `false`.
- Practised checking parent and child object relationships using `instanceof`.
- Implemented safe downcasting by checking the object type before casting.

**Syntax:**

```java
object instanceof ClassName
```

**Example:**

```java
class Parent {
}

class Child extends Parent {
}

class Main {
    public static void main(String[] args) {

        Parent obj = new Child();

        if (obj instanceof Child) {
            Child c = (Child) obj;
            System.out.println("Downcasting successful");
        }
    }
}
```

**Output:**

```text
Downcasting successful
```

## Learning Outcomes

- Understood method overloading and method overriding.
- Learned the restrictions of overriding private, static, and final methods.
- Understood method binding and method resolution.
- Learned the concept of virtual methods and Java's dynamic method dispatch.
- Understood compile-time and runtime polymorphism.
- Learned the purpose and usage of Java annotations.
- Practised upcasting and downcasting.
- Understood runtime type checking using the `instanceof` operator.

## Repository Contents

- Method overloading and overriding programs.
- Static and dynamic binding examples.
- Polymorphism and virtual method examples.
- Java annotation examples.
- Upcasting and downcasting programs.
- `instanceof` operator examples.
- Class notes and supporting practical files.
