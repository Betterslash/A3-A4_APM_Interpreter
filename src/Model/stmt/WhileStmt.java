package Model.stmt;

import Model.CustomExceptions.MyException;
import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IHeap;
import Model.adts.IStack;
import Model.exp.Expression;
import Model.types.BoolType;
import Model.vals.BoolValue;
import Model.vals.Value;

public class WhileStmt implements IStmt{
    Expression expression;
    IStmt execution;

    public WhileStmt(Expression expression, IStmt execute) {
        this.expression = expression;
        this.execution = execute;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IDict<String, Value> symTable = state.getSymTable();
        IHeap<Integer, Value> heapTable = state.getHeap();
        IStack<IStmt> exeStack = state.getExeStack();
        Value value = this.expression.evaluate(symTable, heapTable);
        if(value.getType() instanceof BoolType){
            if(((BoolValue)value).getValue()) {
                exeStack.push(this);
                exeStack.push(this.execution);
            }
        }
        return state;
    }

    @Override
    public String toString() {
        return "(while(" + this.expression + ")" + this.execution + ")";
    }
}
