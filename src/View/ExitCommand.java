package View;

public class ExitCommand extends Command{
    public ExitCommand(String key,String desc){
        super(key, desc);
    }

    @Override
    public void execute() {
        System.exit(0);
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
