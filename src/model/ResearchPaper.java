package model;

import enums.CitationFormat;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class ResearchPaper implements Comparable<ResearchPaper> {

    private String title;
    private ArrayList<String> authors;
    private String journal;
    private int pages;
    private LocalDate publishedDate;
    private String doi;
    private int citations;


    public ResearchPaper(String title, ArrayList<String> authors, String journal, int pages, LocalDate publishedDate, String doi, int citations) {
        this.title = title;
        this.authors = authors;
        this.journal = journal;
        this.pages = pages;
        this.publishedDate = publishedDate;
        this.doi = doi;
        this.citations = citations;
    }

    public String getCitation(CitationFormat f) {
        String authorsStr = String.join(", ", authors);

        int year = publishedDate.getYear();

        if (f == CitationFormat.BIBTEX) {
            String key;
            if (authors.isEmpty()) {
                key = "unknown";
            } else {
                String firstAuthor = authors.get(0);
                String[] parts = firstAuthor.split(" ");
                key = parts[0].toLowerCase();
            }

            String bibtex = "@article{" + key + year + ",\n";
            bibtex = bibtex + "  author = {" + authorsStr + "},\n";
            bibtex = bibtex + "  title = {" + title + "},\n";
            bibtex = bibtex + "  journal = {" + journal + "},\n";
            bibtex = bibtex + "  year = {" + year + "},\n";
            bibtex = bibtex + "  pages = {" + pages + "},\n";
            bibtex = bibtex + "  doi = {" + doi + "}\n";
            bibtex = bibtex + "}";

            return bibtex;

        } else {
            String plainText = authorsStr + ". (" + year + "). " + title + ". " + journal + ". Pages: " + pages + ". DOI: " + doi;
            return plainText;
        }
    }


    public String getTitle() { return title; }
    public ArrayList<String> getAuthors() { return authors; }
    public String getJournal() { return journal; }
    public int getPages() { return pages; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public String getDoi() { return doi; }
    public int getCitations() { return citations; }
    public void setCitations(int citations) { this.citations = citations; }

    @Override
    public int compareTo(ResearchPaper other) {
        return Integer.compare(other.citations, this.citations);
    }

    @Override
    public String toString() {
        return "ResearchPaper title='" + title + "', journal='" + journal + "', citations=" + citations + ", date=" + publishedDate ;
    }


}
