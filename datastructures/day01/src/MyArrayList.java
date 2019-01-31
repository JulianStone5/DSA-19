public class MyArrayList {
    private Cow[] elems;
    private int size;

    // TODO: Runtime: O(1)
    public MyArrayList() {
        elems = new Cow[10];
        size = 0;
    }

    // TODO: Runtime: O(1)
    public MyArrayList(int capacity) {
        elems = new Cow[capacity];
        size = 0;
    }

    // TODO: Runtime: O(1)
    public void add(Cow c) {
        if(size == elems.length) {
            Cow[] temp = new Cow[elems.length*2];
            System.arraycopy(elems,0,temp,0,size);
            elems = temp;
        }
        elems[size] = c;
        size++;
    }

    // TODO: Runtime: O(1)
    public int size() {
        return size;
    }

    // TODO: Runtime: O(1)
    public Cow get(int index) {
        return elems[index];
    }

    // TODO: Runtime: O(N)
    public Cow remove(int index) {
        Cow removed = elems[index];
        for(int i = index+1; i < size; i++) {
            elems[i-1] = elems[i];
        }
        size--;
        if(size <= elems.length/4.0 && elems.length/2 > 1) {
            Cow[] temp = new Cow[elems.length/2];
            System.arraycopy(elems,0,temp,0,size);
            elems = temp;
        }
        return removed;
    }

    // TODO: Runtime: O(N)
    public void add(int index, Cow c) {
        if(size == elems.length) {
            Cow[] temp = new Cow[elems.length*2];
            System.arraycopy(elems,0,temp,0,size);
            elems = temp;
        }
        if(index > size) { throw new IndexOutOfBoundsException();}
        for(int i = size-1; i > index-1; i--) {
            elems[i+1] = elems[i];
        }
        elems[index] = c;
        size++;
    }
}