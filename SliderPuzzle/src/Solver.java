import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {
    private Node currNode;
    //    private MinPQ<Node> pq;
//    private MinPQ<Node> twinPQ;
//    private List<Board> ss;
//    private List<Node> nn;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException("No initial board");
        this.currNode = new Node(null, initial);
        Node twinNode = new Node(null, initial.twin());
        MinPQ<Node> pq = new MinPQ<>();
        MinPQ<Node> twinPQ = new MinPQ<>();
//        this.ss = new ArrayList<>();
//        this.nn = new ArrayList<>();

        pq.insert(currNode);
        twinPQ.insert(twinNode);

        // find solution
        while (true) {
            currNode = pq.delMin();

            twinNode = twinPQ.delMin();
//            nn.add(currNode);
            if (currNode.currBoard.isGoal() || twinNode.currBoard.isGoal()) break;


            for (Board b : currNode.currBoard.neighbors()) {

                if (currNode.prevNode != null && b.equals(currNode.prevNode.currBoard)) continue;
                pq.insert(new Node(currNode, b));


            }
            for (Board b : twinNode.currBoard.neighbors()) {
                if (twinNode.prevNode != null && b.equals(twinNode.prevNode.currBoard)) continue;
                twinPQ.insert(new Node(twinNode, b));
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return currNode.currBoard.isGoal();
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) return -1;
        return currNode.moves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        if (!isSolvable()) return null;
        List<Board> ss = new ArrayList<>();
        Node cur = currNode;
        while (cur != null) {
            ss.add(cur.currBoard);
            cur = cur.prevNode;
        }
        Collections.reverse(ss);
        return ss;
    }

    private class Node implements Comparable<Node> {
        private Node prevNode;
        private Board currBoard;
        private int moves;

        private int manhattan;
        private int priority;

        public Node(Node prevNode, Board currBoard) {
            this.prevNode = prevNode;
            this.currBoard = currBoard;
            if (prevNode == null) {
                this.moves = 0;
            } else {
                this.moves = prevNode.moves + 1;
            }
            this.manhattan = currBoard.manhattan();
            this.priority = this.moves + this.manhattan;
        }

        public int compareTo(Node that) {
            if (this.priority < that.priority) {
                return -1;
            } else if (this.priority == that.priority) {
                return this.manhattan - that.manhattan;
            } else {
                return 1;
            }
        }
    }

    // test client (see below)
    public static void main(String[] args) {

        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }


//        int[][] tiles = {{2, 3, 5}, {1, 0, 4}, {7, 8, 6}};
//        Board initial = new Board(tiles);
//        Solver solver = new Solver(initial);
////        System.out.println(solver.isSolvable());
////        Iterable<Board> list = solver.solution();
////        for (Board b : list) {
////            System.out.println(b.toString());
////        }
//        for (Board b : solver.solution()) {
//            System.out.println(b);
//        }

    }


}
