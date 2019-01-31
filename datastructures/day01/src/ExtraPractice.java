import java.lang.reflect.Array;

public class ExtraPractice {

    public ExtraPractice() {

    }

    public int problemOne(int[] array) {
        int target = array.length/2;
        for(int i = 0; i < array.length; i++) {
            int numLess = 0;
            int numEqual = 0;
            for(int j = 0; j < array.length; j++) {
                if(array[i] == array[j]) { numEqual++; }
                else if (array[i] > array[j]) { numLess++; }
                if(numLess + numEqual/2 == target) {
                    return array[i];
                }
            }
        }
        return -1;
    }

    public int problemTwo(int[] array) {
        int drop = 0;
        for(int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                if(drop != 0) { return -1; }
                drop = i+1;
            }
        }
        if(array[array.length-1] > array[0]) {
            if (drop != 0) { return -1; }
        }
        return drop;
    }

    public int problemThree(int[] array, int target) {
        int count = 0;
        for(int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) { count++; }
            }
        }
        return count;
    }

    public int[] problemFour(int[] array) {
        int[] ind = {0,0};
        int[] temp = {0,0};
        for(int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                temp[1] = i;
                if(temp[1]-temp[0] > ind[1]-ind[0]) {
                    System.arraycopy(temp,0,ind,0,2);
                }
                temp[0] = i+1;
            }
        }
        if(temp[0] >= temp[1]) {
            temp[1] = array.length-1;
            if(temp[1]-temp[0] > ind[1]-ind[0]) {
                System.arraycopy(temp,0,ind,0,2);
            }
        }
        return ind;
    }
}
