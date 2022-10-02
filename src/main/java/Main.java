import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        //Creates Json Array
        JSONArray jsonArray = new JSONArray();

        //Creates Instance of NewDiaryEntry
        NewDiaryEntry newDiaryEntry = new NewDiaryEntry();

        // Counter
        int i = 0;

        //Main Program Loop
        boolean runProgram = true;
        while (runProgram) {


            System.out.println("this is inside jsonArray " + jsonArray.toString());
            Scanner scanner = new Scanner(System.in);

            //USER IS PRESENTED WITH OPTIONS
            System.out.println("Please choose one of the options below by typing a number");
            System.out.println("1. Read previous entries");
            System.out.println("2. Add new entry");
            System.out.println("3. Quit Programme");

            String userChoice = scanner.nextLine();


            switch (userChoice) {

                case "1":

                    System.out.println("Present all previous entries");
                    break;

                case "2":


                    takeUserInput(newDiaryEntry, jsonArray, i);
                    writeToJson(jsonArray);

                    break;

                case "3":
                    runProgram = false;
                    break;

                default:
                    System.out.println("hey");
                    break;


            }

            // adding 1 to counter.
        i++;
        }
    }




    public static void takeUserInput(NewDiaryEntry newDiaryEntry, JSONArray array, int i) {



        Scanner scanner = new Scanner(System.in);
        Date date = new Date();


        //USER INPUT IS STORED INTO OBJECT
        System.out.println("Enter the Title: ");
        newDiaryEntry.setTitle(scanner.nextLine());


        //USER INPUT IS STORED INTO OBJECT
        System.out.println("Now, please us about your day: ");
        newDiaryEntry.setMainText(scanner.nextLine());

        //DATE IS SET AUTOMATICALLY AND ADDED TO OBJECT
        String theDate = date.toString();
        newDiaryEntry.setDate(theDate);

        System.out.println(newDiaryEntry.getTitle());
        System.out.println(newDiaryEntry.getMainText());
        System.out.println(newDiaryEntry.getDate());

        //Creating ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();


        try {

            //       Converts Java Object into JSON String
            String jasonStr = mapper.writeValueAsString(newDiaryEntry);


            JSONParser parser = new JSONParser();

            // CONVERTS JSON STRING INTO JSON OBJECT
            JSONObject json = (JSONObject) parser.parse(jasonStr);


            // ADDS JSON OBJECT TO JSON ARRAY AT INDEX i, WHICH IS SET BY COUNTER IN WHILE LOOP.

            array.add(i, json);





        } catch (Exception e) {

        e.printStackTrace();
        }


    }

    public static void writeToJson(JSONArray array){

        try {

            ObjectMapper mapper = new ObjectMapper();
            // THE LIST IS NOW ADDED INTO OUR JASON FILE
            mapper.writeValue(Paths.get("src/Main/resources/diaryEntries.json").toFile(), array);



        } catch (Exception e) {

            e.printStackTrace();
        }

    }


//    public static String createUser(){
//
//        Scanner scanner = new Scanner(System.in);
//
//
//        User newUser = new User();
//
//        System.out.println("Please type in your first name");
//
//        String firstName = scanner.nextLine();
//
//        newUser.setFirstName(firstName);
//
//        System.out.println("Please type in your last name");
//
//        String lastName = scanner.nextLine();
//
//        newUser.setFirstName(lastName);
//
//        System.out.println("Thank You" + firstName + ". " + "You can now write your first post");
//
//        String fullName = firstName + lastName;
//        return fullName;
//    }
//
//    public static void addUserToList(String name, List<string>userList) {
//
//        userList.add();
//    }
//







//    public static void readEntries() {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        try {
//            List<String> peopleList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry[].class));
//
//
//        } catch (Exception e) {
//
//
//        }
//
//
//    }

}



