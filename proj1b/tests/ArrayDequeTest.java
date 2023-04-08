import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {
    @Test
    public void isEmptyTest(){
        Deque<Integer> list = new DequeLinkedArray<>();

        assertThat(list.isEmpty()).isEqualTo(true);
    }
    @Test
    public void sizeTest(){
        Deque<Integer> list = new DequeLinkedArray<>();
        list.addFirst(4);
        list.addFirst(12);
        list.addFirst(234);
        list.addFirst(13);
        list.addFirst(234);
        list.addFirst(13);
list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);
        list.addLast(12);

        assertThat(list.size()).isEqualTo(16);
    }

    @Test
    public void getTestLargeNumber(){
        Deque<Integer> list = new DequeLinkedArray<>();
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        assertThat(list.get(1234)).isEqualTo(null);
    }

    @Test
    public void getTestNegativeNumber(){
        Deque<Integer> list = new DequeLinkedArray<>();
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        assertThat(list.get(-4)).isEqualTo(null);
    }

    @Test
    public void removeFirstTest(){
        Deque<Integer> list = new DequeLinkedArray<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeFirst();
        assertThat(list.toList()).containsExactly(2,3);

    }

    @Test
    void getTest(){
        Deque<Integer> list = new DequeLinkedArray<>();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);

        assertThat(list.get(0)).isEqualTo(3);
    }
    @Test
    void outOfIndexGetTest(){
        Deque<Integer> list = new DequeLinkedArray<>();
     //   list.addFirst(1);
     //   list.addFirst(4);

        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addFirst(3);
        list.addLast(1);
        list.addLast(1);
        list.addFirst(3);

        System.out.println(list.toList().toString());
        assertThat(list.get(9)).isEqualTo(null);
    }

}
