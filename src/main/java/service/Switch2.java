package service;

import com.vdurmont.emoji.EmojiParser;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * <p>This class holds a few different methods, which all relate to the second menu and options. They are all linked to
 * the creation and display of diary entries</p>
 *
 * @author thomasjuth
 */


public class Switch2 {

    /**
     * This method first the first Second Menu and then takes the user unto the second Switch Menu.
     */
    public static void switchMenu2(List<NewDiaryEntry> diaryList, List<User> userList) throws IOException, InterruptedException {


//
        Scanner scanner = new Scanner(System.in);
        String activeUser = User.getActiveUser();
        boolean runProgram = true;


        while (runProgram) {

            System.out.println(EmojiParser.parseToUnicode(":arrow_down: Please select an option!"));
            System.out.println("------------------------------");
            System.out.println("1. Display Old Entries");
            System.out.println("2. Create New Entry");
            System.out.println("3. Return to First Menu");
            System.out.println("9. Quit");

            int switchChoice = scanner.nextInt();


            switch (switchChoice) {

                case 1: //Display old entries

                    displayOldEntries(diaryList);


                    System.out.println("-----------------------------------------------------------------");

                    break;


                case 2: //Create new entry

                    //this calls this createNewEntry method, which returns our new entry. Voila!
                    NewDiaryEntry diaryEntry = createNewEntry(activeUser, scanner);

//                      //this new diaryEntry is then added to diaryList
                    diaryList.add(diaryEntry);


                    //DiaryList is then added to JSON.
                    WriteReadJson.DiaryToJason(diaryList);

                    break;


                //DISPLAY OLD DIARY ENTRIES


                case 3:
//

                    System.out.println(EmojiParser.parseToUnicode(":back: Taking you back!"));


                    Switch1.switchMenu1(diaryList, userList);
                    break;


                case 9:

                    System.out.println("Good Bye " + User.getActiveUser() + " :)");
                    Thread.sleep(100);
                    Thread.sleep(200);
                    System.out.println(EmojiParser.parseToUnicode(":robot_face: Come Back Soon!"));


                    System.exit(666);

                    break;

                default:

                    System.out.println("You entered an invalid option");
                    break;

            }


        }

    }


    /**
     * This method is run if the user selects 1. It creates a new entry. It takes input and then sends that into the constructor of
     * new object.
     *
     * @return This method returns a brand new diary entry.
     */

    public static NewDiaryEntry createNewEntry(String activeUser, Scanner scanner) throws InterruptedException {

        System.out.println("What is on your mind today " + User.getActiveUser() + "?");
        Thread.sleep(300);

        System.out.println("_______________________________________");
        NewDiaryEntry diaryEntry = null;
        System.out.println("Please enter title");
        scanner.nextLine();
        String title = scanner.nextLine();

        System.out.println("Please enter main text");
        String mainText = scanner.nextLine();

        String date = LocalDate.now().toString();
        diaryEntry = new NewDiaryEntry(title, mainText, activeUser, date);
        System.out.println("Thank you for sharing! Your secrets are safe with me.");
        System.out.println(":)");


        return diaryEntry;

    }


    /**
     * This method is run if the user selects 2. It displays old entires. Also, if diary is empty the user will be informed.
     */

    public static void displayOldEntries(List<NewDiaryEntry> diaryList) {

        String activeUser = User.getActiveUser();

        for (NewDiaryEntry item : diaryList) {


            if (activeUser.equalsIgnoreCase(item.getUserName())) {


                System.out.println(item.toString());

            } else if (!activeUser.equalsIgnoreCase(item.getUserName())) {
                System.out.println(EmojiParser.parseToUnicode(":stop_sign: Your diary is still empty! There is nothing to show."));


            }

        }

    }

}







