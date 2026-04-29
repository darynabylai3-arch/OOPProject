package model;

import enums.LessonType;

public class Lesson {
    private LessonType lessonType;
    private String description;

    public Lesson(LessonType lessonType, String description) {
        this.lessonType = lessonType;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    @Override
    public String toString() {
        return "Lesson type " + lessonType + " description: \n" + description;
    }
}
