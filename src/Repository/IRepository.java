package Repository;

import Model.ProgramState;

import java.io.IOException;

public interface IRepository {
    void addPrg(ProgramState state);
    ProgramState getCurrentPrg();
    void logProgState() throws IOException;
}
