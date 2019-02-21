import java.util.HashMap;
import java.util.Map;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        int count = 0;
        for(int i = 0; i < arr.length-2; i++) {
            HashMap<Integer,Integer> m = new HashMap<>();
            for(int j = i+1; j < arr.length; j++) {
                int x = sum - arr[i] - arr[j];
                if(m.getOrDefault(x,0) == null ) {
                    count++;
                } else {
                    m.put(arr[j],null);
                }
            }
        }
        return count;
    }
}
