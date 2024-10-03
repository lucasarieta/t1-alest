package edu.pucrs.implementation;

import edu.pucrs.QueueTAD;
import edu.pucrs.StackTAD;

public class Utils {
    public static QueueTAD reverseQueue(QueueTAD f) {
        StackTAD tempStack = new ArrayStack();
        QueueTAD reversedQueue = new ArrayQueue();
        QueueTAD originalCopy = new ArrayQueue();

        while (!f.isEmpty()) {
            int element = f.dequeue();
            tempStack.push(element);
            originalCopy.enqueue(element);
        }

        while (!tempStack.isEmpty()) {
            reversedQueue.enqueue(tempStack.pop());
        }

        while (!originalCopy.isEmpty()) {
            f.enqueue(originalCopy.dequeue());
        }

        return reversedQueue;
    }

    public static StackTAD reverseStack(StackTAD p) {
        QueueTAD tempQueue = new ArrayQueue();
        StackTAD reversedStack = new ArrayStack();
        StackTAD originalCopy = new ArrayStack();

        while (!p.isEmpty()) {
            int element = p.pop();
            tempQueue.enqueue(element);
            originalCopy.push(element);
        }

        while (!tempQueue.isEmpty()) {
            reversedStack.push(tempQueue.dequeue());
        }

        while (!originalCopy.isEmpty()) {
            p.push(originalCopy.pop());
        }

        return reversedStack;
    }

    public static StackTAD queueToStack(QueueTAD f) {
        StackTAD stack = new ArrayStack();
        QueueTAD tempQueue = new ArrayQueue();

        while (!f.isEmpty()) {
            int element = f.dequeue();
            stack.push(element);
            tempQueue.enqueue(element);
        }

        while (!tempQueue.isEmpty()) {
            f.enqueue(tempQueue.dequeue());
        }

        return reverseStack(stack);
    }

    public static QueueTAD stackToQueue(StackTAD p) {
        QueueTAD queue = new ArrayQueue();
        StackTAD tempStack = new ArrayStack();

        while (!p.isEmpty()) {
            int element = p.pop();
            queue.enqueue(element);
            tempStack.push(element);
        }

        while (!tempStack.isEmpty()) {
            p.push(tempStack.pop());
        }

        return queue;
    }
}