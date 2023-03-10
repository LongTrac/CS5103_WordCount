import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMainWithIncorrectNumberOfArgLarger() {
        // Set Up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test against 2 or more args
        Main.main(new String[]{"", "", " "});

        // Assert
        String expectedOutput = "The program must have 1 and only 1 argument representing the file that you want to count the word.";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset standard output
        System.setOut(System.out);
    }

    @Test
    void testMainWithIncorrectNumberOfArgSmaller() {
        // Set Up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test against 0 args
        Main.main(new String[]{});

        // Assert
        String expectedOutput = "The program must have 1 and only 1 argument representing the file that you want to count the word.";
        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset standard output
        System.setOut(System.out);
    }

    @Test
    void testMainWithCorrectNumberOfArg() {
        // Set up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        Main.main(new String[]{"./Appleapple.txt"});

        // Assert
        String expectedOutput = """
                Original files:
                Apple
                apple
               
                Word Count: 2
                Frequency:
                \tapple     : 1
                \tApple     : 1""";

        assertEquals(expectedOutput, outContent.toString().trim());

        // Reset standard output
        System.setOut(System.out);
    }
}