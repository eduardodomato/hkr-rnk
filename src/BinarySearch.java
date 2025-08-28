import java.util.Arrays;

public class BinarySearch {


    /*
        Binary Search has O (log n) complexity
        that is better than Linear time O(n) that iterates all items.
        It requires sorted data in ascending order. NO RECURSIVE
     */
    public static boolean binarySearch(int[] arr, int item){

        int min = 0;
        int max = arr.length - 1;

        //If min and max join together, then the element is not present.
        while (min <= max){

            int mid = (min + max) / 2;
            if (item == arr[mid]){
                return true;
            }else if (item < arr[mid]){ // the item is in the lower sub-array
                max = mid -1;
            }else {
                min = mid + 1; // the item is in the higher sub-array
            }
        }

        return false;

    }



    public static void main (String... args){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 4));

        //Built-in function
        System.out.println(Arrays.binarySearch(arr,4));

    }

}
