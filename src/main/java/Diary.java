//import com.fasterxml.jackson.databind.ObjectMapper;
//import model.NewDiaryEntry;
//import model.User;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Diary {
//
//private User user;
//
//
//
//
//    public Diary(User user) {
//        this.user = user;
//    }
//
//    public Diary() {
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public List<Diary> getDiaryList() {
//        return diaryList;
//    }
//
//    public void setDiaryList(List<Diary> diaryList) {
//        this.diaryList = diaryList;
//    }
//
//
//
//
//    public void printDiary () throws IOException {
//
//        ObjectMapper mapper = new ObjectMapper();
//
//
//            List<NewDiaryEntry> printList = new ArrayList<>(List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(),NewDiaryEntry.class)));
//
//
//
//            for(NewDiaryEntry item: printList){
//
//                System.out.println("Title: " + item.getTitle());
//                System.out.println("Main text: " + item.getMainText());
//                System.out.println("Date:  " + item.getDate());
//
//
//            }
//
//
//
//
//
//
//    }
//
//}
//
//
