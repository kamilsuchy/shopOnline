package loginAndRegister;

public class Invoker {

    Command command;

    public Invoker() {
        command = null;
    }

    public void takeCommand(Command command){
        this.command = command;
        command.execute();
    }
}