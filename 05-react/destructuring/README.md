# Destructuring
Extracting data from your JavaScript objects and arrays with ease!

## Learning Objectives
- Analyze the syntax and functionality of the destructuring technique using objects and arrays.
- Evaluate the advantages of using the destructuring technique over traditional variable assignment methods.
- Demonstrate an understanding of advanced techniques in destructuring, such as handling name conflicts and nested structures.

## It's Destructuring Time!
According to Mozilla, "destructuring assignment syntax is a JavaScript expression that makes it possible to unpack values from arrays, or properties from objects into distinct variables." Did you follow that? It means you can take parts of a data structure, like an array or an object, and store their values in a variable.

Before we examine how to achieve that through destructuring, let us quickly review how we might currently perform this task.

Here are two initial data structures - an object literal and an array:

```js
const person = { 
    firstName: 'Bob', 
    lastName: 'Marley', 
    email: 'bob@marley.com', 
    password: 'sekureP@ssw0rd9', 
    username: 'barley', 
    createdAt: 1543945177623
};

const animals = ['horse', 'dog', 'fish', 'cat', 'bird'];
```

### A Trip Down ECMAScript 5 Lane

Assume you want the email property value from the person object and the value at the animal array's 0th index as standalone variables.

Before ES6, that would have looked like this:
```js
//obtaining the object literal's property value
var email = person.email;

//obtaining the value of the array's 0th index
var firstAnimal = animals[0];
```

### Now We're Modern

Let's do that again. This time, we'll use the destructuring technique:

```js
// AFTER ES6
const { email } = person;
const [firstAnimal] = animals;

console.log(email); // Output: bob@marley.com
console.log(firstAnimal); // Output: horse
```

To destructure, the declarations between the curly (object) or square (array) braces must match the value to the right of the equal sign.

This means when you destructure a value from an object, the properties keys must be written exactly as they were initialized in the object. If you want to assign the "Bob" property value to a variable, destructure using the firstName property key exactly as written.

For arrays, create variables to capture content at specific indices. The destructuring is based on the element's index, not any specific property key. You can name these variables whatever you'd like, and the order in which you write them will reflect the order of the array itself.

### Why Do We Destructure?

Interesting, but you may have a couple of questions:

- What happens to the original content?
- Is it more useful than the pre-ES6 example?
- The original content will be unchanged after the newly created variable is declared using the destructuring technique. Destructuring does not destroy the origin data. It merely makes copies of it and sets new variables.

As for its usefulness, let's investigate whether it is more helpful than the ES5 way by expanding the previous scenario.

This time, we want to extract the email and password properties from `person` and the first three strings from `animals`.

First, with ES5 syntax:

```js
var email = person.email;
var password = person.password;

var firstAnimal = animals[0];
var secondAnimal = animals[1];
var thirdAnimal = animals[2];
```

While it is a lot of code, it does have the benefit of being clear and easy to read. We know exactly where each variable is receiving its information, so why wouldn't we do that?

Let's see how concisely and cleanly this is done through destructuring:

```js
// destructuring using multiple property keys
const { email, password } = person;

// destructuring based on the array's indices
const [firstAnimal, secondAnimal, thirdAnimal] = animals;
```

Destructuring allows us to extract multiple items simultaneously; we get all the same data while being significantly more succinct. This method is just as clear once you entirely use the destructuring syntax!

### Solving Naming Conflicts

What if your current scope already has a variable of the same name as a property you're extracting from an object?

```js
const password = '12345';
const { password } = person;
```

This will certainly cause conflict. Because `password` exists before destructuring and is a `const` this will throw an error: `SyntaxError: Identifier 'password' has already been declared`.

So do you have to fall back on this?

```js
const hashedPassword = person.password;
```

Can you destructure into a distinct variable?

```js
const { hashedPassword } = person;
```

That first example will work, but it's unnecessary. The second example won't throw an error but won't have the expected information.

When destructuring from objects, the property names must be matched exactly. In this example, `hashedPassword` does not exist in our `person` object, so it will be `undefined`.

Not to worry. The JS maintainers already considered this scenario and have a way to specify exactly what you want to destructure while also supplying a new variable name.

```js
const password = '12345';
const { password: hashedPassword } = person;
```

### Nested Destructuring

We'll often work with much more complex content and want to take advantage of destructuring these nested structures. For this next example, we'll modify the person object to have an array of addresses.

```js
const person = {
  firstName: 'Bob',
  lastName: 'Marley',
  email: 'bob@marley.com',
  password: 'sekureP@ssw0rd9',
  username: 'barley',
  addresses: [
    {
      address: '1600 Pennsylvania Avenue',
      city: 'Washington, D.C.',
      zipcode: '20500',
    },
    {
      address: '221B Baker St.',
      city: 'London',
      zipcode: 'WC2N 5DU',
    }
  ],
  createdAt: 1543945177623
};
```

If you want the individual addresses as variables, you could certainly destructure `addresses`, then destructure each address.

```js
const { addresses: [whiteHouse, sherlock] } = person;
```

Note that a variable named `addresses` is no longer created, but we can reference each address by the variable name listed at those positions.

What if we want to skip the address at the 0th index and only need the value of the city at the 1st index?

To make it even more challenging, let's say we also want to use an alternate variable name. How could we accomplish this task?

Let's see:

```js
const { addresses: [ , { city: london }] } = person;
console.log(london);
// => London
```

We can leave an 'empty' first position using a comma, which allows us to skip that index and destructure from the second address.

We can skip as many indices as we need to if we are sure the index exists.

```js
const { addresses: [ , , , , { city: london }] } = person;
```

The above example will produce an error. We skipped so many addresses that the final position doesn't have an address object. Attempting to destructure from `undefined` or `null` throws: `TypeError: Cannot destructure property 'city' of 'undefined' or 'null'`.
