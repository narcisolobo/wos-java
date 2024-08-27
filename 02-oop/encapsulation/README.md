# Access Modifiers and Encapsulation
Access Modifiers and Encapsulation

One of the key principles of object-oriented programming (OOP) is encapsulation.

Encapsulation refers to the bundling of an object's state (its fields) and behavior (its methods) and restricting direct access to some of the object's components. This helps protect the integrity of the data within an object and allows you to control how that data is accessed and modified.

To enforce encapsulation, Java provides access modifiers that control the visibility of fields and methods. These access modifiers allow us to specify whether certain members of a class can be accessed from outside the class.

## Access Modifiers in Java

1.	`public`: Members declared as `public` are accessible from any other class. This means that the field or method can be accessed from outside the class where it is defined.
2.	`private`: Members declared as `private` are only accessible within the class where they are declared. This is typically used to restrict access to an object's internal state, ensuring that other parts of the program cannot directly modify the fields of the object.
3.	`protected`: Members declared as `protected` are accessible within the same package and by subclasses. This will be discussed more when we cover inheritance.
4.	(Default or Package-Private): If no access modifier is specified, the member is accessible within the same package but not from outside of it. This is the default access level.

### Example: Using `private` Fields for Encapsulation

By making fields `private`, we can prevent direct access from other classes and provide controlled access via methods, such as *getters* and *setters*.

Consider the following example:
```java
public class Rectangle {
    private int topAndBottomLength;
    private int leftAndRightLength;

    public Rectangle(int topAndBottomLength, int leftAndRightLength) {
        this.topAndBottomLength = topAndBottomLength;
        this.leftAndRightLength = leftAndRightLength;
    }

    public int calculateArea() {
        return this.topAndBottomLength * this.leftAndRightLength;
    }
}
```
Here, the `topAndBottomLength` and `leftAndRightLength` fields are marked as `private`, meaning they cannot be accessed directly from outside the `Rectangle` class. Instead, we provide controlled access through getter and setter methods.

## Getters and Setters

Getters and setters are methods that provide a controlled way to access and modify private fields.

- A getter method returns the value of a private field.
- A setter method updates the value of a private field.

By using getters and setters, we maintain control over how fields are accessed and modified. For example, we can perform validation in a setter method to ensure that only valid data is assigned to a field.

### Example: Getters and Setters in Action
```java
public class Rectangle {
    private int topAndBottomLength;
    private int leftAndRightLength;

    public Rectangle(int topAndBottomLength, int leftAndRightLength) {
        this.topAndBottomLength = topAndBottomLength;
        this.leftAndRightLength = leftAndRightLength;
    }

    // Getter for topAndBottomLength
    public int getTopAndBottomLength() {
        return this.topAndBottomLength;
    }

    // Setter for topAndBottomLength
    public void setTopAndBottomLength(int topAndBottomLength) {
        if (topAndBottomLength > 0) {
            this.topAndBottomLength = topAndBottomLength;
        }
    }

    // Getter for leftAndRightLength
    public int getLeftAndRightLength() {
        return this.leftAndRightLength;
    }

    // Setter for leftAndRightLength
    public void setLeftAndRightLength(int leftAndRightLength) {
        if (leftAndRightLength > 0) {
            this.leftAndRightLength = leftAndRightLength;
        }
    }

    public int calculateArea() {
        return this.topAndBottomLength * this.leftAndRightLength;
    }
}
```
### Benefits of Getters and Setters

- **Encapsulation**: Getters and setters provide access control to the fields. We can hide the internal implementation of the class and only expose what is necessary.
- **Validation**: Setters allow us to validate input before updating the field, ensuring that invalid data cannot be assigned.
- **Flexibility**: We can change the internal representation of the field without affecting other parts of the code that use the getter or setter.

For example, in the `setTopAndBottomLength` and `setLeftAndRightLength` methods, we ensure that only positive values are allowed for the rectangle’s dimensions.

**In essence, getters and setters act as a protective layer**, ensuring that your internal data structure can evolve without disrupting the rest of your application.
