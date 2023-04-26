import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {

    /*Test for checking if the program read the files in correctly */
    @Test
    void compareSourceFiles() {
        //Set Up
        ArrayList<String> testArrayList1 = new ArrayList<String>();
        testArrayList1.add("Con heo con bo con ga con vit.");
        testArrayList1.add("Con nguoi con ma con cho. con ngua" );
        testArrayList1.add("con     meo. ? ?");

        String FileName = "./WordCountTest.txt";
        WordCount wc = new WordCount(FileName);
        boolean sameWords = false;

        //Act
        ArrayList<String> result = new ArrayList<String>(wc.getSourceLines());

        //Assert
        assertEquals(true,testArrayList1.equals(result));

    }

    /*Test for word count from the original text file*/

    @Test
    void getWordCount(){
        //Set up
        String FileName = "./WordCountTest.txt";
        String FileName2 = "./BiggerFile.txt";
        WordCount wc = new WordCount(FileName);
        WordCount wc2 = new WordCount(FileName2);

        //Act
        wc.processDocument();
        wc2.processDocument();

        //Assert
        assertEquals(20,wc.getWordCount());
        assertEquals(273,wc2.getWordCount());
    }

    @Test
    void getWordCountForCaseSensitive () {
        //Set up
        String FileName = "./Appleapple.txt";
        WordCount wc = new WordCount(FileName);

        //Act
        wc.processDocument();

        //Assert
        assertEquals(2,wc.getWordCount());
    }

    @Test
    void getFrequency(){
        //Set up
        String FileName = "./WordCountTest.txt";
        WordCount wc = new WordCount(FileName);
        wc.processDocument();

        //Act
        HashMap <String,Integer> result = new HashMap <String,Integer> (wc.getFrequency());

        //Assert : primarily with word that has count more than 1
        assertEquals(2,result.get("Con"));
        assertEquals(7,result.get("con"));
        assertEquals(2,result.get("?"));
        assertEquals(1,result.get("heo"));
    }

    @Test
    void testPrintOutput(){
        // Set Up
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = """
                Original files:
                Con heo con bo con ga con vit.
                Con nguoi con ma con cho. con ngua
                con     meo. ? ?
                                
                Word Count: 20
                Frequency:
                	Con       : 2
                	heo       : 1
                	con       : 7
                	ma        : 1
                	meo.      : 1
                	ngua      : 1
                	nguoi     : 1
                	ga        : 1
                	vit.      : 1
                	cho.      : 1
                	bo        : 1
                	?         : 2
                Number of lines: 3
                Number of characters: 59""";
        // Act
        Main.main(new String[]{"./WordCountTest.txt"});
        // Assert
        assertEquals(expectedOutput, outContent.toString().trim());
        // Reset standard output
        System.setOut(System.out);
    }

    @Test
    void TestEmptyLineEffectOnWordCount(){
        //Set up
        String FileName = "./BiggerFileWithEmptyLine.txt";
        String FileName2 = "./BiggerFile.txt";
        WordCount wc = new WordCount(FileName);
        WordCount wc2 = new WordCount(FileName2);

        //Act
        wc.processDocument();
        wc2.processDocument();

        //Assert
        assertEquals(wc2.getWordCount(),wc.getWordCount());
    }

    @Test
    void TestLineCountWithOutEmptyLine(){
        String FileName = "./BiggerFile.txt";
        WordCount wc = new WordCount(FileName);

        //Act
        wc.processDocument();

        //Assert
        assertEquals(5,wc.lineCount());
    }

    @Test
    void TestLineCountWithEmptyLine(){
        String FileName = "./BiggerFileWithEmptyLine.txt";
        WordCount wc = new WordCount(FileName);

        //Act
        wc.processDocument();

        //Assert
        assertEquals(9,wc.lineCount());
    }

    @Test
    void TestCharCount(){
        String FileName = "./WordCountTest.txt";
        WordCount wc = new WordCount(FileName);

        //Act
        wc.processDocument();

        //Assert
        assertEquals(59,wc.getCharCount());
    }

    @Test
    void TestEmptyLineEffectOnCharCount(){
        //Set up
        String FileName = "./BiggerFileWithEmptyLine.txt";
        String FileName2 = "./BiggerFile.txt";
        WordCount wc = new WordCount(FileName);
        WordCount wc2 = new WordCount(FileName2);

        //Act
        wc.processDocument();
        wc2.processDocument();

        //Assert
        assertEquals(wc2.getCharCount(),wc.getCharCount());
    }

    @Test
    void checkReplaceWordExist(){
        //Set up
        String FileName = "./WordCountTest.txt";
        WordCount wc = new WordCount(FileName);
        wc.processDocument();

        assertFalse(wc.checkReplaceWordExist("ew"));
        assertTrue(wc.checkReplaceWordExist("Con"));

    }
}