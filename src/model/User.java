package model;

import enums.Language;
import interfaces.Authenticatable;

public class User implements Authenticatable {
    private String id;
    private String fullName;
    private String username;
    private String password;
    private Language language;

    public User(String id, String fullName,String username, String password, Language language ){
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.language = language;
    }

    public void changeLanguage(Language language){
        this.language = language;
    }

    @Override
    public boolean login(String username, String password) {
        if((this.username.equals(username)) && (this.password.equals(password)) ) {
            System.out.println(this.fullName + " is logged in the system");
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        System.out.println("User " + username + " is logged out" );
    }



    @Override
    public String toString() {
        return "User`s full name: " + fullName + " nickname: " + username + " System Language: " + language;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public Language getLanguage() {
        return language;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
