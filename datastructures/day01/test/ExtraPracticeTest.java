import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtraPracticeTest {
    ExtraPractice ex = new ExtraPractice();

    @Test
    public void testProblemOne() {
        int[] array = {2,2,2,2,2,2,2};
        assertEquals(2,ex.problemOne(array));
        int[] array1 = {1,2,2,3,4};
        assertEquals(2,ex.problemOne(array1));
        int[] array2 = {1,2,4,151,7,5,3};
        assertEquals(4,ex.problemOne(array2));
    }

    @Test
    public void testProblemTwo() {
        int[] array = {1,2,3,4,5};
        assertEquals(0,ex.problemTwo(array));
        int[] array1 = {3,4,5,1,2};
        assertEquals(3,ex.problemTwo(array1));
        int[] array2 = {3,3,4,5,4};
        assertEquals(-1,ex.problemTwo(array2));
    }

    @Test
    public void testProblemThree() {
        int[] array = {1,7,3,4,5,2};
        assertEquals(2,ex.problemThree(array,8));
        int[] array1 = {1,6,3,8,4};
        assertEquals(1,ex.problemThree(array1,10));
        int[] array2 = {1,7,2,8,3,4};
        assertEquals(0,ex.problemThree(array,14));
    }

    @Test
    public void testProblemFour() {
        int[] array = {1,2,3,2,3,4,5,6,1,2,1,2,1,1};
        assertArrayEquals(new int[] {3,7},ex.problemFour(array));
        int[] array1 = {1,2,3};
        assertArrayEquals(new int[] {0,2},ex.problemFour(array1));
    }
}
