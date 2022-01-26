import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {

    public static List<String> read(String filename) throws IOException {
        try (var reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().collect(Collectors.toList());
        }
    }

}