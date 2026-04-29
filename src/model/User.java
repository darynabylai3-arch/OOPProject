package model;

import enums.Language;

public class User {
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
}
