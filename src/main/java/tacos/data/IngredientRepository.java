package tacos.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import tacos.dto.Ingredient;

import java.io.Serializable;
import java.util.List;

@Transactional
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Ingredient findIngredientById(String id);

}
