import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Diary {

private User user;
private List<Diary> diaryList;
private Date dateTimeStamp;


    public Diary(User user) {
        this.user = user;
        this.diaryList = new ArrayList<>();
    }

    public Diary() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Diary> getDiaryList() {
        return diaryList;
    }

    public void setDiaryList(List<Diary> diaryList) {
        this.diaryList = diaryList;
    }

    public Date getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(Date dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }


    public static void printDiary () {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<NewDiaryEntry> printList = (List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(),NewDiaryEntry.class)));

            for(NewDiaryEntry item: printList){

                System.out.println(item.getTitle());
                System.out.println(item.getMainText());
                System.out.println(item.getDate());
                System.out.println(item.getUser());

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}


