import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean grids[][];
    private WeightedQuickUnionUF weightedQuickUnionUF;
    private int COLUMNS;
    private int ROWS;

    /*
     TreeGrids represent a tree of grids that have a root.
     */
    private int count; // count number of open sites;

    public Percolation(int N) {
        grids = new boolean[N][N + 2];
        int c = (N * N) + 2;

        weightedQuickUnionUF = new WeightedQuickUnionUF(c);

        COLUMNS = N;
        ROWS = N;
        open(0, N + 1);
        open(ROWS - 1, N + 1);
    }

    public void open(int row, int col) {
        grids[row][col] = true;
        if (col != COLUMNS + 1) {
            count = count + 1;

            boolean top = false;
            boolean left = false;
            boolean right = false;
            boolean bottom = false;

            if (row - 1 >= 0) {
                top = isOpen(row - 1, col);

            }
            if (col - 1 >= 0) {
                left = isOpen(row, col - 1);
            }
            if (col + 1 <= COLUMNS - 1) {
                right = isOpen(row, col + 1);
            }
            if (row + 1 <= ROWS - 1) {
                bottom = isOpen(row + 1, col);
            }

            conductUnion(top, left, right, bottom, row, col);

        }

    }


    private void conductUnion(boolean top, boolean left, boolean right, boolean bottom, int row, int col) {
        int p = xyTo1D(row, col);


        if (row == ROWS - 1 && isFull(row,col)) {
            weightedQuickUnionUF.union(xyTo1D(ROWS - 1, COLUMNS + 1), xyTo1D(ROWS - 1, col));
        } else if (row == 0) {

            weightedQuickUnionUF.union(xyTo1D(0, COLUMNS + 1), xyTo1D(0, col));
        }

        if (top) {
            int q = xyTo1D(row - 1, col);
            weightedQuickUnionUF.union(p, q);
        }
        if (bottom) {
            int q = xyTo1D(row + 1, col);
            weightedQuickUnionUF.union(p, q);
        }
        if (left) {
            int q = xyTo1D(row, col - 1);
            weightedQuickUnionUF.union(p, q);
        }
        if (right) {
            int q = xyTo1D(row, col + 1);
            weightedQuickUnionUF.union(p, q);
        }

    }

    public boolean isOpen(int row, int col) {
        // TODO: Fill in this method.
        return grids[row][col];
    }

    public WeightedQuickUnionUF getWeightedQuickUnionUF() {
        return this.weightedQuickUnionUF;
    }


    public boolean isFull(int row, int col) {
        return weightedQuickUnionUF.connected(xyTo1D(0, COLUMNS + 1), xyTo1D(row, col)) && isOpen(row, col);
    }

    public int numberOfOpenSites() {
        // TODO: Fill in this method.
        return count;
    }

    public boolean percolates() {
        return weightedQuickUnionUF.connected(xyTo1D(0, COLUMNS + 1), xyTo1D(ROWS - 1, COLUMNS + 1));
    }


    public int xyTo1D(int row, int col) {
        /*
            0: 0 1 2 3
            1: 4 5 6 7
            2: 8 9 10 11
            3: 12 13 14 15

         */
        //Rows: 4
        //Cols: 4
        //(Rows)*(Col-4) + columns
        //Ex. 2*(4) + 0= 8 <- take absolute value of result.
        //Ex. 3*4 +0 = 12
        //Ex. 3*4 + 1 = 13
        //Ex. 3*4+2 = 14
        //EX. 1*4 + 2 = 6
        // Our Equation [(Row)*(Col) + columns] is correct !! Congrats...:)

        return (row * (COLUMNS)) + col;
    }

    // TODO: Add any useful helper methods (we highly recommend this!).
    // TODO: Remove all TODO comments before submitting.

}
