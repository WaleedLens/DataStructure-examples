import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    void testing(){
        Percolation p = new Percolation(5);
        p.open(0,0);
        p.open(1,0);
        p.open(2,0);
        p.open(3,0);
        p.open(4,0);
        p.open(4,2);

        System.out.println(p.isFull(4,2));
        System.out.println(p.percolates());

    }
}
