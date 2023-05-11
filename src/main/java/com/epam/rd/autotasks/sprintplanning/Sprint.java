package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;

public class Sprint {

    int capacity;
    int ticketsLimit;

    int totalEstimate = 0;

    Ticket[] tickets = new Ticket[100];

    int ticketCount = 0;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted()||
                totalEstimate + userStory.getEstimate()>capacity||ticketCount>=ticketsLimit) {
            return false;
        }
        for (UserStory dependency : userStory.getDependencies()) {
            if (!dependency.isCompleted()) {
                return false;
            }
        }
        tickets[ticketCount++] = userStory;
        totalEstimate += userStory.getEstimate();
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport==null||bugReport.isCompleted() ||
        totalEstimate+ bugReport.getEstimate()>capacity || ticketCount>=ticketsLimit){
            return false;
        }

            tickets[ticketCount++] = bugReport;
            totalEstimate += bugReport.getEstimate();
        return true;
    }

    public Ticket[] getTickets() {
        Ticket[] result = new Ticket[ticketCount];
        System.arraycopy(tickets,0,result,0,ticketCount);
        return  result;
    }

    public int getTotalEstimate() {
        return totalEstimate;
    }
}
