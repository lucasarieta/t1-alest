package edu.pucrs.implementation;

import edu.pucrs.StackTAD;
import edu.pucrs.util.SinglyLinkedList;

public class LinkedStack implements StackTAD {
    private SinglyLinkedList list;

    public LinkedStack() {
        list = new SinglyLinkedList();
    }

    @Override
    public void push(int element) {
        list.addLast(element);
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
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
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return list.getFirst();
    }
}