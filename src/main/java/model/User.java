package model;

import java.util.List;



/**
 *  <p>The is the Sser class. Its main purpose is to offer a way to set and get username and active user. <br>
 *
 *
 *  </p>
 * @author thomasjuth
 *
 */


public class User {

    private String username;
    private static String activeUser;


    private List<User> userList;


    public User(String username, List<User> userList) {
        /**
        @param
         */

        this.username = username;
        this.userList = userList;
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


    public List<User> getUserList() {
        return userList;
    }


}








