import java.util.Scanner;

public class Hangman {

    public static String draw(int n){
        String answer = "";
        switch (n) {
            
            case 0:
                answer =        "|--|\n" + 
                                "| \n" + 
                                "| \n" + 
                                "| \n" + 
                                "|  \n" + 
                                "| \n" + 
                                "| \n" + 
                                "----";
                return answer;
            case 1:
                answer =        "|--|\n" + 
                                "|  0\n" + 
                                "| \n" + 
                                "| \n" + 
                                "|  \n" + 
                                "| \n" + 
                                "| \n" + 
                                "----";
                return answer;
            
            case 2:
                answer =        "|--|\n" + 
                                "|  0\n" + 
                                "|  |\n" + 
                                "| \n" + 
                                "|  \n" + 
                                "| \n" + 
                                "| \n" + 
                                "----";
                return answer;
            
            case 3:
                answer =        "|--|\n" + 
                                "|  0\n" + 
                                "| -|\n" + 
                                "| \n" + 
                                "|  \n" + 
                                "| \n" + 
                                "| \n" + 
                                "----";
                return answer;
              
            case 4:
                answer =        "|--|\n" + 
                                "|  0\n" + 
                                "| -|-\n" + 
                                "| \n" + 
                                "|  \n" +
                                "| \n" + 
                                "| \n" +
                                "----";
                return answer;
                
            case 5:
                answer =        "|--| \n" + 
                                "|  0 \n" + 
                                "| -|-\n" + 
                                "|  | \n" + 
                                "| /  \n" + 
                                "|    \n" + 
                                "|    \n" + 
                                "----";
                return answer;
            
            case 6:
                answer =        "|--|\n" + 
                                "|  0\n" + 
                                "| -|-\n" + 
                                "|  |\n" + 
                                "| / \\\n" + 
                                "| \n" + 
                                "| \n" + 
                                "----";
                return answer;
            default:
                return "";
        }
    }

    public static String chosenWord(){
        String word = "";
        String wordList = "testword, yetanotherone, aretheseevenwords, christmas, signing, playing, paper, mathclass,";
        int num = (int) (Math.random()*8.0);
        for (int i =0; i<num; i++){
            int comma = wordList.indexOf(",");
            wordList = wordList.substring(comma+2);
        }
        int comma = wordList.indexOf(",");
        word = wordList.substring(0, comma);
        return word;

    }

    public static String gaps(String word, char guess, String currentGaps){
        String result = currentGaps;
        // use the fact that itst 3 so like find the index of the letter in the word and multiply by 3 for starting index in the blanks and delete the next 3 and replace with letter

        for (int i =0; i<word.length();i++){
            if (word.charAt(i) == guess){
                int index = i*3;
                result = result.substring(0, index) + " " + guess + " " + result.substring(index+3);
            }
        }
               if (result.indexOf("_") == -1){
            return "w";
        } 
        return result;
    }
        
    public static void main(String[] args) {
        String death = "\n\n\n               ...\n" + //
                "             ;::::;\n" + //
                "           ;::::; :;\n" + //
                "         ;:::::'   :;\n" + //
                "        ;:::::;     ;.\n" + //
                "       ,:::::'       ;           OOO\\\n" + //
                "       ::::::;       ;          OOOOO\\\n" + //
                "       ;:::::;       ;         OOOOOOOO\n" + //
                "      ,;::::::;     ;'         / OOOOOOO\n" + //
                "    ;:::::::::`. ,,,;.        /  / DOOOOOO\n" + //
                "  .';:::::::::::::::::;,     /  /     DOOOO\n" + //
                " ,::::::;:: DEATH ;::::;,   /  /        DOOO\n" + //
                ";`::::::`'::::::;;;::::: ,#/  /          DOOO\n" + //
                ":`:::::::`;::::::;;::: ;::#  /            DOOO\n" + //
                "::`:::::::`;:::::::: ;::::# /              DOO\n" + //
                "`:`:::::::`;:::::: ;::::::#/               DOO\n" + //
                " :::`:::::::`;; ;:::::::::##                OO\n" + //
                " ::::`:::::::`;::::::::;:::#                OO\n" + //
                " `:::::`::::::::::::;'`:;::#                O\n" + //
                "  `:::::`::::::::;' /  / `:#\n" + //
                "   ::::::`:::::;'  /  /   `#\n";

        String winner =           "\n\n\n .-=========-.     \n"+
                                  " \\'-=======-'/    \n"+
                                  " _|   .=.   |_      \n"+
                                  "((|  {{1}}  |))     \n"+
                                  " \\|   /|\\   |/    \n"+
                                  "  \\__ '`' __/      \n"+
                                  "    _`) (`_         \n"+
                                  "  _/_______\\_      \n"+
                                  " /___________\\ ";
        System.out.println("\n\n WELCOME TO HANGMAN \n");
        System.out.println("|--|\n|  0\n| -|-    DO NOT DIE\n|  |\n| / \\ \n| \n| \n----");
        Scanner getValue = new Scanner(System.in);
        
        String chosenWord = chosenWord();

        int wrongCounter = 0;
        String currentGaps="";
        for (int i =0; i<chosenWord.length(); i++){
            currentGaps += "__ ";
        }
        System.out.println(currentGaps);
        System.out.println("Chosen: "+chosenWord);
        while (true) {

            System.out.print("\n[ Guess ] --> ");
            char guess = getValue.nextLine().charAt(0);

            if (chosenWord.indexOf(guess) == -1) {
                wrongCounter+=1;
                if (wrongCounter > 5) {
                    System.out.println(death);
                    System.out.println("\n     ---- YOU LOSE ----   \n\n");
                    break;
                }
                

            }
            System.out.println(draw(wrongCounter));
            currentGaps=gaps(chosenWord, guess, currentGaps);
            if (currentGaps.equals("w")){
                System.out.println(winner);
                System.out.println("\n--- YOU WIN ---  \n\n");
                break;
            }
            System.out.println(currentGaps);      

        }
    }
}