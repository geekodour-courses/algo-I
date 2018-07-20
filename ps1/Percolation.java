import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.QuickFindUF;

public class Percolation {
    private final QuickFindUF uf[];
    private int num;

    public Percolation(int n){          // create n-by-n grid, with all sites blocked
      uf = new QuickFindUF[n*n + 2];    // +2 for vitual top and bottom
      num = n;
      int i = 0;
      while(i < n){ }
    }

    public void open(int row, int col){       // open site (row, col) if it is not open already
      row = row * num;
      if()
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
    }
}
