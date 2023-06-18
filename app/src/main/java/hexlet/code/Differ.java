package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    static String generate(String filePath1, String filePath2) throws Exception {
        Path path1 = Path.of(filePath1).toAbsolutePath().normalize();
        Path path2 = Path.of(filePath2).toAbsolutePath().normalize();

        // Проверяем существование файла
        if (!Files.exists(path1)) {
            throw new Exception("File '%s' does not exist".formatted(path1));
        }
        if (!Files.exists(path2)) {
            throw new Exception("File '%s' does not exist".formatted(path2));
        }

        // Читаем файлы
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        // Строку в мапу
        Map<String, Object> map1 = stringToMap(content1);
        Map<String, Object> map2 = stringToMap(content2);

        // результирующая мапа
        Map<String, Object> result = new HashMap<>();

        Set<String> keys = new TreeSet<>(map1.keySet());
        keys.addAll(map2.keySet());

        for (String key : keys) {
            String keyRemoved = "- " + key;
            String keyAdded = "+ " + key;
            if (!map1.containsKey(key)) {
                result.put(keyAdded, map2.get(key));
            } else if (!map2.containsKey(key)) {
                result.put(keyRemoved, map1.get(key));
            } else if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result.put(key, map1.get(key));
                } else {
                    result.put(keyRemoved, map1.get(key));
                    result.put(keyAdded, map2.get(key));
                }
            }
        }
        return mapToString(result);
    }

    public static Map stringToMap(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }

    public static String mapToString(Map<String, Object> map) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}
