import java.util.Arrays;

public class AList<T> {
    private static int REFACTOR = 2;
    T[] items;
    int size;

    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }


    public T[] resize(int capacity) {
        T[] temp = (T[]) new Object[capacity*items.length];
       System.arraycopy(items,0,temp,0,size);

        return temp;
    }

    public void addLast(T x) {
        if (size == items.length) {
            items = resize(REFACTOR);
        }

        items[size] = x;
        size += 1;

    }

    public void addFirst(T x) {
        T[] temp = (T[]) new Object[items.length];
        temp[0] = x;
        System.arraycopy(items,0,temp,1,size);
        this.items = temp;
        size +=1;
    }


    public T getLast(){
        return items[size];
    }

    public T removeLast(){
        T tempDeleted = items[size];
        items[size] = null;
        size -=1;
        return tempDeleted;
    }

}

