package model;

import java.util.Comparator;

public class PaperComparators {
    public static final Comparator<ResearchPaper> BY_CITATIONS = new Comparator<ResearchPaper>() {
        @Override
        public int compare(ResearchPaper p1, ResearchPaper p2) {
            return Integer.compare(p2.getCitations(), p1.getCitations());
        }
    };

    public static final Comparator<ResearchPaper> BY_DATE = new Comparator<ResearchPaper>() {
        @Override
        public int compare(ResearchPaper p1, ResearchPaper p2) {
            return p2.getPublishedDate().compareTo(p1.getPublishedDate());
        }
    };

    public static final Comparator<ResearchPaper> BY_LENGTH = new Comparator<ResearchPaper>() {
        @Override
        public int compare(ResearchPaper p1, ResearchPaper p2) {
            return Integer.compare(p2.getPages(), p1.getPages());
        }
    };


    public static final Comparator<ResearchPaper> BY_TITLE = new Comparator<ResearchPaper>() {
        @Override
        public int compare(ResearchPaper p1, ResearchPaper p2) {
            return p1.getTitle().compareTo(p2.getTitle());
        }
    };

}
