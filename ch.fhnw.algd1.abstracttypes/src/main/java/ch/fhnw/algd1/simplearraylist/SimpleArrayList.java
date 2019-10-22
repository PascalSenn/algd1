package ch.fhnw.algd1.simplearraylist;

import java.util.AbstractList;
import java.util.List;

public class SimpleArrayList<E> extends AbstractList<E> implements List<E> {
    private static final int MIN_ARRAY_LEN = 16;
    private Object[] arr = new Object[MIN_ARRAY_LEN];
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) arr[index];
    }

    @Override
    public E set(int index, E element) {
        E old = get(index); // includes index checking
        arr[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (arr.length - 1 == size) {
            this.resizeArray(size + MIN_ARRAY_LEN);
        }
        var counter = size;
        while (counter > index) {
            arr[counter] = arr[counter - 1];
            counter--;
        }
        arr[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        E old = get(index); // includes index checking
        while (index + 1 < size) {
            arr[index] = arr[index + 1];
            index++;
        }
        size--;
        arr[size] = null;
        if (arr.length - MIN_ARRAY_LEN > size) {
            resizeArray(arr.length - MIN_ARRAY_LEN);
        }
        return old;
    }

    private void resizeArray(int newSize) {
        var tempArray = new Object[newSize];
        var index = 0;
        while (index < arr.length && index < tempArray.length) {
            tempArray[index] = arr[index];
            index++;
        }
        arr = tempArray;
    }
}
