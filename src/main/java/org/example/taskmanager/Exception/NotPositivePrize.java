package org.example.taskmanager.Exception;

public class NotPositivePrize extends Exception{
    public String sendMessage() {
        return "Задача не может быть с отрицательной наградой";
    }
}
