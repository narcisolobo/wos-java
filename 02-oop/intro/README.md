# Java Object-Oriented Programming

Learning Objectives for the Day:
- Classes and Objects
- Fields and methods
- Constructors and overloading
- The `this` keyword

## What is a class? What is an object?

A class provides the blueprint for an object's state and behavior. It does this through what we call *"members"* - fields and methods.

Take, for instance, a car. A car might have fields for its make, model, and color. It might also have methods for drive, beep, brake, etc.

## How do we declare a class?

We declare a class with the following syntax:

```java
public class MyClass {
    // body of class
}
```
**Class names should be Pascal case singular nouns!**

The first line can also contain a few other keywords, like whether it extends another class or implements any interfaces.

In general, class declarations can include these components, in order:

1. Modifiers such as `public` and `private` (note that the private modifier can only be applied to nested classes).
2. The class name, with the initial letter capitalized by convention (*Pascal case*).
3. The name of the class's parent (*superclass*), if any, preceded by the keyword `extends`. A class can only extend (*subclass*) one parent.
4. A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword `implements`. A class can implement more than one interface.
5. The class body, surrounded by braces, {}.

For now, though, let's keep it simple. Further discussion on modifiers, inheritance, and interfaces will come later in this course.

## Example: The `Rectangle` Class:
```java
public class Rectangle {
    public int topAndBottomLength;
    public int leftAndRightLength;

    public Rectangle(int topAndBottomLength, int leftAndRightLength) {
        this.topAndBottomLength = topAndBottomLength;
        this.leftAndRightLength = leftAndRightLength;
    }

    public int calculateArea() {
        return this.topAndBottomLength * this.leftAndRightLength;
    }

    public boolean isSquare() {
        return this.topAndBottomLength == this.leftAndRightLength;
    }
}
```

### Declaring Fields
The `Rectangle` class uses the following lines of code to define its fields:

```java
public int topAndBottomLength;
public int leftAndRightLength;
```
These field declarations are composed of three components, in order:

1. The modifier, such as `public` or `private`.
2. The field's data type.
3. The field's name.

The fields of `Rectangle` are `topAndBottomLength` and `leftAndRightLength` and both are of data type integer (`int`). The `public` keyword identifies these fields as `public` members, accessible by any object that can access the class.

### Defining the Constructor
A constructor in Java is a special method that is called when an object of a class is created. Its purpose is to initialize the object's fields with specific values.

In our `Rectangle` class, we have defined one constructor:
```java
public Rectangle(int topAndBottomLength, int leftAndRightLength) {
    this.topAndBottomLength = topAndBottomLength;
    this.leftAndRightLength = leftAndRightLength;
}
```

This constructor takes two parameters: `topAndBottomLength` and `leftAndRightLength`. These values are passed to the constructor when a `Rectangle` object is instantiated.

But how do we assign the values passed in to the fields of the `Rectangle` object? This is where the `this` keyword comes in.

#### The `this` Keyword

The keyword `this` refers to the current instance of the class. It’s used to distinguish between the parameters passed to the constructor and the instance variables of the object.

In the constructor, we have:
```java
this.topAndBottomLength = topAndBottomLength;
```
Here, `this.topAndBottomLength` refers to the field of the current object, while `topAndBottomLength` refers to the parameter passed to the constructor. Without the `this` keyword, Java wouldn’t know whether we're referring to the field or the parameter, so it's necessary for clarity.

**Example of Instantiating an Object**

When you create a new Rectangle like this:
```java
Rectangle rect = new Rectangle(7, 5);
```
1. The constructor `Rectangle(int topAndBottomLength, int leftAndRightLength)` is called.
2.	The `this` keyword ensures that the values 7 and 5 are assigned to the correct fields in the object `rect`.

### Constructor Overloading
Constructors can be *overloaded*, meaning that you can define multiple constructors with different sets of parameters. This allows for flexibility when creating objects. For example:
```java
public Rectangle() {
    this.topAndBottomLength = 0;
    this.leftAndRightLength = 0;
}
```
This constructor creates a `Rectangle` object with default values of `0` for both fields.

### Defining Methods
Our `Rectangle` class defines two methods.

```java
public int calculateArea() {
    return this.topAndBottomLength * this.leftAndRightLength;
}

public boolean isSquare() {
    return this.topAndBottomLength == this.leftAndRightLength;
}
```
**Method names should be camel case verbs (at least the first word)!**

The only required elements of a method declaration are the method's return type, name, a pair of parentheses, `()`, and a body between curly braces, `{}`.

More generally, method declarations have six components, in order:

1. Modifiers—such as `public`, `private`, and others you will learn about later.
2. The return type—the data type of the value returned by the method, or `void` if the method does not return a value.
3. The method name—the rules for field names apply to method names as well.
4. The parameter list in parentheses—a comma-separated list of input parameters, preceded by their data types, enclosed by parentheses, `()`. If there are no parameters, you must use empty parentheses.
5. An exception list (not part of this course).
6. The method body, enclosed between braces—the method's code, including the declaration of local variables, goes here.
