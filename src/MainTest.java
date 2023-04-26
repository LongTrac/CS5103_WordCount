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
        Main.main(new String[]{"", "", " "," "});

        // Assert
        String expectedOutput = "The program must have at least 1 argument representing the file that you want to count the word.\n" +
                " The second and third argument are optional representing the word you want to replace and what you want to replace it with.";
        try{
            assertEquals(expectedOutput, outContent.toString().trim().replace("\r",""));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }

    @Test
    void testMainWithIncorrectNumberOfArgSmaller() {
        // Set Up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test against 0 args
        Main.main(new String[]{});

        // Assert
        String expectedOutput = "The program must have at least 1 argument representing the file that you want to count the word.\n" +
                " The second and third argument are optional representing the word you want to replace and what you want to replace it with.";
        try{
            assertEquals(expectedOutput, outContent.toString().trim().replace("\r",""));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }

    @Test
    void testMainWithIncorrectNumberOfArgEqual2() {
        // Set Up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Test against 2 or more args
        Main.main(new String[]{"", "", " "," "});

        // Assert
        String expectedOutput = "The program must have at least 1 argument representing the file that you want to count the word.\n" +
                " The second and third argument are optional representing the word you want to replace and what you want to replace it with.";
        try{
            assertEquals(expectedOutput, outContent.toString().trim().replace("\r",""));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }

    @Test
    void testMainWithOneArg() {
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
                \tApple     : 1
                Number of lines: 2
                Number of characters: 10""";

        try{
            assertEquals(expectedOutput, outContent.toString().trim().replace("\r",""));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }

    @Test
    void testMainWithThreeArgCorrectly() {
        // Set up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        Main.main(new String[]{"./Appleapple.txt","apple","bee"});

        // Assert
        String expectedOutput = """
                Original files:
                Apple
                apple
               
                Word Count: 2
                Frequency:
                \tapple     : 1
                \tApple     : 1
                Number of lines: 2
                Number of characters: 10
                The replacement is complete please check the file: ./AppleappleAfterReplacement.txt""";

        try{
            assertEquals(expectedOutput, outContent.toString().trim().replace("\r",""));
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }

    @Test
    void testMainWithThreeArgIncorrectly() {
        // Set up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        Main.main(new String[]{"./Appleapple.txt","bee","beef"});

        // Assert
        String expectedOutput = """
                Original files:
                Apple
                apple
               
                Word Count: 2
                Frequency:
                \tapple     : 1
                \tApple     : 1
                Number of lines: 2
                Number of characters: 10
                The word you want to replace can not be found in the document""";

        try{
            assertEquals(expectedOutput, outContent.toString().trim().replace("\r",""));
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // Reset standard output
            System.setOut(System.out);
        }
    }
}