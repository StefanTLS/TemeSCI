package ro.sci.carrental.repository;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 10.07.2017.
 * DAO
 */
public interface RepoInterface <T> {
    //CRUD++

    /**
     * Create?
     * Adds and object of type T to the repository
     * @param t some object
     */
    void add(T t);

    /**
     * Read
     *Reads(finds) certain objects from the repository
     * @return .
     */
    T findObj(T t);

    /**
     * Update
     * Update object
     * ?? - Use the set(index, element) method to replace the element at the specified index by the specified element?
     * @param t .
     */
    void update(T t);

    /**
     * Delete object t!
     * @param t .
     */
    void delete(T t);

    /**
     * Returns all the objects in the repository
     * @return List of objects
     */
    List<T> getAll();

}
