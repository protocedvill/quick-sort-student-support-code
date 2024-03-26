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
        int CAP = 10;
        Random r = new Random();
        Integer[] a = new Integer[CAP];

        for (int j = 0; j < CAP; j++) {
            for (int i = 0; i < CAP; i++) {
                a[i] = r.nextInt(CAP);
            }
            ArraySequence<Integer> array = new ArraySequence<>(a);
            System.out.println(array);
            QuickSort.quicksort(array.begin(), Algorithms.last(array.begin(), array.end()));
            System.out.println(array);
            System.out.println(checkSorted(array.begin().clone(), array.end().clone()));
            //assertTrue(checkSorted(array.begin().clone(), array.end().clone()));
        }
    }

    public boolean checkSorted(Iterator<Integer> begin, Iterator<Integer> end) {
        int i = begin.get();
        Iterator<Integer> j = begin.clone();
        j.advance();
        if (j.equals(end)) return true;
        if (i > j.get()) return false;
        return checkSorted(j, end);
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
