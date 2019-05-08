package br.univali.kob.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Class that represents a row.
 * @param <T>: Generic value for the elements row.
 */
public class Queue<T> {
    private Object[] elements;
    private int first;
    private int last;
    private int cardinality;
    private int size;

    /**
     * Class default constructor.
     * @param size: int with the size of the row.
     */
    public Queue(int size) {
        this.size = size;
        this.elements = new Object[this.size];
        this.first = -1;
        this.last = -1;
    }

    /**
     * Get the elements on the row (array).
     * @return Object[] with the elements on the row.
     */
    public Object[] getElements() {
        return this.elements;
    }

    /**
     * Check if the row is empty.
     * @return boolean if the row is empty return true if not return false.
     */
    public boolean isEmpty() {
        return (this.first == this.last);
    }

    /**
     * Check if the row has space.
     * @return boolean true if has space and false if not.
     */
    public boolean hasSpace() {
        return (this.cardinality < this.size);
    }

    /**
     * Get the queue total.
     * @return int with the total of elements on the row.
     */
    public int queueTotal() {
        return this.cardinality;
    }

    /**
     * Check if the element is on the list, by the object passed for reference.
     * @param obj: Object reference that will be search on the list.
     * @return boolean true is the element is on the list and false if not.
     */
    public boolean isOnQueue(Object obj) {
        for (int i = 0; i < this.cardinality; i++) {
            if (this.elements[i].equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the index passed is a valid position on the row.
     * @param index: int with the value of index that will be checked.
     * @return boolean true is the position is valid and false if not.
     */
    public boolean isValidPosition(int index) {
        return (index <= this.size);
    }

    /**
     * Get the element on the row by the index.
     * @param index: int with the index of the element that will be get.
     * @return Object reference for the element on the given index.
     */
    public Object getElement(int index) {
        if (!isValidPosition(index)) { return null; }

        int loop = 0;
        for (int i = (this.first + 1); loop < this.cardinality; i++) {
            if (i == index) {
                return this.elements[i];
            }
            if (i == this.cardinality) { i = 0; }
            loop++;
        }
        return null;
    }

    /**
     * Get the element index that is inside on the row (return -1 if the element is not on the row).
     * @param obj: Object reference that will be search on the row.
     * @return int with the index of the element on the row (return -1 if the element is not on the row).
     */
    public int getElementRowPosition(Object obj) {
        int index = 0;
        for (int i = (this.first + 1); index < this.cardinality; i++) {
            if (this.elements[i].equals(obj)) {
                return index + 1;
            }
            if (i == this.cardinality) { i = 0; }
            index++;
        }
        return -1;
    }

    /**
     * Get the first element on the row.
     * @return Object reference for the last element on the row.
     */
    public Object getFirstElement() { return this.elements[this.first + 1]; }

    /**
     * Get the last element on the row.
     * @return Object reference for the last element on the row.
     */
    public Object getLastElement() {
        return this.elements[this.last];
    }

    /**
     * Insert a element on the row.
     * @param obj: Object that will be inserted on the row.
     */
    public void insert(Object obj) throws ArrayIndexOutOfBoundsException {
        if (this.cardinality != this.size) {
            if ((this.last + 1) == this.size) {
                this.last = 0;
            } else {
                this.last++;
            }
            this.elements[this.last] = obj;
            this.cardinality++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Overflow!");
        }
    }

    /**
     * Remove a element on the row.
     */
    public void remove() throws IllegalArgumentException {
        if (this.cardinality != 0) {
            if ((this.first + 1) == this.size) {
                this.first = 0;
            } else {
                this.first++;
            }
            // obj = this.elements[this.first];
            this.cardinality--;
        } else {
            throw new IllegalArgumentException("Underflow!");
        }
    }

    /**
     * Print the row elements.
     */
    public void print() {
        System.out.print("{ ");
        int index = 0;
        for (int i = (this.first + 1); index < this.cardinality;) {
            System.out.print(this.elements[i]);
            i++;
            if (i < this.size && index < this.cardinality) { System.out.print(" --> "); }
            if (i == this.size) { i = 0; }
            index++;
        }
        System.out.print(" }");
        System.out.println();
    }

    /**
     * Convert a Object for the class type of the List<T>
     * @param o: the object tha will be converted.
     * @param clazz: the class that the object wil be converted.
     * @param <T>: type of the class will be converted.
     * @return element Object converted to the type of class passed.
     */
    public static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch(ClassCastException e) {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queue<?> queue = (Queue<?>) o;
        return first == queue.first &&
                last == queue.last &&
                cardinality == queue.cardinality &&
                size == queue.size &&
                Arrays.equals(elements, queue.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(first, last, cardinality, size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}

