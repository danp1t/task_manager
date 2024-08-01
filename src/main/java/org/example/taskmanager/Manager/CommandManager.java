package org.example.taskmanager.Manager;

import org.example.taskmanager.Command.*;
import org.example.taskmanager.Interface.Command;

import java.util.HashMap;

public class CommandManager {
    private HashMap<String, Command> listCommand = new HashMap<>();

    //Список команд
    public CommandManager() {
        listCommand.put("help", new Help());
        listCommand.put("addTask", new AddTask());
        listCommand.put("showListTask", new ShowListTask());
        listCommand.put("exit", new Exit());
        listCommand.put("save", new Save());
        listCommand.put("doneTask", new DoneTask());
    }

    public Command getCommand(String command) {
        return listCommand.get(command);
    }
    
    public HashMap<String, Command> getListCommand() {
        return listCommand;
    }
}
