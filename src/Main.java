import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Integer> l = Arrays.asList(1,2,4,5,6,7,8);

        for (int i = 0; i<l.size(); i++){
            System.out.println(l.get(i));
        }
    }
}
