package org.example.taskmanager.Manager;

import org.example.taskmanager.Collection.Task;

import java.util.ArrayList;

public class CollectionManager {
    private static ArrayList<Task> taskList = new ArrayList<>();

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void setTaskList(ArrayList<Task> taskList1) {
        taskList = taskList1;
    }
}
