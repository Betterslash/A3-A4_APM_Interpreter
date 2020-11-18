package Model.adts;

public interface IList<T> {
    void add(T elem);
    T delete();
    T getOut();
}
