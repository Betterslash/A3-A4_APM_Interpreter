package Model.exp;

import Model.adts.IDict;
import Model.adts.IHeap;
import Model.vals.BoolValue;
import Model.vals.Value;

public class LogicalExp extends Expression{
    final Expression left;
    final Expression right;
    final char op;
    public LogicalExp(Expression left, Expression right, char op) {
        this.left = left;
        this.right = right;
        this.op = op;
    }

    @Override
    public Value evaluate(IDict<String, Value> symTable, IHeap<Integer, Value> heapTable) {
        BoolValue valueLeft = (BoolValue) this.left.evaluate(symTable, heapTable);
        BoolValue valueRight = (BoolValue) this.right.evaluate(symTable, heapTable);
        return switch (op) {
            case '&' -> new BoolValue(valueLeft.getValue() & valueRight.getValue());
            case '|' -> new BoolValue(valueLeft.getValue() || valueRight.getValue());
            default -> null;
        };
    }
}
