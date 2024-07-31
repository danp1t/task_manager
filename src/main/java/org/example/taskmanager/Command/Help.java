package org.example.taskmanager.Command;

import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CommandManager;

import java.util.HashMap;

public class Help implements Command {
    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Вывести информацию о командах";
    }

    @Override
    public void execute(String[] tokens) {
        CommandManager commandManager = new CommandManager();
        HashMap<String, Command> listCommand = commandManager.getListCommand();
        for (String commandName : listCommand.keySet()) {
            Command command = listCommand.get(commandName);
            String text = String.format("%s - %s", command.getCommandName(), command.getDescription());
            System.out.println(text);
        }
    }
}
