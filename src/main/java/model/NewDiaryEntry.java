package model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class NewDiaryEntry {


    private String title;

    private String mainText;
    private String date;
    private String userName;

    private static User user;

    private List<NewDiaryEntry> diaryList;


    //CONSTRUCTORS



    public NewDiaryEntry(String userName) {
        this.userName = userName;
    }

    public NewDiaryEntry() {

    }

    //GETTERS AND SETTERS





    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getDate() {
        return date;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        NewDiaryEntry.user = user;
    }

    public static void printDiary() throws IOException {

        ObjectMapper mapper = new ObjectMapper();



        List<NewDiaryEntry> temp = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry[].class));

        System.out.println("Hey Hey");
        for (NewDiaryEntry item : temp) {

            System.out.println("Hey Hey");
            if (temp == null) {
                System.out.println("Your diary is empty. There are no entries to print");

            }

            else {

                System.out.println("Title: " + item.getTitle());
                System.out.println("Main text: " + item.getMainText());
                System.out.println("Date:  " + item.getDate());
            }

        }

    }

    @Override
    public String toString() {
        return
                "Title: " + title + "\n" +
                "Main Text: " + mainText + "\n" +
                "Date: '" + date + "\n" +
                "Username: " + userName + "\n"
               ;
    }
}



