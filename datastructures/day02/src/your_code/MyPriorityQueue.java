package your_code;


import java.util.LinkedList;

/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue{

    private LinkedList<Integer> ll;

    public MyPriorityQueue() {
        ll = new LinkedList<>();
    }

    public void enqueue(int item) {
        int size = ll.size();
        for(int i = 0; i < size; i++) {
            int temp = ll.pop();
            if(item >= temp && size == ll.size()+1) {
                ll.addLast(item);
            }
            ll.addLast(temp);
        }
        if(ll.size() == size) {
            ll.addLast(item);
        }
    }

    /**
     * Return and remove the largest item on the queue.
     */
    public int dequeueMax() {
       return ll.pop();
    }

}