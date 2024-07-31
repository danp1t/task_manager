package org.example.taskmanager.Manager;

import org.example.taskmanager.Collection.Task;

import java.util.ArrayList;

public class CollectionManager {
    private ArrayList<Task> taskList = new ArrayList<>();






    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
}
