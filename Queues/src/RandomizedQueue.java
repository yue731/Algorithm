import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] q;

    private int N;


    // construct an empty randomized queue
    public RandomizedQueue() {
        this.q = (Item[]) new Object[1];

        this.N = 0;

    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;

    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (N == q.length) resize(q.length * 2);
        q[N++] = item;

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomIdx = StdRandom.uniform(N);
        Item item = q[randomIdx];
        // move the last item to the removed item position
        q[randomIdx] = q[N - 1];
        q[N - 1] = null;
        N--;
        if (N > 0 && N == q.length / 4) resize(q.length / 2);
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int randomIdx = StdRandom.uniform(N);
        return q[randomIdx];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = q[i];
        }
        q = copy;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private Item[] randomItems;
        private int curr;

        public RandomizedQueueIterator() {
            this.randomItems = (Item[]) new Object[N];
            for (int i = 0; i < N; i++) {
                randomItems[i] = q[i];
            }
            StdRandom.shuffle(randomItems);

            this.curr = 0;

        }


        public boolean hasNext() {
            return curr < N;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = randomItems[curr];
            curr++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void printRandomizedQueue() {
        for (int i = 0; i < N; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        System.out.println(rq.size());
        System.out.println(rq.isEmpty());
        rq.enqueue("hello");
        rq.enqueue("world");
        rq.enqueue("good");
        rq.enqueue("old");
        rq.enqueue("happy");
        System.out.println(rq.size());
        System.out.println(rq.sample());
        for (String s : rq) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println(rq.dequeue());
        System.out.println(rq.size());
        for (String s : rq) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : rq) {
            System.out.print(s + " ");
        }
        System.out.println();

    }
}
