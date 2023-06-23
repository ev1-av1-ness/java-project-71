package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    void testGenerateJsonPlain() throws Exception {
        String expectedResult = Files.readString(Path.of("src/test/resources/expected1.json"));
        String filePath1 = ("src/test/resources/file1.json");
        String filePath2 = ("src/test/resources/file2.json");
        String actualResult = Differ.generate(filePath1, filePath2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testGenerateJsonStylish() throws Exception {
        String expectedResult = Files.readString(Path.of("src/test/resources/expected_stylish.json"));
        String filePath1 = ("src/test/resources/file_stylish_1.json");
        String filePath2 = ("src/test/resources/file_stylish_2.json");
        String actualResult = Differ.generate(filePath1, filePath2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testGenerateYamlPlain() throws Exception {
        String expectedResult = Files.readString(Path.of("src/test/resources/expected2.yaml"));
        String filePath1 = ("src/test/resources/file1.yaml");
        String filePath2 = ("src/test/resources/file2.yaml");
        String actualResult = Differ.generate(filePath1, filePath2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void testYamlGenerateStylish() throws Exception {
        String expectedResult = Files.readString(Path.of("src/test/resources/expected_stylish.yaml"));
        String filePath1 = ("src/test/resources/file_stylish_1.yaml");
        String filePath2 = ("src/test/resources/file_stylish_2.yaml");
        String actualResult = Differ.generate(filePath1, filePath2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
