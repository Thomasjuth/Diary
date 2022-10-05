import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class WriteReadJson {



    public static void DiaryToJason(List entryList){

        ObjectMapper mapper = new ObjectMapper();


        try {

//
            mapper.writeValue(Paths.get("src/Main/resources/diaryEntries.json").toFile(), entryList);


        } catch (Exception e) {

            e.printStackTrace();
        }



    }


    public static void UsersToJason(List entryList){

        ObjectMapper mapper = new ObjectMapper();


        try {

//
            mapper.writeValue(Paths.get("src/Main/resources/userList.json").toFile(), entryList);


        } catch (Exception e) {

            e.printStackTrace();
        }



    }



    public static List DiaryFromJason() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

            List<NewDiaryEntry> entryList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry[].class));




        return entryList;
    }


    public static List UsersFromJason() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        List<NewDiaryEntry> diaryList = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), NewDiaryEntry[].class));




        return diaryList;
    }



    public static void printDiaryList(NewDiaryEntry newDiaryEntry, List<Diary> diaryList ) {

        for (Diary diaries : diaryList) {

            System.out.println(newDiaryEntry.getTitle());
            System.out.println(newDiaryEntry.getMainText());
            System.out.println(newDiaryEntry.getDate());


        }

    }

}
