package hu.nye.progkor.studentmanager.data.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Crud operations.
 */
public interface Repository<T, ID> {
    T save(T item);

    Optional<T> getById(ID id);

    List<T> getAll();

    T update(T item);

    void deleteById(ID id);

}
