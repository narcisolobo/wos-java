# Java Object-Oriented Programming (The `static` Keyword)

**Learning Objectives:**

- The static Keyword
- Static Fields
- Static Methods
- Static Blocks

## What does the `static` keyword mean?

In Java, the `static` keyword is used to indicate that a field, method, or block belongs to the class itself rather than to instances (objects) of the class. This means that `static` members are shared across all instances of the class.

## Static Fields

When you declare a field as `static`, it means that there is only one copy of that field, regardless of how many objects of the class are created. All instances of the class share this single field.

**Example:**
```java
public class Counter {
    public static int count = 0; // static field

    public Counter() {
        count++; // Increment the static field
    }
}
```
If you create multiple Counter objects, they will all share the same count variable.
```java
Counter c1 = new Counter();  // count is 1
Counter c2 = new Counter();  // count is 2
Counter c3 = new Counter();  // count is 3
```
Here, all instances of Counter increment the same count variable.

## Static Methods

Similarly, static methods belong to the class and can be called without creating an instance of the class. Static methods typically perform operations that are related to the class, but not specific to any individual object.

**Example:**
```java
public class MathUtils {
    public static int add(int a, int b) {
        return a + b;
    }
}
```
You can call the `add` method directly using the class name, without needing to create an instance:
```java
int result = MathUtils.add(5, 3);  // result is 8
```
## When to Use Static Fields and Methods?

- **Static Fields**: Use them for data that should be shared among all instances of a class (e.g., constants or counters).
- **Static Methods**: Use them for utility functions (like mathematical operations) or behavior that is not tied to a specific object.

## Important Considerations

1.	No `this` Keyword in Static Methods: Since static methods belong to the class rather than any specific object, you cannot use the this keyword inside a static method.
2.	Accessing Static Members: You can access static fields and methods using either the class name or an object reference. However, the preferred way is to use the class name to emphasize that the field or method belongs to the class.
