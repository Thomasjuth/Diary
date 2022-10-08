import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.nio.file.Paths;
import java.util.List;

public class WriteReadJson {



    public static void DiaryToJason(Object diaryEntry){

        ObjectMapper mapper = new ObjectMapper();


        try {

//
            mapper.writeValue(Paths.get("src/Main/resources/diaryEntries.json").toFile(), diaryEntry);


        } catch (Exception e) {

            e.printStackTrace();
        }



    }


    public static void UsersToJason(List<User> entryList){

        ObjectMapper mapper = new ObjectMapper();


        try {

//
            mapper.writeValue(Paths.get("src/Main/resources/userList.json").toFile(), entryList);


        } catch (Exception e) {

            e.printStackTrace();
        }



    }





}
