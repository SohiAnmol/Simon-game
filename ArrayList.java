/**
 * Anmoldeep Singh
 * 3149800
 */
import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    static int CAPACITY = 4;
    int size;
    Object[] elements;

    ArrayList() {
        this(CAPACITY);
    }

    ArrayList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elements[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        E temp = (E) elements[i];
        elements[i] = e;
        return temp;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            resize(2*size);
        }
        for (int j = size - 1; j >= i; j--) {
            elements[j + 1] = elements[j];
        }
        elements[i] = e;
        size++;
    }

    public void add(E e) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size);
        }
        elements[size] = e;
        size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        E temp = (E) elements[i];
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        elements[size - 1] = null;
        size--;
        return temp;
    }

    private void resize(int newCapacity) {
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            public boolean hasNext() {
                return currentIndex < size && elements[currentIndex] != null;
            }

            public E next() {
                return (E) elements[currentIndex++];
            }
        };
    }

    public boolean equals(Object obj) {
        if (elements == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ArrayList<?> other = (ArrayList<?>) obj;
        return size == other.size && Arrays.equals(elements, other.elements);
    }

}