package mergeSort;

import sun.security.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSort {

    //Time complexity is O(n log(n)) and if array is almost sorted it is O(n²)
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int n = array.length;
        int midLength = n / 2;

        int[] left = Arrays.copyOfRange(array, 0, midLength);
        left = mergeSort(left);

        int[] right = Arrays.copyOfRange(array, midLength, n);
        right = mergeSort(right);

        return merge(left, right);
    }


    public static int[] merge(int[] a1, int[] a2) {
        int[] combinedArray = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int c = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                combinedArray[c] = a1[i];
                i++;
                c++;
            } else if (a1[i] > a2[j]) {
                combinedArray[c] = a2[j];
                j++;
                c++;
            }
        }
        if (i < a1.length) {
            while (i < a1.length) {
                combinedArray[c] = a1[i];
                i++;
                c++;
            }
        }
        if (j < a2.length) {
            while (j < a2.length) {
                combinedArray[c] = a2[j];
                j++;
                c++;
            }
        }
        return combinedArray;
    }
}
