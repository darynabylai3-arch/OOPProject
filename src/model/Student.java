package model;

import enums.Language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends User{

    private static final int MAX_CREDITS = 21;
    private static final int MAX_FAILS = 3;

    private String studentId;
    private double gpa;
    private int yearOfStudy;
    private int credits;
    private int failCount;
    private Map<Course, Mark> marks;
    private Map<Course, Integer> failCounts;
    private List<Course> registeredCourses;
    private String  organization;

    public Student(String id, String name, String username, String password, Language language, String studentId, int yearOfStudy) {
        super(id, name, username, password, language);
        this.studentId = studentId;
        this.yearOfStudy = yearOfStudy;
        this.gpa = 0.0;
        this.credits = 0;
        this.marks = new HashMap<>();
        this.failCounts = new HashMap<>();
        this.registeredCourses = new ArrayList<>();
    }


    public void viewCourses() {
        System.out.println("Registered Courses for " + getUsername() + " ===");
        for (Course course : registeredCourses) {
            System.out.println(course);
        }
    }

    public void viewMarks() {
        System.out.println("Marks" );
        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }

    public void viewTranscript() {
        System.out.println("Transcript: " + getUsername() + " GPA: " + gpa );
        for (Map.Entry<Course, Mark> entry : marks.entrySet()) {
            Course c = entry.getKey();
            Mark m = entry.getValue();
            System.out.println(c.getName() + " | " + m.getLetterGrade() + " | " + m.getTotal());
        }
    }

    public void rateTeacher(double score, Teacher teacher) {
        teacher.addRating(score);
        System.out.println("You rated teacher successful");
    }


    public void recalculateGpa() {
        if (marks.isEmpty()) {
            gpa = 0;
            return;
        }
        double sum = 0;
        for (Mark mark : marks.values()) {
            sum = sum + mark.getTotal();
        }

        gpa = sum / marks.size() / 10.0;
    }

    public double getGpa() {
        return gpa;
    }
    public String getStudentId() { return studentId; }

    public void setGpa(double gpa) { this.gpa = gpa; }
    public int getYearOfStudy() { return yearOfStudy; }
    public int getCredits() { return credits; }
    public Map<Course, Mark> getMarks() { return marks; }
    public List<Course> getRegisteredCourses() { return registeredCourses; }
    public String getOrganization() { return organization; }
    public void setOrganization(String org) { this.organization = org; }

    public void setFailCount(int failCount) {
        this.failCount += 1;
    }
}
