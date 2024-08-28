# Java Object-Oriented Programming: Inheritance

## Learning Objectives:

- Understand the concept of inheritance in Java.
- Learn how to create subclasses and use the extends keyword.
- Explore the super keyword and how it is used to access superclass methods and constructors.
- Recognize the difference between method overriding and method overloading.
- Understand the concept of polymorphism.

## Inheritance

Inheritance is a fundamental concept in Object-Oriented Programming (OOP) that allows a new class to inherit state and behavior (fields and methods) from an existing class. The new class is called a subclass (or child class), and the existing class is called a superclass (or parent class).

**For instance:**

Imagine we have a `Vehicle` class that represents general characteristics of a vehicle, such as speed and capacity. We can create a more specific class, like `Car`, that inherits from `Vehicle`. The `Car` class would then have all the fields and methods of `Vehicle`, along with its own specific fields and methods.

### Declaring a Subclass with `extends`

In Java, the `extends` keyword is used to declare that a class is a subclass of another class.

```java
// Superclass/Parent Class
public class Vehicle {
    public int speed;
    public int capacity;

    public void startEngine() {
        System.out.println("Engine started");
    }
}

// Subclass/Child Class
public class Car extends Vehicle {
    public String model;

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Speed: " + speed);
        System.out.println("Capacity: " + capacity);
    }
}
```
**Key Points:**

- **Inheritance Hierarchy**: The `Car` class inherits fields and methods from the `Vehicle` class.
- **Subclass Features**: The `Car` class can add additional fields (like `model`) and methods (like `displayInfo()`).
- **Accessing Superclass Members**: The `Car` class can access `speed` and `capacity` directly because it inherits these fields from Vehicle.

### The `super` Keyword

The `super` keyword is used to refer to the superclass. It can be used in two main contexts:

1.	**Accessing Superclass Methods**: You can use `super` to call a method from the superclass that has been overridden in the subclass.
2.	**Calling Superclass Constructors**: You can use `super()` to call the constructor of the superclass from the subclass constructor.

**Example: Calling Superclass Methods**
```java
public class Car extends Vehicle {
    public String model;

    @Override
    public void startEngine() {
        super.startEngine(); // Calls the startEngine method from Vehicle
        System.out.println("Car engine started");
    }
}
```
**Example: Calling Superclass Constructors**
```java
// Superclass
public class Vehicle {
    public int speed;
    public int capacity;

    public Vehicle(int speed, int capacity) {
        this.speed = speed;
        this.capacity = capacity;
    }
}

// Subclass
public class Car extends Vehicle {
    public String model;

    public Car(String model, int speed, int capacity) {
        super(speed, capacity); // Calls the Vehicle constructor
        this.model = model;
    }
}
```
### Method Overriding
When a subclass provides a specific implementation of a method that is already defined in its superclass, we can allow the subclass to modify or extend the behavior of the superclass method.

For example, the `startEngine()` method in the `Car` class overrides the `startEngine()` method in the `Vehicle` class.

### Method Overloading
When multiple methods in the same class have the same name but different parameter lists, we can provide different ways to perform a similar action depending on the input.
```java
public class Vehicle {
    public void startEngine() {
        System.out.println("Engine started");
    }

    public void startEngine(boolean warmUp) {
        if (warmUp) {
            System.out.println("Warming up the engine");
        }
        System.out.println("Engine started");
    }
}
```
