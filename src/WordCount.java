import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WordCount {
    private String SrcFileName;                     //File name



    private ArrayList<String> SourceLines;          //array list of source text lines
    private static String Blank = " \t\n";          //All acceptable blank characters
    private static String Punctuation = ":;,.?!";

    public WordCount(String SourceFileName){
        this.SrcFileName = SourceFileName;
        SourceLines = new ArrayList<String>();

        try {
            File file = new File(this.SrcFileName);
            java.util.Scanner sc = new java.util.Scanner(file);

            while (sc.hasNextLine()) {
                String sTemp = sc.nextLine();
                SourceLines.add(sTemp);
                System.out.println(sTemp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File can not be opened");
        }
    }




    /********************************************Getter and Setter*************************************/
    public ArrayList<String> getSourceLines() {
        return SourceLines;
    }
}
