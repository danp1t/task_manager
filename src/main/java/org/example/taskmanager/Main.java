package org.example.taskmanager;

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
