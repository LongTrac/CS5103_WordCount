import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean returnFlag = true;
        if(args.length == 1 || args.length==3)
            returnFlag = false;
        if(returnFlag){
            System.out.println("The program must have at least 1 argument representing the file that you want to count the word.\n" +
                    " The second and third argument are optional representing the word you want to replace and what you want to replace it with.");
            return;
        }

        // mandatory part
        WordCount wc = new WordCount(args[0]);
        wc.processDocument();
        wc.printResult();

        //optional
        if(args.length == 3){
            wc.optionalWordReplacement(args[1], args[2]);
        }

    }
}