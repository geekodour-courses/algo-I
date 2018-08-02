/******************************************************************************
 *  Compilation:  javac WeightedQuickUnionUF.java
 *  Execution:  java WeightedQuickUnionUF < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/15uf/tinyUF.txt
 *                https://algs4.cs.princeton.edu/15uf/mediumUF.txt
 *                https://algs4.cs.princeton.edu/15uf/largeUF.txt
 *
 *  Precolation
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private QuickFindUF uf;
    private int size;
    private int vtop = 0;
    private int vbtm;
    private boolean grid[][];

    private int getIndex(int i, int j){
      return (i-1)*size + j;
    }

    private void validateIndex(int i, int j){
      if(i <= 0 || i > size || j <= 0 || j > size) throw new java.lang.IllegalArgumentException();
    }

    //private void connectIfOpen(int i, int j){
    //  uf.union(i, j);
    //}

    public Percolation(int n){          // create n-by-n grid, with all sites blocked
      uf = new QuickFindUF(n*n + 2);    // +2 for vitual top and bottom
      size = n;
      vbtm = size*size + 1;
      grid = new boolean[n][n];
    }

    public void open(int row, int col){       // open site (row, col) if it is not open already

      // validate row and col
      validateIndex(row, col);
      int index = getIndex(row, col);

      // mark the site as open
      grid[row-1][col-1] = true;


      // if it is in the first row, connect to top
      if (row == 1) { uf.union(index, vtop); }
      if (row == size) { uf.union(index, vbtm); }

      // call uniunion methods

      if( uf.find(getIndex(row, col+1)) == getIndex(row, col+1) ){
      }
      //connectIfOpen(getIndex(row, col+1), index); // right
      //connectIfOpen(getIndex(row, col-1), index); // left
      //connectIfOpen(getIndex(row-1, col), index); // top
      //connectIfOpen(getIndex(row+1, col), index); // bottom
    }

    public boolean isOpen(int row, int col){  // is site (row, col) open?
      //if (i*j <= 0 && i*j > size*size){
      //  throw new java.lang.IllegalArgumentException();
      //}
      return grid[row-1][col-1];
    }

    public boolean isFull(int row, int col){  // is site (row, col) full?
      return uf.connected(vtop, getIndex(row, col));
    }

    public int numberOfOpenSites(){           // number of open sites
      return uf.count();
    }

    public boolean percolates(){              // does the system percolate?
      return uf.connected(vtop, vbtm);
    }

    public void main(String[] args){    // test client (optional)
      Percolation p = new Percolation(3);
      p.open(1,1);
      p.open(1,2);
      StdOut.print(uf.connected(1,2));
      //StdOut.print(p.isFull(1,1));
    }
}
