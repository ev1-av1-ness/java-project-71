package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferTest {
    @Test
    void testGenerate1() throws Exception {
        String expectedResult = Files.readString(Path.of("src/test/resources/expected1.txt"));
        String filePath1 = ("src/test/resources/file1.json");
        String filePath2 = ("src/test/resources/file2.json");
        String actualResult = Differ.generate(filePath1, filePath2);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
