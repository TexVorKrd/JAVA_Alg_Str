package heap_sort;

public class Main {
    public static void main(String[] args) {

        Integer[] myArray = RndInt(15);
        HeapForSort myHeap = new HeapForSort(myArray);
        System.out.println(myHeap.toString());
        myHeap.sort();
        System.out.println(myHeap.toString());

    }

    private static Integer[] RndInt(int size) {

        // Интервал для рандомного массива
        int startInterval = 1;
        int doneInterval = 99;

        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = startInterval + (int) (Math.random() * (doneInterval - startInterval + 1));
        }
        return array;
    }
}
