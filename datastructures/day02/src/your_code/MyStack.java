package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private LinkedList<Integer> maxElements;

    public MyStack() {
        ll = new LinkedList<>();
        maxElements = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
        if(maxElements.size() == 0 || maxElements.peek() < e) {
            maxElements.addFirst(e);
        }
        ll.addFirst(e);
    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        if(maxElements.peek() == pop) {
            maxElements.pop();
        }
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        return maxElements.peek();
    }
}
