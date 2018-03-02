import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {
    public static List<String> of(String s) {

        if (s.length() == 2) {
            return Arrays.asList(
                    s.substring(0, 1) + s.substring(1, 2),
                    s.substring(1, 2) + s.substring(0, 1));
        }

        if (s.length() >= 3) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < Anagram.of(dropChar(s, i)).size(); j++) {
                    result.add(
                            s.substring(i, i + 1) + Anagram.of(dropChar(s, i)).get(j)
                    );
                }
            }

            return result;
        }

        return Arrays.asList(s);
    }


    static private String dropChar(String str, int index) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == index) continue;
            result += str.charAt(i);
        }
        return result;
    }
}
