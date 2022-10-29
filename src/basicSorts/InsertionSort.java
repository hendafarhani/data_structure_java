package basicSorts;

public class InsertionSort {

    //Time Complexity O(n²) and for almost sorted algo it's O(n)
    public static void insertionSort(int array[]){
        for (int i = 1; i < array.length; i++){
            int j = i-1;
            int min = array[i]; // let min = array[minIndex]
            while(j>= 0 && array[j] > min){  // compare min to its predecessors,
                // if it is less, then do the switch.
                array[j+1] = array[j]; // Always switch j and j+1,
                // because the sub-array of [0, j] is always sorted.
                //Once an element found in this sub-array greater than min, then it is the max.
                // We can't find in the sub-array [0, j-1] an element > array[j].
                //so it is always about comparing array[j] and array[j+1], where j+1 is always the position of the min.
                array[j] = min;
                 j--;
            }
        }
    }
    
}
