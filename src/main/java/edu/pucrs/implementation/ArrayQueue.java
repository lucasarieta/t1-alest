package edu.pucrs.implementation;

import edu.pucrs.QueueTAD;

public class ArrayQueue implements QueueTAD {
    private int[] array;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public ArrayQueue() {
        array = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(int element) {
        if (size == array.length) {
            resize();
        }
        rear = (rear + 1) % array.length;
        array[rear] = element;
        size++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        int element = array[front];
        front = (front + 1) % array.length;
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        array = new int[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public int head() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return array[front];
    }

    private void resize() {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        rear = size - 1;
    }
}