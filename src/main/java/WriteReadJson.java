import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class WriteReadJson {



    public static void writeToJson(List entryList){

        ObjectMapper mapper = new ObjectMapper();


        try {

//
            mapper.writeValue(Paths.get("src/Main/resources/diaryEntries.json").toFile(), entryList);


        } catch (Exception e) {

            e.printStackTrace();
        }



    }




    public static List readEntryList() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

            List<NewDiaryEntry> entryList = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry[].class));


            for (NewDiaryEntry entry : entryList) {

                System.out.println(entry.getTitle());
                System.out.println(entry.getMainText());
                System.out.println(entry.getDate());


            }


        return entryList;
    }

}
