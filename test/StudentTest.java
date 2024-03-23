import org.junit.jupiter.api.Test;
//import sequences.*;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

public class StudentTest {

    @Test
    public void quicksort() {
        Random r = new Random();
        Integer[] a = new Integer[10];
        for (int i = 0; i<10; i++) {
            a[i] = r.nextInt(10);
        }
        ArraySequence<Integer> array = new ArraySequence<Integer>(a);
        System.out.println(array);
        QuickSort.quicksort(array.begin(),Algorithms.last(array.begin(),array.end()));
        System.out.println(array);
    }

    @Test
    public void test() {
        quicksort();
    }

}
