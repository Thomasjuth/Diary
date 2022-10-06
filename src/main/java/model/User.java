package model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String Username;
    private static String activeUser;
    private static String activeUserName;

    private List<User> userList;


    public User(String username, String activeUser, String user) {
        Username = username;
        this.activeUser = activeUser;
        this.activeUserName = user;
        this.userList = new ArrayList<>();
    }





    public User(String username) {
        Username = username;
    }

    public User() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public static String getActiveUser() {
        return activeUser;
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

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}



