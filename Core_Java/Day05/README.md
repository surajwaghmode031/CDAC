# Day 05 – Core Java

## Topics Covered

### 1. Method Overloading

- Studied method overloading as a form of compile-time polymorphism.
- Learned how multiple methods can have the same name with different parameter lists.
- Practiced overloading methods by changing:
  - Number of parameters
  - Type of parameters
  - Order of parameters
- Understood that changing only the return type does not achieve method overloading.
- Practiced calling overloaded methods with different arguments.

### 2. Method Overriding

- Studied method overriding as a feature of inheritance and runtime polymorphism.
- Learned how a child class provides its own implementation of an inherited method.
- Understood the relationship between:
  - **Overridden Method:** Method defined in the parent class.
  - **Overriding Method:** Method redefined in the child class.
- Practiced overriding methods using parent and child classes.

#### a. Private Methods

- Learned that private methods are not inherited and cannot be overridden.
- Understood that declaring a method with the same signature in a child class creates a separate method.

#### b. Static Methods

- Studied static method hiding.
- Understood that static methods are resolved based on the reference type rather than the runtime object type.
- Differentiated static method hiding from instance method overriding.

#### c. Final Methods

- Learned that final methods cannot be overridden in child classes.
- Understood how the `final` keyword restricts method modification through inheritance.

#### d. Access Specifiers in Method Overriding

- Studied access-level rules while overriding methods.
- Understood that an overriding method cannot have more restrictive access than the overridden method.
- Practiced overriding methods with different access levels.
- Learned the role of `public`, `protected`, default, and `private` access.

### 3. Method Binding and Method Binding Resolution

- Studied method binding as the process of connecting a method call to its actual implementation.
- Learned two types of method binding:

#### a. Static Binding (Early Binding)

- Understood that method calls are resolved at compile time.
- Studied static, private, and final methods in relation to static binding.
- Practiced identifying method calls resolved using the reference type.

#### b. Dynamic Binding (Late Binding)

- Learned how overridden instance methods are resolved at runtime.
- Understood that the actual object type determines which overridden method is executed.
- Practiced dynamic method dispatch using parent-class references and child-class objects.

### 4. Virtual Keyword

- Studied the concept of virtual methods in object-oriented programming.
- Understood how virtual methods support runtime polymorphism in languages such as C++.
- Compared virtual method behaviour with Java's instance method overriding.
- Learned that Java instance methods are dynamically dispatched by default, except for methods that cannot be overridden, such as static, private, and final methods.

### 5. Polymorphism

- Studied polymorphism as the ability to represent different behaviours through a common method name or reference.

#### a. Static Polymorphism

- Studied compile-time polymorphism using method overloading.
- Understood how the compiler determines which overloaded method to execute.
- Practiced implementing overloaded methods with different parameter lists.

#### b. Dynamic Polymorphism

- Studied runtime polymorphism using method overriding.
- Understood dynamic method dispatch.
- Practiced using parent-class references to refer to child-class objects.
- Learned how runtime polymorphism improves flexibility and extensibility.

### 6. Annotations

- Studied annotations as metadata that provide information about Java code.
- Learned commonly used built-in annotations:
  - `@Override`
  - `@Deprecated`
  - `@SuppressWarnings`
  - `@FunctionalInterface`
- Practiced using `@Override` to indicate that a child-class method overrides a parent-class method.
- Understood how annotations help the compiler and development tools identify and process additional information.

### 7. Upcasting and Downcasting

- Studied type casting between parent and child class references.

#### a. Upcasting

- Learned how to assign a child-class object to a parent-class reference.
- Understood that upcasting is performed automatically.
- Practiced accessing inherited and overridden methods through parent references.
- Explored how upcasting supports runtime polymorphism.

#### b. Downcasting

- Learned how to convert a parent-class reference back into a child-class reference.
- Understood that downcasting requires explicit casting.
- Practiced using the `instanceof` operator to check object types before downcasting.
- Learned about `ClassCastException` when an invalid downcast is performed.

### 8. instanceof Operator

- Studied the `instanceof` operator in Java.
- Learned how to check whether an object is an instance of a particular class or implements a particular interface.
- Understood that `instanceof` returns a boolean value (`true` or `false`).
- Practiced checking object types before performing downcasting.
- Explored the relationship between inheritance, upcasting, downcasting, and `instanceof`.
- Learned that checking a `null` reference using `instanceof` returns `false`.

## Practical Work

- Implemented method overloading examples.
- Practiced method overriding using parent and child classes.
- Tested private, static, and final method behaviour.
- Implemented static binding and dynamic binding examples.
- Practiced runtime polymorphism through method dispatch.
- Explored Java's method overriding behaviour in comparison with C++ virtual methods.
- Used built-in annotations, especially `@Override`.
- Implemented upcasting and downcasting with inheritance examples.
- Practiced safe downcasting using the `instanceof` operator.
- Implemented object type-checking examples using `instanceof`.

## Learning Outcomes

- Gained a clear understanding of method overloading and overriding.
- Understood the rules and limitations of method overriding.
- Learned the difference between static binding and dynamic binding.
- Understood how polymorphism works at compile time and runtime.
- Learned the purpose and usage of Java annotations.
- Gained practical knowledge of upcasting and downcasting.
- Understood how to check object types using `instanceof`.
- Learned how inheritance and dynamic method dispatch work together in Java.

## Repository Contents

- Java programs and practical examples
- Method overloading and overriding programs
- Static and dynamic binding examples
- Polymorphism examples
- Annotation examples
- Upcasting and downcasting programs
- `instanceof` operator examples
- Class notes and supporting learning materials
