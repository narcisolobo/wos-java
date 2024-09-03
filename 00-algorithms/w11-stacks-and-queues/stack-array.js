/**
 * Class to represent a stack using an array to store the stacked items.
 * Follows a LIFO (Last In First Out) order where new items are stacked on
 * top (back of array) and removed items are removed from the top / back.
 */
class Stack {
  /**
   * The constructor is executed when instantiating a new Stack() to construct
   * a new instance.
   * @returns {Stack} This new Stack instance is returned without having to
   *    explicitly write 'return' (implicit return).
   */
  constructor() {
    this.items = [];
  }

  /**
   * Adds a new given item to the top / back of this stack.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @param {any} item The new item to be added to the top / back.
   * @returns {number} The new length of this stack.
   */
  push(item) {}

  /**
   * Removes the top / last item from this stack.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {any} The removed item or undefined if this stack was empty.
   */
  pop() {}

  /**
   * Retrieves the top / last item from this stack without removing it.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {any} The top / last item of this stack.
   */
  peek() {}

  /**
   * Returns whether or not this stack is empty.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {boolean}
   */
  isEmpty() {}

  /**
   * Returns the size of this stack.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {number} The length.
   */
  size() {}
}

const myStack = new Stack();

myStack.push(25);
myStack.push(72);
myStack.push(76);
myStack.push(89);
myStack.push(5);
myStack.push(37);
myStack.push(15);
myStack.push(55);
myStack.push(79);

const newLength = myStack.push(12);
console.log(`${newLength} should equal 10`);

const popped = myStack.pop();
console.log(`${popped} should equal 12`);

const peek = myStack.peek();
console.log(`${peek} should equal 79`);

const emptyStack = new Stack();

console.log(`${emptyStack.isEmpty()} should equal true`);
console.log(`${myStack.isEmpty()} should equal false`);

const size = myStack.size();
console.log(`${size} should equal 9`);
