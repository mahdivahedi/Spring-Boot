package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.dto.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
