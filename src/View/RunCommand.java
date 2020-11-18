package View;
import Controller.Controller;
import Model.CustomExceptions.MyException;

import java.io.IOException;

public class RunCommand extends Command{
    Controller controller;
    RunCommand(String key, String desc, Controller controller) {
        super(key, desc);
        this.controller = controller;
    }

    @Override
    void execute() throws IOException, MyException {
        this.controller.allStep();
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getDescription() {
        return this.desc;
    }
}
