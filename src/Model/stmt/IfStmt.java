package Model.stmt;

import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IHeap;
import Model.adts.IStack;
import Model.exp.Expression;
import Model.types.BoolType;
import Model.vals.BoolValue;
import Model.vals.Value;

public class IfStmt implements IStmt{
    Expression cond;
    IStmt thenStmt;
    IStmt elseStmt;

    public IfStmt(Expression cond, IStmt thenStmt, IStmt elseStmt) {
        this.cond = cond;
        this.thenStmt = thenStmt;
        this.elseStmt = elseStmt;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IDict<String, Value> symTable = state.getSymTable();
        IStack<IStmt> exeStack = state.getExeStack();
        IHeap<Integer, Value> heapTable = state.getHeap();
        Value val = cond.evaluate(symTable, heapTable);
        if(val.getType().equals(new BoolType())){
            BoolValue tval = (BoolValue) val;
            if(tval.getValue()){
                exeStack.push(thenStmt);
            }
            else {
                exeStack.push(elseStmt);
            }
        }
        return state;
    }

    @Override
    public String toString() {
        return "if( " +this.cond +" ) then " + thenStmt + " else " + elseStmt;
    }
}
