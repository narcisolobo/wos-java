class StackNode {
  constructor(data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedListStack {
  /**
   * @param {StackNode|null}
   */
  constructor() {
    this.head = null;
  }

  /**
   * Adds a new item to the top of the stack (the head).
   * - Time: O(1) constant.
   * - Space: O(1).
   * @param {any} val The val to add.
   * @returns {LinkedListStack} This stack.
   */
  push(val) {
    const newNode = new StackNode(val);

    if (this.isEmpty()) {
      this.head = newNode;
    } else {
      newNode.next = this.head;
      this.head = newNode;
    }

    return this;
  }

  /**
   * Removes the top item (the head).
   * - Time: O(1) constant.
   * - Space: O(1).
   * @returns {any} The top item of the stack.
   */
  pop() {
    if (this.isEmpty()) {
      return null;
    }

    const popped = this.head.data;
    this.head = this.head.next;
    return popped;
  }

  /**
   * Returns the top item of the stack without removing it.
   * - Time: O(1) constant.
   * - Space: O(1).
   * @returns {any} The top item.
   */
  peek() {
    if (this.isEmpty()) {
      return null;
    }

    return this.head.data;
  }

  /**
   * Determines if the stack is empty.
   * - Time: O(1) constant.
   * - Space: O(1).
   * @returns {boolean}
   */
  isEmpty() {
    return this.head === null;
  }

  /**
   * Gets the count of items in the stack.
   * - Time: O(n) linear, n = list length.
   * - Space: O(1).
   * @returns {number} The total number of items.
   */
  size() {
    if (this.isEmpty()) {
      return 0;
    }

    let runner = this.head;
    let count = 0;
    while (runner) {
      count++;
      runner = runner.next;
    }

    return count;
  }

  /**
   * Determines whether or not the given search value
   * exists in this list.
   * @param {any} val The data to search for in the nodes of this list.
   * @returns {boolean} `true` if `val` exists in list, `false` if not.
   */
  contains(val) {
    if (this.isEmpty()) {
      return false;
    }

    let runner = this.head;
    while (runner) {
      if (runner.data === val) {
        return true;
      }

      runner = runner.next;
    }

    return false;
  }

  // Time: O(n) linear, n = list length
  // Space: O(n)
  print() {
    if (this.isEmpty()) {
      console.log(`This stack is empty.`);
    }

    let output = 'head -> ';
    let runner = this.head;
    while (runner) {
      output += `${runner.data} -> `;
      runner = runner.next;
    }

    output += 'null';
    console.log(output);
  }
}

const emptyStack = new LinkedListStack();
const myStack = new LinkedListStack();

myStack
  .push(25)
  .push(72)
  .push(76)
  .push(89)
  .push(5)
  .push(37)
  .push(15)
  .push(55)
  .push(79)
  .push(12);

myStack.print();

console.log(`${myStack.size()} should equal 10`);

const popped = myStack.pop();
console.log(`${popped} should equal 12`);

const peek = myStack.peek();
console.log(`${peek} should equal 79`);

console.log(`${emptyStack.isEmpty()} should equal true`);
console.log(`${myStack.isEmpty()} should equal false`);

const emptySize = emptyStack.size();
console.log(`${emptySize} should equal 0`);

const myStackSize = myStack.size();
console.log(`${myStackSize} should equal 9`);

const result1 = emptyStack.contains(1);
console.log(`${result1} should equal false`);

const result2 = myStack.contains(89);
console.log(`${result2} should equal true`);

const result3 = myStack.contains(1);
console.log(`${result3} should equal false`);
