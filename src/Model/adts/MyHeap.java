package Model.adts;

import Model.vals.Value;

import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;

public class MyHeap<Integer, T1> implements IHeap<Integer, T1>{
    HashMap<Integer, T1> representation;
    int freeLocation;
    public MyHeap(){
        this.freeLocation = 1;
        this.representation = new HashMap<Integer, T1>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('\n');
        for(Integer i : this.representation.keySet()){
            sb.append(i).append("->").append(this.representation.get(i)).append('\n');
        }
        return sb.toString();
    }

    private void incFreeLoc(){
        this.freeLocation += 1;
    }

    @Override
    public void add(Integer key, T1 elem) {
        this.representation.put(key, elem);
        this.incFreeLoc();
    }

    public void autoAdd(T1 elem){
        Integer c = (Integer) java.lang.Integer.valueOf(this.freeLocation);
        this.representation.put(c, elem);
        this.incFreeLoc();
    }

    @Override
    public Integer getAddress() {
        return (Integer) java.lang.Integer.valueOf(this.freeLocation);
    }

    @Override
    public void setContent(Map<Integer, T1> heap) {
        this.representation = (HashMap<Integer, T1>) heap;
    }

    @Override
    public T1 lookup(Integer key) {
        return this.representation.get(key);
    }

    public HashMap<Integer, T1> getContent() {
        return representation;
    }

    @Override
    public void update(Integer key, T1 elem) {
        this.representation.put(key, elem);
    }
}