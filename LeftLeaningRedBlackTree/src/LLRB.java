public class LLRB<Key extends Comparable<Key>, Val> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Val val;
        private Node left;
        private Node right;
        private boolean color; // color of the parent link

        public Node(Key key, Val val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    private Node root;

    private boolean isRed(Node curr) {
        // check if the node's parent link is red
        if (curr == null) return false; // null links are black
        return curr.color == RED;
    }

    public Val get(Key key) {
        Node curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.key);
            if (cmp < 0) curr = curr.left;
            else if (cmp > 0) curr = curr.right;
            else return curr.val;
        }
        return null;
    }

    private Node rotateLeft(Node h) {
        // rotate (left) of h and h.right
        // h.right will then be on the top and h will be on the left of h.right
        // relink and update color
        Node x = h.right;
        assert isRed(x);
        // relink
        h.right = x.left;
        x.left = h;
        // update color
        x.color = h.color;
        h.color = RED;
        return x;

    }

    private Node rotateRight(Node h) {
        // rotate (right) of h.left and h
        // h.left then be on the top, and h will be on the right of h.left
        // relink and update color
        Node x = h.left;
        assert isRed(x);
        // relink
        h.left = x.right;
        x.right = h;
        // update color
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        // recolor to split a temporary 4-node h
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node put(Node h, Key key, Val val) {
        if (h == null) return new Node(key, val, RED); // insert at bottom and color red
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h); // right child red and left child black, rotate left
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h); // left child and left-left grandchild red, rotate right
        if (isRed(h.left) && isRed(h.right)) flipColors(h); // both children red, flip color (split 4-node)

        return h;

    }


}
