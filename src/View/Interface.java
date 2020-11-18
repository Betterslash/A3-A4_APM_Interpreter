package View;

import Controller.Controller;
import Model.CustomExceptions.MyException;
import Model.ProgramState;
import Model.exp.*;
import Model.stmt.*;
import Model.types.IntType;
import Model.types.RefType;
import Model.vals.IntValue;
import Repository.Repository;

import java.io.IOException;

public class Interface {
    public static void main(String[] args) throws MyException, IOException {
        IStmt ex2 = new CompStmt( new VarDeclStmt(new IntType(), "a"),
                new CompStmt(new VarDeclStmt(new IntType(), "b"),
                        new CompStmt(new AssignStmt("a", new ArithmExp('+',new ValueExp(new IntValue(2)),
                                new ArithmExp('*',new ValueExp(new IntValue(3)),
                                        new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b",new ArithmExp('+',new VarExp("a"),
                                        new ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        VarDeclStmt v = new VarDeclStmt(new RefType(new IntType()), "v");
        HeapAllocStmt heapAllocStmt = new HeapAllocStmt("v", new ValueExp(new IntValue(20)));
        VarDeclStmt rdc = new VarDeclStmt(new RefType(new RefType(new IntType())),"a");
        HeapAllocStmt rfc = new HeapAllocStmt("a",new VarExp("v"));
        HeapAllocStmt rfc1 = new HeapAllocStmt("v",new ValueExp(new IntValue(30)));
        CompStmt cms = new CompStmt(new PrintStmt(new ReadHeapExp(new VarExp("v"))), new PrintStmt(new ReadHeapExp(new ReadHeapExp(new VarExp("a")))));
        IStmt ex3 = new CompStmt(v ,new CompStmt(heapAllocStmt, new CompStmt(rdc, new CompStmt(rfc, new CompStmt(rfc1, cms)))));
        IStmt ex4 = new CompStmt(new VarDeclStmt(new RefType(new IntType()),"v"),
                new CompStmt(new HeapAllocStmt("v", new ValueExp(new IntValue(20))),
                        new CompStmt(new PrintStmt(new ReadHeapExp(new VarExp("v"))),
                                new CompStmt(new HeapWriteStmt("v", new ValueExp(new IntValue(30))),
                                        new PrintStmt(new ArithmExp('+',new ValueExp(new IntValue(5)),new ReadHeapExp(new VarExp("v"))))))));
        IStmt ex5 = new CompStmt(new VarDeclStmt(new IntType(), "v") ,
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(4))),
                        new WhileStmt(new LogicExp(">", new VarExp("v"), new ValueExp(new IntValue(0))),
                                new CompStmt(
                                        new PrintStmt(new VarExp("v")),
                                        new AssignStmt("v", new ArithmExp('-',
                                                new VarExp("v"),
                                new ValueExp(new IntValue(1))))
                                        ))));
        ProgramState state = new ProgramState();
        Repository repository = new Repository("File.in");
        Controller controller = new Controller(repository);
        state.getExeStack().push(ex3);
        repository.addPrg(state);

        ProgramState state1 = new ProgramState();
        Repository repository1 = new Repository("File.in");
        Controller controller1 = new Controller(repository1);
        state1.getExeStack().push(ex4);
        repository1.addPrg(state1);

        ProgramState state2 = new ProgramState();
        Repository repository2 = new Repository("File.in");
        Controller controller2 = new Controller(repository2);
        state2.getExeStack().push(ex5);
        repository2.addPrg(state2);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunCommand("1",ex3.toString(),controller));
        menu.addCommand(new RunCommand("2",ex4.toString(),controller1));
        menu.addCommand(new RunCommand("3",ex5.toString(),controller2));
        menu.show();
    }
}
