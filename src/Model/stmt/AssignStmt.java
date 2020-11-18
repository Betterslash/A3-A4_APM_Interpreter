package Model.stmt;

import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IHeap;
import Model.exp.Expression;
import Model.vals.Value;

public class AssignStmt implements IStmt{
    final String id;
    final Expression value;

    public AssignStmt(String id, Expression value) {
        this.id = id;
        this.value = value;
    }


    @Override
    public ProgramState execute(ProgramState state) {
        IDict<String, Value> symTable = state.getSymTable();
        IHeap<Integer, Value> heapTable = state.getHeap();
        if(this.value.evaluate(symTable, heapTable).getType().equals(symTable.lookup(this.id).getType())){
            symTable.update(id, value.evaluate(symTable, heapTable));
        }
        return state;
    }

    @Override
    public String toString() {
        return this.id +"="+this.value;
    }
}
