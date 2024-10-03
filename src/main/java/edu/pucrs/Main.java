package edu.pucrs;

import edu.pucrs.implementation.*;

public class Main {
    public static void main(String[] args) {
        testArrayQueue();
        testLinkedQueue();
        testArrayStack();
        testLinkedStack();
        testUtils();
    }

    private static void testArrayQueue() {
        System.out.println("Testando ArrayQueue:");
        ArrayQueue queue = new ArrayQueue();

        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("Tamanho após enqueue: " + queue.size() + " (Esperado: 5)");

        System.out.println("Elemento na frente: " + queue.head() + " (Esperado: 1)");

        System.out.println("Elementos removidos:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("\nTamanho após dequeue: " + queue.size() + " (Esperado: 0)");

        System.out.println("Fila vazia? " + queue.isEmpty() + " (Esperado: true)");

        queue.enqueue(1);
        queue.clear();
        System.out.println("Tamanho após clear: " + queue.size() + " (Esperado: 0)");

        System.out.println();
    }

    private static void testLinkedQueue() {
        System.out.println("Testando LinkedQueue:");
        LinkedQueue queue = new LinkedQueue();

        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        System.out.println("Tamanho após enqueue: " + queue.size() + " (Esperado: 5)");

        System.out.println("Elemento na frente: " + queue.head() + " (Esperado: 1)");

        System.out.println("Elementos removidos:");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("\nTamanho após dequeue: " + queue.size() + " (Esperado: 0)");

        System.out.println("Fila vazia? " + queue.isEmpty() + " (Esperado: true)");

        queue.enqueue(1);
        queue.clear();
        System.out.println("Tamanho após clear: " + queue.size() + " (Esperado: 0)");

        System.out.println();
    }

    private static void testArrayStack() {
        System.out.println("Testando ArrayStack:");
        ArrayStack stack = new ArrayStack();

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println("Tamanho após push: " + stack.size() + " (Esperado: 5)");

        System.out.println("Elemento no topo: " + stack.top() + " (Esperado: 5)");

        System.out.println("Elementos removidos:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nTamanho após pop: " + stack.size() + " (Esperado: 0)");

        System.out.println("Pilha vazia? " + stack.isEmpty() + " (Esperado: true)");

        stack.push(1);
        stack.clear();
        System.out.println("Tamanho após clear: " + stack.size() + " (Esperado: 0)");

        System.out.println();
    }

    private static void testLinkedStack() {
        System.out.println("Testando LinkedStack:");
        LinkedStack stack = new LinkedStack();

        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        System.out.println("Tamanho após push: " + stack.size() + " (Esperado: 5)");

        System.out.println("Elemento no topo: " + stack.top() + " (Esperado: 5)");

        System.out.println("Elementos removidos:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("\nTamanho após pop: " + stack.size() + " (Esperado: 0)");

        System.out.println("Pilha vazia? " + stack.isEmpty() + " (Esperado: true)");

        stack.push(1);
        stack.clear();
        System.out.println("Tamanho após clear: " + stack.size() + " (Esperado: 0)");

        System.out.println();
    }

    private static void testUtils() {
        System.out.println("Testando métodos da classe Utils:");

        QueueTAD queue = new ArrayQueue();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
        QueueTAD reversedQueue = Utils.reverseQueue(queue);
        System.out.println("Fila original: " + queueToString(queue));
        System.out.println("Fila invertida: " + queueToString(reversedQueue));

        StackTAD stack = new ArrayStack();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
        StackTAD reversedStack = Utils.reverseStack(stack);
        System.out.println("Pilha original: " + stackToString(stack));
        System.out.println("Pilha invertida: " + stackToString(reversedStack));

        QueueTAD queueForConversion = new ArrayQueue();
        for (int i = 1; i <= 5; i++) {
            queueForConversion.enqueue(i);
        }
        StackTAD convertedStack = Utils.queueToStack(queueForConversion);
        System.out.println("Fila original: " + queueToString(queueForConversion));
        System.out.println("Pilha convertida: " + stackToString(convertedStack));

        StackTAD stackForConversion = new ArrayStack();
        for (int i = 1; i <= 5; i++) {
            stackForConversion.push(i);
        }
        QueueTAD convertedQueue = Utils.stackToQueue(stackForConversion);
        System.out.println("Pilha original: " + stackToString(stackForConversion));
        System.out.println("Fila convertida: " + queueToString(convertedQueue));
    }

    private static String queueToString(QueueTAD queue) {
        StringBuilder sb = new StringBuilder();
        QueueTAD tempQueue = new ArrayQueue();
        while (!queue.isEmpty()) {
            int element = queue.dequeue();
            sb.append(element).append(" ");
            tempQueue.enqueue(element);
        }
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
        return sb.toString().trim();
    }

    private static String stackToString(StackTAD stack) {
        StringBuilder sb = new StringBuilder();
        StackTAD tempStack = new ArrayStack();
        while (!stack.isEmpty()) {
            int element = stack.pop();
            sb.append(element).append(" ");
            tempStack.push(element);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return sb.toString().trim();
    }
}