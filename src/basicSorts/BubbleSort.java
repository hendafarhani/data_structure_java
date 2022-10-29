package basicSorts;

public class BubbleSort {

    //Time Complexity O(n²) and for almost sorted algo it's O(n)
    public static void bubbleSort(int[] array) {
        // The principle of bubble sort is that from with every iteration, the greatest element is placed at
        // the top left of an array
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
