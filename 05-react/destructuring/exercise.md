# Destructuring Exercise

Objectives:

- Practice destructuring from objects and arrays.
- Learn to handle name conflicts and nested structures with destructuring.

## Instructions:

You will work with two data structures: an object representing a user and an array of colors. Use the destructuring technique to extract data from these structures.

### Step 1: Object Destructuring

Given the following user object:
```js
const user = {
  firstName: 'Alice',
  lastName: 'Wonderland',
  email: 'alice@wonderland.com',
  password: 'superSecureP@ss',
  username: 'alice123',
  address: {
    street: '123 Rabbit Hole Ln',
    city: 'Wonderland',
    zipcode: '12345'
  }
};
```

- Use destructuring to extract the firstName, lastName, and email properties from the user object and store them in variables.
- Use destructuring to extract street, city, and zipcode from the address object within user.

### Step 2: Array Destructuring

Given the following colors array:

```js
const colors = ['red', 'green', 'blue', 'yellow', 'orange'];
```

- Use destructuring to extract the first three colors from the array and store them in variables.
- Use destructuring to skip the first color and extract the second and third colors only.

### Step 3: Handling Name Conflicts

Let’s say we already have a variable named password in our current scope. Now, we want to extract the password from the user object without causing a naming conflict. How can you rename the destructured variable?

- Use destructuring to extract the password property from the user object but store it as userPassword.

### Step 4: Nested Destructuring

Given the following post object:

```js
const post = {
  id: 12345,
  title: 'JavaScript Destructuring',
  author: {
    name: 'John Doe',
    email: 'john@example.com'
  },
  comments: [
    { username: 'commenter1', text: 'Great article!' },
    { username: 'commenter2', text: 'Very helpful, thanks!' }
  ]
};
```

- Use nested destructuring to extract the name and email of the author and store them in variables.
- Use nested destructuring to extract the username of the second comment.
