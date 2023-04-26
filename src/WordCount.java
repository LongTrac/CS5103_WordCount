import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class WordCount {
    private String SrcFileName;                     //File name
    private ArrayList<String> SourceLines;          //array list of source text lines
    private int WordCount;
    private int CharCount;
    private HashMap<String, Integer> frequency;

    public WordCount(String SourceFileName){
        this.SrcFileName = SourceFileName;
        SourceLines = new ArrayList<String>();
        WordCount = 0;
        CharCount = 0;
        frequency = new HashMap<String, Integer>();

        try {
            File file = new File(this.SrcFileName);
            java.util.Scanner sc = new java.util.Scanner(file);

            while (sc.hasNextLine()) {
                String sTemp = sc.nextLine();
                SourceLines.add(sTemp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File can not be opened. Please check filepath");
        }
    }

    public void processDocument (){
        for (String line: this.SourceLines) {
            //Skip processing empty line
            if (line.isEmpty() || line.isBlank())
                continue;
            //count total words
            String[] tokens = line.split("[ \t\n]+");
            this.WordCount += tokens.length;

            //count character
            for (String token: tokens){
                this.CharCount += token.length();
            }

            Integer count = 0;
            //count frequency
            for (String word: tokens) {
                count = 0;
                if(frequency.containsKey(word)){
                    count = frequency.get(word);
                }
                count++;
                frequency.put(word,count);
            }
        }
    }

    public void printResult(){
        StringBuilder result = new StringBuilder();
        result.append("Original files:\n");

        for (String line: SourceLines) {
            result.append(line + "\n");
        }

        result.append("\nWord Count: "+this.getWordCount());
        result.append("\nFrequency:");

        for(String key: frequency.keySet()){
            result.append(String.format("\n\t%-10s: %s",key,frequency.get(key)));
        }
        result.append("\nNumber of lines: " + lineCount());
        result.append("\nNumber of characters: " + getCharCount());


        System.out.println(result);
    }

    public int lineCount (){
        return SourceLines.size();
    }

    public void optionalWordReplacement(String replaceWord, String replaceWith){
        //if word not found in doc
        if(!checkReplaceWordExist(replaceWord)){
            System.out.println("The word you want to replace can not be found in the document");
            return;
        }
        //word found ==> replacing
        ArrayList<String> afterReplace = new ArrayList<>();
        for (String line: SourceLines) {
            afterReplace.add(line.replace(replaceWord, replaceWith));
        }
        writeOutput(afterReplace);
    }

    public boolean checkReplaceWordExist (String replaceWord){
        return(frequency.containsKey(replaceWord));
    }

    public void writeOutput (ArrayList<String> list){
        String name = SrcFileName.substring(0,SrcFileName.length()-4)+"AfterReplacement.txt";
        File file = new File(name);
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            for (String item : list) {
                writer.println(item);
            }
            writer.close();
            System.out.println("The replacement is complete please check the file: "+ name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /********************************************Getter and Setter*************************************/
    public ArrayList<String> getSourceLines() {
        return SourceLines;
    }
    public int getWordCount () {
        return WordCount;
    }
    public int getCharCount() {
        return CharCount;
    }
    public HashMap<String,Integer> getFrequency () { return frequency; }
}
