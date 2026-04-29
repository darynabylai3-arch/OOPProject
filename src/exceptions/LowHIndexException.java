package exceptions;

public class LowHIndexException extends Exception {
    public LowHIndexException(String supervisorName, int hIndex) {
        super("Cannot assign " + supervisorName + " as supervisor: h-index=" + hIndex + " < 3");
    }
}