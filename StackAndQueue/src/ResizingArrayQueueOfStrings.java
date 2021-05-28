public class ResizingArrayQueueOfStrings {
    private String[] q;
    private int head; // point to the first element
    private int tail; // point to the next of last element

    public ResizingArrayQueueOfStrings() {
        this.q = new String[1];
        this.head = 0;
        this.tail = 0;
        q[0] = null;
    }

    public void enqueue(String item) {

        if (isEmpty()) {
            q[head] = item;
        } else {
            q[tail] = item;
        }
//        System.out.println(q[tail]);
        tail += 1;
        if (size() == q.length) resize(q.length * 2);
        tail %= q.length;

    }

    public String dequeue() {
        String item = q[head];
        q[head] = null;
        head += 1;
        int currSize = size();
        if (currSize > 0 && currSize == q.length / 4) resize(q.length / 2);
        head %= q.length;
        if (isEmpty()) {
            head = 0;
            tail = 0;
        }
        return item;

    }

    public boolean isEmpty() {
        return q[head] == null;
    }

    public int size() {
        if (isEmpty()) return 0;
        if (tail > head) return tail - head;
        else return q.length - head + tail;
    }

    public void printQueue() {
        for (int i = 0; i < q.length; i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    /*
    resize q with the new capacity
    copy over the items from original q
     */
    private void resize(int capacity) {
//        System.out.println("resizing is called");
        String[] copy = new String[capacity];
        int j = 0;
        if (head < tail) {
            for (int i = head; i < tail; i++) {
                copy[j] = q[i];
                j++;
            }

        } else {
            for (int i = head; i < q.length; i++) {
                copy[j] = q[i];
                j++;
            }
            for (int i = 0; i < tail; i++) {
                copy[j] = q[i];
                j++;
            }
        }

        q = copy;
        head = 0;
        tail = j;
    }
}
