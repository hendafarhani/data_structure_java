package basicSorts;

public class SelectionSort {

    //Time Complexity O(n²) and for almost sorted algo it's O(n)
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++){
            int minIndex = i;
            for (int j = i+1; j < array.length; j++){ // So let's search for the minimum number in the subArray from i+1 till array.length
                if(array[j] < array[i]){
                    minIndex = j;
                }
            }
            if(minIndex != i){ // Once the minimum is found and its index != i, then switch.
                int min = array[minIndex];
                array[minIndex] = array[i];
                array[i] = min; // Because i < minIndex, so it should contain the minimum.
            }
        }
    }

}
