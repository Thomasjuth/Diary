package model;

public class NewDiaryEntry {



    private String title;

    private String mainText;
    private String date;
    private String userName;



    public NewDiaryEntry(String title, String mainText, String date, String userName ) {
        this.title = title;
        this.mainText = mainText;
        this.date = date;
        this.userName = userName;

    }



    public NewDiaryEntry(String userName) {
        this.userName = userName;

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
}
