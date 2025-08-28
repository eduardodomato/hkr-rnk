import java.util.Arrays;

public class Ordering {

    public static int[] reverse(int[] arr) {

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public static void reverseInPlace(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            //Swap item at index (i) and item at index (arr.length -i-1)
            int temp = arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;

        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Arrays.stream(reverse(arr)).forEach(System.out::println);
        System.out.println("---------------");
        reverseInPlace(arr);
        Arrays.stream(arr).forEach(System.out::println);


    }

}
