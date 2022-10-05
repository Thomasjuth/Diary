import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Diary diary = new Diary();
        List<User> userList = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));

        //OLD JSON ENTRIES ARE READ BACK AND SAVED INTO TEMP ARRAY
      List<Diary> diaryList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), Diary[].class));



            //Main Program Loop
            boolean runProgram = true;
            while (runProgram) {


                Scanner scanner = new Scanner(System.in);
                Menu.optionsMenu1();

                runProgram = Menu.switchMenu1(true);

                Menu.optionsMenu2();


                runProgram = Menu.switchMenu2( true);




            }
        }



    }








