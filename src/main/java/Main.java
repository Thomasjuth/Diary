import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();


        List<User> userList = new ArrayList<>();
        List<User> tempUser = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));
        userList.addAll(tempUser);

        //OLD JSON ENTRIES ARE READ BACK AND SAVED INTO TEMP ARRAY

        List<NewDiaryEntry> diaryList = new ArrayList<>();
        List<NewDiaryEntry> tempDiary = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry[].class));
        diaryList.addAll(tempDiary);


               Switch1.switchMenu1(diaryList, userList);


        }




    }





























