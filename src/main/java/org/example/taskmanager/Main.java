package org.example.taskmanager;

import org.example.taskmanager.Interface.Command;
import org.example.taskmanager.Manager.CommandManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] commandToken = scanner.nextLine().split(" ");
        CommandManager commandManager = new CommandManager();
        Command command = commandManager.getCommand(commandToken[0]);
        command.execute(commandToken);

    }
}
