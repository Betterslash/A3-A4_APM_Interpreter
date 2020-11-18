package Model.exp;

import Model.adts.IDict;
import Model.adts.IHeap;
import Model.vals.Value;

public class VarExp extends Expression{
    final String id;

    public VarExp(String id) {
        this.id = id;
    }

    @Override
    public Value evaluate(IDict<String, Value> symTable, IHeap<Integer, Value> heapTable) {
        return symTable.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
