import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        LinkedList<Integer> l = new LinkedList<>();
        int x = 0;
        for(int i = 0; i < A.length; i++) {
            while (!l.isEmpty() && A[i] < l.getLast() && x < k) {
                l.removeLast();
                x++;
            }
            if (l.size() < A.length - k) {
                l.addLast(A[i]);
            }
        }
        return l;
    }

    public static boolean isPalindrome(Node n) {
        if(n == null) { return true; }
        int size = 1;
        Node current = n;
        while(current.next != null) {
            size++;
            current = current.next;
        }
        if(size == 1) { return true; }
        int count = 1;
        current = n;
        Node prev = null;
        Node nxt = null;
        while(count < size/2) {
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
            count++;
        }
        Node head1 = current;
        Node head2 = current.next;
        head1.next = prev;
        if(size % 2 == 1) { head2 = head2.next; }
        current = head1;
        Node current2 = head2;
        while(current.next != null && current2.next != null) {
            if(current.val != current2.val) { return false; }
            current = current.next;
            current2 = current2.next;
        }
        return true;
    }

    public static String infixToPostfix(String s) {
        String str = s.replaceAll(" ","");
        String operation = "";
        LinkedList<String> operands = new LinkedList<>();
        for(int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))) {
                operation += str.charAt(i) + " ";
            } else if(str.charAt(i) == ')') {
                operation += operands.pop() + " ";
            } else if(str.charAt(i) != '('){
                operands.push("" + str.charAt(i));
            }
        }
        return operation.substring(0,operation.length()-1);
    }

}
