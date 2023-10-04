
public class christmas {
    public static void main(String[] args) {

        System.out.println("The Twelve Days of Christmas");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        for(int day = 1; day < 13; day++){
            System.out.println("On the " + day + "th day of Christmas \nMy true love gave to me: ");

            switch(day){
                case 12:
                    System.out.println("12 Drummers Drumming");

                case 11:
                    System.out.println("11 Piper Piping");
                
                case 10:
                    System.out.println("10 Lord a Leaping");
                
                case 9:
                        System.out.println("9 Ladies Dancing");
                
                case 8:
                        System.out.println("8 Maids a Milking");

                case 7:
                    System.out.println("7 Swans a Swimming");

                case 6:
                    System.out.println("6 Geese a Laying");
                
                case 5:
                    System.out.println("5 Golden Rings");
                
                case 4:
                        System.out.println("4 Calling Birds");
                
                case 3:
                        System.out.println("3 French Hens");

                case 2:
                        System.out.println("2 Turtle Doves");
                        System.out.print("and ");
                
                default:
                        System.out.println("a Partridge in a Pear Tree");
                        System.out.println(" ");
                        System.out.println(" ");


            }


        }


    }
}