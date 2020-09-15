package main.basics;

import java.util.*;

public class SampleArrayList<E>  implements List<E> {
    private static int INITIAL_CAPACITY = 16;
    private Object currList[];
    private int count;

    public SampleArrayList() {
        this(INITIAL_CAPACITY);
    }

    public SampleArrayList(int initialCapacity) {
        currList = new Object[initialCapacity];
        count = 0;
    }

    public  SampleArrayList(Collection<? extends E> c) {
        currList = c.toArray();
        count = c.size();

    }


    public boolean add(E element) {
        ensureCapacity(1);
        currList[count] = element;
        count++;
        return true;
    }

    public E get(int index) {
        return (E) currList[index];
    }

    public E set(int index, E element) {
        return null;
    }

    public void add(int index, E element) {

    }

    public void set(E element) {

    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }


    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public Object[] toArray() {
        return Arrays.copyOf(currList, count);
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    private void ensureCapacity(int size) {
        if(count + size  < currList.length) {
            return;
        }
        int expectedSize = 2*(currList.length + size);
        Object tempList[] = new Object[expectedSize];
        System.arraycopy(currList,0, tempList, 0, currList.length);
        currList = tempList;
    }

}
