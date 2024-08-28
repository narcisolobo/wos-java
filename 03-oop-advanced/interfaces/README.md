# Java Object-Oriented Programming: Interfaces

**Learning Objectives**:

- Understand the concept of interfaces in Java.
- Learn how to declare and implement interfaces.
- Explore the differences between abstract classes and interfaces.
- Understand the purpose and usage of default methods in interfaces.
- Practice using interfaces with real-world examples.

## Interfaces

An interface in Java is a reference type that can contain abstract methods (methods without a body) and constants. Unlike classes, interfaces cannot have fields (except for static final constants), and their methods do not provide implementations by default. Interfaces are used to specify a "contract" that other classes must adhere to.

### Why Use Interfaces?

- **Separation of Concerns**: Interfaces allow you to define methods that must be implemented by any class that agrees to adhere to the interface, promoting a clear separation of responsibilities.
- **Multiple Inheritance**: Java does not support multiple inheritance with classes, but a class can implement multiple interfaces, allowing it to inherit method signatures from more than one source.

**For instance:**

Think of an interface as a contract. For example, if we have a `Startable` interface with a `startEngine` method, any class that implements `Startable` must provide an implementation of the `startEngine` method.

### Declaring an Interface

Interfaces are declared using the `interface` keyword. By convention, interface names should be adjectives in Pascal case (e.g., `Startable`, `Drivable`, `Payable`).

**Example:**
```java
public interface Startable {
    void startEngine(); // Abstract method
    void stopEngine();  // Another abstract method
}
```
**Key Points:**

- All methods in an interface are implicitly `public` and `abstract` (you do not need to explicitly declare them as such).
- All fields in an interface are implicitly `public`, `static`, and `final`.
- Interfaces cannot be instantiated directly.

### Implementing an Interface

When a class implements an interface, it agrees to provide concrete implementations for all the interface's methods. The `implements` keyword is used for this purpose.

**Example:**
```java
public class Car implements Startable {
    @Override
    public void startEngine() {
        System.out.println("Car engine started");
    }

    @Override
    public void stopEngine() {
        System.out.println("Car engine stopped");
    }
}
```
**Key Points:**

- A class can implement multiple interfaces by separating them with commas.
- If a class fails to implement all methods of an interface, it must be declared `abstract`.

### Interfaces vs. Abstract Classes

Both interfaces and abstract classes are used to define methods that must be implemented by subclasses or implementing classes. However, they serve different purposes and have some key differences:

#### Interfaces:

- **Multiple Inheritance**: A class can implement multiple interfaces.
- **No State**: Interfaces cannot have instance fields.
- **All Methods Abstract**: All methods in an interface are abstract by default.
- **Purpose**: Defines a contract that implementing classes must fulfill.

#### Abstract Classes:

- **Single Inheritance**: A class can only extend one abstract class.
- **State**: Abstract classes can have instance fields and non-abstract methods.
- **Partial Implementation**: Abstract classes can provide some method implementations.
- **Purpose**: Provides a common base class with shared code and behavior.

**Example:**
```java
public abstract class StringedInstrument {
    public abstract void strum();

    public void tune(){
        System.out.println("Tuning the instrument.");
    }
}

public interface Jammable() {
    void jam();
}

public class Guitar extends StringedInstrument implements Jammable {
    @Override
    public void strum() {
        System.out.println("Strumming the guitar.");
    }

    @Override
    public void jam() {
        System.out.println("Jamming on the guitar.");
    }
}
```
In this example, `Guitar` extends the abstract class `StringedInstrument` and implements the `Jammable` interface, inheriting and implementing methods from both.

### Default Methods in Interfaces

In Java 8 and later, interfaces can include default methods, which are methods with a body. These methods provide a default implementation that classes can use or override.

**Example:**
```java
public interface Jammable() {
    void jam();

    default void solo() {
        System.out.println("Playing sick solo.");
    }
}

public class Guitar implements Jammable {
    @Override
    public void jam() {
        System.out.println("Jamming on the guitar.");
    }
}

public class Bass implements Jammable {
    @Override
    public void jam() {
        System.out.println("Jamming on the bass.");
    }

    @Override
    public void solo() {
        System.out.println("Slappin' da bass.");
    }
}
```
**Key Points:**

- **Default Methods**: Provides a way to add new functionality to interfaces while maintaining backward compatibility.
- **Override Option**: Implementing classes can choose to override default methods.

## Summary

- An interface is a contract that classes can implement, defining methods that must be provided by the implementing class.
- Interfaces support multiple inheritance, whereas classes do not.
- Default methods allow interfaces to provide implementations that can be overridden.
- Understanding the differences between interfaces and abstract classes helps in designing flexible and reusable code.
