import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public static boolean switchMenu1(boolean runProgram, List<User> userList, List<Diary> diaryList){

        Scanner scanner = new Scanner (System.in);

        String userChoice1 = scanner.nextLine();

        switch (userChoice1) {

            case "1":
                System.out.println("Please type in your desired user name");
                String userName = scanner.nextLine();
                User newUser = new User(userName);
                userList.add(newUser);
                WriteReadJson.UsersToJason(userList);
                Diary newDiary = new Diary(newUser);
                diaryList.add(newDiary);
                System.out.println("This diary belongs to " + newUser);
                try {
                    switchMenu2(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                runProgram = true;
                break;


            case "2":

                for(User users: userList){

                    System.out.println(users.getUser());
                }

                System.out.println("Please choose userName. Type in to continue");
                String activeUser = scanner.nextLine();

                for(User users: userList){

                    if (activeUser.equalsIgnoreCase(users){


                    }



                }



                runProgram = true;
                break;


            case "3":

                return false;




        }


        return true;
    }



    public static boolean switchMenu2(boolean runProgram) throws IOException {

        Scanner scanner = new Scanner (System.in);
        String userChoice2 = scanner.nextLine();

        switch (userChoice2) {

            case "1":

                //READS FROM JSON FILE
                WriteReadJson.DiaryFromJason();
                runProgram = true;
                break;

                //TAKES USER INPUT AND WRITES TO JSON FILES

            case "2":

                NewDiaryEntry newDiaryEntry = new NewDiaryEntry();
                UserInput.userInput(newDiaryEntry, entryList);

                runProgram = true;
                break;

            case "3":
                return false;


            default:
                System.out.println("You entered an invalid option");
                break;


        }
        return true;
    }



    public static void optionsMenu1() {

        //USER IS PRESENTED WITH OPTIONS
        System.out.println("Please choose one of the options below by typing a number");
        System.out.println("1. Register a new user");
        System.out.println("2. Choose name from list");
        System.out.println("3. Quit Programme");


    }
    public static void optionsMenu2() {

        //USER IS PRESENTED WITH OPTIONS
        System.out.println("Please choose one of the options below by typing a number");
        System.out.println("1. Read previous entries");
        System.out.println("2. Add new entry");
        System.out.println("3. Quit Programme");
    }

}
