package Utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonReader {

    public static List<Map<String, String>> getTestData(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(filePath), List.class);
        } catch (IOException e) {
            throw new RuntimeException("Error reading JSON file: " + filePath, e);
        }
    }
}