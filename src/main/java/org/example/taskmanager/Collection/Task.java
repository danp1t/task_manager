package org.example.taskmanager.Collection;

import com.google.gson.annotations.SerializedName;

/**
 * Данный класс содержит информацию о задаче
 * Задача - это действие, которое мы должны совершить, чтобы получить награду.
 */
public class Task {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("priority")
    private Priority priority;

    @SerializedName("deadline")
    public java.time.LocalDateTime deadline;

    @SerializedName("prize")
    private int prize;

    public Task(String name, Priority priority, java.time.LocalDateTime deadline, int prize) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
        this.prize = prize;
    }

    public Task(int id, String name, Priority priority, java.time.LocalDateTime deadline, int prize) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
        this.prize = prize;
    }

    //Getter
    public int getId() {
        return id;
    }

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

    public String toString() {
        return "id: " + this.id + "\nname: " + this.name + "\npriority: " + this.priority + "\ndeadline: " + this.deadline + "\nprize: " + this.prize;
    }
}
