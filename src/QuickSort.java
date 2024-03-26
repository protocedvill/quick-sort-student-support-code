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

        Iterator<E> last = Algorithms.last(begin.clone(), end.clone());

        //if (begin.equals(last)) return;

        Iterator<E> pivot = partition(begin, last);
        quicksort(begin.clone(), pivot.clone());
        if (!pivot.equals(last)) {
            pivot.advance();
            quicksort(pivot.clone(),end);
        }
    }

    public static <E extends Comparable<? super E>>
    Iterator<E> partition(Iterator<E> begin, Iterator<E> end) {
        Iterator<E> pivot = random(begin,end);
        Algorithms.iter_swap(pivot, end);
        pivot = end.clone();
        Iterator<E> i = begin.clone();
        int len = 0;
        for (Iterator<E> j = begin.clone();;) {
            if (j.equals(end) || i.equals(end)) break;
            if (0 >= j.get().compareTo(pivot.get())) {
                Algorithms.iter_swap(i,j);
                i.advance();
            }
            j.advance();
            len++;
        }
        Algorithms.iter_swap(i, end);
        return i;
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

}
