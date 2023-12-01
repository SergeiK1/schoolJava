
public class Dicebaby {

    public static void main(String[] args) {
        int NUM_FACES = 6;
        int NUM_DIE = 2;
        int TRIALS = 100;

        int[] TOTAL = new int[NUM_FACES*NUM_DIE-NUM_DIE+1];

        for (int i = 0; i < TRIALS; i++){
            int internalSum = 0;
            for (int j = 0; j < NUM_DIE; j++) {
                internalSum += (int) (Math.random() * NUM_FACES + 1);
                // System.out.println(internalSum);
            }
            TOTAL[internalSum-NUM_DIE] += 1;
        }


        for (int k = 0; k < TOTAL.length; k++){
            System.out.println("[ "+(k+NUM_DIE)+" ]:   "+TOTAL[k]);
        }

    }

}