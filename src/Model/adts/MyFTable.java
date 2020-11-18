package Model.adts;

import java.util.HashMap;

public class MyFTable<T, T1> implements IFTable<T, T1>{
    HashMap<T, T1> representation;

    public MyFTable(){
        this.representation = new HashMap<>();
    }

    @Override
    public void add(T key, T1 elem) {
        this.representation.put(key, elem);
    }

    @Override
    public T1 lookup(T key) {
        return this.representation.get(key);
    }

    @Override
    public T1 delete(T key) {
        return this.representation.remove(key);
    }

    @Override
    public void update(T key, T1 elem) {
        this.representation.put(key, elem);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T key : this.representation.keySet()){
            sb.append(key).append("-->").append(this.representation.get(key));
        }
        sb.append('\n');
        return sb.toString();
    }
}
