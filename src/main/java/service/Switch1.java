package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Switch1 {


    public static void switchMenu1(List<NewDiaryEntry> diaryList, List<User> userList) throws IOException, InterruptedException {


        Scanner scanner = new Scanner(System.in);

        boolean runProgam = true;


        while (runProgam) {


            System.out.println("Please Select an Option Below");
            System.out.println("------------------------------");
            System.out.println("1. Register a New User");
            System.out.println("2. Choose User From List");
            System.out.println("9. Quit");



            int switchChoice = scanner.nextInt();



            switch (switchChoice) {


                case 1: //CREATE USER

                    createUser(diaryList,  userList);

                    Switch2.switchMenu2(diaryList);

                    break;


                case 2:

                    //PRINT USERS

                    readUsersList();
                    if (userList.isEmpty()) {
                        System.out.println("There are no users in the list. Please register before writing your first entry");
                        break;

                    } else {

                        System.out.println("Please select user name and type it in below");
                        scanner.nextLine();
                    }

                    // User chooses desired UserName
                    String desiredUser = scanner.nextLine();

                    // Active User is set!
                    setActiveUser(userList, desiredUser);

                    // We now go to menu 2...
                    Switch2.switchMenu2(diaryList);
                    break;


                    //QUIT PROGRAMME

                case 9:


                    System.out.println("Why are you leaving so soon?");
                    Thread.sleep(400);
                    System.out.println("Didn't you like the program?");
                    Thread.sleep(400);

                    for(int x = 1; x < 5; x++) {
                        System.out.println(":-(");
                        Thread.sleep(200);

                    }

                    runProgam = false;
                    break;


            }


        }



    }


    public static void createUser(List<NewDiaryEntry> diaryList, List<User> userList){


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give a user name");
        String chosenName = scanner.nextLine();
        User newUser = new User();
        newUser.setUsername(chosenName);
        userList.add(newUser);
        service.WriteReadJson.UsersToJason(userList);
        User.setActiveUser(chosenName);
        System.out.println("Welcome " + User.getActiveUser() + "!" + " You can now start using your new diary.");



    }

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
    
    public static void setActiveUser(List<User> userList, String desiredUser) {

        for (User item : userList) {
//
            if (desiredUser.equalsIgnoreCase(item.getUsername())) {
                User.setActiveUser(desiredUser);

            }


        }

        System.out.println("Active User: " + User.getActiveUser());
//                    System.out.println("This diary belongs to " + User.getActiveUser().toString());



    }
    }














