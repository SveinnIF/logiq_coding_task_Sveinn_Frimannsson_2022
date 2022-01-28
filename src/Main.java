import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        List<String> list = ReadFile.read("C:\\Users\\svøn\\IdeaProjects\\logiq_coding_task_Sveinn_Frimannsson_2022\\src\\actiontexts.txt");

        for (String elem : list) {
            String[] parts = elem.split(":");
            String action = parts[0];
            String text = parts[1];

            switch (action) {
                case "REVERSE":
                    System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + StringUtils.reverse_text(text) + "]");
                    break;

                case "WHITESPACE":
                    System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + StringUtils.remove_whitespace(text) + "]");
                    break;

                case "UNIQUE_COUNT":
                    System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + StringUtils.unique_count(text) + "]");
                    break;

                case "PALINDROME":
                    System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + StringUtils.palindrome(text) + "]");
                    break;

                case "CAPITALIZE":
                    System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + StringUtils.capitalize(text) + "]");
                    break;

                default:
                    System.out.println("Unknown Action: " + action);
            }
        }
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