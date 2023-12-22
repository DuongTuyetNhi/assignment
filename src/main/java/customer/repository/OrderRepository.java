package customer.repository;

import customer.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Integer> {
    List<OrderEntity> findAll();
    OrderEntity findById(int id);

    @Query("select o from OrderEntity o " +
            "where year(o.orderDate) = year(current_date)" +
            "and month(o.orderDate) = month(current_date)")
    List<OrderEntity> getOrderInCurrentMonth();
    @Query("select od from OrderDetailEntity od" +
            "where (od.quantity)*(od.unitPrice) > 1000")
    List<OrderEntity> getOrderMoreThan1000();
    @Query("select od from OrderDetailEntity od" +
            "where od.productName like ?Java book")
    List<OrderEntity> getOrderBuyJavaBook();

}
