package Model.exp;

import Model.adts.IDict;
import Model.adts.IHeap;
import Model.types.RefType;
import Model.vals.RefValue;
import Model.vals.Value;

public class ReadHeapExp extends Expression {
    final Expression expression;

    public ReadHeapExp(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Value evaluate(IDict<String, Value> symTable, IHeap<Integer, Value> heapTable) {

        if(this.expression.evaluate(symTable,heapTable).getType() instanceof RefType)
        {
            RefValue refValue = (RefValue) this.expression.evaluate(symTable, heapTable);
            int address = refValue.getAddress();
            return heapTable.lookup(address);
        }
        return null;
    }

    @Override
    public String toString() {
        return "rH(" + expression + ")";
    }
}
