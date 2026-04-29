package model;

public class Mark implements Comparable<Mark> {
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;

    public Mark(double firstAttestation, double secondAttestation, double finalExam) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
    }

    public double getTotal() {
        return firstAttestation + secondAttestation + finalExam;
    }

    public boolean isPassed() {
        return getTotal() >= 50 && (firstAttestation + secondAttestation >=29.5);
    }

    public String getLetterGrade() {
        double total = getTotal();
        if (total >= 95) return "A";
        if (total >= 90) return "A-";
        if (total >= 85) return "B+";
        if (total >= 80) return "B";
        if (total >= 75) return "B-";
        if (total >= 70) return "C+";
        if (total >= 65) return "C";
        if (total >= 60) return "C-";
        if (total >= 55) return "D+";
        if (total >= 50) return "D";
        return "F";
    }

    public double getFirstAttestation() { return firstAttestation; }
    public double getSecondAttestation() { return secondAttestation; }
    public double getFinalExam() { return finalExam; }
    public void setFirstAttestation(double v) { firstAttestation = v; }
    public void setSecondAttestation(double v) { secondAttestation = v; }
    public void setFinalExam(double v) { finalExam = v; }

    @Override
    public int compareTo(Mark other) {
        return Double.compare(this.getTotal(), other.getTotal());
    }

    @Override
    public String toString() {
        return "Mark{att1=" + firstAttestation + ", att2=" + secondAttestation
                + ", final=" + finalExam + ", total=" + getTotal() + " (" + getLetterGrade() + ")}";
    }

}
