package org.example.taskmanager.Manager;

import com.google.gson.*;
import org.example.taskmanager.Collection.Priority;
import org.example.taskmanager.Collection.Task;
import org.example.taskmanager.Collection.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Класс для работы с коллекцией
 */
public class CollectionManager {
    /**
     * Список задач
     */
    private static ArrayList<Task> taskList = new ArrayList<>();
    /**
     * Баланс
     */
    private static int balance;

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void setTaskList(ArrayList<Task> taskList1) {
        taskList = taskList1;
    }

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance1) {
        balance = balance1;
    }

    /**
     * @return возвращает id следующей задачи
     */
    public static int nextID(){
        return taskList.size();
    }

    /**
     * Переводит коллекцию из оперативной памяти в JSON формат
     * @return JspnArray с задачами
     */
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

    /**
     * Сохраняет коллекцию в файл
     */
    public static void saveJSON() {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter("/home/danp1t/github/TaskManager/user.json");
            int id = 0;
            String userName = "Danil Putintsev";
            User user = new User(id, userName, balance);

            gson.toJson(user, fileWriter);
            fileWriter.close();

            FileWriter writer = new FileWriter("/home/danp1t/github/TaskManager/collection.json");
            gson.toJson(getJSON(), writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Файл для сохранения коллекции не найден");
        }
    }

    /**
     * Читает коллекцию из файла в оперативную память
     */
    public static void readJSONfromFile(){
        try {
            JsonObject jsonObjectUser = (JsonObject) new JsonParser().parse(new FileReader("/home/danp1t/github/TaskManager/user.json"));
            balance = jsonObjectUser.get("balance").getAsInt();
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
