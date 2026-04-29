package model;

import enums.CourseType;
import enums.SchoolType;
import model.Teacher;
import model.Lesson;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String name;
    private CourseType courseType;
    private int courseCredit;
    private List<Teacher> instructors;
    private List<Lesson> lessons;
    private SchoolType school;

    public Course(String courseId, String name, CourseType courseType, int courseCredit, SchoolType school) {
        this.courseId = courseId;
        this.name = name;
        this.courseType = courseType;
        this.courseCredit = courseCredit;
        this.school = school;
        this.instructors = new ArrayList<>();
        this.lessons = new ArrayList<>();
    }

    public void addInstructor(Teacher teacher) { instructors.add(teacher); }
    public void addLesson(Lesson lesson) { lessons.add(lesson); }

    public String getCourseId() {
        return courseId;
    }
    public String getName() {
        return name;
    }
    public CourseType getCourseType() {
        return courseType;
    }
    public int getCourseCredit() {
        return courseCredit;
    }
    public List<Teacher> getInstructors() {
        return instructors;
    }
    public List<Lesson> getLessons() {
        return lessons;
    }
    public SchoolType getSchool() {
        return school;
    }
    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    @Override
    public String toString() {
        return "Course: " + name + " credits " + courseCredit;
    }
}
