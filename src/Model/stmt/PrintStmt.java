package Model.stmt;

import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IHeap;
import Model.adts.IList;
import Model.exp.Expression;
import Model.vals.Value;

public class PrintStmt implements IStmt{
    Expression value;

    public PrintStmt(Expression value) {
        this.value = value;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IList<Value> output = state.getOutput();
        IDict<String, Value> symTable = state.getSymTable();
        IHeap<Integer, Value> heapTable = state.getHeap();
        output.add(value.evaluate(symTable, heapTable));
        return state;
    }

    @Override
    public String toString() {
        return "print("+this.value+")";
    }
}
