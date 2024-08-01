package org.example.taskmanager.Command;

import org.example.taskmanager.Collection.Task;
import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CollectionManager;

import java.util.ArrayList;

public class ShowListTask implements Command {
    @Override
    public String getCommandName() {
        return "showListTask";
    }

    @Override
    public String getDescription() {
        return "Посмотреть список задач";
    }

    @Override
    public void execute(String[] tokens) {
        ArrayList<Task> taskList = CollectionManager.getTaskList();
        for (Task task : taskList) {
            System.out.println(task.getId() + ". " + task.getName() + ". Награда: " + task.getPrize());
        }
    }
}
