import java.util.ArrayList;
import java.util.List;

public class Board {
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)

    private final int[][] tiles;
    private final int N;

    public Board(int[][] tiles) {
        this.N = tiles.length;
        this.tiles = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                this.tiles[i][j] = tiles[i][j];
            }
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(N).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(String.format("%2d ", tiles[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // board dimension n
    public int dimension() {
        return N;
    }

    // given row and column, return the index of goal board
    private int index(int i, int j) {
        if (i == N - 1 && j == N - 1) {
            return 0;
        }
        return i * N + j + 1;
    }

    // number of tiles out of place
    public int hamming() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int index = index(i, j); // index of goal board at (i, j)
                if (index != 0 && index != tiles[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int distance = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tiles[i][j] != 0) {
                    int goalRow = (tiles[i][j] - 1) / N;
                    int goalCol = (tiles[i][j] - 1) % N;
                    distance += manhattanDis(i, j, goalRow, goalCol);
                }
            }
        }

        return distance;

    }

    // compute the manhattan distance between tiles[a][b] and tiles[c][d]
    private int manhattanDis(int a, int b, int c, int d) {
        return Math.abs(c - a) + Math.abs(d - b);
    }

    // is this board the goal board?
    public boolean isGoal() {
        return manhattan() == 0;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        // https://www.geeksforgeeks.org/overriding-equals-method-in-java/
        if (this == y) return true;
        if (!(y instanceof Board)) return false;

        Board b = (Board) y;
        return this.toString().equals(b.toString());

    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        List<Board> list = new ArrayList<>();
        // find the empty tile
        int row = -1;
        int col = -1;
        boolean findEmpty = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tiles[i][j] == 0) {
                    row = i;
                    col = j;
                    findEmpty = true;
                    break;
                }
            }
            if (findEmpty) break;
        }
        if (row >= 1) {
//            System.out.println(this.toString());
            int[][] neighbor = copyTiles();

            swap(neighbor, row, col, row - 1, col);
            Board b = new Board(neighbor);
            list.add(b);
        }
        if (row < N - 1) {
//            System.out.println(this.toString());
            int[][] neighbor = copyTiles();
            swap(neighbor, row, col, row + 1, col);
            Board b = new Board(neighbor);
            list.add(b);
        }
        if (col >= 1) {
//            System.out.println(this.toString());
            int[][] neighbor = copyTiles();
            swap(neighbor, row, col, row, col - 1);
            Board b = new Board(neighbor);
            list.add(b);
        }
        if (col < N - 1) {
//            System.out.println(this.toString());
            int[][] neighbor = copyTiles();
            swap(neighbor, row, col, row, col + 1);
            Board b = new Board(neighbor);
            list.add(b);
        }
        return list;

    }

    private static void swap(int[][] neighbor, int a, int b, int c, int d) {
        int temp = neighbor[a][b];
        neighbor[a][b] = neighbor[c][d];
        neighbor[c][d] = temp;
    }

    private int[][] copyTiles() {
        int[][] neighbor = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                neighbor[i][j] = tiles[i][j];
            }
        }
        return neighbor;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[][] bb = copyTiles();
        int a = -1;
        int b = -1;
        int c = -1;
        int d = -1;
        int found = 0;
        for (int i = 0; i < N; i++) {
            if (found == 2) break;
            for (int j = 0; j < N; j++) {
                if (bb[i][j] != 0) {
                    if (a == -1 && b == -1) {
                        a = i;
                        b = j;
                    } else {
                        c = i;
                        d = j;
                    }
                    found++;
                }
                if (found == 2) break;
            }
        }
        swap(bb, a, b, c, d);
        return new Board(bb);
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] tiles = {{1, 0, 3}, {4, 2, 5}, {7, 8, 6}};
        Board b = new Board(tiles);
        Iterable<Board> list = b.neighbors();
        for (Board bb : list) {
            System.out.println(bb.toString());
        }

    }
}
