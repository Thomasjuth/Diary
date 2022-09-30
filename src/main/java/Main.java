import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



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
                saveUserInputInJson();


                break;

            case "3":
                System.out.println("Quit!");
                break;

            default:
                System.out.println("hey");
                break;


        }

    }


    public static void saveUserInputInJson() {

        NewDiaryEntry newDiaryEntry = new NewDiaryEntry();
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();


        //TAKE IN TITLE FROM USER AND SET THE CONSTRUCTOR
        System.out.println("Title: ");
        newDiaryEntry.setTitle(scanner.nextLine());


        //AS USER TO WRITE HIS ENTRY AND SET CONSTRUCTOR
        System.out.println("Diary Entry: ");
        newDiaryEntry.setMainText(scanner.nextLine());

        //SET DATE
        String theDate = date.toString();
        newDiaryEntry.setDate(theDate);



        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(Paths.get("src/Main/resources/diaryEntries.json").toFile(), newDiaryEntry);
        } catch (Exception e) {

        }


        System.out.println(newDiaryEntry.getTitle());
        System.out.println(newDiaryEntry.getMainText());
        System.out.println(newDiaryEntry.getDate());
    }





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



