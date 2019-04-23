import java.util.HashMap;

public class DiceRollSum {

    // Runtime: O(n)
    // Space: O(n)
    public static int diceRollSum(int N) {
        return DRS(N,new HashMap<Integer, Integer>());
    }

    private static int DRS(int N, HashMap<Integer,Integer> DP) {
        if(DP.containsKey(N)) { return DP.get(N); }
        if(N <= 6) { DP.put(N,(N <= 0) ? 1 : (int) Math.pow(2,N-1)); }
        else {
            int m = 0;
            for(int i = 1; i <= 6 ; i++ ) { m += DRS(N-i,DP); }
            DP.put(N, m);
        }
        return DP.get(N);
    }
}
