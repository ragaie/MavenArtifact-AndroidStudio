import org.example.KPITApi;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KPITApiTests {
    KPITApi sutApi;

    @BeforeEach
    void setUp() {
        sutApi = new KPITApi();
    }

    @AfterEach
    void tearDown() {
        sutApi = null;
    }
    @Test
    @DisplayName("Normal test case")
    void correctFilepath() {
        try {
            int count = sutApi.countFileWords("src/main/resources/mock-test.txt");
            assertEquals(count, 8071, "counter working correct");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    @Test
    @DisplayName("Empty file")
    void emptyFile() {
        try {
            int count = sutApi.countFileWords("src/main/resources/empty-file.txt");
            assertEquals(count, 0, "counter working correct");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Test
    @DisplayName("Large file")
    void largeFile() {
        try {
            int count = sutApi.countFileWords("src/main/resources/large-file.txt");
            assertEquals(count, 1025017, "counter working correct");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    @Test
    @DisplayName("Empty path")
    void emptyFilepath() {
        try {
            int count = sutApi.countFileWords("");
        } catch (Exception e) {
            assertEquals("java.io.FileNotFoundException:  (No such file or directory)", e.toString());
        }
    }
    @Test
    @DisplayName("null path")
    void nullFilepath() {
        try {
            int count = sutApi.countFileWords(null);
        } catch (Exception e) {
            assertEquals("java.lang.NullPointerException", e.toString());
        }
    }
    @Test
    @DisplayName("Bad file path")
    void badFilepath() {
        try {
            int count = sutApi.countFileWords("resources/mock-test.txt");
        } catch (Exception e) {
            assertEquals("java.io.FileNotFoundException: resources/mock-test.txt (No such file or directory)", e.toString());
        }
    }
}
