import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        List<String> list = ReadFile.read("C:\\Users\\svøn\\IdeaProjects\\logiq_coding_task_Sveinn_Frimannsson_2022\\src\\actiontexts.txt");

        for(String elem : list){
            String[] parts = elem.split(":");
            String action = parts[0];
            String text = parts[1];

            switch (action) {
                case "REVERSE":
                    System.out.println("Text: ["+ text +"] ran Action: [" + action + "] with the result of: [" + reverse_text(text) + "]");
                    break;

                case "WHITESPACE":
                    System.out.println("Text: ["+ text +"] ran Action: [" + action + "] with the result of: [" + remove_whitespace(text) + "]");
                    break;

                case "UNIQUE_COUNT":
                    System.out.println("Text: ["+ text +"] ran Action: [" + action + "] with the result of: [" + unique_count(text) + "]");
                    break;

                case "PALINDROME":
                    System.out.println("Text: ["+ text +"] ran Action: [" + action + "] with the result of: [" + palindrome(text) + "]");
                    break;

                case "CAPITALIZE":
                    System.out.println("Text: ["+ text +"] ran Action: [" + action + "] with the result of: [" + capitalize(text) + "]");
                    break;

                default:
                    System.out.println("Unknown Action: " + action);
            }
        }
    }

    private static String reverse_text(String text) {

        StringBuilder text_reversed = new StringBuilder();

        text_reversed.append(text);

        text_reversed.reverse();

        return String.valueOf(text_reversed);
    }

    private static String remove_whitespace(String text) {
        return text.replaceAll("\\s", "");
    }

    private static int unique_count(String text) {
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

    private static String palindrome(String text) {
        String reversed_text = reverse_text(text);
        if(reversed_text.equals(text)){
            return "True";
        }else{
            return "False";
        }
    }

    private static String capitalize(String text){
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}

/*
In Java 12 it is possible to make the switch statement look like this:
            switch (action) {
                case "REVERSE" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + reverse_text(text) + "]");
                case "WHITESPACE" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + remove_whitespace(text) + "]");
                case "UNIQUE_COUNT" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + unique_count(text) + "]");
                case "PALINDROME" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + palindrome(text) + "]");
                default -> System.out.println("Unknown Action: " + action);
            }
 */