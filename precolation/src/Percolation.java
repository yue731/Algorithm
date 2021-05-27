import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid; // 0 means blocked and 1 means opened
    private final int n; // len of the grid
    private final WeightedQuickUnionUF ufGrid; // include both virtual top and bottom
    private final WeightedQuickUnionUF ufTop; // include only virtual top, avoid backwash
    private int openSites; // count number of open sites in grid
    private final int virtualTop;
    private final int virtualBottom;
//    private Set<Integer> blocked; // list of blocked sites

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.grid = new boolean[n][n];
        this.n = n;
        this.ufGrid = new WeightedQuickUnionUF(n * n + 2);
        this.ufTop = new WeightedQuickUnionUF(n * n + 1);
        this.openSites = 0;
        this.virtualTop = 0;
        this.virtualBottom = n * n;
//        this.blocked = new HashSet<>();
        // fill in blocked sites
//        for (int i = 0; i < n * n; i++) {
//            blocked.add(i);
//        }
        // union virtual top with top row
//        for (int i = 0; i < n; i++) {
//            uf.union(virtualTop, i);
//        }

        // union virtual bottom with bottom row
//        for (int i = (n - 1) * n; i < n * n; i++) {
//            uf.union(virtualBottom, i);
//        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        // if already open, no action needed
        if (isOpen(row, col)) {
            return;
        }

        openSites++; // increment the open sites count
        grid[row - 1][col - 1] = true; // update to open on grid
//        blocked.remove(idx(row, col)); // remove this site from blocked

        // union top row with virtualTop
        if (row == 1) {
            ufGrid.union(virtualTop, idx(row, col));
            ufTop.union(virtualTop, idx(row, col));
        }

        // union bottom row with virtualBottom
        if (row == n) {
            ufGrid.union(virtualBottom, idx(row, col));
        }

        // check up
        if (row > 1) {
            if (isOpen(row - 1, col)) {
                ufGrid.union(idx(row, col), idx(row - 1, col));
                ufTop.union(idx(row, col), idx(row - 1, col));
            }
        }

        // check down
        if (row < n) {
            if (isOpen(row + 1, col)) {
                ufGrid.union(idx(row, col), idx(row + 1, col));
                ufTop.union(idx(row, col), idx(row + 1, col));
            }
        }

        // check left
        if (col > 1) {
            if (isOpen(row, col - 1)) {
                ufGrid.union(idx(row, col), idx(row, col - 1));
                ufTop.union(idx(row, col), idx(row, col - 1));
            }
        }

        // check right
        if (col < n) {
            if (isOpen(row, col + 1)) {
                ufGrid.union(idx(row, col), idx(row, col + 1));
                ufTop.union(idx(row, col), idx(row, col + 1));
            }
        }


    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException();
        }
        return (ufTop.find(idx(row, col)) == ufTop.find(virtualTop)) && isOpen(row, col);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        if (numberOfOpenSites() == 0) return false;
        return ufGrid.find(virtualTop) == ufGrid.find(virtualBottom);
    }

    // compute the idx of an element given row and col
    private int idx(int row, int col) {
        return (row - 1) * n + col;
    }

    private void printGrid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

//    private void printBlocked() {
//        for (int element : blocked) {
//            System.out.print(element + " ");
//        }
//        System.out.println();
//    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(1, 1);
        p.open(1, 2);
        p.open(1, 4);
        p.open(2, 4);
        p.open(3, 2);
        p.open(3, 4);
        p.open(3, 5);
        p.open(4, 1);
        p.open(4, 3);
        p.open(5, 1);
        p.open(5, 2);
        p.open(5, 4);
        p.open(5, 5);
//        p.open(4, 4);
        p.printGrid();
        System.out.println(p.isFull(2, 4));
        System.out.println(p.isFull(3, 2));
        System.out.println(p.percolates());
//        p.printBlocked();
    }
}
