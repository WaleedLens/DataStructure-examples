import java.util.ArrayList;
import java.util.List;

public class DequeLinkedArray<T> implements Deque<T> {

    private int size;
    private T[] array;
    private int firstIndex;
    private int lastIndex;

    public DequeLinkedArray() {
        array = (T[]) new Object[8];
        firstIndex = 4; //Init first index [indices]. Assume that we'll start from index 1. If firstIndex = 0 then second first index is last index ( circular ).
        lastIndex = 5; //init last index [indices]
        size = 0;
    }
    @Override
    public void addFirst(T x) {
        if (firstIndex < 0) {
            firstIndex = array.length - 1;
        }
        if (array[firstIndex] == null) { //then fill the field!
            array[firstIndex] = x;
        } else { //Array is full
            //resize
            resize(2);
            firstIndex = array.length - 1;
            lastIndex = size;
            array[firstIndex] = x;
        }

        if (firstIndex < 0) {
            firstIndex = array.length - 1;
        }
        firstIndex = firstIndex - 1;
        size += 1;
    }
    @Override
    public void addLast(T x) {
        if (lastIndex >= array.length) {
            lastIndex = (array.length-1 - (size * 2))-1;
            System.out.println("Last: "+ lastIndex);
        }
        if (array[lastIndex] == null) { //then fill the field!
            array[lastIndex] = x;
        } else { //Array is full
            //resize
            resize(2);
            firstIndex = array.length - 1;
            lastIndex = size;
            array[lastIndex] = x;
        }
        lastIndex = lastIndex + 1;
        size = size + 1;
    }


    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                returnList.add(array[i]);
            }

        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        T temp = array[firstIndex];
        array[0] = null;
        return temp;
    }

    @Override
    public T removeLast() {
        T temp = array[lastIndex];
        array[lastIndex] = null;
        return temp;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity * array.length];
        for (int i = 0; i < size; i++) {
            temp[i] = get(i);
        }
        this.array = temp;
    }

    @Override
    public T get(int index) {

        if (index <= array.length && index >= 0)
            return array[index];
        else
            return null;
    }
}
