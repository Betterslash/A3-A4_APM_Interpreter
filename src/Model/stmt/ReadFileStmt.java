package Model.stmt;

import Model.ProgramState;
import Model.adts.IDict;
import Model.adts.IFTable;
import Model.adts.IHeap;
import Model.exp.Expression;
import Model.types.IntType;
import Model.types.StringType;
import Model.vals.IntValue;
import Model.vals.StringValue;
import Model.vals.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileStmt implements IStmt{
    Expression expression;
    String varName;

    public ReadFileStmt(Expression expression, String varName) {
        this.expression = expression;
        this.varName = varName;
    }

    @Override
    public ProgramState execute(ProgramState state) throws IOException {
        IDict<String, Value> symTable = state.getSymTable();
        IHeap<Integer, Value> heapTable = state.getHeap();
        IFTable<String, BufferedReader> fileTable = state.getFileTable();
        if(symTable.lookup(varName) != null){
            Value value = this.expression.evaluate(symTable, heapTable);
            if(value.getType().equals(new StringType())){
                StringValue stringValue = (StringValue) value;
                BufferedReader bufferedReader = fileTable.lookup(stringValue.getValue());
                String read = bufferedReader.readLine();
                while(read != null){
                    Value value1 = symTable.lookup(varName);
                    if(value1.getType().equals(new IntType())){
                        symTable.update(varName, new IntValue(Integer.parseInt(read)));
                        read = bufferedReader.readLine();
                    }
                }
            }
        }
        return state;
    }

    @Override
    public String toString() {
        return "ReadFileStmt(" + varName +", "+ expression +")";
    }
}
