package org.example.taskmanager.Command;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.taskmanager.Collection.Task;
import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CollectionManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DoneTask implements Command {
    @Override
    public String getCommandName() {
        return "doneTask";
    }

    @Override
    public String getDescription() {
        return "Отмечает, то что мы выполнили задачу";
    }

    @Override
    public void execute(String[] tokens) {
        ArrayList<Task> taskList = CollectionManager.getTaskList();
        for (Task task : taskList) {
            System.out.println(task.getId() + ". " + task.getName());
        }

        System.out.print("Введите id выполненной задачи: ");
        Scanner scanner = new Scanner(System.in);
        String idStr = scanner.nextLine();
        Integer id = Integer.parseInt(idStr);
        ArrayList<Task> newTaskList = new ArrayList<>();
        for (Task task : taskList) {
            if (!id.equals(task.getId())) {
                newTaskList.add(task);
            }
            else {

                Gson gson = new Gson();
                try {
                    CollectionManager.setBalance(CollectionManager.getBalance() + task.getPrize());
                    FileWriter writer = new FileWriter("/home/danp1t/github/TaskManager/done.json", true);

                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("id", task.getId());
                    jsonObject.addProperty("name", task.getName());
                    jsonObject.addProperty("priority", task.getPriority().toString());
                    jsonObject.addProperty("deadline", task.getDeadline().toString());
                    jsonObject.addProperty("prize", task.getPrize());

                    gson.toJson(jsonObject, writer);
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Файл для сохранения коллекции не найден");
                }
            }
        }
        if (newTaskList.size() == taskList.size()) {
            System.out.println("ID не был найден. =(");
        }
        CollectionManager.setTaskList(newTaskList);
    }
}
