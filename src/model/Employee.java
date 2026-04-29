package model;

import enums.Language;

public class Employee extends User{
    private String empId;
    private String department;

    public Employee(String id, String name, String username, String password, Language language, String empId, String department){
        super(id,name,username,password,language);
        this.empId = empId;
        this.department = department;
    }

    public void sendMessage(Message message){
        System.out.println("Message " + getUsername() + " sent message to " + message.getTo().getUsername() + " message: " + message.getDescription());
    }

    @Override
    public String toString() {
        return "Employee: " + getFullName()+ " ID: " + empId  + " department: " + department;
    }

    public String getEmpId() {
        return empId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
