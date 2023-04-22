import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    void testing(){
        Percolation p = new Percolation(5);
       p.open(0,0);
        p.open(1,0);
        p.open(2,0);
        p.open(3,0);
        p.open(3,1);
        p.open(3,3);
        p.open(3,2);
        System.out.println(p.getWeightedQuickUnionUF().connected(p.xyTo1D(0,0),p.xyTo1D(1,0)));
        System.out.println(p.isFull(3,3));

    }
}
