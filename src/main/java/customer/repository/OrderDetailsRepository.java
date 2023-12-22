package customer.repository;

import customer.entity.OrderDetailsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderDetailsRepository, Integer> {
    List<OrderDetailsEntity> findByOrderId(int orderId);

}
