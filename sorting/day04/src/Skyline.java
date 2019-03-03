import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;
        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        if(B.length == 0) return new ArrayList<>();
        if(B.length == 1) {
            List<Point> skyline = new ArrayList<>();
            skyline.add(new Point(B[0].l,B[0].h));
            skyline.add(new Point(B[0].r,0));
            return skyline;
        }
        List<Point> left = skyline(Arrays.copyOfRange(B,0,B.length/2));
        List<Point> right = skyline(Arrays.copyOfRange(B,B.length/2,B.length));
        return merge(left,right);
    }

    private static List<Point> merge(List<Point> a, List<Point> b) {
        int i = 0;
        int j = 0;
        int aLastHeight = 0;
        int bLastHeight = 0;
        List<Point> merged = new ArrayList<>();
        while(i < a.size() || j < b.size()) {
            if(j >= b.size()) {
                merged.add(a.get(i));
                i++;
            } else if(i >= a.size()) {
                merged.add(b.get(j));
                j++;
            } else if(a.get(i).x < b.get(j).x) {
                int height = (a.get(i).y > bLastHeight) ? a.get(i).y : bLastHeight;
                merged.add(new Point(a.get(i).x, height));
                aLastHeight = a.get(i).y;
                i++;
            } else if(a.get(i).x > b.get(j).x) {
                int height = (b.get(j).y > aLastHeight) ? b.get(j).y : aLastHeight;
                merged.add(new Point(b.get(j).x, height));
                bLastHeight = b.get(j).y;
                j++;
            } else {
                int height = (a.get(i).y > b.get(j).y) ? a.get(i).y : b.get(j).y;
                merged.add(new Point(a.get(i).x,height));
                aLastHeight = a.get(i).y;
                bLastHeight = b.get(j).y;
                i++;
                j++;
            }
        }
        for(int k = 0; k < merged.size(); k++) {
            int l = k+1;
            while(l < merged.size() && merged.get(l).y == merged.get(k).y) {
                merged.remove(l);
            }
        }
        return merged;
    }
}
