import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private QuickFindUF uf;
    private int size;

    private int getIndex(int i, int j){
      return (i-1)*size + (j-1);
    }

    public Percolation(int n){          // create n-by-n grid, with all sites blocked
      uf = new QuickFindUF(n*n + 2);    // +2 for vitual top and bottom
      size = n;
      int i = 0;
    }

    public void open(int row, int col){       // open site (row, col) if it is not open already
      int index = getIndex(row, col);
      StdOut.print(index);
      // row = row * size;
      // connect to left if left is open
      // connect to right if right is open
      // connect to top if top is open
      // connect to bottom if bottom is open
    }

    public boolean isOpen(int row, int col){  // is site (row, col) open?
      //return uf.connected(row, col);
      return true;
    }

    public boolean isFull(int row, int col){  // is site (row, col) full?
      return true;
    }

    public int numberOfOpenSites(){           // number of open sites
      return 2;
    }

    public boolean percolates(){              // does the system percolate?
      return true;
    }

    public static void main(String[] args){    // test client (optional)
      Percolation p = new Percolation(3);
      p.open(2,3);
    }
}
