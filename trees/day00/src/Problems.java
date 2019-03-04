import java.util.*;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for(Integer val : values) {
            tree.add(val);
        }
        List<Integer> sorted = tree.inOrderTraversal();
        return helper(sorted);
    }

    public static BinarySearchTree<Integer> helper(List<Integer> values) {
        if(values.size() == 0) return null;
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(values.get(values.size()/2));
        BinarySearchTree<Integer> left = helper(values.subList(0,values.size()/2));
        BinarySearchTree<Integer> right = helper(values.subList(values.size()/2+1,values.size()));
        tree.root.rightChild = (right == null) ? null : right.root;
        tree.root.leftChild = (left == null) ? null : left.root;
        return tree;
    }

    public static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) { return true; }
        if((n1 == null || n2 == null) ||(n1.key != n2.key))  { return false; }
        boolean matched = isIsomorphic(n1.leftChild,n2.leftChild) && isIsomorphic(n1.rightChild,n2.rightChild);
        boolean switched = isIsomorphic(n1.leftChild,n2.rightChild) && isIsomorphic(n1.rightChild,n2.leftChild);
        return matched || switched;
    }
}
