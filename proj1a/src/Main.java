public class Main {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedListDeque<>();


        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);


        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list.toList());

    }
}
