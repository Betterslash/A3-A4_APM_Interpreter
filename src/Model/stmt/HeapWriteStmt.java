package Model.stmt;

import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IHeap;
import Model.exp.Expression;
import Model.types.RefType;
import Model.vals.RefValue;
import Model.vals.Value;

public class HeapWriteStmt implements IStmt{
    String varName;
    Expression exp;

    public HeapWriteStmt(String varName, Expression exp) {
        this.varName = varName;
        this.exp = exp;
    }

    @Override
    public ProgramState execute(ProgramState state) {
        IDict<String, Value> symTable = state.getSymTable();
        IHeap<Integer, Value> heapTable = state.getHeap();
        Value value = this.exp.evaluate(symTable, heapTable);
        Value value1 = symTable.lookup(varName);
        if(value1 != null){
            if(value1.getType() instanceof RefType){
                if(((RefValue)value1).getLocationType().equals(value.getType())){
                    int location = ((RefValue) value1).getAddress();
                    heapTable.update(location, value);
                }
            }
        }
        return state;
    }

    @Override
    public String toString() {
        return "wH("+ varName+", "+ exp+")";
    }
}
