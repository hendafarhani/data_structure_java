package quickSort;


public class QuickSort {

    //Time complexity is O(n log(n)) and if array is almost sorted it is O(n²)
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    public static int pivot(int[] array, int startIndex, int endIndex) {
        int swapIndex = startIndex;
        int pivotIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swap(array, i, ++swapIndex);
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
