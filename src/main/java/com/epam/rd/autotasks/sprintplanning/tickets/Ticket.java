package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {

    int id;
    String name;
    int estimate;
    boolean completed;


    public Ticket(int id, String name, int estimate) {
        this.id = id;
        this.name = name;
        this.estimate = estimate;
        completed = false;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        if(this.completed) return true;
        else return false;
    }

    public void complete() {
        this.completed = true;
    }

    public int getEstimate() {
        return estimate;
    }
}
