import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class PercolationStats {
  private int _trials;
  private double tresholds[];

  public PercolationStats(int n, int trials){    // perform trials independent experiments on an n-by-n grid
    if(n <= 0 || trials <= 0){ throw new IllegalArgumentException(); }
    _trials = trials;
    int x,y;
    tresholds = new double[trials];

    for(int i=0;i<trials;i++){
      StdOut.println(i);
      Percolation p = new Percolation(n);
      while(!p.percolates()){
        x = StdRandom.uniform(1,n+1);
        y = StdRandom.uniform(1,n+1);
        if(p.isOpen(x,y)){ continue; }
        p.open(x,y);
      }
      tresholds[i] = (double) p.numberOfOpenSites() / (n*n);
    }
  }

  public double mean(){                          // sample mean of percolation threshold
    return StdStats.mean(tresholds);
  }

  public double stddev(){                        // sample standard deviation of percolation threshold
    return StdStats.stddev(tresholds);
  }

  public double confidenceLo(){                  // low  endpoint of 95% confidence interval
    return mean()-(1.96*stddev()/Math.sqrt(_trials));
  }

  public double confidenceHi(){                  // high endpoint of 95% confidence interval
    return mean()+(1.96*stddev()/Math.sqrt(_trials));
  }

  public static void main(String[] args){        // test client (described below)
    int n = Integer.parseInt(args[0]);
    int t = Integer.parseInt(args[1]);
    PercolationStats p = new PercolationStats(n,t);
    StdOut.println("mean                    ="+p.mean());
    StdOut.println("stddev                  ="+p.stddev());
    StdOut.println("95% confidence interval = ["+p.confidenceLo()+", "+p.confidenceHi()+"]");
  }
}
