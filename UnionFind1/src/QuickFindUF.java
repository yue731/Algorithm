public class QuickFindUF {

    private int[] id;


    /*
    Constructor to initialize id[i] with idx i
     */
    public QuickFindUF(int N) {
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /*
    Check if p and q are connected by checking if they have the same id
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /*
    Connect p and q by updating all elements with id == id[p] to id[q]
     */
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    public void printId() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickFindUF qfuf = new QuickFindUF(10);
        qfuf.union(4, 3);
        qfuf.union(3, 8);
        qfuf.union(6, 5);
        qfuf.union(9, 4);
        System.out.println(qfuf.connected(8, 9));
        qfuf.union(2, 1);
        qfuf.union(5, 0);
        qfuf.union(7, 2);
        qfuf.union(6, 1);
        qfuf.printId();
    }
}
