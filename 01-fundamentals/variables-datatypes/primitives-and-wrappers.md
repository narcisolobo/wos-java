# Variables and Datatypes

## Primitive Datatypes
In Java, primitive data types are the most basic types of data that are used to represent simple values. They are not objects and hold their values directly in memory.

Java provides eight primitive data types that serve as the building blocks for more complex data structures and operations. These types are integral to Java’s type system and are crucial for understanding how data is stored and manipulated in programs.

Each primitive type has its own size and range of values, and they are designed to provide efficient storage and performance. Understanding these data types is fundamental to programming in Java, as they are used in virtually every Java application to perform a wide variety of tasks.

- **`byte`** - The `byte` data type is an 8-bit integer. It has a minimum value of -128 and a maximum value of 127 (inclusive). The `byte` data type can be useful for saving memory in large arrays, where the memory savings actually matters. They can also be used in place of `int` where their limits help to clarify your code; the fact that a variable's range is limited can serve as a form of documentation.
- **`short`**: The `short` data type is a 16-bit integer. It has a minimum value of -32,768 and a maximum value of 32,767 (inclusive). As with `byte`, the same guidelines apply: you can use a `short` to save memory in large arrays, in situations where the memory savings actually matters.
- **`int`**: By default, the `int` data type is a 32-bit integer, which has a range of -2^31 to 2^31 - 1. In Java SE 8 and later, you can use the `int` data type to represent an unsigned 32-bit integer, which has a range of 0 to 2^32 - 1.
- **`long`**: The `long` data type is a 64-bit integer. The signed `long` has a range of -2^63 to 2^63 - 1. Use this data type when you need a range of values wider than those provided by int.
- **`float`**: The `float` data type is a single-precision 32-bit IEEE 754 floating point. As with the recommendations for `byte` and `short`, use a `float` (instead of `double`) if you need to save memory in large arrays of floating point numbers. This data type should never be used for precise values, such as currency. For that, you will need to use the `java.math.BigDecimal` class instead. The `float` datatype is typically used in scientific computations or situations where precision isn’t critical.
- **`double`**: The `double` data type is a double-precision 64-bit IEEE 754 floating point. For decimal values, this data type is generally the default choice. As mentioned above, this data type should never be used for precise values, such as currency. The `double` datatype is typically used in scientific computations or situations where precision isn’t critical.
- **`boolean`**: The `boolean` data type has only two possible values: `true` and `false`. Use this data type for simple flags that track true/false conditions. This data type represents one bit of information, but its "size" isn't something that's precisely defined.
- **`char`**: The `char` data type is a single 16-bit Unicode character.

## Wrapper Classes
In Java, each primitive data type has a corresponding wrapper class that allows it to be treated as an object. Wrapper classes are part of the `java.lang` package and provide methods to convert between primitive types and their corresponding objects. These classes also offer utility methods for manipulating primitive data.

### List of Wrapper Classes
Each primitive type has a wrapper class:

- `byte` → `Byte`
- `short` → `Short`
- `int` → `Integer`
- `long` → `Long`
- `float` → `Float`
- `double` → `Double`
- `char` → `Character`
- `boolean` → `Boolean`

### Auto-boxing and Unboxing
Java provides automatic conversion between primitive types and their corresponding wrapper classes. This feature is known as auto-boxing and unboxing:

**Auto-boxing: Converting a primitive to its corresponding wrapper class automatically. For example:**
```java
Integer myInt = 5; // auto-boxing of int to Integer
```

**Unboxing: Converting a wrapper class object back to its primitive type automatically. For example:**
```java
int myInt = myInteger; // unboxing of Integer to int
```

### When to Use Wrapper Classes
Wrapper classes are useful in various scenarios:

**Collections**: Collections like `ArrayList` only work with objects, not primitives. Therefore, you use wrapper classes:
```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10); // int is auto-boxed to Integer
```

**Methods and APIs**: Some methods and APIs require objects rather than primitives. For example, the `Optional` class:
```java
Optional<Integer> optionalInt = Optional.of(5);
```

**Handling Null Values**: Wrapper classes can represent null values, unlike primitives:
```java
Integer myInteger = null; // valid
int myInt = null; // invalid
```

### Common Methods in Wrapper Classes
Wrapper classes provide several useful methods.

**Parsing Strings**: Convert strings to primitives:
```java
int parsedInt = Integer.parseInt("123");
double parsedDouble = Double.parseDouble("12.34");
```

**Converting to Strings**: Convert primitives to strings:
```java
String intString = Integer.toString(123);
String doubleString = Double.toString(12.34);
```

`Other Methods`: Methods like `valueOf`, `compare`, and `MAX_VALUE` are available in wrapper classes:
```java
int maxInt = Integer.MAX_VALUE;
Integer integerValue = Integer.valueOf(42);
```