const pokémon = Object.freeze([
  { id: 1, name: 'Bulbasaur', types: ['poison', 'grass'] },
  { id: 5, name: 'Charmeleon', types: ['fire'] },
  { id: 9, name: 'Blastoise', types: ['water'] },
  { id: 12, name: 'Butterfree', types: ['bug', 'flying'] },
  { id: 16, name: 'Pidgey', types: ['normal', 'flying'] },
  { id: 23, name: 'Ekans', types: ['poison'] },
  { id: 24, name: 'Arbok', types: ['poison'] },
  { id: 25, name: 'Pikachu', types: ['electric'] },
  { id: 35, name: 'Clefairy', types: ['normal'] },
  { id: 37, name: 'Vulpix', types: ['fire'] },
  { id: 52, name: 'Meowth', types: ['normal'] },
  { id: 63, name: 'Abra', types: ['psychic'] },
  { id: 67, name: 'Machamp', types: ['fighting'] },
  { id: 72, name: 'Tentacool', types: ['water', 'poison'] },
  { id: 74, name: 'Geodude', types: ['rock', 'ground'] },
  { id: 87, name: 'Dewgong', types: ['water', 'ice'] },
  { id: 98, name: 'Krabby', types: ['water'] },
  { id: 115, name: 'Kangaskhan', types: ['normal'] },
  { id: 122, name: 'Mr. Mime', types: ['psychic'] },
  { id: 133, name: 'Eevee', types: ['normal'] },
  { id: 144, name: 'Articuno', types: ['ice', 'flying'] },
  { id: 145, name: 'Zapdos', types: ['electric', 'flying'] },
  { id: 146, name: 'Moltres', types: ['fire', 'flying'] },
  { id: 148, name: 'Dragonair', types: ['dragon'] },
]);

// The .map Method

const pokeIds = pokémon.map((poke) => poke.id);
console.log('Just the poke ids:');
console.log(pokeIds);

// an array of pokémon objects where the id is evenly divisible by 3
const trePoke = pokémon.filter((poke) => poke.id % 3 === 0);
console.log(
  'an array of pokémon objects where the id is evenly divisible by 3'
);
console.log(trePoke);

// an array of pokémon objects that are "fire" type
const firePokes = pokémon.filter((poke) => poke.types.includes('fire'));
console.log('an array of pokémon objects that are "fire" type');
console.log(firePokes);

// an array of pokémon objects that have more than one type
const multiTypes = pokémon.filter((poke) => poke.types.length > 1);
console.log('an array of pokémon objects that have more than one type');
console.log(multiTypes);

// an array with just the names of the pokémon
const justNames = pokémon.map((poke) => poke.name);
console.log('an array with just the names of the pokémon');
console.log(justNames);

// an array with just the names of pokémon with an id greater than 99
const justNamesGreaterThan99 = pokémon
  .filter((poke) => poke.id > 99)
  .map((poke) => poke.name);
console.log(
  'an array with just the names of pokémon with an id greater than 99'
);
console.log(justNamesGreaterThan99);

// an array with just the names of the pokémon whose only type is poison
const onlyPoison = pokémon.filter(
  (poke) => poke.types.length === 1 && poke.types[0] === 'poison'
);
console.log(
  'an array with just the names of the pokémon whose only type is poison'
);
console.log(onlyPoison);

// an array containing just the first type of all the pokémon whose second type is "flying"
const secondTypeFlying = pokémon
  .filter((poke) => poke.types[1] === 'flying')
  .map((poke) => poke.types[0]);
console.log(
  'an array containing just the first type of all the pokémon whose second type is "flying"'
);
console.log(secondTypeFlying);

// a count of the number of pokémon that are "normal" type
const normalCount = pokémon.filter((poke) =>
  poke.types.includes('normal')
).length;
console.log('a count of the number of pokémon that are "normal" type');
console.log(normalCount);

// an array with all pokemon except the pokemon with the id of 148
const no148 = pokémon.filter((poke) => poke.id !== 148);
console.log('an array with all pokemon except the pokemon with the id of 148');
console.log(no148);

// an array with all pokemon and for pokemon id: 35 replacing "normal" with "fairy"
const normalToFairy35 = pokémon.map((poke) =>
  poke.id === 35 ? { ...poke, types: ['fairy'] } : poke
);
console.log(normalToFairy35);
