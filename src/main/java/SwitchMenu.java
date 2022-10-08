import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SwitchMenu {


    public static int switchMenu1(int choice, List<User> userList, List<NewDiaryEntry> diaryList) throws IOException {
        Scanner scanner = new Scanner(System.in);


        int menuChoice = 1;

        while (menuChoice == 1) {

            switch (choice) {

                //USER CAN CREATE A NEW USERNAME

                case 1:

                    //CREATE NEW USER

                    System.out.println("Please type in your desired user name");
//
                    String chosenName = scanner.nextLine();

                    // NEW USER CREATED AND NAME IS SET. USER IS ALSO ADDED TO USERS LIST. LIST IS FINALLY ADDED TO JSON FILE
                    User newUser = new User();
                    newUser.setUsername(chosenName);
                    userList.add(newUser);
                    WriteReadJson.UsersToJason(userList);


                    //The newly created user becomes the "active user"
                    User.setActiveUser(chosenName);


                    NewDiaryEntry newDiaryEntry = new NewDiaryEntry(chosenName);


                    System.out.println("Welcome " + newUser.getActiveUser() + "!" + " You can now start using your new diary.");
                    System.out.println("");


                    menuChoice = 2;
                    break;

                case 2:

                    //PRINT USERS

                    User.printUsers();

//                ObjectMapper mapper = new ObjectMapper();
//                List<User> tempUserList = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));

                    System.out.println("Please choose username. Type in to continue");

                    String desiredUser = scanner.nextLine();


                    for (User item : userList) {

                        if (item.getUsername().equalsIgnoreCase(desiredUser)) {

                            User.setActiveUser(desiredUser);

                            System.out.println("This diary belongs to " + User.getActiveUserName());

                            menuChoice = 2;


                        } else {
                            System.out.println("That name is not in the list. Please try again!");
                            menuChoice = 2;
                        }


                        break;

                    }


                case 3:

                    break;


            }


        }
        return menuChoice;
    }




    public static int switchMenu2(int choice, List<NewDiaryEntry> diaryList) throws IOException {

        //Bringing in active user into this switch method

        String activeUser = User.getActiveUser();
        NewDiaryEntry diaryEntry = new NewDiaryEntry();
        diaryEntry.setUserName(activeUser);


        Scanner scanner = new Scanner(System.in);
        int menuChoice = 2;

        while (menuChoice == 2) {

            switch (choice) {


                //PRESENTS OLD DIARY ENTRIES

                case 1:

                    ObjectMapper mapper = new ObjectMapper();


                    //READS FROM JSON FILE
//                List<Diary> tempList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries").toFile(), Diary[].class));


                    for (NewDiaryEntry item : diaryList) {
                        if (activeUser.equalsIgnoreCase(diaryEntry.getUserName())) {
                            item.printDiary();
                        }
                    }


                    menuChoice = 2;
                    break;


                //Create New Entry
                case 2:


                    System.out.println("Please enter title");
                    String title = scanner.nextLine();
                    diaryEntry.setTitle(title);

                    System.out.println("Please enter main text");
                    String mainText = scanner.nextLine();
                    diaryEntry.setMainText(mainText);

                    System.out.println("Title: " + diaryEntry.getTitle());
                    System.out.println("Main Text: " + diaryEntry.getMainText());

                    diaryList.add(diaryEntry);

                    WriteReadJson.DiaryToJason(diaryList);

                    menuChoice = 2;
                    OptionsMenu.optionsAndChoice2();
                    break;

                case 3:

                    menuChoice = 1;
                    break;

                case 4:
                    break;

                default:
                    System.out.println("You entered an invalid option");
                    break;

            }


        }
        return menuChoice;
    }

    }





