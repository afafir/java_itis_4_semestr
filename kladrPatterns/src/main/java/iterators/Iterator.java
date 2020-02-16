package iterators;

public interface Iterator<T>  {
    boolean hasNext();
    T next();
    T getCurrent();
    void reset();
}
