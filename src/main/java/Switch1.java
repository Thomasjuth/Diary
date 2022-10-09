import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Switch1 {


    public static void switchMenu1(List<NewDiaryEntry> diaryList, List<User> userList) throws IOException {


        Scanner scanner = new Scanner(System.in);
        User newUser = null;
        boolean runProgam = true;


        while (runProgam) {
            System.out.println("Please choose one of the options below by typing a number");
            System.out.println("1. Register a New User");
            System.out.println("2. Choose User From List");
            System.out.println("3. Quit Programme");

            int switchChoice = scanner.nextInt();

            switch (switchChoice) {


                case 1: //CREATE USER
                    System.out.println("Please give a user name");
                    scanner.nextLine();
                    String chosenName = scanner.nextLine();
                    newUser = new User();
                    newUser.setUsername(chosenName);
                    userList.add(newUser);
                    WriteReadJson.UsersToJason(userList);
                    User.setActiveUser(chosenName);
                    System.out.println("Welcome " + User.getActiveUser() + "!" + " You can now start using your new diary.");



                    Switch2.switchMenu2(diaryList);



                    break;

                case 2:

                    //PRINT USERS

                    User.printUsers();
                    if (userList.isEmpty()) {
                        System.out.println("There are no users in the list. Please register before writing your first entry");
                        break;

                    } else {

                        System.out.println("Please select which username you want to sign in with");
                        scanner.nextLine();
                    }


                    String desiredUser = scanner.nextLine();

                    for (User item : userList) {
//                        User.printUsers();
                        if (desiredUser.equalsIgnoreCase(item.getUsername())) {
                            User.setActiveUser(desiredUser);

                        }


                    }

                    System.out.println("Active User: " + User.getActiveUser());
//                    System.out.println("This diary belongs to " + User.getActiveUser().toString());


                    Switch2.switchMenu2(diaryList);
                    break;


                case 3:


                    System.exit(33);

                    break;


            }


        }

    }






}












