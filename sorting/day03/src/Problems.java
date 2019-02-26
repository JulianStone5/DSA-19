import java.util.LinkedList;

public class Problems {

    static void sortNumsBetween100s(int[] A) {
        int max = A[0]+100;
        for(int i : A) {
            max = (i+100 > max) ? i+100 : max;
        }
        int[] counts = new int[max+1];
        for(int i : A) {
            counts[i+100]++;
        }
        int i = 0;
        for(int j = 0; j < counts.length; j++) {
            while(counts[j] > 0) {
                A[i] = j-100;
                counts[j]--;
                i++;
            }
        }
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    static void countingSortByCharacter(String[] A, int n) {
        int b = 26;
        LinkedList<String>[] L = new LinkedList[b];
        for (int i = 0; i < b; i++)
            L[i] = new LinkedList<>();
        for (String i : A) {
            int d = getNthCharacter(i,n);
            L[d].add(i);
        }
        int j = 0; // index in A to place numbers
        for (LinkedList<String> list : L) {
            while(!list.isEmpty()){
                A[j] = list.pop();
                j++;
            }
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    static void sortStrings(String[] S, int stringLength) {
        for(int i = 0; i < stringLength; i++) {
            countingSortByCharacter(S,i);
        }
    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }

}
