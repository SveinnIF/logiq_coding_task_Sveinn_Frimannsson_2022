import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> list = ReadFile.read("C:\\Users\\svøn\\IdeaProjects\\logiq_coding_task_Sveinn_Frimannsson_2022\\actiontexts.txt");

        for(String elem : list){ // iterating through the list
            String[] parts = elem.split(":"); // splitting the elements in two parts, the action part and the text part
            String action = parts[0];
            String text = parts[1];

            switch (action) { // checking what action to preform on what text and then calling the function that does that action
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

                default:
                    System.out.println("Unknown Action: " + action);
            }
        }
    }

    private static String reverse_text(String text) {

        StringBuilder text_reversed = new StringBuilder(); // making a string builder

        text_reversed.append(text); // appending the text to the string builder

        text_reversed.reverse(); // using the string builder to reverse the text

        return String.valueOf(text_reversed);
    }

    private static String remove_whitespace(String text) {
        return text.replaceAll("\\s", ""); // replaces all white spaces, denoted in unicode as "\\s", and replacing it with not a space.
    }
    private static int unique_count(String text) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    private static String palindrome(String text) {
        String reversed_text = reverse_text(text); // using the reverse text function to reverse the text
        if(reversed_text.equals(text)){ // checking if the text is equal to its reversed counterpart
            return "True";
        }else{
            return "False";
        }
    }
}

/*
In Java 12 it is possible to make the switch statement into a switch expression, like this:

            switch (action) {
                case "REVERSE" -> reverse_text(text);
                case "WHITESPACE" -> remove_whitespace(text);
                case "UNIQUE_COUNT" -> unique_count(text);
                case "PALINDROME" -> palindrome(text);
                default -> System.out.println("Unknown action: " + action);
            }

This would make it a bit easier to read and can reduce the amount of bugs in the code according Oracle: https://blogs.oracle.com/javamagazine/post/new-switch-expressions-in-java-12
 */