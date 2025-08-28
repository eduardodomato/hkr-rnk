import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class HashSamples {


    public static List<Integer> getMissingElements(int[] arr1, int[] arr2){

        List<Integer> missingElements = new ArrayList<>();
        HashSet<Integer> mySet = new HashSet<>();
        for (int i:arr2) {
            mySet.add(i);
        }
        for (int i:arr1) {
            if (!mySet.contains(i)){
                missingElements.add(i);
            }
        }
        return missingElements;
    }

    public static void displayElementFrecuency(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:arr){
            if (!map.containsKey(x)){
                map.put(x,1);
            }else {
                map.put(x, map.get(x)+1);
            }
        }

        map.forEach((key,value)-> System.out.println(key+" : "+value));



    }

    public static void main(String[] args) {

    }
}
