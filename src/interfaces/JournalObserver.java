package interfaces;

import model.ResearchPaper;

public interface JournalObserver {
    void onNewPaperPublished(ResearchPaper paper, String journalName);
}
