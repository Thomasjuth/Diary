package service;

import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Switch2 {


        public static void switchMenu2(List <NewDiaryEntry> diaryList, List <User> userList) throws IOException, InterruptedException {



//
            Scanner scanner = new Scanner(System.in);
            String activeUser = User.getActiveUser();
            boolean runProgram = true;




            while (runProgram) {

                System.out.println("Please Select an Option Below");
                System.out.println("------------------------------");
                System.out.println("1. Create New Entry");
                System.out.println("2. Display Old Entries");
                System.out.println("3. Return to First Menu");
                System.out.println("9. Quit");

                int switchChoice = scanner.nextInt();


                switch (switchChoice) {


                    //Create New Entry
                    case 1:

                        NewDiaryEntry diaryEntry = createNewEntry(activeUser, scanner);
//                        System.out.println("Title: " + diaryEntry.getTitle());
//                        System.out.println("Main Text: " + diaryEntry.getMainText());
                        diaryList.add(diaryEntry);
                        WriteReadJson.DiaryToJason(diaryList);

                        break;



                    //DISPLAY OLD DIARY ENTRIES

                    case 2:

                        //We loop through List
                        for (NewDiaryEntry item : diaryList) {
                            // If our active user equals diaryEntry UserName, print it out!

                         if (activeUser.equalsIgnoreCase(item.getUserName())) {


                                System.out.println(item.toString()); }




                        }

                        System.out.println("Your diary is empty! Select '1' to create your first diary entry");
                        System.out.println("-----------------------------------------------------------------");

                        break;




                    case 3:
//

                        System.out.println("Returning back to Menu 1...in..");
                        Thread.sleep(500);
                        System.out.println("3");
                        Thread.sleep(500);
                        System.out.println("2");
                        Thread.sleep(500);
                        System.out.println("1");
                        Thread.sleep(500);
                        System.out.println("Lift off!");
                        Thread.sleep(300);
                        Switch1.switchMenu1(diaryList, userList);
                        break;


                    case 9:

                        System.out.println("Good Bye " + User.getActiveUser() + " :)");
                        Thread.sleep(200);
                        Thread.sleep(200);
                        System.out.println("Come Back Soon!");

                        System.exit(666);

                        break;

                    default:

                        System.out.println("You entered an invalid option");
                        break;

                }


            }

        }

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

    }



