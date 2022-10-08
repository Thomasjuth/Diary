import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SwitchMenu {


    public static boolean switchMenu1(int choice, boolean status, List<User> userList) throws IOException {
        Scanner scanner = new Scanner(System.in);


        int menuChoice = 1;
        User newUser = null;


            switch (choice) {

                //USER CAN CREATE A NEW USERNAME

                case 1:

                    //CREATE NEW USER

                    System.out.println("Please type in your desired user name");
//
                    String chosenName = scanner.nextLine();

                    // NEW USER CREATED AND NAME IS SET. USER IS ALSO ADDED TO USERS LIST. LIST IS FINALLY ADDED TO JSON FILE
                    newUser = new User();
                    newUser.setUsername(chosenName);
                    userList.add(newUser);
                    WriteReadJson.UsersToJason(userList);
                    User.setActiveUser(chosenName);

                    System.out.println("Welcome " + newUser.getActiveUser() + "!" + " You can now start using your new diary.");
                    System.out.println("");


                    status = true;
                    break;

                case 2:

                    //PRINT USERS

                    User.printUsers();

//                ObjectMapper mapper = new ObjectMapper();
//                List<User> tempUserList = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));

                    System.out.println("Please choose username. Type in to continue");

                    String desiredUser = scanner.nextLine();

                    for (User item : userList) {
//                        User.printUsers();
                        if (desiredUser.equalsIgnoreCase(item.getUsername()) )
                            User.setActiveUser(desiredUser);


                    }

                    System.out.println("Active User: " + User.getActiveUser());
//                    System.out.println("This diary belongs to " + User.getActiveUser().toString());

                    status = true;
                    break;



                case 3:

                    status = false;
                    break;


            }

        return status;

        }






    public static boolean switchMenu2(int choice, boolean status, List<NewDiaryEntry> diaryList) throws IOException {

//        //Bringing in active user into this switch method
//
        Scanner scanner = new Scanner(System.in);
        String activeUser = User.getActiveUser();
        NewDiaryEntry diaryEntry = null;






            switch (choice) {


                //DISPLAY OLD DIARY ENTRIES
                case 1:

                    ObjectMapper mapper = new ObjectMapper();


                    //READS FROM JSON FILE
//                List<model.User.model.Diary> tempList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries").toFile(), model.User.model.Diary[].class));

                    /*for (NewDiaryEntry item: diaryList) {

                        System.out.println(item);
                    }*/


                    for (NewDiaryEntry item : diaryList) {
                        if (activeUser.equalsIgnoreCase(item.getUserName())) {
                            //System.out.println(item.toString());
                            NewDiaryEntry.printDiary();

                        }
                    }

                    OptionsMenu.optionsAndChoice2();
                    status = true;
                    break;




                //Create New Entry
                case 2:

                    diaryEntry = new NewDiaryEntry(activeUser);
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

                    status = true;

                    OptionsMenu.optionsAndChoice2();// TODO think THuumas
                    break;

                case 3:

                    status = true;
                    break;

                case 4:
                    status = false;
                    break;

                default:
                    status = true;
                    System.out.println("You entered an invalid option");
                    break;

            }
        return status;
    }

    }







