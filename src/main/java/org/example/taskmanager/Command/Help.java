package org.example.taskmanager.Command;

import org.example.taskmanager.Interface.Command;

public class Help implements Command {
    @Override
    public String getCommandName() {
        return "Help";
    }

    @Override
    public String getDescription() {
        return "Вывести информацию о командах";
    }

    @Override
    public void execute(String[] tokens) {
        System.out.println("Лол");

    }
}
