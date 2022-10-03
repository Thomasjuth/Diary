import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class WriteReadJson {


    public static void UserInputIntoJson(NewDiaryEntry newDiaryEntry) {


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

//
            mapper.writeValue(Paths.get("src/Main/resources/diaryEntries.json").toFile(), newDiaryEntry);


        } catch (Exception e) {

            e.printStackTrace();
        }


    }


    public static void readEntryList() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<Users> usersList = mapper.readValue(new File("src/main/resources/emp.json"), new TypeReference<List<Users>>() {
        });
        for (Users i : usersList) {



        }


}
}
