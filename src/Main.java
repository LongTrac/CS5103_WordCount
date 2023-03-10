public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("The program must have 1 and only 1 argument representing the file that you want to count the word.");
            return;
        }
        WordCount wc = new WordCount(args[0]);
        wc.processDocument();
        wc.printResult();
    }
}