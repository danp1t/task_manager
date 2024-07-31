package org.example.taskmanager.Exception;

public class NotFoundCommand extends NullPointerException {
    public String sendMessage(){
        return "Команда не найдена!";
    }
}
