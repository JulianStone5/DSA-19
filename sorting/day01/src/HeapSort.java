public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        if(leftChild(i) >= size) { return; }
        else if(rightChild(i) >= size) {
            if(heap[i] > heap[leftChild(i)]) { return; }
            swap(heap,leftChild(i),i);
        } else {
            int left = heap[leftChild(i)];
            int right = heap[rightChild(i)];
            if(heap[i] > left && heap[i] > right) { return; }
            int maxIn = (left > right) ? leftChild(i) : rightChild(i);
            swap(heap,maxIn,i);
            sink(maxIn);
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            sink(i);
        }
    }

    /**
     * Best-case runtime: O(N log N)
     * Worst-case runtime: O(N log N)
     * Average-case runtime: O(N log N)
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);
        for (int i=size-1; i>0; i--) {
            swap(heap,i,0);
            size--;
            sink(0);
        }
        return heap;
    }
}
