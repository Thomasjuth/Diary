package model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NewDiaryEntry {



    private String title;

    private String mainText;
    private String date;

    private User user;
    private Date dateTimeStamp;


    public NewDiaryEntry(String title, String mainText, String date, User user, Date dateTimeStamp) {
        this.title = title;
        this.mainText = mainText;
        this.date = date;
        this.user = user;
        this.dateTimeStamp = Calendar.getInstance().getTime();
    }

    public NewDiaryEntry(User user) {
    }


    public NewDiaryEntry() {
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

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(Date dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public static void addToDiaryList(NewDiaryEntry newDiaryEntry, List diaryList){

        diaryList.add(newDiaryEntry);


    }

    public static void userInput(NewDiaryEntry newDiaryEntry, List<Diary> entryList, User activeUser) {

        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Date date = new Date();


        System.out.println("Title: ");
        newDiaryEntry.setTitle(scanner.nextLine());

        //USER INPUT IS STORED INTO OBJECT
        System.out.println("Now, please us about your day: ");
        newDiaryEntry.setMainText(scanner.nextLine());

        //DATE IS SET AUTOMATICALLY AND ADDED TO OBJECT
        String theDate = date.toString();
        newDiaryEntry.setDate(theDate);


        System.out.println("here");
        System.out.println(newDiaryEntry.getTitle());
        System.out.println(newDiaryEntry.getMainText());
        System.out.println(newDiaryEntry.getDate());
        System.out.println(newDiaryEntry.getUser());


        NewDiaryEntry.addToDiaryList(newDiaryEntry, entryList);

        WriteReadJson.writeToJson(entryList);



    }

}


}
