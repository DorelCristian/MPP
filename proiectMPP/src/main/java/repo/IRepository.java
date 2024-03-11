package repo;

import domain.Entity;

import java.util.Optional;

/**
 * CRUD operations repository interface
 * @param <ID> - type E must have an attribute of type ID
 * @param <E> -  type of entities saved in repository
 */
public interface IRepository<ID,E extends Entity<ID>> {


    /**
     *
     * @param id -the id of the entity to be returned
     *           id must not be null
     * @return the entity with the specified id
     *          or null - if there is no entity with the given id

     */
    Optional<E> findOne(ID id);


 //   Optional<E>findUser(String firstName);

    Iterable<E> findAll();

    /**
     *
     * @param entity
     *         entity must be not null
     * @return null- if the given entity is saved
     *         otherwise returns the entity (id already exists)

     */
    Optional<E> save(E entity);


    /**
     *  removes the entity with the specified id
     * @param id
     *      id must be not null
     * @return the removed entity or null if there is no entity with the given id

     */
    Optional<E> delete(Long id);

    /**
     *
     * @param id
     *          entity must not be null
     * @return null - if the entity is updated,
     *                otherwise  returns the entity  - (e g id does not exist).
     */
    Optional<E> update(Long id);
}