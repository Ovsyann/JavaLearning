package Nobilis.Training.DataStructures;

import java.util.*;

public class MyArrayList<T> extends AbstractList<T> implements List<T> {
    private int size;
    private Object[] innerArray;

    public MyArrayList(int capacity){
        innerArray = new Object[capacity];
    }

    private Object[] grow(int minCapacity){

        if(innerArray.length > 0){
            int newCapacity = innerArray.length >> 1;
            innerArray = Arrays.copyOf(innerArray, newCapacity);
        }
        else {
            innerArray = new Object[Math.max(10, size + 1)];
        }

        return innerArray;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return  size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(innerArray, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {

        if(a.length < size){
            return (T1[])Arrays.copyOf(innerArray, size, a.getClass());
        }
        else{
            System.arraycopy(innerArray, 0, a, 0, size);
        }

        if(a.length > size){
            a[size] = null;
        }

        return a;
    }

    @Override
    public boolean add(T t) {

        if(innerArray.length == size){
            innerArray = grow(size + 1);
        }

        innerArray[size] = t;
        size++;

        return true;
    }

    @Override
    public void add(int index, T element) {

        Objects.checkIndex(index, size);
        if(innerArray.length == size){
            innerArray = grow(size + 1);
        }

        System.arraycopy(innerArray, index, innerArray, index + 1,  size - index);

        innerArray[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            for(int i = 0; i < size; i++){
                if(innerArray[i] == null){
                    return true;
                }
            }
        }
        else{
            for(int i = 0; i < size; i++){
                if(o.equals(innerArray[i])){
                    return true;
                }
            }
        }

        return false;
    }

    private void fastRemove(int index){

        int newSize = size - 1;
        if(newSize > index){
            System.arraycopy(innerArray, index + 1, innerArray, index,newSize - index);
            innerArray[size = newSize] = null;
        }
    }



    @Override
    public boolean addAll(Collection<? extends T> c) {

        int collectionSize = c.size();
        if(collectionSize == 0){
            return false;
        }

        if(collectionSize > innerArray.length - size){
            grow(size + collectionSize);
        }

        System.arraycopy(c, 0, innerArray, size, collectionSize);
        size += collectionSize;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        int collectionSize = c.size();
        if(collectionSize == 0){
            return false;
        }

        if(collectionSize > innerArray.length - size){
            grow(size + collectionSize);
        }

        int moveCount = size - index;
        System.arraycopy(innerArray, index, innerArray, index + collectionSize, moveCount);
        System.arraycopy(c, 0, innerArray, index, collectionSize);
        size += collectionSize;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return batchRemove(c, false, 0, size);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    boolean batchRemove(Collection<?> c, boolean complement,
                        final int from, final int end){

        int i = from;
        int startIndex = from;
        int endIndex = end;
        for(i = from; i < end; i++){
            if(c.contains(innerArray[i]) != complement){
                startIndex = i;
                break;
            }
        }
        if(i == end){
            return false;
        }
        for (i++; i < end; i++){
            if(c.contains(innerArray[i]) == complement){
                endIndex = i;
                break;
            }
        }

        shiftTailOverGap(innerArray, startIndex, endIndex);
        return true;
    }

    private void shiftTailOverGap(Object[] es, int start, int end) {
        System.arraycopy(es, end, es, start, size - end);
        for (int to = size, i = (size -= end - start); i < to; i++)
            es[i] = null;
    }

    @Override
    public void clear() {
        Arrays.fill(innerArray, null);
        size = 0;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T)innerArray[index];
    }

    @Override
    public T remove(int index) {

        Objects.checkIndex(index,size);
        T obj = (T)innerArray[index];
        fastRemove(index);

        return obj;
    }

    @Override
    public int indexOf(Object o) {
        return indexOfRange(o, 0, innerArray.length);
    }

    private int indexOfRange(Object objectToFind, int start, int end){

        if(objectToFind == null){
            for(int i = start; i < end; i++){
                if(innerArray[i] == null){
                    return i;
                }
            }
        }
        else{
            for(int i = start; i < end; i++){
                if(objectToFind.equals(innerArray[i])){
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return lastIndexOfRange(o, 0, innerArray.length);
    }

    private int lastIndexOfRange(Object objectToFind, int start, int end){

        if(objectToFind == null){
            for(int i = end - 1; i >= start; i--){
                if(innerArray[i] == null){
                    return i;
                }
            }
        }
        else{
            for(int i = end - 1; i >= start; i--){
                if(objectToFind.equals(innerArray[i])){
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private class MyIterator implements Iterator<T>{

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {

            if (cursor >= size)
                throw new NoSuchElementException();

            cursor++;

            return (T)(MyArrayList.this.innerArray[cursor - 1]);
        }
    }
}
