package com.epam.rd.autotasks.sprintplanning.tickets;


import java.util.Arrays;

public class UserStory extends Ticket {

    UserStory[] dependsOn;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependsOn = dependsOn;

    }


    @Override
    public void complete() {
        boolean allDependenciesCompleted = true;
        for (UserStory dependency: this.dependsOn
             ) {
            if(!dependency.isCompleted()){ allDependenciesCompleted = false;
            break;
            }
        }
        if (allDependenciesCompleted){
            completed = true;
        }
    }


    public UserStory[] getDependencies() {
        return Arrays.copyOf(this.dependsOn,this.dependsOn.length);
    }

    @Override
    public String toString() {
        return "[US "+ id+"] " + name;
    }
}
