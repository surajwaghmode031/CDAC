# Day 04 – Core Java

## Topics Covered

### 1. Array Memory Representation

- Studied how Java arrays are represented and accessed in memory.
- Understood that arrays are objects created on the heap, while local variables may hold references to those arrays on the stack.
- Learned how array references point to array objects and how elements are accessed using indexes.
- Practiced drawing memory diagrams for primitive arrays and reference-type arrays.
- Understood the difference between array variables, array references, and array elements.

### 2. Dynamic Initialization

- Learned how to initialize variables and arrays at runtime using values calculated or obtained during program execution.
- Practiced creating arrays with sizes determined at runtime.
- Used loops and runtime input to populate arrays dynamically.
- Understood how dynamic initialization differs from assigning fixed values directly in the source code.

### 3. `static` Keyword

Studied class-level members using the `static` keyword.

#### a. Static Data Members

- Learned that static variables belong to the class rather than individual objects.
- Understood that a single static variable is shared among instances of the class.
- Practiced accessing static variables using the class name.
- Explored how static variables can maintain shared information across objects.

#### b. Static Methods

- Learned how to declare and call static methods.
- Practiced invoking static methods using the class name without creating an object.
- Understood that static methods cannot directly access instance members without an object reference.
- Learned why the `main()` method is declared `static`.

### 4. `this` Keyword

- Studied how `this` refers to the current object.
- Practiced distinguishing instance variables from local variables or method parameters with the same names.
- Used `this` to access current-object fields and methods.
- Revised constructor chaining using `this()`.
- Understood the difference between `this` and `this()`.

### 5. Inheritance

- Learned how inheritance enables code reuse between related classes.
- Studied the `extends` keyword for creating child classes.
- Understood parent classes, child classes, inherited members, and constructor execution.
- Explored single, multilevel, and hierarchical inheritance.
- Learned that Java classes do not support multiple inheritance through classes, but similar behaviour can be achieved using interfaces.
- Practiced creating parent-child class relationships and accessing inherited members.

### 6. Polymorphism

- Studied polymorphism as the ability to represent different behaviours through a common interface or method name.
- Learned the two main forms of polymorphism in Java:

#### a. Compile-Time Polymorphism

- Studied method overloading.
- Practiced defining multiple methods with the same name but different parameter lists.
- Understood how the compiler selects the appropriate overloaded method.

#### b. Runtime Polymorphism

- Studied method overriding.
- Practiced overriding parent-class methods in child classes.
- Understood dynamic method dispatch using parent-class references to child-class objects.
- Learned how runtime polymorphism supports flexible and extensible code.

## Practical Work

- Created array memory diagrams and examined array references.
- Practiced dynamic array initialization.
- Implemented examples using static variables and static methods.
- Used the `this` keyword in constructors and instance methods.
- Created inheritance examples using parent and child classes.
- Implemented method overloading and method overriding.
- Practiced runtime polymorphism using inheritance and dynamic method dispatch.

## Learning Outcomes

- Gained a clearer understanding of array memory representation and initialization.
- Learned how static members are shared at the class level.
- Understood the role of `this` in accessing the current object.
- Practiced code reuse through inheritance.
- Understood compile-time and runtime polymorphism in Java.

## Repository Contents

- Java programs and practical examples
- Array memory diagrams
- Static keyword and `this` keyword examples
- Inheritance programs
- Method overloading and overriding examples
- Class notes and supporting learning materials
