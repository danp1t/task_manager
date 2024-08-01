package org.example.taskmanager.Manager;

import com.google.gson.Gson;
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

    public static int nextID(){
        return taskList.size();
    }

    public static String getJSON(){
        Gson gson = new Gson();
        System.out.println(taskList);
        return gson.toJson(taskList);
    }
}
