package tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import tacos.dto.Order;
import tacos.dto.User;

import java.util.List;

@Transactional
public interface OrderRepository extends CrudRepository<Order, Long> {

    // tag::findByUser_paged[]
    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
    // end::findByUser_paged[]

  /*
  // tag::findByUser[]
  List<Order> findByUserOrderByPlacedAtDesc(User user);
  // end::findByUser[]
   */

}
