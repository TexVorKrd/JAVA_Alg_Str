package heap_sort;

import java.util.Arrays;

public class HeapForSort {
    Integer[] myHeap;

    public HeapForSort(Integer[] heap) {
        this.myHeap = heap;
    }

    /**
     * Сортировка элементов массива кучей
     */
    public void sort() {
        for (int element = myHeap.length - 1; element > 0; element--) {

            resortHeap(0, element);
            int temp = myHeap[element];
            myHeap[element] = myHeap[0];
            myHeap[0] = temp;
        }
    }

    /**
     * Если есть дети то поднимаем большего наверх (меняем метами с родителем)
     *
     * @param parrent - индекс родителя
     * @param endFind - ограничение длины поиска
     */
    public void test_children(int parrent, int endFind) {

        if (parrent * 2 + 1 <= endFind && myHeap[parrent] < myHeap[parrent * 2 + 1]) {
            int temp = myHeap[parrent];
            myHeap[parrent] = myHeap[parrent * 2 + 1];
            myHeap[parrent * 2 + 1] = temp;
        }

        if (parrent * 2 + 2 <= endFind && myHeap[parrent] < myHeap[parrent * 2 + 2]) {
            int temp = myHeap[parrent];
            myHeap[parrent] = myHeap[parrent * 2 + 2];
            myHeap[parrent * 2 + 2] = temp;
        }

    }

    public void resortHeap(int parrent, int endFind) {

        if (parrent * 2 + 1 > endFind) return;

        resortHeap(parrent * 2 + 1, endFind);
        resortHeap(parrent * 2 + 2, endFind);
        test_children(parrent, endFind);

    }

    @Override
    public String toString() {
        return Arrays.toString(myHeap);
    }
}
