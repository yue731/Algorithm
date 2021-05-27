public class WeightedQU {
    private int[] id; // id[i] is the parent of i
    private int[] sz; // sz[i] is the size of the tree at root i

    public WeightedQU(int N) {
        this.id = new int[N];
        this.sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    /*
    compute the root of given element
     */
    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /*
    check if p and q are connected by checking if the root of p and root of q are the same
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /*
    union p and q by linking the smaller tree to the root of the bigger tree
    also update the size accordingly
     */
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        // if rootP and rootQ are the same, no action needed
        if (rootP == rootQ) return;
        if (sz[rootP] < sz[rootQ]) {
            // p is in the smaller tree, connect tree containing p to q
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        } else {
            // q is in the smaller tree, connect tree containing q to p
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        }
    }

    public void printID() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        WeightedQU wqu = new WeightedQU(10);
        wqu.union(4, 3);
        wqu.union(3, 8);
        wqu.union(6, 5);
        wqu.union(9, 4);
        System.out.println(wqu.connected(8, 9));
        wqu.union(2, 1);
        wqu.union(5, 0);
        wqu.union(7, 2);
        wqu.union(6, 1);
        wqu.union(7, 3);
        wqu.printID();
    }
}
