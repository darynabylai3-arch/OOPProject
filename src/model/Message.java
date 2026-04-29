package model;

import java.time.LocalDateTime;

public class Message {
    private User from;
    private User to;
    private String description;
    private LocalDateTime sentAt;

    public Message(User from, User to, String description) {
        this.from = from;
        this.to = to;
        this.description = description;
        this.sentAt = LocalDateTime.now();
    }

    public void sendMessage(User to){
        System.out.println("Message sent from " + this.from.getUsername() + " to " + to.getUsername() + " at " + sentAt);
    }

    public void readMessage(User from) {
        System.out.println("Reading message from " + from.getUsername() + ": " + description);
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public String getDescription() {
        return description;
    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from=" + from +
                ", to=" + to +
                ", description='" + description + '\'' +
                ", sentAt=" + sentAt +
                '}';
    }
}
