import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordCountTest {

    @Test
    void getSourceLines() {
        ArrayList<String> testArrayList1 = new ArrayList<String>();
        testArrayList1.add("Con heo con bo con ga con vit.");
        testArrayList1.add("Con nguoi con ma con cho." );
        testArrayList1.add("con meo.");
        String FileName = "./WordCountTest.txt";
        boolean sameWords = false;

        WordCount wc = new WordCount(FileName);
        ArrayList<String> result = new ArrayList<String>(wc.getSourceLines());
        sameWords = testArrayList1.equals(result);

        assertEquals(true,sameWords);

    }
}