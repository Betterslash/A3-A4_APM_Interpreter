package Model.adts;

public interface IFTable<T, T1> {
    void add(T key, T1 elem);
    T1 lookup(T key);
    T1 delete(T key);
    void update(T key, T1 elem);
}
