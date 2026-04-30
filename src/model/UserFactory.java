package model;
import enums.Language;
import enums.StudentDegree;
import enums.TeacherPosition;
import enums.ManagerType;


public class UserFactory {
    public static User create(String type, String id, String name, String username, String password, Language lang, String... extra) {
        return switch (type.toUpperCase()) {
            case "STUDENT" -> new Student(id, name, username, password, lang,
                    extra[0],
                    Integer.parseInt(extra[1]));
            case "GRADUATE_MASTER" -> new GraduateStudent(id, name, username, password, lang,
                    extra[0], Integer.parseInt(extra[1]),
                    StudentDegree.MASTER);

            case "GRADUATE_PHD" -> new GraduateStudent(id, name, username, password, lang,
                    extra[0], Integer.parseInt(extra[1]),
                    StudentDegree.PHD);

            case "TEACHER" ->
                    new Teacher(id, name, username, password, lang,
                            extra[0],                               // empId
                            extra[1],                               // department
                            TeacherPosition.valueOf(extra[2]));     // position

            case "MANAGER" ->
                    new Manager(id, name, username, password, lang,
                            extra[0], extra[1],
                            ManagerType.valueOf(extra[2]));

            case "ADMIN" ->
                    new Admin(id, name, username, password, lang,
                            extra[0], extra[1]);

            case "TECH_SUPPORT" ->
                    new TechSupporter(id, name, username, password, lang,
                            extra[0], extra[1]);


            default -> throw new IllegalArgumentException(
                    "Unknown user type: " + type +
                            ". Use: STUDENT, GRADUATE_MASTER, GRADUATE_PHD, TEACHER, MANAGER, ADMIN, TECH_SUPPORT");


        };
    }
}

