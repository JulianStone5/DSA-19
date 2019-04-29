import java.util.HashMap;

public class LongestIncreasingSubsequence {

    // Runtime: O(n^2)
    // Space: O(n)
    public static int LIS(int[] A) {
        if(A.length == 0) {return 0;}
        int[] DP = new int[A.length];
        lts(0,A,DP);
        int maxLen = 0;
        for(int i = 0; i < DP.length; i++) {
            maxLen = (maxLen > DP[i]) ? maxLen : DP[i];
        }
        return maxLen;
    }

    public static int lts(int i, int[] A, int[] DP) {
        if(DP[i] != 0) { return DP[i]; }
        if(i == A.length - 1) { DP[i] = 1;}
        else {
            int maxLen = 0;
            for (int a = i + 1; a < A.length; a++) {
                int len = lts(a, A, DP);
                if (A[a] > A[i]) {
                    maxLen = (len > maxLen) ? len : maxLen;
                }
            }
            DP[i] = 1 + maxLen;
        }
        return DP[i];
    }
}