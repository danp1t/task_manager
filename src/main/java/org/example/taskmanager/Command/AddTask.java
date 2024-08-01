package org.example.taskmanager.Command;

import org.example.taskmanager.Collection.Priority;
import org.example.taskmanager.Collection.Task;
import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CollectionManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class AddTask implements Command {
    @Override
    public String getCommandName() {
        return "addTask";
    }

    @Override
    public String getDescription() {
        return "Добавить задачу в список задач";
    }

    @Override
    public void execute(String[] tokens) {
        Task task = inputTask();
        ArrayList<Task> tasks = CollectionManager.getTaskList();
        tasks.add(task);
        CollectionManager.setTaskList(tasks);
    }

    private Task inputTask() {
        System.out.print("Введите текст задачи: ");
        Scanner scanner = new Scanner(System.in);
        String taskName = scanner.nextLine();
        System.out.println("Низкий, Средний, Высокий, Не задан");
        System.out.print("Выберите приоритет задачи из списка выше: ");
        String priority = scanner.nextLine().toLowerCase();
        Priority priorityEnum = Priority.NOTSTATED;
        switch (priority) {
            case "низкий": {
                priorityEnum = Priority.LOW;
            }
            case "средний": {
                priorityEnum = Priority.MEDIUM;
            }
            case "высокий": {
                priorityEnum = Priority.HIGH;
            }
            case "не задан": {
                priorityEnum = Priority.NOTSTATED;
            }
        }
        System.out.print("Введите дату дедлайна задачи (формат dd.mm.yyyy): ");
        String[] deadlineDate = scanner.nextLine().split("\\.");
        Integer day = Integer.valueOf(deadlineDate[0]);
        Integer month = Integer.valueOf(deadlineDate[1]);
        Integer year = Integer.valueOf(deadlineDate[2]);
        System.out.print("Введите время дедлайна задачи (формат hh:mm): ");
        String[] deadlineTime = scanner.nextLine().split(":");
        Integer hour = Integer.valueOf(deadlineTime[0]);
        Integer minute = Integer.valueOf(deadlineTime[1]);

        LocalDateTime deadline = LocalDateTime.of(year, month, day, hour, minute);

        System.out.print("Введите размер баллов за задачу: ");
        String prizeStr = scanner.nextLine();
        Integer prize = Integer.valueOf(prizeStr);

        Task task = new Task(CollectionManager.nextID(), taskName, priorityEnum, deadline, prize);
        return task;

    }
}
