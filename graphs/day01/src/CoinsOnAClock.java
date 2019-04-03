import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinsOnAClock {

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        char[] clock = new char[hoursInDay];
        for(int i = 0; i < clock.length; i++) {
            clock[i] = '.';
        }
        List<char[]> answers = new ArrayList<>();
        recSolve(clock,0,pennies,nickels,dimes,hoursInDay,answers);
        return answers;
    }

    private static void recSolve(char[] clock, int current, int pennies, int nickels, int dimes, int hours, List<char[]> answers) {
        int c = current, p = pennies, n = nickels, d = dimes;
        char[] cl = new char[clock.length];
        System.arraycopy(clock,0,cl,0,clock.length);
        if(p == 0 && n == 0 && d == 0) {
            answers.add(cl);
            return;
        }
        if(cl[c] == '.') {
            if(p != 0) {
                cl[c] = 'p';
                c = (c + 1) % hours;
                recSolve(cl, c, p - 1, n, d, hours, answers);
                c = current;
                cl[c] = '.';
            }
            if(n != 0) {
                cl[c] = 'n';
                c = (c + 5) % hours;
                recSolve(cl, c, p, n - 1, d, hours, answers);
                c = current;
                cl[c] = '.';
            }
            if(d != 0) {
                cl[c] = 'd';
                c = (c + 10) % hours;
                recSolve(cl, c, p, n, d - 1, hours, answers);
                c = current;
                cl[c] = '.';
            }
        }
    }
}
