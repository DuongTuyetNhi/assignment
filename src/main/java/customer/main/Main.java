package customer.main;

import customer.configuration.JPAConfig;
import customer.entity.CustomerEntity;
import customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static CustomerRepository customerRepository = (CustomerRepository) context.getBean("customerRepository");

    public static void main(String[] args) {
        insertCustomer();
        findAll();
        findById(1);
        findByName("abc");
        findByPhoneOrEmail("0123456789", "aa");
    }

    //tao ham insertCustomer()
    public static void insertCustomer(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1);
        customerEntity.setName("abc");
        customerEntity.setBirthdate(LocalDate.parse("1995-02-02", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        customerEntity.setSex("Male");
        customerEntity.setEmail("abc@gmail.com");
        customerEntity.setPhone("0123456789");
        customerEntity.setAddress("abc Da Nang");

        CustomerEntity result = customerRepository.save(customerEntity);
        if(result != null){
            System.out.println("da them, customerId = " + customerEntity.getId());
        }

    }

    private static void findAll(){
        List<CustomerEntity> customerEntityList = customerRepository.findAll();
        if(customerEntityList != null){
            System.out.println("danh sach hien co: ");
            for (CustomerEntity customerEntity : customerEntityList){
                System.out.println(customerEntity.toString());
            }
        }
    }
    private static void findById(int id){
        CustomerEntity customerEntity = customerRepository.findById(id);
        if(customerEntity != null){
            System.out.println("find by id: ");
            System.out.println("id = " + customerEntity.getId() + customerEntity.toString());
        }
    }

    private static void findByName(String name){
        List<CustomerEntity> customerEntityList = customerRepository.findByName(name);
        if(customerEntityList != null){
            System.out.println("find by name");
            for (CustomerEntity customerEntity : customerEntityList){
                System.out.println(customerEntity.toString());
            }
        }
    }

    private static void findByPhoneOrEmail(String phone, String email){
        CustomerEntity customerEntity = customerRepository.findByPhoneOrEmail(phone, email);
        if(customerEntity != null){
            System.out.println("find by phone or email");
            System.out.println(customerEntity.toString());
        }
    }

//    private static void findBySexAndBirthdateBetween(String sex, LocalDate startDate, LocalDate endDate){
//        endDate = LocalDate.now();
//        List<CustomerEntity> customerEntityList = customerRepository.findBySexAndBirthdateBetween(sex, startDate, endDate);
//        if(customerEntityList != null){
//            System.out.println("find by sex and old");
//            for (CustomerEntity customerEntity : customerEntityList){
//                System.out.println(customerEntity.toString());
//            }
//        }
//    }
}
