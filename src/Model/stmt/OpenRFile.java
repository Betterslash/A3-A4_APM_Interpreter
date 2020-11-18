package Model.stmt;

import Model.CustomExceptions.MyException;
import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IFTable;
import Model.adts.IHeap;
import Model.exp.Expression;
import Model.types.StringType;
import Model.vals.StringValue;
import Model.vals.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class OpenRFile implements IStmt{
    Expression expression;

    public OpenRFile(Expression expression) {
        this.expression = expression;
    }

    @Override
    public ProgramState execute(ProgramState state) throws MyException, FileNotFoundException {
        IDict<String, Value> symTable = state.getSymTable();
        IHeap<Integer, Value> heapTable = state.getHeap();
        Value value = this.expression.evaluate(symTable, heapTable);
        IFTable<String, BufferedReader> fileTable = state.getFileTable();
        if(value.getType().equals(new StringType())){
            StringValue stringValue = (StringValue)value;
            if(fileTable.lookup(stringValue.getValue()) == null){
                BufferedReader bufferedReader = new BufferedReader(new FileReader(stringValue.getValue()));
                fileTable.add(stringValue.getValue(), bufferedReader);
            }
        }
        return state;
    }

    @Override
    public String toString() {
        return "OpenRFile("+this.expression+")";
    }
}
