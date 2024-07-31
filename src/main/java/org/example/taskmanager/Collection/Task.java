package org.example.taskmanager.Collection;

public class Task {
    private String name;
    private Priority priority;
    private java.time.LocalDateTime deadline;
    private int prize;

    public Task(String name, Priority priority, java.time.LocalDateTime deadline, int prize) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
        this.prize = prize;
    }

    //Getter
    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public java.time.LocalDateTime getDeadline() {
        return deadline;
    }

    public int getPrize() {
        return prize;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDeadline(java.time.LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
}
