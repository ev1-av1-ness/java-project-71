package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String content, String dataFormat) throws Exception {

        switch (dataFormat.toUpperCase()) {
            case "JSON" -> {
                return parserJSON(content);
            }
            case "YAML" -> {
                return parserYAML(content);
            }
            default -> throw new Exception("Unknown data format: " + dataFormat);
        }
    }

    public static Map<String, Object> parserJSON(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<HashMap<String, Object>>() {
        });
    }

    public static Map<String, Object> parserYAML(String content) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content, new TypeReference<HashMap<String, Object>>() {
        });
    }
}
