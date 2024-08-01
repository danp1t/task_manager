package org.example.taskmanager;
//1. Хранение списка задач в файле/базе данных
//2. Отдебажить ввод задач. Добавить обработку ошибок
//3. Создать объект для пользователя (id, name, balance)
//5. Сделать удаление задач по ID
//6. Сделать выполнение задач с начислением баллов
//7. Сделать так, чтобы выполненные задачи уходили в базу "Done"



import org.example.taskmanager.Exception.NotFoundCommand;
import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CommandManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Task Manager");
        System.out.println("Введите команду help, чтобы увидеть весь список команд");

        while (true) {
            //Блок для ввода команды
            System.out.print("Введите команду: ");
            Scanner scanner = new Scanner(System.in);
            String[] commandToken = scanner.nextLine().split(" ");
            CommandManager commandManager = new CommandManager();
            Command command = commandManager.getCommand(commandToken[0]);
            System.out.println();
            //Блок для обработки ошибки, если команда не будет найдена в списке
            try {
                if (command == null) throw new NotFoundCommand();
                command.execute(commandToken);
            }
            catch (NotFoundCommand e) {
                System.out.println(e.sendMessage());
            }
            System.out.println();
        }

    }
}
