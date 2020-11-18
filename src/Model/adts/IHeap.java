package Model.adts;

import java.util.Map;

public interface IHeap<T, T1> {
    void add(T key, T1 elem);
    T1 lookup(T key);
    void update(T key, T1 elem);
    void autoAdd(T1 elem);
    T getAddress();
    void setContent(Map<T, T1> heap);
    Map<T, T1> getContent();
}
