package edu.pucrs.implementation;

import edu.pucrs.StackTAD;

public class ArrayStack implements StackTAD {
    private int[] array;
    private int top;
    private static final int DEFAULT_CAPACITY = 8;

    public ArrayStack() {
        array = new int[DEFAULT_CAPACITY];
        top = -1;
    }

    @Override
    public void push(int element) {
        if (top == array.length - 1) {
            resize();
        }
        array[++top] = element;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return array[top--];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void clear() {
        array = new int[DEFAULT_CAPACITY];
        top = -1;
    }

    @Override
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return array[top];
    }

    private void resize() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}