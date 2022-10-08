package model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NewDiaryEntry {


    private String title;

    private String mainText;
    private String date;
    private String userName;

    private List<NewDiaryEntry> diaryList;


    //CONSTRUCTORS

    public NewDiaryEntry(String title, String mainText, String date, String userName) {
        this.title = title;
        this.mainText = mainText;
        this.date = date;
        this.userName = userName;

    }


    public NewDiaryEntry(String userName) {
        this.userName = userName;

    }

    public NewDiaryEntry() {
    }



    //GETTERS AND SETTERS

    public List<NewDiaryEntry> getDiaryList() {
        return diaryList;
    }

    public void setDiaryList(List<NewDiaryEntry> diaryList) {
        this.diaryList = diaryList;
    }

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


    public void printDiary() throws IOException {

        ObjectMapper mapper = new ObjectMapper();


        List<NewDiaryEntry> printList = new ArrayList<>(List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry.class)));


        for (NewDiaryEntry item : printList) {

            System.out.println("Title: " + item.getTitle());
            System.out.println("Main text: " + item.getMainText());
            System.out.println("Date:  " + item.getDate());


        }

    }

    }



