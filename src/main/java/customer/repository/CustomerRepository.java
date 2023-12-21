package customer.repository;

import customer.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
    //1.add tao ham trong main Insertcustomer()
//    CustomerEntity save();
    //2. list tat ca dsach = finAll
    List<CustomerEntity> findAll();
    //3. find by id
    CustomerEntity findById(int id);
    //4. find by name
    List<CustomerEntity> findByName(String name);
    //5. find by phone or email
    CustomerEntity findByPhoneOrEmail(String phone, String email);
    //6. list dsach customer la nam, tuoi tu 20-30
    List<CustomerEntity> findBySexAndBirthdateBetween(String sex, LocalDate startDate, LocalDate endDate);

}
