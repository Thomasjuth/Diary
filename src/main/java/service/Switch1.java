package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vdurmont.emoji.EmojiParser;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>This class holds a bunch a methods, which all relate to the first menu and options. They are all linked to
 * *  the creation and display of users</p>
 *
 * @author thomasjuth
 */


public class Switch1 {

    /**
     * This method first the first Options Menu and then takes the user unto the first Switch Menu.
     */


    public static void switchMenu1(List<NewDiaryEntry> diaryList, List<User> userList) throws IOException, InterruptedException {


        Scanner scanner = new Scanner(System.in);

        boolean runProgam = true;


        while (runProgam) {


            System.out.println(EmojiParser.parseToUnicode(":arrow_down: Please select an option!"));
            System.out.println("------------------------------");
            System.out.println("1. Select User");
            System.out.println("2. Register a New User");
            System.out.println("9. Quit");


            String switchChoice = scanner.nextLine();


            switch (switchChoice) {


                case "1":

                    //Print users and select one

                    readUsersList();
                    if (userList.isEmpty()) {
                        System.out.println(EmojiParser.parseToUnicode(":eyes: There are no users in the list. Please register before writing your first entry"));
                        break;

                    } else {

                        System.out.println(EmojiParser.parseToUnicode(":arrow_down: Please select user name and type it in below"));

                    }

                    // User chooses desired UserName
                    String desiredUser = scanner.nextLine();


                    // Active User is set!
                    setActiveUser(userList, desiredUser, diaryList);

                    // We now go to menu 2...
                    Switch2.switchMenu2(diaryList, userList);
                    break;


                case "2": //Create new user

                    createUser(diaryList, userList);

                    Switch2.switchMenu2(diaryList, userList);

                    break;


                case "9": //QUIT PROGRAMME
                    System.out.println(EmojiParser.parseToUnicode(":cry: Why are you leaving so soon? "));


                    runProgam = false;
                    System.exit(666);
                    break;

                default:
                    System.out.println("Hm. I am not sure what you are trying to tell me. Please type in numbers only!");
                    System.out.println(":/");
                    break;

            }


        }


    }

    /**
     * This method is run if the user selects 1. User is created and username is set by input. User is then added to userList.
     * Finally activeUser is updated.
     */

    public static void createUser(List<NewDiaryEntry> diaryList, List<User> userList) throws IOException, InterruptedException {


        Scanner scanner = new Scanner(System.in);


        System.out.println(EmojiParser.parseToUnicode(":partying_face: Woohoo! A new user! What is your name my friend?"));
        System.out.println("(In case you change your mind, type Q to return to the menu.");

        String chosenName = scanner.nextLine();

        switch (chosenName) {

            case "Q":

            case "q":
                switchMenu1(diaryList, userList);
                break;


            default:
                User newUser = new User();
                newUser.setUsername(chosenName);
                userList.add(newUser);
                service.WriteReadJson.UsersToJason(userList);
                User.setActiveUser(chosenName);


                System.out.println("Welcome " + User.getActiveUser() + "!" + " You can now start using your new diary.");

        }


    }


    /**
     * This method is run if the user selects 2. UserList is printed!
     */

    public static void readUsersList() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<User> userList = new ArrayList<>(List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class)));


            for (User item : userList) {

                System.out.println("Username: " + item.getUsername());


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * This method is used to set the activeUser, and used as part of Case 2. If this fails I have also prepared a message for that.
     */
    public static void setActiveUser(List<User> userList, String desiredUser, List<NewDiaryEntry> diaryList) throws IOException, InterruptedException {

        for (User item : userList) {
//
            if (desiredUser.equalsIgnoreCase(item.getUsername())) {
                User.setActiveUser(desiredUser);
            }


        }


        if (User.getActiveUser() == null) {

            System.out.println("That user does not exist...Try again!");
            Switch1.switchMenu1(diaryList, userList);
        }
        System.out.println("You are now logged in as: " + User.getActiveUser());


    }


//                    System.out.println("This diary belongs to " + User.getActiveUser().toString());


}















