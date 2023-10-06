import java.util.Scanner;

public class grammar {
    public static void main(String[] args) {
        Scanner getValue = new Scanner(System.in);
        System.out.print("[ Enter Sentence ]  ");
        String sentence = getValue.nextLine();
        System.out.print("[ String to Remove ]  ");
        String remove = getValue.nextLine();
        // String newSentence="";
        getValue.close();
        boolean testing= true;
        while (testing) {
            int location = sentence.indexOf(remove, 0);
            if (location == -1){
                testing=false;
                break;
            }
            int len = remove.length();
            sentence = sentence.substring(0, location) + sentence.substring(location+len+1);
        }

        System.out.println(sentence);
        }
}