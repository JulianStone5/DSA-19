public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: O(N)
     *
     * k: maximum element in array A
     */
    static void countingSort(int[] A) {
        int max = A[0];
        for(int i : A) {
            max = (i > max) ? i : max;
        }
        int[] counts = new int[max+1];
        for(int i : A) {
            counts[i]++;
        }
        int i = 0;
        for(int j = 0; j < counts.length; j++) {
            while(counts[j] > 0) {
                A[i] = j;
                counts[j]--;
                i++;
            }
        }
    }

}
