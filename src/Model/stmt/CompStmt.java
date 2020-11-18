package Model.stmt;

import Model.ProgramState;
import Model.adts.IStack;
import Model.exp.Expression;

public class CompStmt implements IStmt{
    IStmt st1;
    IStmt st2;

    public CompStmt(IStmt st1, IStmt st2) {
        this.st1 = st1;
        this.st2 = st2;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IStack<IStmt> exeStack = state.getExeStack();
        exeStack.push(this.st2);
        exeStack.push(this.st1);
        return state;
    }

    @Override
    public String toString() {
        return st1 + "; " + st2;
    }
}
