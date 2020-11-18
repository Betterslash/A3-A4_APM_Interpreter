package Model.stmt;

import Model.CustomExceptions.MyException;
import Model.ProgramState;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IStmt {
    ProgramState execute(ProgramState state) throws MyException, IOException;
}
