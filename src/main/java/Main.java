import java.io.IOException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {


        //Main Program Loop
        boolean runProgram = true;
        while (runProgram) {

            options2();

            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();

            runProgram = Menu.menu2(userChoice, true);



        }
    }


    public static void options1() {



    }

    public static void options2() {

        //USER IS PRESENTED WITH OPTIONS
        System.out.println("Please choose one of the options below by typing a number");
        System.out.println("1. Read previous entries");
        System.out.println("2. Add new entry");
        System.out.println("3. Quit Programme");
    }
    }





