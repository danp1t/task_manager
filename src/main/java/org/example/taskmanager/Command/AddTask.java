package org.example.taskmanager.Command;

import org.example.taskmanager.Interface.Command;

public class AddTask implements Command {
    @Override
    public String getCommandName() {
        return "addTask";
    }

    @Override
    public String getDescription() {
        return "Добавить задачу в список задач";
    }

    @Override
    public void execute(String[] tokens) {

    }
}
