package model;

import enums.Language;
import enums.StudentDegree;
import exceptions.LowHIndexException;
import interfaces.Researcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GraduateStudent extends Student implements Researcher{
    private StudentDegree degree;
    private Researcher supervisor;
    private List<ResearchPaper> diplomaProjects;
    private List<ResearchPaper> papers;
    private List<ResearchProject> projects;

    public GraduateStudent(String id, String name, String username, String password, Language language, String studentId, int yearOfStudy, StudentDegree degree) {
        super(id, name, username, password, language, studentId, yearOfStudy);
        this.degree = degree;
        this.diplomaProjects = new ArrayList<>();
        this.papers = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public void setSupervisor(Researcher supervisor)throws LowHIndexException{
        int indexOfSup = supervisor.calculateHIndex();

        if(indexOfSup < 3) {
            String supervisorName = "";
            if (supervisor instanceof User) {
                User u = (User) supervisor;
                supervisorName = u.getFullName();
            }

            throw new LowHIndexException(supervisorName,indexOfSup);
        }

        this.supervisor = supervisor;

    }

    public void addDiplomaProject(ResearchPaper paper) {
        this.diplomaProjects.add(paper);
        this.papers.add(paper);
    }

    @Override
    public List<ResearchPaper> getPapers() {
        return this.papers;
    }

    @Override
    public List<ResearchProject> getProjects() {
        return this.projects;
    }

    @Override
    public void printPapers(Comparator<ResearchPaper> c) {
        System.out.println("Papers of GraduateStudent " + getFullName());
        List<ResearchPaper> tempPapers = new ArrayList<>(this.papers);
        Collections.sort(tempPapers, c);
        for (ResearchPaper p : tempPapers) {
            System.out.println(p);
        }
    }

    public StudentDegree getDegree() {
        return degree;
    }

    public Researcher getSupervisor() {
        return supervisor;
    }

    public List<ResearchPaper> getDiplomaProjects() {
        return diplomaProjects;
    }

    @Override
    public String toString() {
        return "GraduateStudent name: " + getFullName() + " degree: " + degree + " gpa:" + getGpa() + ", hIndex=" + calculateHIndex() ;
    }
}

