package model;

import enums.Language;

import java.util.List;

public class Admin extends Employee {
    public Admin(String id, String name, String username, String password, Language language, String empId, String department) {
        super(id, name, username, password, language, empId, department);
    }

    public void addUser(User user, List<User> userList) {
        userList.add(user);
        System.out.println("Added user: " + user.getFullName());
    }

    public void removeUser(User user, List<User> userList) {
        userList.remove(user);
        System.out.println("Removed user: " + user.getFullName());
    }

    public void updateUser(User user, String newName, String newPassword, String fullName) {
        user.setUsername(newName);
        user.setFullName(fullName);
        user.setPassword(newPassword);
        System.out.println("Updated user: " + user.getUsername());
    }

    public void viewLogs(List<String> logs) {
        System.out.println("System Logs");
        logs.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Admin : " + getUsername() + " department " + getDepartment();
    }
}
