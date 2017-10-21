import sequences.*;
import static sequences.Algorithms.*;

public class QuickSort {

    /**
     * @param begin The position of the first element in the sequence to be sorted.
     * @param end   The position that is one-past the last element in the sequence to be sorted.
     * @param <E>   The element type for the sequence.
     */
    public static <E extends Comparable<E>>
    void quicksort(Iter<E> begin, Iter<E> end) {

        if(!(begin.equals(end))){

            Iter<E> pi = partition(begin, end);//get partition

            quicksort(begin, pi);//at pi

            pi.advance();
            quicksort(pi, end);//after pi

            }
    }

    static <E extends Comparable<? super E>> Iter<E> partition(Iter<E> i1, Iter<E> i2){

                E piv = last(i1, i2).get(); //get element for right pos

                Iter<E> i = i1.clone(); //get low

                for (Iter<E> j = i.clone(); ! j.equals(last(i1, i2)); j.advance()){

                        //if curr less or equal to piv
                        if (j.get().compareTo(piv) < 1) {
                            iter_swap(i, j);//swap
                            i.advance();//increment
                        }
                    }
                iter_swap(last(i1, i2), i);//cleanup
                return i;
            }

}
