import java.util.HashMap;
import java.util.Map;

public class StrongPassword {

    public static int minimumNumber(int n, String password) {

        Map<Character, Integer> conditions = new HashMap<>();
        for (Character c : password.toCharArray()) {
            conditions.put(getNature(c), 1);
        }

        int result=0;
        if(conditions.size()<4){
            result = 4 - conditions.size();
        }
        if (password.length()+result<6){
            result = 6 - password.length();
        }
        return result;

    }

    private static Character getNature(Character c) {
        if (c >= '0' && c <= '9') return 'n';//number
        if (c >= 'a' && c <= 'z') return 'l';//lower
        if (c >= 'A' && c <= 'Z') return 'u';//upper
        return 's';//Special
    }

    public static void main(String[] args) {
        minimumNumber(2, "lalalsllsa");
    }


}
