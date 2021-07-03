import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int count;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node curr, Key key, Value val) {
        // exit
        if (curr == null) return new Node(key, val);
        // curr level processing
        int cmp = key.compareTo(curr.key);
        if (cmp < 0) {
            curr.left = put(curr.left, key, val);
        } else if (cmp > 0) {
            curr.right = put(curr.right, key, val);
        } else {
            curr.val = val;
        }
        curr.count = 1 + size(curr.left) + size(curr.right);
        // return
        return curr;
    }

    public Value get(Key key) {
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) {
                curr = curr.left;
            } else if (cmp > 0) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return null;
    }

    public Key floor(Key key) {
        // find the largest key <= key
        Node n = floor(root, key);
        if (n == null) return null;
        return n.key;
    }

    private Node floor(Node curr, Key key) {
        if (curr == null) return null;
        int cmp = key.compareTo(curr.key);
        if (cmp == 0) return curr;
        if (cmp < 0) return floor(curr.left, key);
        Node temp = floor(curr.right, key);
        return temp == null ? curr : temp;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node curr, Key key) {
        if (curr == null) return null;

        int cmp = key.compareTo(curr.key);
        if (cmp < 0) curr.left = delete(curr.left, key);
        else if (cmp > 0) curr.right = delete(curr.right, key);
        else {
            if (curr.right == null) return curr.left;
            if (curr.left == null) return curr.right;

            Node temp = curr;
            curr = min(temp.right); // min from right sub-tree
            curr.right = deleteMin(temp.right);
            curr.left = temp.left; // relink


        }
        curr.count = 1 + size(curr.left) + size(curr.right);

        return curr;
    }

    private Node min(Node curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public Iterable<Key> iterator() {
        Queue<Key> q = new Queue<>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node curr, Queue<Key> q) {
        if (curr == null) return;
        inorder(curr.left, q);
        q.enqueue(curr.key);
        inorder(curr.right, q);
    }

    public int size() {
        return size(root);
    }

    private int size(Node curr) {
        if (curr == null) return 0;
        return curr.count;
    }

    public int rank(Key key) {
        // how many keys < k
        return rank(root, key);
    }

    private int rank(Node curr, Key key) {
        if (curr == null) return 0;
        int cmp = key.compareTo(curr.key);
        if (cmp == 0) return size(curr.left);
        else if (cmp < 0) return rank(curr.left, key);
        else return 1 + size(curr.left) + rank(curr.right, key);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node curr) {
        // exit
        if (curr.left == null) return curr.right;
        // curr level processing
        curr.left = deleteMin(curr.left);
        curr.count = 1 + size(curr.left) + size(curr.right);
        // return
        return curr;

    }


}
