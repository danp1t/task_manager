package org.example.taskmanager.Manager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.taskmanager.Collection.Task;

import java.io.FileWriter;
import java.io.IOException;
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

    private static JsonArray getJSON(){
        JsonArray jsonArray = new JsonArray();
        for(Task task : taskList){
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("id", task.getId());
            jsonObject.addProperty("name", task.getName());
            jsonObject.addProperty("priority", task.getPriority().toString());
            jsonObject.addProperty("deadline", task.getDeadline().toString());
            jsonObject.addProperty("prize", task.getPrize());
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    public static void saveJSON() {
        try(FileWriter writer = new FileWriter("/home/danp1t/github/TaskManager/collection.json", false)) {
            writer.write(getJSON().toString());
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл");
            System.out.println(e.getMessage());
        } ;
    }
}
