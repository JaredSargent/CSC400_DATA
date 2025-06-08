class Queue:
    def __init__(self):
        self.items = []

    def enqueue(self, item):
        self.items.append(item)
        print(f"Enqueued: {item}")

    def dequeue(self):
        if not self.isEmpty():
            item = self.items.pop(0)
            print(f"Dequeued: {item}")
            return item
        print("Queue is empty!")
        return None

    def peek(self):
        if not self.isEmpty():
            return self.items[0]
        return None

    def isEmpty(self):
        return len(self.items) == 0

    def size(self):
        return len(self.items)

    def display(self):
        print("Queue:", self.items)

# Demonstration
if __name__ == "__main__":
    queue = Queue()
    print("Is queue empty?", queue.isEmpty())
    queue.enqueue("Customer1")
    queue.enqueue("Customer2")
    queue.enqueue("Customer3")
    queue.display()
    print("Front element:", queue.peek())
    queue.dequeue()
    queue.display()
    print("Queue size:", queue.size())
    queue.dequeue()
    queue.dequeue()
    queue.dequeue()  # Attempt to dequeue from empty queue
    print("Is queue empty?", queue.isEmpty())