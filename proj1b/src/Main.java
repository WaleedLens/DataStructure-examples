import org.checkerframework.checker.units.qual.A;

public class Main {

    public static void main(String[] args){

        Deque<Integer> dt = new DequeLinkedArray<>();
        dt.addFirst(4);
        dt.addFirst(4);


        System.out.println(dt.toList().toString());





    }
}
