import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        List<String> list = ReadFile.read("C:\\Users\\svøn\\IdeaProjects\\logiq_coding_task_Sveinn_Frimannsson_2022\\src\\actiontexts.txt");

        for(String elem : list){ // iterating through the list
            String[] parts = elem.split(":"); // splitting the elements in two parts, the action part and the text part
            String action = parts[0];
            String text = parts[1];

            switch (action) { // checking what action to preform on what text and then calling the function that does that action
                case "REVERSE" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + reverse_text(text) + "]");
                case "WHITESPACE" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + remove_whitespace(text) + "]");
                case "UNIQUE_COUNT" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + unique_count(text) + "]");
                case "PALINDROME" -> System.out.println("Text: [" + text + "] ran Action: [" + action + "] with the result of: [" + palindrome(text) + "]");
                default -> System.out.println("Unknown Action: " + action);
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
        int unique_character_count = 0;
        List<Character> visited_characters = new LinkedList<Character>(); // array for storing characters
        for (int i = 0; i < text.length(); i++) { // going through all characters in string
            if(!visited_characters.toString().contains(text.subSequence(i, i +1))) { // checks if the text contains characters that has already visited
                unique_character_count++; // if the character is not in the visited_characters array, it is a unique character and is added to the count
                visited_characters.add(text.charAt(i)); // then this character is added to the visited_characters array so it is not counted again
            }
        }
        return unique_character_count;
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
In Java 12 it is possible to make the switch statement look like this:

            switch (action) {
                case "REVERSE" -> reverse_text(text);
                case "WHITESPACE" -> remove_whitespace(text);
                case "UNIQUE_COUNT" -> unique_count(text);
                case "PALINDROME" -> palindrome(text);
                default -> System.out.println("Unknown Action: " + action);
            }
 */