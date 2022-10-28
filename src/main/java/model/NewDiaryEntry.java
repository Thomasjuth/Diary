package model;

/**
 * <p>The is my second POJO class, used to create new Diary Entry objects.
 * Its main purpose is to offer a way to set and get username and active user. <br>
 *
 *
 * </p>
 *
 * @author thomasjuth
 */

public class NewDiaryEntry {


    private String title;

    private String mainText;

    private String userName;

    private static User user;

    private String date;


    //CONSTRUCTORS


    public NewDiaryEntry(String title, String mainText, String userName, String date) {

        this.title = title;
        this.mainText = mainText;
        this.userName = userName;
        this.date = date;
    }

    public NewDiaryEntry(String userName) {
        this.userName = userName;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return

                "Title: " + title + "\n" +
                        "Main Text: " + mainText + "\n" +
                        "User: " + userName + "\n" +
                        "Date: " + date + "\n"
                ;
    }
}



