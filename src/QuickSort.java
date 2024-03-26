import java.util.Random;

public class QuickSort {

    /**
     * TODO
     * @param begin The position of the first element in the sequence to be sorted.
     * @param end   The position that is one-past the last element in the sequence to be sorted.
     * @param <E>   The element type for the sequence.
     */
    public static <E extends Comparable<? super E>>
    void quicksort(Iterator<E> begin, Iterator<E> end) {
        if (begin.equals(end)) return;
        Iterator<E> pivot = partition(begin.clone(),end.clone());
        quicksort(begin.clone(), pivot.clone());
        pivot.advance();
        quicksort(pivot.clone(),end.clone());
    }

    private static <E extends Comparable<? super E>>
    Iterator<E> min(Iterator<E> begin, Iterator<E> end) {
        Iterator<E> m = begin;
        for (; ! begin.equals(end); begin.advance()) {
            Iterator<E> c = begin;
            if (m.get().compareTo(c.get()) < 0) {
                m = c;
            }
        }
        return m;
    }

    private static <E extends Comparable<? super E>>
    Iterator<E> random(Iterator<E> begin, Iterator<E> end) {
        Random rand = new Random();
        Iterator<E> m = begin;
        int len = length(begin.clone(), end.clone());
        int cap = rand.nextInt(len);
        int x = 0;
        for (Iterator<E> j = begin.clone();; j.advance()) {
            if (x == cap) break;
            x++;
            m = j;
        }
        return m;
    }

    protected static <E extends Comparable<? super E>>
    int length(Iterator<E> begin, Iterator<E> end) {
        int i = 1;
        for (Iterator<E> j = begin.clone();; j.advance()) {
            if (j.equals(end)) break;
            i++;
        }
        return i;
    }

    public static <E extends Comparable<? super E>>
    Iterator<E> partition(Iterator<E> begin, Iterator<E> end) {
        if (begin.equals(end)) return begin;

        int length = length(begin.clone(),end.clone());
        Iterator<E> pivot = random(begin.clone(),end.clone());
        System.out.println(pivot);
        Algorithms.iter_swap(pivot,end);
        //pivot = end.clone();

        // i is small
        // j is large
        Iterator<E> i = begin.clone();
        for (Iterator<E> j = begin.clone();;) {
            if (0 < j.get().compareTo(pivot.get())) {
                System.out.println("swapping " + i + " & " + j);
                if(i.equals(end)) break;
                Algorithms.iter_swap(i, j);
                i.advance();

                System.out.println("(a) i = " + i + "; j = " + j);

            }
            else if (0 > j.get().compareTo(pivot.get())) {
                if(i.equals(end)) break;
                j.advance();

                System.out.println("(b) i = " + i + "; j = " + j);
            }
            else {
                j.advance();
                System.out.println("(c) i = " + i + "; j = " + j);
            }
            if(j.equals(end)) break;
        }
        //if (length > 2) Algorithms.iter_swap(i, pivot);
        return i;
    }

}
