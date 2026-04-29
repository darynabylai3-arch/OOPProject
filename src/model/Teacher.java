package model;

import enums.Language;
import enums.TeacherPosition;
import enums.UrgencyLevel;
import interfaces.Researcher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Teacher extends Employee implements Researcher {
    private TeacherPosition position;
    private List<Course> courses;
    private double rating;
    private int ratingCount;
    private List<ResearchPaper> papers;
    private List<ResearchProject> projects;


    public Teacher(String id, String name, String username, String password, Language language, String empId, String department, TeacherPosition position) {
        super(id, name, username, password, language, empId, department);
        this.position = position;
        this.courses = new ArrayList<>();
        this.papers = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public void viewCourses(){
        System.out.println("Courses");
        for (Course c : courses){
            System.out.println(c);
        }
    }

    public void putMark(Course c, Map<Student,Mark> marks){
        for (Map.Entry<Student, Mark> entry : marks.entrySet()) {
            Student student = entry.getKey();
            Mark mark = entry.getValue();

            Map<Course, Mark> studentMarks = student.getMarks();
            studentMarks.put(c, mark);
            System.out.println("  " + student.getUsername() + " -> " + mark);
        }
    }

    public void sendComplaint(Student student, UrgencyLevel urgency, String reason) {
        System.out.println("Complaint" + urgency + " " + getFullName() + " complaints about " + student.getFullName() + ": " + reason);
    }

    public double getAverageRating() {
        if (ratingCount == 0) {
            return 0.0;
        } else {
            double average = rating / ratingCount;
            return average;
        }
    }

    public boolean isResearcher() {
        return position == TeacherPosition.PROFESSOR || !papers.isEmpty();
    }


    public void addRating(double score) {
        rating += score;
        ratingCount++;
    }


    public void addCourse(Course course) { courses.add(course); }
    public void addPaper(ResearchPaper paper) { papers.add(paper); }
    public void addProject(ResearchProject project) { projects.add(project); }

    public void setPosition(TeacherPosition position) { this.position = position; }
    public List<Course> getCourses() { return courses; }

    @Override
    public void printPapers(Comparator<ResearchPaper> c) {
        System.out.println("Papers of " + getUsername() );
        papers.stream().sorted(c).forEach(System.out::println);
    }

    @Override
    public List<ResearchPaper> getPapers() { return papers; }

    @Override
    public List<ResearchProject> getProjects() { return projects; }

    @Override
    public String toString() {
        return "Teacher name:" + getUsername() + " position: " + position + ", department:" + getDepartment() + "', rating=" + getAverageRating() ;
    }


    public TeacherPosition getPosition() {
        return position;
    }
}
