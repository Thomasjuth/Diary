import model.User;

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


    public User getUser(User user) {
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
}
