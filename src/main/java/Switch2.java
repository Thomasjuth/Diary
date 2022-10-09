import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Switch2 {


        public static void switchMenu2(List <NewDiaryEntry> diaryList) throws IOException {



//
            Scanner scanner = new Scanner(System.in);
            String activeUser = User.getActiveUser();
            NewDiaryEntry diaryEntry = null;
            boolean runProgam = true;




            while (runProgam) {

                System.out.println("Please choose one of the options below by typing a number");
                System.out.println("1. Display Old Entries");
                System.out.println("2. Create New Entry");
                System.out.println("3. Return to the first menu");
                System.out.println("4. Quit Programme");

                int switchChoice = scanner.nextInt();


                switch (switchChoice) {


                    //DISPLAY OLD DIARY ENTRIES
                    case 1:




                        for (NewDiaryEntry item : diaryList) {
                            if (activeUser.equalsIgnoreCase(item.getUserName())) {
//                                NewDiaryEntry.printDiary();
                                System.out.println(item.toString());



                            }

                        }


                        break;


                    //Create New Entry
                    case 2:

                        diaryEntry = new NewDiaryEntry(activeUser);
                        scanner.nextLine();
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

                        System.out.println("TESTING");
                        break;

                    case 3:
                        ObjectMapper mapper = new ObjectMapper();

                        List<User> userList = new ArrayList<>();
                        List<User> tempUser = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));
                        userList.addAll(tempUser);

                        Switch1.switchMenu1(diaryList, userList);
                        break;

                    case 4:

                        System.exit(3);

                        break;

                    default:

                        System.out.println("You entered an invalid option");
                        break;

                }


            }

        }

    }



