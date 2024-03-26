import org.junit.jupiter.api.Test;
//import sequences.*;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

public class StudentTest {

    @Test void qqiuck() {
        Integer[] a = {2,8,7,0};
        ArraySequence<Integer> array = new ArraySequence<>(a);
        System.out.println(array);
        QuickSort.quicksort(array.begin(),array.end());
        System.out.println(array);
    }

    @Test
    public void quicksort() {
        int CAP = 1000;
        Random r = new Random();
        Integer[] a = new Integer[CAP];

        for (int j = 0; j < CAP; j++) {
            for (int i = 0; i < CAP; i++) {
                a[i] = r.nextInt(CAP);
            }
            ArraySequence<Integer> array = new ArraySequence<>(a);
            System.out.println(array);
            QuickSort.quicksort(array.begin(), array.end());
            System.out.println(array);
            System.out.println(checkSorted(array.begin().clone(), array.end().clone()));
            assertTrue(checkSorted(array.begin().clone(), array.end().clone()));
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
        Integer[] b = {2,1,3};
        ArraySequence<Integer> barry = new ArraySequence<>(b);
        System.out.println(barry);
        Iterator<Integer> bivot = QuickSort.partition(barry.begin().clone(),Algorithms.last(barry.begin().clone(),barry.end().clone()));
        System.out.println(bivot);
        System.out.println(barry);
        bivot = Algorithms.last(barry.begin().clone(), bivot.clone());
        //bivot.advance();
        System.out.println(bivot);
        Iterator<Integer> bivot2 = QuickSort.partition(barry.begin().clone(), bivot);
        System.out.println(bivot2);
        System.out.println(barry);

        System.out.println("-");

        Integer[] a = {2,8,7,1,3,5,6,4};
        ArraySequence<Integer> array = new ArraySequence<>(a);
        System.out.println(array);
        Iterator<Integer> pivot = QuickSort.partition(array.begin(),Algorithms.last(array.begin(),array.end()));
        System.out.println(pivot);
        System.out.println(array);
        Iterator<Integer> pivot1 = QuickSort.partition(array.begin(),Algorithms.last(array.begin(), pivot));
        System.out.println(pivot1);
        System.out.println(array);
        Iterator<Integer> pivot2 = QuickSort.partition(array.begin(),Algorithms.last(array.begin(), pivot1));
        System.out.println(pivot2);
        System.out.println(array);
        //

    }

    @Test
    public void length() {
        Integer[] a = {1,2,5,3,3,4,5};
        ArraySequence<Integer> array = new ArraySequence<>(a);
        //System.out.println(QuickSort.length(array.begin(),Algorithms.last(array.begin(),array.end())));
    }
    @Test
    public void test() {
        quicksort();
    }

}
