import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public static boolean switchMenu1(boolean runProgram, List<User> userList, List<Diary> diaryList, User user){

        Scanner scanner = new Scanner (System.in);

        String userChoice1 = scanner.nextLine();

        switch (userChoice1) {

            //USER CAN CREATE A NEW USERNAME

            case "1":
                System.out.println("Please type in your desired user name");
                String userName = scanner.nextLine();
                User newUser = new User(userName);
                userList.add(newUser);
                WriteReadJson.UsersToJason(userList);
                Diary newDiary = new Diary(newUser);
                diaryList.add(newDiary);
                System.out.println("This diary belongs to " + newUser.getUsername());
                try {
                    switchMenu2(true, userList, diaryList, newUser);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                runProgram = true;
                break;


                //PRINT OUT USERS AND ASK USER TO CHOOSE ONE. THEN GO TO SWITCHMENU 2
            case "2":

                for(User users: userList){

                    System.out.println(users.getUser());
                }

                System.out.println("Please choose userName. Type in to continue");
                String activeUser = scanner.nextLine();

                for(User users: userList){

                    if (users.getUsername().equalsIgnoreCase(activeUser)) {

                        users.setActiveUser(activeUser);

                        System.out.println("This diary belongs to " + users.getActiveUser());

                        try {
                            switchMenu2(true, userList, diaryList, user);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        runProgram = true;
                        break;

                    }

                }



                //Exit Program

            case "3":

                return false;




        }


        return true;
    }



    public static boolean switchMenu2(boolean runProgram, List<User> userList, List<Diary> diaryList, User user) throws IOException {

        Scanner scanner = new Scanner (System.in);
        String userChoice2 = scanner.nextLine();

        switch (userChoice2) {

            //PRESENTS OLD DIARY ENTRIES

            case "1":

                //READS FROM JSON FILE
                diaryList = WriteReadJson.DiaryFromJason();
                NewDiaryEntry diaryEntry = new NewDiaryEntry();
                for(Diary entries: diaryList){

                    System.out.println("Title " +diaryEntry.getTitle() );
                    System.out.println("Main Text " +diaryEntry.getMainText() );
                    System.out.println("User " + diaryEntry.getUser());
                    System.out.println("Date " + diaryEntry.getDate());

                }

                runProgram = true;
                break;



            case "2":


             user.getUsername();
                System.out.println(user.toString() + "GASGGSGSGSGSD");
             NewDiaryEntry newDiaryEntry = new NewDiaryEntry();
                System.out.println("Please enter title");
                newDiaryEntry.setTitle(scanner.nextLine());

                System.out.println("Please enter main text");
                newDiaryEntry.setMainText(scanner.nextLine());



                Menu.switchMenu2(true, userList, diaryList, user);
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
