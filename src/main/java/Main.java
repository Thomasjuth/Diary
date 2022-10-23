import com.fasterxml.jackson.databind.ObjectMapper;
import model.NewDiaryEntry;
import model.User;
import service.Switch1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();

        //Reads back both the User List and the DiaryEntry List

        List<User> userList = readFromUsersList(mapper);
        List<NewDiaryEntry> diaryList = readFromDiaryList(mapper);

        welcomeMessage();
        // Takes us to Menu 1
               Switch1.switchMenu1(diaryList, userList);


        }



        public static List<User> readFromUsersList(ObjectMapper mapper) throws IOException {


            List<User> userList = new ArrayList<>();
            List<User> tempUser = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));
            userList.addAll(tempUser);

            return userList;

        }


    public static List<NewDiaryEntry> readFromDiaryList(ObjectMapper mapper) throws IOException {

        List<NewDiaryEntry> diaryList = new ArrayList<>();
        List<NewDiaryEntry> tempDiary = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), NewDiaryEntry[].class));
        diaryList.addAll(tempDiary);

        return diaryList;

    }


    public static void welcomeMessage () throws InterruptedException {


        System.out.println("Welcome!");
        Thread.sleep(200);

        System.out.println("I am glad you feel like sharing your secrets with me");
        Thread.sleep(100);
        System.out.println(" :) ");
    }
    }





























