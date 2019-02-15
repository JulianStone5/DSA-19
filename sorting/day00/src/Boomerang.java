import java.util.HashMap;
import java.util.Map;

public class Boomerang {

    public static int numberOfBoomerangs(int[][] points) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i != j) {
                    int dist = distance(points[i], points[j]);
                    int num = map.getOrDefault(dist,0);
                    map.put(dist,num+1);
                }
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                int val = entry.getValue();
                count += val * (val - 1);
            }
            map.clear();
        }
        return count;
    }

    private static int distance(int[] a, int[] b) {
        int c = a[0]-b[0];
        int d = a[1]-b[1];
        return c*c+d*d;
    }
}

