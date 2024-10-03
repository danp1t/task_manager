package org.example.taskmanager.Command;

import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CollectionManager;

/**
 * Команда выхода из приложения
 */
public class Exit implements Command {
    @Override
    public String getCommandName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Выход из приложения (с сохранением коллекции в файл)";
    }

    @Override
    public void execute(String[] tokens) {
        CollectionManager.saveJSON();
        System.exit(0);
    }
}
