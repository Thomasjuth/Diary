import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();


        List<User> userList = new ArrayList<>();
        List<User> tempUser = List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(), User[].class));
        userList.addAll(tempUser);

        //OLD JSON ENTRIES ARE READ BACK AND SAVED INTO TEMP ARRAY

        List<Diary> diaryList = new ArrayList<>();
        List<Diary> tempDiary = List.of(mapper.readValue(Paths.get("src/main/resources/diaryEntries.json").toFile(), Diary[].class));
        diaryList.addAll(tempDiary);


        int menu = 1;

        if (menu == 1) {
            int optionChoice = OptionsMenu.optionsAndChoice1();
            menu = SwitchMenu.switchMenu1(optionChoice, userList, diaryList);
        }

        if (menu == 2) {
            int optionsChoice2 = OptionsMenu.optionsAndChoice2();
            menu = SwitchMenu.switchMenu2(optionsChoice2, diaryList);
                }


            }


        }
















