import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {

    /*Test for checking if the program read the files in correctly */
    @Test
    void compareSourceFiles() {
        ArrayList<String> testArrayList1 = new ArrayList<String>();
        testArrayList1.add("Con heo con bo con ga con vit.");
        testArrayList1.add("Con nguoi con ma con cho. con ngua" );
        testArrayList1.add("con     meo. ? ?");

        String FileName = "./WordCountTest.txt";
        WordCount wc = new WordCount(FileName);
        boolean sameWords = false;

        ArrayList<String> result = new ArrayList<String>(wc.getSourceLines());

        assertEquals(true,testArrayList1.equals(result));

    }

    /*Test for word count from the original text file*/

    @Test
    void getWordCount(){
        String FileName = "./WordCountTest.txt";
        WordCount wc = new WordCount(FileName);
        wc.processDocument();
        assertEquals(20,wc.getWordCount());

    }

    @Test
    void getWordCountForCaseSensitive () {
        String FileName = "./Appleapple.txt";
        WordCount wc = new WordCount(FileName);
        wc.processDocument();
        assertEquals(2,wc.getWordCount());
    }

}