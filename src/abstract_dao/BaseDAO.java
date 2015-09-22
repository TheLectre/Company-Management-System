package abstract_dao;

import java.util.List;

public interface BaseDAO<T> {

    public void addItem(T item);

    public void updateItem(T item) throws IllegalArgumentException;
    
    public void removeItem(int pKey);

    public T getItemByID(int id);

    public List<T> getAll();
}
