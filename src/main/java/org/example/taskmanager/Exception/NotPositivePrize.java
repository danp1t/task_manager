package org.example.taskmanager.Exception;

/**
 * Класс ошибки, возникающая при попытке выбрать не положительный приз
 */
public class NotPositivePrize extends Exception{
    public String sendMessage() {
        return "Задача не может быть с отрицательной наградой";
    }
}
