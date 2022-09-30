public class newDiaryEntry {

    String title;
    String entry;
    int date;


    public newDiaryEntry(String title, String entry, int date) {
        this.title = title;
        this.entry = entry;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
