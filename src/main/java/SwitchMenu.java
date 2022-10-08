import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class SwitchMenu {


    public static int switchMenu1(int choice, List<User> userList, List<Diary> diaryList) throws IOException {
        Scanner scanner = new Scanner(System.in);


        int menuChoice = 1;
        switch (choice) {

            //USER CAN CREATE A NEW USERNAME

            case 1:

                System.out.println("Please type in your desired user name");
//
                String chosenName = scanner.nextLine();

                // NEW USER CREATED AND NAME IS SET. USER IS ALSO ADDED TO USERS LIST. LIST IS FINALLY ADDED TO JSON FILE
                User newUser = new User();
                newUser.setUsername(chosenName);
                userList.add(newUser);
                WriteReadJson.UsersToJason(userList);


                //The newly created user becomes the "active user"
                User.setActiveUserName(chosenName);
                User.setActiveUser(chosenName);

                //A New Diary is Created in the name of user. Diary is then added to list.
                Diary diary = new Diary(newUser);
                diaryList.add(diary);


                System.out.println("Welcome " + newUser.getActiveUserName() + "!" + " You can now start using your new diary.");
                System.out.println("");


                menuChoice = 2;
                break;


            case 2:
                // CREATE NEW USER


                User.printUsers();

                ObjectMapper mapper = new ObjectMapper();
                List<User> tempUserList = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));

                System.out.println("Please choose username. Type in to continue");

                String desiredUser = scanner.nextLine();


                for (User item : tempUserList) {

                    if (item.getUsername().equalsIgnoreCase(desiredUser)) {

                        User.setActiveUserName(desiredUser);

                        System.out.println("This diary belongs to " + User.getActiveUserName());

                        OptionsMenu.optionsAndChoice2();
                    } else {
                        System.out.println("That name is not in the list. Please try again!");

                    }

                    menuChoice = 2;


                    break;

                }


            case 3:

                break;

            default:


        }

        return menuChoice;
    }



    public static int switchMenu2(int choice, List diaryList) throws IOException {

        Scanner scanner = new Scanner (System.in);
        int menuChoice = 2;

        switch (choice) {


            //PRESENTS OLD DIARY ENTRIES

            case 1:

                ObjectMapper mapper = new ObjectMapper();

                //READS FROM JSON FILE
                List<Diary> tempList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries").toFile(), Diary[].class));

                for (Diary item : tempList) {
                    if (Objects.equals(User.getActiveUser(), item.getUser().getUsername())) {
                        item.printDiary();
                        }
                    }


                menuChoice = 2;
                break;


                //Create New Entry
            case 2:


                String activeUser = User.getActiveUserName();
                NewDiaryEntry newDiaryEntry = new NewDiaryEntry(activeUser);

                System.out.println(newDiaryEntry.getUserName());


                System.out.println("Please enter title");
                String title = scanner.nextLine();
                newDiaryEntry.setTitle(title);

                System.out.println("Please enter main text");
                String mainText = scanner.nextLine();
                newDiaryEntry.setMainText(mainText);

                System.out.println("Title: " + newDiaryEntry.getTitle());
                System.out.println("Main Text: " + newDiaryEntry.getMainText());

                diaryList.add(newDiaryEntry);

                WriteReadJson.DiaryToJason(diaryList);

                menuChoice = 2;
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

        return menuChoice;
    }









}
