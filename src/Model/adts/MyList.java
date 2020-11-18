package Model.adts;

import Model.vals.Value;

import java.util.ArrayList;

public class MyList<T> implements IList<T>{
    ArrayList<T> representation;

    public MyList(){
        this.representation = new ArrayList<>();
    }

    @Override
    public void add(T elem) {
        this.representation.add(elem);
    }

    @Override
    public T delete() {
        return this.representation.remove(this.representation.size() - 1);
    }

    @Override
    public T getOut() {
        return this.representation.get(this.representation.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        for(T v : this.representation){
            sb.append(v).append('\n');
        }
        return sb.toString();
    }
}
