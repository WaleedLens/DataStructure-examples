import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {


    public int size;
    public Node node;

    public LinkedListDeque() {

        this.node = new Node(null, null, null, 0); // <-- Init Sentinel node
    }

    @Override
    public void addFirst(T x) {

        if (node.next == null) {
            node.next = new Node(node.next, node, x, node.index + 1);
        } else {
            Node temp = node.next;
            node.next = new Node(node.next, node, x, node.index + 1);
            temp.prev = node.next;
        }
        size += 1;

    }

    @Override
    public void addLast(T x) {
        Node temp = node;
        if (temp.prev == null) {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(null, temp, x, temp.index + 1);
            node.prev = temp.next;
        } else {

            temp.prev.next = new Node(null, node, x, temp.prev.index + 1);
            temp.prev.next.prev = temp.prev;
            temp.prev.next.next = node;

            node.prev = temp.prev.next;
        }
        size += 1;
    }

    @Override
    public List<T> toList() {
        if (isEmpty()) {
            System.out.println("--1");
            return null;
        } else {
            List<T> tempList = new ArrayList<>();
            Node temp = node.next;
            int i = 0;
            while (i < size) {
                tempList.add(temp.value);
                temp = temp.next;
                i++;
            }
            return tempList;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        Node temp = node.next; //to be deleted
        T tempDeleted = temp.value;
        if(temp.next == null) {
            node.next = null; //empty list
        }else {
            temp.next.prev = node;
            node.next = temp.next;
        }
        size +=-1;
        return tempDeleted; //Returns first item
    }

    @Override
    public T removeLast() {
        Node temp = node.prev.prev;
        T tempDeleted = node.prev.value;
        node.prev.prev.next = null;
        temp.next = node;
        node.prev = temp;
        size +=-1;
        return tempDeleted; //Returns last item
    }

    @Override
    public T get(int index) {
        Node temp = node.next;
        int tempIndex = 0;
        while (temp != null) {
            if (tempIndex == index) {
                return temp.value;
            }
            tempIndex += 1;
            temp = temp.next;

        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return getRecursive(index, node);
    }

    public T getRecursive(int index, Node n) {
        if (index == n.index - 1) {
            return n.value;
        }
        if (n.next == null)
            return null;


        return getRecursive(index, n.next);
    }

    private class Node {
        public Node next;
        public Node prev;
        public T value;
        public int index;

        public Node(Node next, Node prev, T value, int index) {
            this.next = next;
            this.prev = prev;
            this.value = value;
            this.index = index;
        }
    }


}
