public class Main {
    public static void main(String[] args) {

        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.dequeue();
        queue.enqueue("d");
        queue.enqueue("e");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("f");
        queue.dequeue();
        queue.enqueue("h");
        queue.enqueue("i");
        queue.dequeue();


        queue.printQueue();
        System.out.println(queue.size());
        System.out.println(queue.getHead());
        System.out.println(queue.getTail());

//        LinkedStackOfStrings stack = new LinkedStackOfStrings();
//        while (!StdIn.isEmpty()) {
//            String s = StdIn.readString();
//            if (s.equals("-")) StdOut.print(stack.pop());
//            else stack.push(s);
//        }

    }
}
