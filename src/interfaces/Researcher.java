package interfaces;

import model.ResearchPaper;
import model.ResearchProject;

import java.util.Comparator;
import java.util.List;

public interface Researcher {
    List<ResearchPaper> getPapers();
    List<ResearchProject> getProjects();

    void printPapers(Comparator<ResearchPaper> c);

    default int calculateHIndex() {
        List<ResearchPaper> papers = getPapers();
        papers.sort((a, b) -> Integer.compare(b.getCitations(), a.getCitations()));
        int h = 0;
        for (ResearchPaper p : papers) {
            if (p.getCitations() >= h + 1) h++;
            else break;
        }
        return h;
    }


}
