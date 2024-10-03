package org.example.taskmanager.Exception;

/**
 * Класс ошибка, возникающая при попытке выполнить несуществующую команду
 */
public class NotFoundCommand extends NullPointerException {
    public String sendMessage(){
        return "Команда не найдена!";
    }
}
