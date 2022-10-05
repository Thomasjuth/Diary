import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User newUser = new User();
        Diary diary = new Diary();
        ArrayList<User> userList = new ArrayList<>();

        List<User> tempUser = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));

        userList.addAll(tempUser);

        //OLD JSON ENTRIES ARE READ BACK AND SAVED INTO TEMP ARRAY
        ArrayList<Diary> diaryList = new ArrayList<>();
         List<Diary> tempDiary = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), Diary[].class));

        diaryList.addAll(tempDiary);


            //Main Program Loop
            boolean runProgram = true;
            while (runProgram) {


                Scanner scanner = new Scanner(System.in);
                Menu.optionsMenu1();

                runProgram = Menu.switchMenu1(true, userList, diaryList, newUser);

                Menu.optionsMenu2();


                runProgram = Menu.switchMenu2( true, userList, diaryList, newUser);




            }
        }



    }








