import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Please choose one of the options below by typing a number");
        System.out.println("1. Read previous entries");
        System.out.println("2. Add new entry");
        System.out.println("3. Quit Programme");


        String userChoice = scanner.nextLine();

        switch (userChoice) {

            case "1":

                System.out.println("Present all previous entries");
                break;

            case "2":
                System.out.println("Add new entry");
                break;

            case "3":
                System.out.println("Quit!");
                break;

            default:
                System.out.println("hey");
                break;




        }

    }
}
