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

        Iterator<E> traverse = begin;
        Iterator<E> pivot = begin.clone();
        Iterator<E> low = begin.clone();
        Iterator<E> high = begin.clone();
        while (!traverse.equals(end)) {
            if(0 < traverse.get().compareTo(pivot.get())) {
                // if holding is greater than the pivot then
                low.advance();
                Algorithms.iter_swap(high, low);
                traverse.advance();
            } else {
                low.advance();
                high.advance();
                traverse.advance();
            }
        }
        low.advance();
        //Algorithms.iter_swap(low,pivot);
    }

}
