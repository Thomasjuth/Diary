import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static String pathToUsers = "src/main/resources/userList.json";
    public static String pathToDiary = "src/main/resources/diaryEntries.json";

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User newUser = new User();
        ArrayList<User> userList = new ArrayList<>();
        List<User> tempUser = List.of(mapper.readValue(Paths.get(pathToUsers).toFile(), User[].class));

        userList.addAll(tempUser);

        //OLD JSON ENTRIES ARE READ BACK AND SAVED INTO TEMP ARRAY
        ArrayList<Diary> diaryList = new ArrayList<>();
        List<Diary> tempDiary = List.of(mapper.readValue(Paths.get(pathToDiary).toFile(), Diary[].class));

        diaryList.addAll(tempDiary);


        //Main Program Loop
//            boolean runProgram = true;
//            while (runProgram) {

        String choice = Menu.optionsMenu1();

        Menu.switchMenu1(choice, true, userList, diaryList);

        String choice2 = Menu.optionsMenu2();


        Menu.switchMenu2(choice2, true, diaryList, newUser);


    }

    public static List tempListCreationUsers()  {
        ObjectMapper mapper = new ObjectMapper();


        List<User> tempList = null;
        try {
            tempList = (List.of(mapper.readValue(Paths.get(pathToUsers).toFile(), User.class)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return tempList;

    }

}












