import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class StringUtils {

    public static String reverse_text(String text) {

        StringBuilder text_reversed = new StringBuilder();

        text_reversed.append(text);

        text_reversed.reverse();

        return String.valueOf(text_reversed);
    }

    public static String remove_whitespace(String text) {
        return text.replaceAll("\\s", "");
    }

    public static int unique_count(String text) {
        int unique_character_count = 0;
        List<Character> visited_characters = new LinkedList<>();
        for (int i = 0; i < text.length(); i++) {
            if (!visited_characters.contains(text.charAt(i))) {
                unique_character_count++;
                visited_characters.add(text.charAt(i));
            }
        }
        return unique_character_count;
    }

    public static boolean palindrome(String text) {
        String reversed_text = reverse_text(text);
        return reversed_text.equals(text);
    }

    public static String capitalize(String text){
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}

