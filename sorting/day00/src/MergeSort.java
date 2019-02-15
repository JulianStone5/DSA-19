import java.util.Arrays;

public class    MergeSort extends SortAlgorithm {

    private static final int INSERTION_THRESHOLD = 10;

    /**
     * This is the recursive step in which you split the array up into
     * a left and a right portion, sort them, and then merge them together.
     * Use Insertion Sort if the length of the array is <= INSERTION_THRESHOLD
     *
     * TODO
     * Best-case runtime: O(N log N)
     * Worst-case runtime: O(N log N)
     * Average-case runtime: O(N log N)
     *
     * Space-complexity: O(N)
     */
    @Override
    public int[] sort(int[] array) {
        if(array.length <= 1) return array;
        int[] left = sort(Arrays.copyOfRange(array, 0, array.length/2));
        int[] right = sort(Arrays.copyOfRange(array,array.length/2, array.length));
        return merge(left,right);
    }

    /**
     * Given two sorted arrays a and b, return a new sorted array containing
     * all elements in a and b. A test for this method is provided in `SortTest.java`
     */
    public int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int[] merged = new int[a.length + b.length];
        while(i < a.length || j < b.length) {
            if(i >= a.length || (j<b.length && a[i] > b[j])) {
                merged[i+j] = b[j];
                j++;
            } else {
                merged[i+j] = a[i];
                i++;
            }
        }
        return merged;
    }

}
