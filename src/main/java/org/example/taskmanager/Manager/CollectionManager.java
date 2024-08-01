package org.example.taskmanager.Manager;

import com.google.gson.*;
import org.example.taskmanager.Collection.Priority;
import org.example.taskmanager.Collection.Task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Gson gson = new Gson();
        try {
            System.out.println(getJSON());
            FileWriter writer = new FileWriter("/home/danp1t/github/TaskManager/collection.json");
            gson.toJson(getJSON(), writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Файл для сохранения коллекции не найден");
        }
    }

//    public static void readJSONfromFile(){
//        try {
//            Gson gson = new Gson();
//            FileReader reader = new FileReader("/home/danp1t/github/TaskManager/collection.json");
//            //ArrayList<Task> listTask = gson.fromJson(reader, ArrayList.class);
//            List<Task> books = Arrays.asList(gson.fromJson(reader, Task[].class));
//            System.out.println(books);
//            //taskList = listTask;
//            reader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Ошибка при чтении из файла");
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public static void readJSONfromFile(){
        try {
            ArrayList<Task> taskList = new ArrayList<>();
            JsonArray jsonArray = (JsonArray) new JsonParser().parse(new FileReader("/home/danp1t/github/TaskManager/collection.json"));
            for (JsonElement jsonElement : jsonArray){
                JsonObject jsonObject = (JsonObject) jsonElement;
                int id = jsonObject.get("id").getAsInt();
                String name = jsonObject.get("name").getAsString();
                String priorityStr = jsonObject.get("priority").getAsString();
                Priority priority = Priority.valueOf(priorityStr);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
                String deadlineStr = jsonObject.get("deadline").getAsString();
                LocalDateTime deadline = LocalDateTime.parse(deadlineStr, formatter);
                int prize = jsonObject.get("prize").getAsInt();
                Task task = new Task(id, name, priority, deadline, prize);
                taskList.add(task);
            }
            CollectionManager.setTaskList(taskList);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении коллекции из файла");
        }
    }
}
