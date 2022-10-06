import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {


    public static boolean switchMenu1(String choice, boolean runProgram, List<User> userList, List<Diary> diaryList){

        Scanner scanner = new Scanner (System.in);



        switch (choice) {

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

                    optionsMenu2();

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

                            optionsMenu2();


                        break;

                    }

                }




            case "3":

                return false;




        }


        return true;
    }



    public static boolean switchMenu2(String choice, boolean runProgram, List<Diary> diaryList, User user) throws IOException {

        Scanner scanner = new Scanner (System.in);


        switch (choice) {

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


                break;



            case "2":


                System.out.println(user.toString() + "GASGGSGSGSGSD");
                 NewDiaryEntry newDiaryEntry = new NewDiaryEntry();
                System.out.println("Please enter title");
                newDiaryEntry.setTitle(scanner.nextLine());

                System.out.println("Please enter main text");
                newDiaryEntry.setMainText(scanner.nextLine());



                break;

            case "3":
                return false;


            default:
                System.out.println("You entered an invalid option");
                break;


        }
        return true;
    }



    public static String optionsMenu1() {

            System.out.println("Please choose one of the options below by typing a number");
            System.out.println("1. Register a new user");
            System.out.println("2. Choose name from list");
            System.out.println("3. Quit Programme");
             Scanner scanner = new Scanner(System.in);

            String choice = scanner.nextLine();
            return choice;

            }



    public static String optionsMenu2() {

        //USER IS PRESENTED WITH OPTIONS
        System.out.println("Please choose one of the options below by typing a number");
        System.out.println("1. Read previous entries");
        System.out.println("2. Add new entry");
        System.out.println("3. Quit Programme");

        Scanner scanner = new Scanner(System.in);

        String choice2 = scanner.nextLine();


        return choice2;
    }

}
