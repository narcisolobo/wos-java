const person = {
  firstName: 'Bob',
  lastName: 'Marley',
  email: 'bob@marley.com',
  password: 'sekureP@ssw0rd9',
  username: 'barley',
  createdAt: 1543945177623,
};

const otherPerson = {
  firstName: 'Bill',
  lastName: 'Withers',
  email: 'bill@withers.com',
  password: 'sekureP@ssw0rd9',
  username: 'bwithers',
  createdAt: 1543945177623,
};

const animals = ['horse', 'dog', 'fish', 'cat', 'bird'];

const { email, username } = person;
console.log(email, username);
console.log(person);

const { email: billEmail } = otherPerson;
console.log(billEmail);

const [firstAnimal, , , , fifthAnimal] = animals;
console.log(firstAnimal, fifthAnimal);
console.log(animals);

const complexPerson = {
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
    },
  ],
  createdAt: 1543945177623,
};

const {
  addresses: [firstAddress, secondAddress],
} = complexPerson;
console.log(firstAddress, secondAddress);

const {
  addresses: [, { city: london }],
} = complexPerson;
console.log(london);
