import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static List<List<Integer>> permutations(List<Integer> A) {
        // TODO
        List<Integer> unused = new ArrayList<Integer>();
        for(Integer a: A) { unused.add(a); }
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> current = new ArrayList<Integer>();
        permHelper(current, unused, permutations);
        return permutations;
    }

    private static void permHelper(List<Integer> current, List<Integer> unused, List<List<Integer>> perms) {
        if(unused.isEmpty()) { perms.add(current); }
        for(Integer a : unused) {
            List<Integer> tempCur = new ArrayList<Integer>(current);
            tempCur.add(a);
            List<Integer> tempUn = new ArrayList<Integer>(unused);
            tempUn.remove(a);
            permHelper(tempCur,tempUn,perms);
        }
    }

}