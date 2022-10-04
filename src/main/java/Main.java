import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        NewDiaryEntry newDiaryEntry = new NewDiaryEntry();
        List<NewDiaryEntry> entryList = new ArrayList<>();

        WriteReadJson.writeToJson(entryList);
        List<NewDiaryEntry> tempList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry[].class));

        for(NewDiaryEntry entry : tempList){

            System.out.println(tempList.toArray());
        }



            //Main Program Loop
            boolean runProgram = true;
            while (runProgram) {
                Scanner scanner = new Scanner(System.in);

                presentOptions();
                String userChoice = scanner.nextLine();

                runProgram = Menu.menu2(userChoice, true, entryList);


            }
        }



        public static void presentOptions () {

            //USER IS PRESENTED WITH OPTIONS
            System.out.println("Please choose one of the options below by typing a number");
            System.out.println("1. Read previous entries");
            System.out.println("2. Add new entry");
            System.out.println("3. Quit Programme");
        }
    }








