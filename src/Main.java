import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        List<String> list = ReadFile.read("C:\\Users\\svøn\\IdeaProjects\\logiq_coding_task_Sveinn_Frimannsson_2022\\src\\actiontexts.txt");

        for (String elem : list) {
            String[] parts = elem.split(":");
            String action = parts[0];
            String text = parts[1];

            try{
                System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + perform_action(action, text) + "]");
            }catch (IllegalArgumentException ex){
                System.out.println(action + " is an unknown action");
            }
        }
    }

    public static String perform_action(String action, String text) {
        switch (action) {
            case "REVERSE": return StringUtils.reverse_text(text);
            case "WHITESPACE": return StringUtils.remove_whitespace(text);
            case "UNIQUE_COUNT": return String.valueOf(StringUtils.unique_count(text));
            case "PALINDROME": return String.valueOf(StringUtils.palindrome(text));
            case "CAPITALIZE": return StringUtils.capitalize(text);
            default: throw new IllegalArgumentException("No function of said name found in switch statement");
        }
    }
}


/*
In Java 12 it is possible to make the switch statement look like this:
        return switch (action) {
            case "REVERSE" -> StringUtils.reverse_text(text);
            case "WHITESPACE" -> StringUtils.remove_whitespace(text);
            case "UNIQUE_COUNT" -> String.valueOf(StringUtils.unique_count(text));
            case "PALINDROME" -> String.valueOf(StringUtils.palindrome(text));
            case "CAPITALIZE" -> StringUtils.capitalize(text);
            default -> action + " is an unknown action";
        };
 */