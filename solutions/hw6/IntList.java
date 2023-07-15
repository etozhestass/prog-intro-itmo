package hw6;

import java.util.Arrays;

public class IntList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;

    public IntList() {
        elements = new int[DEFAULT_CAPACITY];
    }

    public void add(int num) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = num;
    }

    @SuppressWarnings("unchecked")
    public int get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size" + i);
        }
        return (int) elements[i];
    }

    @SuppressWarnings("unchecked")
    public int remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - (i + 1);
        System.arraycopy(elements, i + 1, elements, i, numElts);
        size--;
        return (int) item;
    }

    @SuppressWarnings("unchecked")
    public void changeLast(int num) {
        remove(size - 1);
        add(num);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(String.valueOf(elements[i]));
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String toPairs() {
        if (size % 2 == 1) throw new ArrayIndexOutOfBoundsException("This is not List of Pairs");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i += 2) {
            sb.append(elements[i]);
            sb.append(':');
            sb.append(elements[i + 1]);
            if (i < size - 2) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}