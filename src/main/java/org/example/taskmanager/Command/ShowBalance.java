package org.example.taskmanager.Command;

import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CollectionManager;

public class ShowBalance implements Command {
    @Override
    public String getCommandName() {
        return "showBalance";
    }

    @Override
    public String getDescription() {
        return "Посмотреть текущий баланс";
    }

    @Override
    public void execute(String[] tokens) {
        System.out.println("Ваш баланс: " + CollectionManager.getBalance());
    }
}
