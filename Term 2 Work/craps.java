
public class craps {

    public static void main(String[] args) {

        int rollSum = 0;
        boolean firstRoll = true;
        int currentRoll = 0;
        char winLose = 'f';
        int point=-1;

        while (winLose == 'f') {
            currentRoll = ((int) (Math.random()*6+1)) + ((int) (Math.random()*6+1));
            System.out.println("Roll: "+currentRoll);

            if (!firstRoll) { // next rolls 
                if (currentRoll == 7) {
                    winLose = 'l';
                    break;
                }
                if (currentRoll == point) {
                    winLose = 'w';
                    break;
                }
            }

            if (firstRoll){ // all conditions for first roll
                if (currentRoll == 7 || currentRoll == 11){
                    winLose = 't';
                    break;
                }
                if (currentRoll == 2 || currentRoll == 3 || currentRoll == 12) {
                    winLose = 'l';
                    break;
                }

                point = currentRoll;
                firstRoll = false;
            }


        }
        if (winLose == 't') {
            System.out.println("YOU WIN!");
        } else if (winLose == 'l') {
            System.out.println("YOU LOSE :(");
        } else {
            System.out.println("Broke??");
        }

       


    }


}