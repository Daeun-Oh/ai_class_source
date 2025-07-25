class Queue<T> {
  private items: T[] = []

  offer(item: T) {
    this.items.push(item)
  }

  poll(): T | undefined {
    return this.items.shift()
  }
}

const queue = new Queue<number>()
queue.offer(10)
queue.offer(20)
// queue.offer("10") -> number만 가능
console.log(queue.poll())
console.log(queue.poll())
