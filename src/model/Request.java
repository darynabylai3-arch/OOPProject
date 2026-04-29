package model;

import enums.RequestStatus;
import enums.UrgencyLevel;

public class Request {
    private String description;
    private UrgencyLevel level;
    private RequestStatus status;

    public Request(String description,UrgencyLevel level, RequestStatus status){
        this.description = description;
        this.level = level;
        this.status = status;
    }

    public void sendRequest(Employee e){
        System.out.println("Employee e sent request to " + e.getUsername() + " request level: " + level );
    }

    public RequestStatus getStatus() {
        return status;
    }

    public UrgencyLevel getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
