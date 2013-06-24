package dao;

import java.util.List;

public interface CrudDao<T> {
    public void delete(T objeto);
    public void save(T objeto);
    public List<T> findAll();
    public T findById(Long id);
}
