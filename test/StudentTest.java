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
        Integer[] a = new Integer[1000];
        for (int i = 0; i<1000; i++) {
            a[i] = r.nextInt(10);
        }
        ArraySequence<Integer> array = new ArraySequence<>(a);
        System.out.println(array);
        QuickSort.quicksort(array.begin(),Algorithms.last(array.begin(),array.end()));
        System.out.println(array);
    }

    @Test
    public void partition() {
        Integer[] a = {2,3};
        ArraySequence<Integer> array = new ArraySequence<>(a);
        System.out.println(array);
        QuickSort.partition(array.begin(),Algorithms.last(array.begin(),array.end()));
        System.out.println(array);
    }

    @Test
    public void length() {
        Integer[] a = {1,2,5,3,3,4,5};
        ArraySequence<Integer> array = new ArraySequence<>(a);
        System.out.println(QuickSort.length(array.begin(),Algorithms.last(array.begin(),array.end())));
    }
    @Test
    public void test() {
        quicksort();
    }

}
