package Model.adts;

import java.util.Map;

public interface IDict<T, T1> {
    void add(T key, T1 elem);
    T1 lookup(T key);
    void update(T key, T1 elem);

    Map<T, T1> getContent();
}
