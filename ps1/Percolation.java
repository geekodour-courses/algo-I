/******************************************************************************
 *  Compilation:  javac Percolation.java
 *  Execution:  java Percolation < input.txt
 *  Dependencies: StdRandom StdStats QuickFindUF StdOut
 *
 *  Precolation
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {

    private boolean[][] grid;
    private final WeightedQuickUnionUF uf;
    private int openSites;
    private final int size;

    public Percolation(int n) {                 // create n-by-n grid, with all sites blocked
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n*n+2);
        openSites = 0;
        size = n;
    }

    private int encode(int i, int j) {
        return size*(i-1) + j;
    }

    private void validate(int row, int col) {
        if ((row <= 0 || row > size) && (col <= 0 || col > size)) throw new IllegalArgumentException();
    }

    private void connectIfOpen(int row, int col, int rowO, int colO) {
        if ((row > 0 && row <= size) && (col > 0 && col <= size)) {
            if (isOpen(row, col)) {
                uf.union(encode(row, col), encode(rowO, colO));
            }
        }
    }

    public void open(int row, int col) {          // open site (row, col) if it is not open already
        validate(row, col);
        if (!isOpen(row, col)) {
            grid[row-1][col-1] = true;

            connectIfOpen(row-1, col, row, col);
            connectIfOpen(row+1, col, row, col);
            connectIfOpen(row, col-1, row, col);
            connectIfOpen(row, col+1, row, col);

            openSites += 1;

            if (row == 1) {
                uf.union(0, encode(row, col));
            }
            if (row == size) {
                uf.union(size*size+1, encode(row, col));
            }
        }
    }

    public boolean isOpen(int row, int col) {     // is site (row, col) open?
        validate(row, col);
        return grid[row-1][col-1];
    }

    public boolean isFull(int row, int col) {     // is site (row, col) full?
        validate(row, col);
        return uf.connected(0, encode(row, col));
    }

    public int numberOfOpenSites() {              // number of open sites
        return openSites;
    }

    public boolean percolates() {                 // does the system percolate?
        return uf.connected(0, size*size+1);
    }

    public static void main(String[] args) {      // test client (optional)
        Percolation p = new Percolation(1);
        p.open(1, 1);
        StdOut.println(p.percolates());
    }

}
