import java.util.Scanner;

public class turtle{
    public static void main(String[] args){

        char[][] canvas = new char[20][20]; // creates 20 x 20 array
        for (int i = 0; i < canvas.length; i++){
            for (int j = 0; j < canvas[0].length; j++){
                canvas[i][j] = '-';
            }
        }
        boolean END = false;
        int direction = 0; // 0 = up  1 = right  2 = up  3 = up
        boolean penDown = false;
        int[] currentCoord = {0,0};
        
        Scanner getValue = new Scanner(System.in);


        while (!END) {

            System.out.println("\n\t[ --  Next Move  -- ]\n");
            System.out.println("\t[1] pen up\n\t[2] pen down\n\t[3] turn right\n\t[4] turn left\n\t[5] move forward\n\t[6] display canvas\n\t[9] end\n\n");
            System.out.print("\t[ SELECT ] ");

            int userInput = getValue.nextInt();



        


    


            switch (userInput){
                case 1:
                    //pen up
                    penDown = false;
                    break;
                case 2:
                    // pen down 
                    penDown = true;
                    break;
                case 3:
                    //turn right 
                    direction -= 1;
                    if (direction == -1) {
                        direction = 3;
                    }
                    System.out.println("direction: " + direction);
                    break;
                case 4:
                    //turn left
                    direction += 1;
                    if (direction == 4) {
                        direction = 0;
                    }
                    System.out.println("direction: " + direction);
                    break;
                case 5:
                    // move forward 
                    try {
                        switch (direction){
                            case 0:
                                // increase y
                                if (penDown){
                                    canvas[currentCoord[0]][currentCoord[1]] = '#';
                                }
                                currentCoord[1] += 1;
                                break;
                            case 1:
                                // increase x 
                                if (penDown){
                                    canvas[currentCoord[0]][currentCoord[1]] = '#';
                                }
                                currentCoord[0] += 1;
                                break;
                            case 2:
                                // decrease y
                                if (penDown){
                                    canvas[currentCoord[0]][currentCoord[1]] = '#';
                                }
                                currentCoord[1] -= 1;
                                break;
                            case 3:
                                // decrease x
                                if (penDown){
                                    canvas[currentCoord[0]][currentCoord[1]] = '#';
                                }
                                currentCoord[1] -= 1;
                                break;
                        }
                    } catch (Exception e) {
                        if (currentCoord[0] > 20) {
                            currentCoord[0]--;
                        }
                        if (currentCoord[0] < 0) {
                            currentCoord[0]++;
                        }
                        if (currentCoord[1] > 20) {
                            currentCoord[1]--;
                        }
                        if (currentCoord[1] < 0) {
                            currentCoord[1]++;
                        }
                        System.out.println("Out Of Bounds");
                        System.out.println("Coords: "+currentCoord[0] + " " + currentCoord[1]);
                        break;
                    }
                    break;
                case 6:
                    //display 
                    for (int i = 0; i < canvas.length; i++){
                        for (int j = 0; j < canvas[0].length; j++){
                            System.out.print(canvas[j][i]+" ");
                        }
                        System.out.print("\n");
                    } 
                    break;
                case 9:
                    //end 
                    System.out.println("END");
                    END = true;
                    break;

                default:
                    System.out.println("Not Found Selection: "+userInput);
                    break;
            }

    }
    getValue.close();
    }
}