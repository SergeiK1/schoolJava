
public class craps {

    public static void runCraps(int[] statsWon, int[] statsLoss){
        // int rollSum = 0;
        int numberRoll = 0;
        int currentRoll = 0;
        boolean lost = false;
        int point=-1;

        while (!lost) {
            numberRoll++;
            currentRoll = ((int) (Math.random()*6+1)) + ((int) (Math.random()*6+1));
            // System.out.println("Roll: "+currentRoll);


            if (numberRoll > 1) { // next rolls 
                if (numberRoll > 20){
                    if (currentRoll == 7) {
                        statsLoss[20]++;
                        lost = true;
                        break;
                    }
                    if (currentRoll == point) {
                        statsWon[20]++;
                        lost = true;
                        break;
                    } 
                }
                if (currentRoll == 7) {
                    statsLoss[numberRoll]++;
                    lost = true;
                    break;
                }
                if (currentRoll == point) {
                    statsWon[numberRoll]++;
                    lost = true;
                    break;
                }
            }

            if (numberRoll == 1){ // all conditions for first roll
                if (currentRoll == 7 || currentRoll == 11){
                    statsWon[numberRoll]++;
                    lost = true;
                    break;

                }
                if (currentRoll == 2 || currentRoll == 3 || currentRoll == 12) {
                    statsLoss[numberRoll]++;
                    lost = true;
                    break;
                }

                point = currentRoll;
            }


        }

    }

    public static void main(String[] args) {

        int TRIALS = 10000;
        int winSum = 0;
        int lossSum = 0;

        int[] statsWon = new int[21];
        int[] statsLoss = new int[21];

        for (int i = 0; i < TRIALS; i++){
            runCraps(statsWon, statsLoss);
        }
        System.out.println("--- Victories ---");
        for (int j = 1; j<statsWon.length; j++){
            System.out.println("["+j+"]:  "+statsWon[j]);
            winSum += statsWon[j];
        }
        System.out.println("--- Defeats ---");
        for (int k = 1; k<statsLoss.length; k++){
            System.out.println("["+k+"]:  "+statsLoss[k]);
            lossSum += statsLoss[k];
        }

        System.out.println("## RESULTS ##");
        System.out.println("Total Win: "+winSum);
        System.out.println("Total Loss: "+lossSum);
       
    }


}