## MyBlockingQueue
MyBlockingQueue is a simple implementation of a blocking queue in Java. It provides thread-safe operations for adding and removing elements, ensuring that producers and consumers can work together without encountering race conditions.

### Features
- **Thread-Safety:** Operations (enqueue, dequeue, size) are synchronized to ensure that they are atomic and safe for concurrent access by multiple threads.
- **Fixed Capacity:** The maximum capacity of the queue is defined upon initialization and cannot be changed.