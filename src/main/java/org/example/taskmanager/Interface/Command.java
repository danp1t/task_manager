package org.example.taskmanager.Interface;

public interface Command {
    public void execute(String[] tokens);
    public String getCommandName();
    public String getDescription();
}
