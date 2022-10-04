import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInput {


        public static void userInput(NewDiaryEntry newDiaryEntry, List<NewDiaryEntry> entryList) {

            Scanner scanner = new Scanner(System.in);
            String userChoice = scanner.nextLine();
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
//
        System.out.println(newDiaryEntry.getTitle());
        System.out.println(newDiaryEntry.getMainText());
        System.out.println(newDiaryEntry.getDate());

        NewDiaryEntry.addToEntryList(newDiaryEntry, entryList);

        WriteReadJson.writeToJson(entryList);



}

    }
