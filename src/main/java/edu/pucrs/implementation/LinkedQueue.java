package edu.pucrs.implementation;

import edu.pucrs.QueueTAD;
import edu.pucrs.util.SinglyLinkedList;

public class LinkedQueue implements QueueTAD {
    private SinglyLinkedList list;

    public LinkedQueue() {
        list = new SinglyLinkedList();
    }

    @Override
    public void enqueue(int element) {
        list.addLast(element);
    }

    @Override
    public int dequeue() {
        return list.removeFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public int head() {
        return list.getFirst();
    }
}