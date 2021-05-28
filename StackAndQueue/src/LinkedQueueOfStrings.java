public class LinkedQueueOfStrings {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        String item;
        Node next;
    }

    public LinkedQueueOfStrings() {

        this.size = 0;
    }

    public void enqueue(String item) {
        // insert item at the end of of the queue
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public String dequeue() {
        // remove and return from the end of queue
        String item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;

        return item;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


}
