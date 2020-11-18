package View;

import Model.CustomExceptions.MyException;

import java.io.IOException;

public abstract class Command{
    String key, desc;
    Command(String key, String desc){
        this.key = key;
        this.desc = desc;
    }
    abstract void execute() throws IOException, MyException;

    public abstract String getKey();

    public abstract String getDescription();
}
