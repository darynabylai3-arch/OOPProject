package model;

import interfaces.Researcher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResearchProject {
    private String topic;
    private List<Researcher> participants;
    private List<ResearchPaper> publishedPapers;
    private LocalDate startDate;

    public ResearchProject(String topic, LocalDate startDate) {
        this.topic = topic;
        this.startDate = startDate;
        this.participants = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    public void addParticipant(Object person) {
        participants.add((Researcher) person);
    }

    public void removeParticipant(Researcher r) {
        participants.remove(r);
    }

    public void addPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
    }


    public String getTopic() { return topic; }
    public List<Researcher> getParticipants() { return participants; }
    public List<ResearchPaper> getPublishedPapers() { return publishedPapers; }
    public LocalDate getStartDate() { return startDate;}

    @Override
    public String toString() {
        return "ResearchProject topic='" + topic + "', participants=" + participants.size() + ", papers=" + publishedPapers.size()  ;
    }


}
