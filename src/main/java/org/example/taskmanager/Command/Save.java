package org.example.taskmanager.Command;

import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CollectionManager;

public class Save implements Command {
    @Override
    public String getCommandName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "Сохраняет коллекцию в файл";
    }

    @Override
    public void execute(String[] tokens) {
        CollectionManager.saveJSON();
    }
}
