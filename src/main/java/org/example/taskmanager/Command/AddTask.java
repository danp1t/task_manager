package org.example.taskmanager.Command;

import org.example.taskmanager.Collection.Priority;
import org.example.taskmanager.Collection.Task;
import org.example.taskmanager.Exception.NotPositivePrize;
import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CollectionManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Данный класс описывает команду добавления нового задания.
 */
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
        if (task != null) {
            ArrayList<Task> tasks = CollectionManager.getTaskList();
            tasks.add(task);
            CollectionManager.setTaskList(tasks);
        }

    }

    /**
     * Данный метод ввода задачи и её параметров.
     * @return экземпляр задачи
     */
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
        Integer day, month, year, hour, minute;
        System.out.print("Введите дату дедлайна задачи (формат dd.mm.yyyy): ");
        String[] deadlineDate = scanner.nextLine().split("\\.");
        LocalDateTime now = LocalDateTime.now();
        if (deadlineDate.length != 3) {
            day = now.getDayOfMonth() + 1;
            month = now.getMonthValue();
            year = now.getYear();
        }
        else {
            day = Integer.valueOf(deadlineDate[0]);
            month = Integer.valueOf(deadlineDate[1]);
            year = Integer.valueOf(deadlineDate[2]);
        }
        System.out.print("Введите время дедлайна задачи (формат hh:mm): ");
        String[] deadlineTime = scanner.nextLine().split(":");
        if (deadlineTime.length != 2) {
            hour = now.getHour();
            minute = now.getMinute();
        }
        else {
            hour = Integer.valueOf(deadlineTime[0]);
            minute = Integer.valueOf(deadlineTime[1]);
        }


        LocalDateTime deadline = LocalDateTime.of(year, month, day, hour, minute);

        System.out.print("Введите размер баллов за задачу: ");
        String prizeStr = scanner.nextLine();
        Integer prize = 1;
        Task task = null;
        try {
            if (prizeStr.length() != 0) {
                prize = Integer.valueOf(prizeStr);
                if (prize < 0) {
                    throw new NotPositivePrize();
                }
            }
            task = new Task(CollectionManager.nextID(), taskName, priorityEnum, deadline, prize);
        } catch (NotPositivePrize e) {
            System.out.println(e.sendMessage());
        }

        return task;

    }
}
