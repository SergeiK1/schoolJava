import java.util.Scanner;

public class countVowels {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("[ Enter Text ]  ");
        String sentence = getValue.nextLine();
        getValue.close();
        int counter =0;
        for (int i =0; i<sentence.length();i++){

            if (sentence.substring(i, i+1).equals("a") || sentence.substring(i, i+1).equals("e") || sentence.substring(i, i+1).equals("i") || sentence.substring(i, i+1).equals("o") || sentence.substring(i, i+1).equals("u") || sentence.substring(i, i+1).equals("A") || sentence.substring(i, i+1).equals("E") || sentence.substring(i, i+1).equals("I") || sentence.substring(i, i+1).equals("O") || sentence.substring(i, i+1).equals("U") ){
                counter++; 
            } else {
                continue;
            }
        }
        System.out.println("There are " + counter + " vowels in \"" + sentence + ".\"");
    }
}