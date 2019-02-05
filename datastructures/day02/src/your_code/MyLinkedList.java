package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        Node nn = new Node(c);
        if(head == null) {
            head = nn;
        }
        if(tail != null) {
            tail.next = nn;
            nn.prev = tail;
        }
        tail = nn;
        size++;
    }

    public void addFirst(Chicken c) {
        Node nn = new Node(c);
        if(tail == null) {
            tail = nn;
        }
        if(head != null) {
            head.prev = nn;
            nn.next = head;
        }
        head = nn;
        size++;
    }

    public Chicken get(int index) {
        if(index >= size) {throw new IndexOutOfBoundsException();}
        int counter = 0;
        Node current = head;
        while(counter < index) {
            current = current.next;
            counter++;
        }
        return current.val;
    }

    public Chicken remove(int index) {
        if(index >= size) {throw new IndexOutOfBoundsException();}
        int counter = 0;
        Node current = head;
        while(counter < index) {
            current = current.next;
            counter++;
        }
        if(current.prev != null) {
            current.prev.next = current.next;
        }
        if(current.next != null) {
            current.next.prev = current.prev;
        }
        size--;
        return current.val;
    }

    public Chicken removeFirst() {
        if(head != null) {
            Chicken c = head.val;
            head = head.next;
            if(head != null) {
                head.prev = null;
            }
            size--;
            return c;
        }
        return null;
    }

    public Chicken removeLast() {
        if(tail != null) {
            Chicken c = tail.val;
            tail = tail.prev;
            if(tail != null) {
                tail.next = null;
            }
            size--;
            return c;
        }
        return null;
    }
}