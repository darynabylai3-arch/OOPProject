package model;

import interfaces.Researcher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ResearcherDecorator implements Researcher {
    private User wrappedUser;           // исходный объект
    private List<ResearchPaper> papers = new ArrayList<>();
    private List<ResearchProject> projects = new ArrayList<>();

    public ResearcherDecorator(User user) {
        this.wrappedUser = user;
    }


    public String getName() { return wrappedUser.getName(); }

    @Override
    public List<ResearchPaper> getPapers() { return papers; }

    @Override
    public List<ResearchProject> getProjects() { return projects; }

    @Override
    public void printPapers(Comparator<ResearchPaper> c) {
        System.out.println("Papers of " + getName() );
        List<ResearchPaper> sortedPapers = new ArrayList<>(papers);
        Collections.sort(sortedPapers, c);
        for (ResearchPaper p : sortedPapers) {
            System.out.println(p);
        }
    }

}
