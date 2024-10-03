package org.example.taskmanager.Interface;

/**
 * Интерфейс команд
 */
public interface Command {
    public void execute(String[] tokens);
    public String getCommandName();
    public String getDescription();
}
