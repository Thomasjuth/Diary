package model;

import java.util.List;

public class User {

    private String Username;
    private String activeUser;
    private String user;

    private List<User> userList;


    public User(String username, String activeUser, String user) {
        Username = username;
        this.activeUser = activeUser;
        this.user = user;
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

    public String getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(String activeUser) {
        this.activeUser = activeUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }






}



