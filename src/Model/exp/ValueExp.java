package Model.exp;

import Model.adts.IDict;
import Model.adts.IHeap;
import Model.vals.Value;

public class ValueExp extends Expression{
    Value value;

    public ValueExp(Value value) {
        this.value = value;
    }

    @Override
    public Value evaluate(IDict<String, Value> symTable, IHeap<Integer, Value> heapTable) {
        return this.value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
