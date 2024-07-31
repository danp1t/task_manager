package org.example.taskmanager.Manager;

import org.example.taskmanager.Command.Help;
import org.example.taskmanager.Interface.Command;

import java.util.HashMap;

public class CommandManager {
    private HashMap<String, Command> listCommand = new HashMap<>();

    //Список команд
    public CommandManager() {
        listCommand.put("help", new Help());
    }

    public Command getCommand(String command) {
        return listCommand.get(command);
    }
}
