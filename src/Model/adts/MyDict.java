package Model.adts;

import java.util.HashMap;
import java.util.Map;

public class MyDict<T, T1> implements IDict<T, T1>{
    HashMap<T, T1> representation;

    public MyDict(){
        this.representation = new HashMap<T, T1>();
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
    public void update(T key, T1 elem) {
        this.representation.put(key, elem);
    }

    @Override
    public Map<T, T1> getContent() {
        return this.representation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        for(T key: this.representation.keySet()){
            sb.append(key).append("-->").append(this.representation.get(key)).append('\n');
        }
        return sb.toString();
    }
}
