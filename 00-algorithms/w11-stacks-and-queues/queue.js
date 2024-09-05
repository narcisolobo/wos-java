/**
 * Class to represent a queue using an array which follows a FIFO
 * (First In First Out) order. New items are added to the back and items are
 * removed from the front.
 */
class Queue {
  /**
   *
   * @param {Array<any>} items The starting items, useful for if you already
   *    have an array of items in the right order and want to convert it to a
   *    queue instance to get access to the queue methods.
   */
  constructor(items = []) {
    this.items = items;
  }

  /**
   * Adds a new given item to the back of this queue.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @param {any} item The new item to add to the back.
   * @returns {number} The new size of this queue.
   */
  enqueue(item) {
    this.items.push(item);
    return this.size();
  }

  /**
   * Removes and returns the first item of this queue.
   * - Time: O(n) linear, due to having to shift all the remaining items to
   *    the left after removing first elem.
   * - Space: O(1) constant.
   * @returns {any} The first item or undefined if empty.
   */
  dequeue() {
    return this.items.shift();
  }

  /**
   * Retrieves the first item without removing it.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {any} The first item or undefined if empty.
   */
  front() {
    return this.isEmpty() ? undefined : this.items[0];
  }

  /**
   * Returns whether or not this queue is empty.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {boolean}
   */
  isEmpty() {
    return this.items.length === 0;
  }

  /**
   * Retrieves the size of this queue.
   * - Time: O(1) constant.
   * - Space: O(1) constant.
   * @returns {number} The length.
   */
  size() {
    return this.items.length;
  }
}

const emptyQueue = new Queue();
const myQueue = new Queue();
myQueue.enqueue(46);
myQueue.enqueue(3);
myQueue.enqueue(36);
myQueue.enqueue(37);
myQueue.enqueue(98);
myQueue.enqueue(23);
myQueue.enqueue(89);
myQueue.enqueue(100);
myQueue.enqueue(24);
myQueue.enqueue(75);

console.log(myQueue);

const result1 = myQueue.dequeue();
console.log(`${result1} should equal 46`);
console.log(myQueue);

const result2 = emptyQueue.isEmpty();
console.log(`${result2} should equal true`);

const result3 = myQueue.isEmpty();
console.log(`${result3} should equal false`);

const result4 = myQueue.size();
console.log(`${result4} should equal 9`);
