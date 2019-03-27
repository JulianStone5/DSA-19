package divide_and_conquer;

import java.util.Arrays;

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
        if(nums.length == 1) { return 0; }
        if(peakOneD(nums.length-1,nums) == 0) { return nums.length-1; }
        if(peakOneD(0,nums) == 0) { return 0; }
        int mid = nums.length/2;
        if(peakOneD(mid,nums) == 0){
            return mid;
        } else if(peakOneD(mid,nums) < 0){
            int[] temp = Arrays.copyOfRange(nums,0,mid);
            return findOneDPeak(temp);
        } else {
            int[] temp = Arrays.copyOfRange(nums,mid,nums.length);
            return findOneDPeak(temp);
        }
    }

    public static int[] findTwoDPeak(int[][] nums) {
        int[] result = new int[2];
        int mid = nums.length/2;
        if(peakX(nums[0].length-1,nums.length-1,nums) == 0 && peakY(nums[0].length-1,nums.length-1,nums) == 0) {
            return new int[] {nums.length-1,nums[0].length-1};
        }
        if(mid == 0 || mid == nums.length-1) {
            return new int[] {mid,maxXIndex(mid,0,nums[0].length-1,nums)};
        }
        return new int[] {mid, findOneDPeak(nums[mid])};
    }

}
