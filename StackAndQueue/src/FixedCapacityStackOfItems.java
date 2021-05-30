import java.util.Iterator;

public class FixedCapacityStackOfItems<Item> implements Iterable<Item> {
    private Item[] s;
    private int N;

    public FixedCapacityStackOfItems(int capacity) {
        this.s = (Item[]) new Object[capacity];
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        s[N++] = item;
    }

    public Item pop() {
        Item item = s[--N];
        s[N] = null;
        return item;
    }

    public int size() {
        return N;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int i = N;

        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return s[--i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
