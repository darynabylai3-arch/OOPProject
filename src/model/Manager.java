package model;

import enums.Language;
import enums.ManagerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Manager extends Employee{

    private ManagerType managerType;

    public Manager(String id, String name, String username, String password,
                   Language language, String empId, String department, ManagerType managerType) {
        super(id, name, username, password, language, empId, department);
        this.managerType = managerType;
    }


    public void assignCourseToTeacher(Teacher teacher, Course course) {
        teacher.addCourse(course);
        course.addInstructor(teacher);
        System.out.println("Assigned " + course.getName() + " to " + teacher.getFullName());
    }

    public void approveCourseRegistration(Student student, Course course) {
        System.out.println(" Approved " + student.getFullName() + " for course " + course.getName());
    }

    public void addCourseForRegistration(Course course, String major, int year) {
        System.out.println("Added course " + course.getName() + " for major=" + major + ", year=" + year);
    }

    public String createStatisticalReport(List<Student> students) {
        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            sum = sum + students.get(i).getGpa();
        }

        double avgGpa = 0;
        if (students.size() > 0) {
            avgGpa = sum / students.size();
        }

        StringBuilder sb = new StringBuilder("Report:\n");
        sb.append("Total students: ").append(students.size()).append("\n");
        sb.append("Average GPA: ").append(String.format("%.2f", avgGpa)).append("\n");

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s2.getGpa() > s1.getGpa()) return 1;
                if (s2.getGpa() < s1.getGpa()) return -1;
                return 0;
            }
        });
        for (Student s : students) {
            sb.append(s.getFullName()).append(": ").append(s.getGpa()).append("\n");
        }

        System.out.println(sb.toString());
        return sb.toString();
    }


    public List<Student> viewStudentsSortedByGpa(List<Student> students) {
        List<Student> sortedList = new ArrayList<>(students);

        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getGpa(), s1.getGpa());
            }
        });

        return sortedList;
    }

    public List<Student> viewStudentsSortedAlphabetically(List<Student> students) {
        List<Student> sortedList = new ArrayList<>(students);

        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getUsername().compareTo(s2.getUsername());
            }
        });

        return sortedList;
    }

    public List<Teacher> viewTeachersSortedAlphabetically(List<Teacher> teachers) {
        List<Teacher> sortedList = new ArrayList<>(teachers);

        Collections.sort(sortedList, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher t1, Teacher t2) {
                return t1.getUsername().compareTo(t2.getUsername());
            }
        });

        return sortedList;
    }


    public void seeRequests(List<Request> requests) {
        System.out.println("Requests:\n");
        for (Request r:requests){
            System.out.println(r);
        }
    }

    public void addNews(News news,List<News> newsList, String title, String body){
        news.setTitle(title);
        news.setBody(body);
        newsList.add(news);
        System.out.println("New news added");
    }

    public void removeNews(News news, List<News> newsList){
        newsList.remove(news);
        System.out.println("News deleted");
    }

    public ManagerType getManagerType() { return managerType; }

    @Override
    public String toString() {
        return "Manager name: " + getFullName() + " type: " + managerType + ", department:" + getDepartment()  ;
    }

}
