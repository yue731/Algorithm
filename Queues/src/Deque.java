import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    // construct an empty deque
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;


    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node curr = new Node();
        curr.item = item;

        if (first == null) {
            first = curr;
            last = curr;
        } else {
            first.prev = curr;
            curr.next = first;
            first = curr;

        }

        size++;

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node curr = new Node();
        curr.item = item;
        if (last == null) {
            first = curr;
            last = curr;
        } else {
            last.next = curr;
            curr.prev = last;
            last = curr;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if (first != null) {
            first.prev = null;
        }
//        first.prev = null;
        size--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }

        size--;
        if (isEmpty()) {
            first = null;
            last = null;
        }
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node curr = first;

        public boolean hasNext() {
            return curr != null;
        }

        public Item next() {
            if (curr == null) throw new NoSuchElementException();
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void printDeque() {
        for (Item item : this) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private Item getFirst() {
        return first.item;
    }

    private Item getLast() {
        return last.item;
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        System.out.println(deque.isEmpty());
        deque.addFirst("hello");
        deque.addLast("world");
        System.out.println(deque.size());
        deque.addLast("good");
        deque.printDeque();
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        deque.printDeque();

        Deque<Integer> dq2 = new Deque<>();
        System.out.println(dq2.isEmpty());
        dq2.addFirst(1);
        System.out.println(dq2.removeLast());
        dq2.addFirst(3);
        System.out.println(dq2.getFirst());
        System.out.println(dq2.getLast());
        System.out.println(dq2.removeLast());

    }

}
