public class QuickUnionUF {
    private int[] id; // id[i] is the parent of element i, root's parent is the root itself

    public QuickUnionUF(int N) {
        this.id = new int[N];
        // initialize id array with each index
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /*
    find the root of the given element
     */
    private int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /*
    check if p and q are connected by checking if p and q have the same root
     */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /*
    union p and q by updating id of p's root to id of q's root
     */
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        id[rootP] = rootQ; // update id of p's root to id of q's root, root of p becomes a child of root of q
    }

    public void printID() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickUnionUF quuf = new QuickUnionUF(10);
        quuf.union(4, 3);
        quuf.union(3, 8);
        quuf.union(6, 5);
        quuf.union(9, 4);
        System.out.println(quuf.connected(8, 9));
        quuf.union(2, 1);
        quuf.union(5, 0);
        quuf.union(7, 2);
        quuf.union(6, 1);
        quuf.union(7, 3);
        quuf.printID();

    }

}
