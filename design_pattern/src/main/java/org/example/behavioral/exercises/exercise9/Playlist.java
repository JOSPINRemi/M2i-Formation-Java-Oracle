package org.example.behavioral.exercises.exercise9;

public class Playlist {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand(){
        if(command != null){
            command.execute();
        }else{
            System.out.println("Command is null");
        }
    }
}
