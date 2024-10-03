package org.example.taskmanager.Collection;

/**
 * Класс для хранения информации о награде
 * Награда подразумевает под собой некое поощерение за выполнение задания
 */
public class Award {
    public String name;
    public int cost;

    public Award(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    //Getter
    public String getName() {
        return name;
    }
    public int getCost() {
        return cost;
    }

    //Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
}
