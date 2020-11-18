package Model;

import Model.adts.*;
import Model.stmt.IStmt;
import Model.vals.Value;
import java.io.BufferedReader;

public class ProgramState {
    IDict<String, Value> symTable;
    IList<Value> output;
    IStack<IStmt> exeStack;
    IHeap<Integer, Value> heapTable;
    IFTable<String, BufferedReader> fileTable = new MyFTable<>();
    public ProgramState(IDict<String, Value> symTable, IList<Value> output, IStack<IStmt> exeStack, IHeap<Integer, Value> heapTable, IFTable<String, BufferedReader> fileTable) {
        this.symTable = symTable;
        this.output = output;
        this.exeStack = exeStack;
        this.heapTable = heapTable;
        this.fileTable = fileTable;
    }
    public ProgramState(){
        this.heapTable = new MyHeap<>();
        this.exeStack = new MyStack<>();
        this.output = new MyList<>();
        this.symTable = new MyDict<>();
    }

    public IFTable<String, BufferedReader> getFileTable() {
        return fileTable;
    }

    public IDict<String, Value> getSymTable() {
        return symTable;
    }

    public IList<Value> getOutput() {
        return output;
    }

    public IStack<IStmt> getExeStack() {
        return exeStack;
    }

    @Override
    public String toString() {
        return "--------------"+"\nsymTable ->" + symTable +
                "\noutput -> " + output +
                "\nexeStack->" + exeStack+
                "\nHeap table->" + heapTable;
    }
    public IHeap<Integer, Value> getHeap() {
        return this.heapTable;
    }
    public void addStatement(IStmt stmt){this.exeStack.push(stmt);}
}
