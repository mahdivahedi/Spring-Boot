package tacos.data;

import java.io.Serializable;
import java.util.List;

public interface IngredientRepository{

    <E> List<E> findAll(Class<E> entityClass);

    <E, K extends Serializable> E findOne(K id);

    <E> boolean save(E entity);

}
