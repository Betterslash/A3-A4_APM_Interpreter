package Model.adts;

import Model.stmt.IStmt;

import java.util.Stack;

public class MyStack<T> implements IStack<T>{
    Stack<T> representation;

    public MyStack(){
        this.representation = new Stack<T>();
    }

    @Override
    public void push(T elem) {
        this.representation.push(elem);
    }

    @Override
    public T pop() {
        return this.representation.pop();
    }

    @Override
    public boolean isEmpty() {
        return this.representation.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        for(T s : this.representation){
            sb.append(s).append('\n');
        }
        return sb.toString();
    }
}
