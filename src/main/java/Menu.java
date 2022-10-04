import model.NewDiaryEntry;

import java.io.IOException;
import java.util.List;

public class Menu {



    public static boolean menu2(String userChoice, boolean runProgram, List<NewDiaryEntry> entryList, List<NewDiaryEntry> tempList) throws IOException {
        switch (userChoice) {

            case "1":

                //READS FROM JSON FILE
                WriteReadJson.readEntryList();
                runProgram = true;
                break;

                //TAKES USER INPUT AND WRITES TO JSON FILES

            case "2":

                NewDiaryEntry newDiaryEntry = new NewDiaryEntry();
                UserInput.userInput(newDiaryEntry, entryList, tempList);

                runProgram = true;


                break;

            case "3":
                return false;


            default:
                System.out.println("You entered an invalid option");
                break;


        }
        return true;
    }

}
