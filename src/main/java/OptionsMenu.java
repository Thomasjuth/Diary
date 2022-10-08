import java.util.Scanner;

public class OptionsMenu {



    public static int optionsAndChoice1() {


        System.out.println("Please choose one of the options below by typing a number");
        System.out.println("1. Register a New User");
        System.out.println("2. Choose User From List");
        System.out.println("3. Quit Programme");



        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();

        return choice;
    }



    public static int optionsAndChoice2() {


        System.out.println("1. Display Old Entries");
        System.out.println("2. Create New Entry");
        System.out.println("3. Return to the first menu");
        System.out.println("4. Quit Programme");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose one of the options below by typing a number");

        return scanner.nextInt();
    }

}
