import java.util.Scanner;
public class Main {

    //Global variables
    static String myErr;

    public static void main(String[] args) {
        int number;
        int input1;
        int input2;
        String name;
        boolean looping = true;
        Scanner whichNumber = new Scanner(System.in);
        Scanner whichName = new Scanner(System.in);
        Scanner doWhat = new Scanner(System.in);
        System.out.print("""
                What would you like to do? (Type the word after the colon of the task you would like done)
                Say hello: hello
                Check if a non-zero integer is positive or negative: sign
                Check if an integer is positive, negative or zero: zsign
                Find out the favorite drink of somebody: drink
                Get the sum of two integers: sum
                
                Answer ->\s""");
        String task = doWhat.nextLine();

        switch (task) {

            /*-------------
             * hello task |
             *-----------*/
            case "hello":
                hello();
                break;

            /*------------
             * sign task |
             *----------*/
            case "sign":
                myErr = "Error. You have not entered a non-zero integer.";
                while(looping) {
                    System.out.print("Enter a non-zero integer: ");
                    if (whichNumber.hasNextInt()) {
                        number = whichNumber.nextInt();
                        if (number == 0) {
                            System.out.println(myErr);
                        } else {
                            positiveOrNegative(number);
                            looping = false;
                        }
                    } else {
                        whichNumber.nextLine();
                        System.out.println(myErr);
                    }
                }
                break;

            /*-------------
             * zsign task |
             *-----------*/
            case "zsign":
                myErr = "Error. You have not entered an integer.";
                while(looping) {
                    System.out.print("Enter an integer: ");
                    if (whichNumber.hasNextInt()) {
                        number = whichNumber.nextInt();
                        positiveOrZeroOrNegative(number);
                        looping = false;
                    } else {
                        whichNumber.nextLine();
                        System.out.println(myErr);
                    }
                }
                looping = true;
                break;

            /*------------
            * drink task |
            *-----------*/
            case "drink":
                System.out.print("""
                        Whose favorite drink would you like to know?
                        Ben
                        Mark
                        Robert-Jan
                        Henk
                        
                        Answer ->\s""");
                name = whichName.nextLine();
                bartender(name);
                break;

            /*----------
            * sum task |
            *---------*/
            case "sum":
                while(looping) {
                    System.out.print("Enter two integers: ");
                    if (whichNumber.hasNextInt()) {
                        input1 = whichNumber.nextInt();
                        input2 = whichNumber.nextInt();
                        sum(input1, input2);
                        looping = false;
                    } else {
                        System.out.println("Error. Please enter two integers.");
                    }
                }
                looping = true;
                break;

            /*---------------
            * invalid input |
            *--------------*/
            default:
                System.out.println("That's not a valid task");
                break;
        }
    }


    /*-----------------------------------------------
     *                                              |
     *                    METHODS                   |
     *                                              |
     *---------------------------------------------*/

    /*-------------------
     *      HELLO       |
     *-----------------*/
    public static void hello() {
            System.out.println("Hello World");
    }

    /*-------------------
     *      SIGN        |
     *-----------------*/
    public static void positiveOrNegative(int number) {
        String sign = "";
        if (number < 0) {
            sign = "negative";
        } else if (number > 0) {
            sign = "positive";
        }
        System.out.printf("This number is %s.\n", sign);
    }

    /*-------------------
     *    ZERO SIGN     |
     *-----------------*/
    public static void positiveOrZeroOrNegative(int number) {
        String sign = "";
        if (number < 0) {
            sign = "negative";
        } else if (number > 0) {
            sign = "positive";
        } else if (number == 0) {
            sign = "zero";
        }
        System.out.printf("This number is %s.\n", sign);
    }

    /*-------------------
     *    BARTENDER     |
     *-----------------*/
    public static void bartender(String name) {
        String drink = "";
        boolean knowDrink = true;
        myErr = "Ik weet niet wat %s graag drinkt.";
        switch (name) {
            case "Ben":
                drink = "Spa rood";
                break;
            case "Mark":
                drink = "Fanta";
                break;
            case "Robert-Jan":
                drink = "Cola";
                break;
            case "Henk":
                drink = "Pan Galactic Gargle Blaster";
                break;
            default:
                System.out.printf(myErr, name);
                knowDrink = false;
        }
        if (knowDrink) System.out.printf("%s drinkt graag %s.\n", name, drink);
    }

    /*-------------------
     *       SUM        |
     *-----------------*/
    public static void sum(int input1, int input2) {
        System.out.println(input1 + input2);
    }
}