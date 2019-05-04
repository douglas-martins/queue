package br.univali.kob.test;

import br.univali.kob.model.Queue;

import java.util.Random;

public class QueueTestCase {
    private static final int MAX = 10;
    private Queue<Integer> queue = new Queue<>(MAX);

    public static void main(String[] args) {
        System.out.println("########## QUEUE CLASS TESTS CASE ##########");
        System.out.println();
        System.out.println();

        QueueTestCase testCase = new QueueTestCase();

        // insert() test case
        testCase.insertTestCase(MAX);
        System.out.println();
        System.out.println();

        // isEmpty() test case
        testCase.isEmptyTestCase();
        System.out.println();
        System.out.println();

        // print() test case
        testCase.printTestCase();
        System.out.println();
        System.out.println();

        // hasSpace() test case
        testCase.hasSpaceTestCase();
        System.out.println();
        System.out.println();

        // rowTotal() test case
        testCase.queueTotalTestCase();
        System.out.println();
        System.out.println();

        // isOnRow() test case
        testCase.isOnQueueTestCase(8);
        System.out.println();
        System.out.println();

        // isValidPosition() test case
        testCase.isValidPositionTestCase(11);
        System.out.println();
        System.out.println();

        // getElement() test case
        testCase.getElementTestCase(3);
        System.out.println();
        System.out.println();

        // getElementRowPosition() test case
        testCase.getElementQueuePositionTestCase(5);
        System.out.println();
        System.out.println();

        // getFirstElement() test case
        testCase.getFirstElementTestCase();
        System.out.println();
        System.out.println();

        // getLastElement() test case
        testCase.getLastElementTestCase();
        System.out.println();
        System.out.println();

        // remove() test case
        testCase.removeTestCase();
        System.out.println();
        System.out.println();

        // remove() test case
        testCase.removeTestCase();
        System.out.println();
        System.out.println();


        // remove() test case
        testCase.removeTestCase();
        System.out.println();
        System.out.println();

        // insert() one test case
        testCase.insertOneTestCase();
        System.out.println();
        System.out.println();


        // insert() one test case
        testCase.insertOneTestCase();
        System.out.println();
        System.out.println();

        System.out.println("########## QUEUE CLASS TESTS CASE ##########");

    }

    public void isEmptyTestCase() {
        System.out.println("========== IS EMPTY TEST CASE ==========");
        System.out.println("Queue is empty? " + this.queue.isEmpty());
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== IS EMPTY TEST CASE ==========");
    }

    public void printTestCase() {
        System.out.println("========== PRINT TEST CASE ==========");
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== PRINT TEST CASE ==========");
    }

    public void hasSpaceTestCase() {
        System.out.println("========== HAS SPACE TEST CASE ==========");
        System.out.println("Queue has space? " + this.queue.hasSpace());
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== HAS SPACE TEST CASE ==========");
    }

    public void queueTotalTestCase() {
        System.out.println("========== ROW TOTAL TEST CASE ==========");
        System.out.println("Queue total is =  " + this.queue.rowTotal());
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== ROW TOTAL TEST CASE ==========");
    }

    public void isOnQueueTestCase(Object obj) {
        System.out.println("========== IS ON QUEUE TEST CASE ==========");
        System.out.println(obj.toString());
        System.out.println("Object is on the queue? " + this.queue.isOnRow(obj));
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== IS ON QUEUE TEST CASE ==========");
    }

    public void isValidPositionTestCase(int index) {
        System.out.println("========== IS VALID POSITION TEST CASE ==========");
        System.out.println("Position checked = " + index);
        System.out.println("Is a valid position on the queue? " + this.queue.isValidPosition(index));
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== IS VALID POSITION TEST CASE ==========");
    }

    public void getElementTestCase(int index) {
        System.out.println("========== GET ELEMENT TEST CASE ==========");
        Object obj = this.queue.getElement(index);
        if (obj != null) {
            System.out.println("The element in position " + index + " is = " + obj.toString());
        } else {
            System.out.println("The position given is not valid!");
        }
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== GET ELEMENT TEST CASE ==========");
    }

    public void getElementQueuePositionTestCase(Object obj) {
        System.out.println("========== GET ELEMENT ROW POSITION TEST CASE ==========");
        int result = this.queue.getElementRowPosition(obj);
        if (result >= 0) {
            System.out.println("The object position on the queue is = " + result);
        } else {
            System.out.println("The object is not on the queue!");
        }
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== GET ELEMENT QUEUE POSITION TEST CASE ==========");
    }

    public void getFirstElementTestCase() {
        System.out.println("========== GET ELEMENT FIRST ELEMENT TEST CASE ==========");
        System.out.println("First element on the queue is = " + this.queue.getFirstElement());
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== GET ELEMENT FIRST ELEMENT TEST CASE ==========");
    }

    public void getLastElementTestCase() {
        System.out.println("========== GET ELEMENT LAST ELEMENT TEST CASE ==========");
        System.out.println("Last element on the queue is = " + this.queue.getLastElement());
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== GET ELEMENT LAST ELEMENT TEST CASE ==========");
    }

    public void insertTestCase(int max) {
        System.out.println("========== INSERT TEST CASE ==========");
        for (int i = max; i > 0; i--) {
            Object obj = i;
            System.out.println("Try to insert " + obj.toString() + " on the queue....");
            this.queue.insert(obj);
        }
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== INSERT TEST CASE ==========");
    }

    public void insertOneTestCase() {
        Object obj = new Random().nextInt(10);
        System.out.println("========== INSERT TEST CASE ==========");
        System.out.println("Try to insert " + obj.toString() + " on the queue....");
        this.queue.insert(obj);
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== INSERT TEST CASE ==========");
    }

    public void removeTestCase() {
        System.out.println("========== REMOVE TEST CASE ==========");
        System.out.println("Try to remove a element from the queue..." );
        this.queue.remove();
        System.out.print("Queue = ");
        this.queue.print();
        System.out.println("========== REMOVE TEST CASE ==========");
    }
}
