package hu.nye.progkor.studentmanager.data.repository;

import java.util.List;
/**
 * Interface for Crud operations
 */
public interface Repository<T, ID>{
    T save(T item);

    T getById(ID id);

    List<T> getAll();

    T update(T item);

    void deleteById(ID id);

}
