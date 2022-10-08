package model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private static String activeUser;
    private static String activeUserName;

    private List<User> userList;


    public User(String username, String activeUser, String user) {
        this.username = username;
        this.activeUser = activeUser;
        this.activeUserName = user;
        this.userList = new ArrayList<>();
    }


    public User() {

    }



    public String getUsername() {
        return username;
    }



    public static String getActiveUser() {
        return activeUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void setActiveUser(String activeUser) {
        User.activeUser = activeUser;
    }

    public static String getActiveUserName() {
        return activeUserName;
    }

    public static void setActiveUserName(String activeUserName) {
        User.activeUserName = activeUserName;
    }

    public List<User> getUserList() {
        return userList;
    }





    public static void printUsers () {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<User> userList = new ArrayList<>(List.of(mapper.readValue(Paths.get("src/main/resources/userList.json").toFile(),User[].class)));



            for(User item: userList){

                System.out.println("Username: " + item.getUsername());


            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}










