import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;

import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        boolean runProgram = true;
        while (runProgram) {

            Scanner scanner = new Scanner(System.in);

            //Create JSON ARRAY
            JSONArray jsonArray = new JSONArray();




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

                    takeUserInput(jsonArray);
                    writeFile(jsonArray);




                    break;

                case "3":
                    runProgram = false;
                    break;

                default:
                    System.out.println("hey");
                    break;


            }

        }
    }


    public static void takeUserInput(JSONArray array) {


        //NEW INSTANCE OF NEW DIARY CLASS CREATED
        NewDiaryEntry newDiaryEntry = new NewDiaryEntry();

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

        //THE NEW OBJECT IS ADDED TO ARRAY LIST

        array.add(newDiaryEntry);
    }

        public static void writeFile(JSONArray array) {

        ObjectMapper mapper = new ObjectMapper();

        // THE LIST IS NOW ADDED INTO OUR JASON FILE
        try {

            mapper.writeValue(Paths.get("src/Main/resources/diaryEntries.json").toFile(), array);
        } catch (Exception e) {

        }



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



