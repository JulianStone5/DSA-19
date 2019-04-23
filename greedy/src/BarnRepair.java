import java.util.*;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
        Arrays.sort(occupied);
        int numStalls = occupied[occupied.length-1]-occupied[0]+1;
        List<Integer> gaps = new ArrayList<>();
        for(int i = 1; i < occupied.length; i++) {
            int gap = occupied[i] - occupied[i-1]-1;
            if(gap > 0) { gaps.add(gap); }
        }
        Collections.sort(gaps);
        for(int i = 0; i < gaps.size() && i < M-1; i++) {
            numStalls -= gaps.get(gaps.size()-1-i);
        }
        return numStalls;
    }
}