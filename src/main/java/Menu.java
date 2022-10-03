import java.io.IOException;

public class Menu {



    public static boolean menu2(String userChoice, boolean runProgram) throws IOException {
        switch (userChoice) {

            case "1":

                //READS FROM JSON FILE
                WriteReadJson.readEntryList();
                runProgram = true;
                break;

                //TAKES USER INPUT AND WRITES TO JSON FILES
            case "2":

                NewDiaryEntry newDiaryEntry = new NewDiaryEntry();
                WriteReadJson.UserInputIntoJson(newDiaryEntry);

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
