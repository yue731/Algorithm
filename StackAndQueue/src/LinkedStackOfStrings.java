public class LinkedStackOfStrings {

    private Node first;
    private int size;

    private class Node {
        String item;
        Node next;
    }

    public LinkedStackOfStrings() {
        this.first = null;
        this.size = 0;
    }

    public void push(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        size -= 1;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

}
