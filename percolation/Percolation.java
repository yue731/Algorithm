/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[] site;
    private final int size;
    private final WeightedQuickUnionUF uf;
    private boolean[] connectTop;
    private boolean[] connectBottom;
    private int numerOfOpenSites = 0;
    private boolean percolationFlag = false;

    public Percolation(int n) {
        validate(n);
        this.size = n;
        this.uf = new WeightedQuickUnionUF(n * n);
        this.site = new boolean[n * n];
        this.connectTop = new boolean[n * n];
        this.connectBottom = new boolean[n * n];
    }

    public void open(int row, int col) {
        validate(row, col);
        int index = xyTo1D(row, col);
        if (!site[index]) {
            site[index] = true;
            numerOfOpenSites++;
        }
        boolean topFlag = false;
        boolean bottomFlag = false;

        if (row == 1) {
            topFlag = true;
        }
        if (row == size) {
            bottomFlag = true;
        }
        // connect with down site
        if (row < size && site[index + size]) {

        }

    }

    private void validate(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int row, int col) {
        if (row <= 0 || row > size || col <= 0 || col > size) {
            throw new IllegalArgumentException();
        }
    }

    private int xyTo1D(int row, int col) {
        // convert coefficient to index of 1D
        validate(row, col);
        return size * (row - 1) + col - 1;
    }

    public static void main(String[] args) {

    }
}
