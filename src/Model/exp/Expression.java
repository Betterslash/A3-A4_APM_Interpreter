package Model.exp;

import Model.adts.IDict;
import Model.adts.IHeap;
import Model.vals.Value;

public abstract class Expression {
    public abstract Value evaluate(IDict<String, Value> symTable, IHeap<Integer, Value> heapTable);
}
