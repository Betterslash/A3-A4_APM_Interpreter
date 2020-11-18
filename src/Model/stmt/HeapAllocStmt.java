package Model.stmt;

import Model.CustomExceptions.MyException;
import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IHeap;
import Model.exp.Expression;
import Model.types.RefType;
import Model.vals.RefValue;
import Model.vals.Value;

public class HeapAllocStmt implements IStmt{
    final String varName;
    final Expression exp;

    public HeapAllocStmt(String varName, Expression exp) {
        this.varName = varName;
        this.exp = exp;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException {
        IHeap<Integer, Value> heapTable = state.getHeap();
        IDict<String, Value> symTable = state.getSymTable();
        Value value = this.exp.evaluate(symTable, heapTable);
        Value vl = symTable.lookup(varName);
        if(vl.getType() instanceof RefType){
            if(symTable.lookup(varName) != null){
                Value val = this.exp.evaluate(symTable, heapTable);
                if(((RefType) vl.getType()).getInner().equals(val.getType())){
                    heapTable.autoAdd(value);
                    symTable.update(varName, new RefValue(((RefType) vl.getType()).getInner(), heapTable.getAddress() - 1));
                }
                else{
                    throw new MyException("Inner types don't match!");
                }
            }
            else{
                throw new MyException("There's no such variable stored!");
            }
        }
        else{
            throw new MyException("The variable is not a reference type!");
        }
        return null;
    }

    @Override
    public String toString() {
        return "new(" + varName + ", "+ exp+")";
    }
}
