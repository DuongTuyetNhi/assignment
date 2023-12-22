package customer.main;

import customer.configuration.JPAConfig;
import customer.entity.OrderDetailsEntity;
import customer.entity.OrderEntity;
import customer.repository.OrderDetailsRepository;
import customer.repository.OrderRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class MainOrder {
    static ApplicationContext context = new AnnotationConfigApplicationContext(JPAConfig.class);
    static OrderRepository orderRepository = (OrderRepository) context.getBean("oderRepository");
    static OrderDetailsRepository orderDetailsRepository = (OrderDetailsRepository) context.getBean("orderDetailsRepository");

    public static void main(String[] args) {
//        createNewOrderDetailsEntryWithNewOrder();
        createNewOrderDetailsEntry();
        findAll();
        findById(1);
        getOrderInCurrentMonth();
        getOrderMoreThan1000();
        getOrderBuyJavaBook();
    }
//    0: fill data
    private static OrderDetailsEntity createNewOrderDetail(){
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setId(1);
        orderDetailsEntity.setOrderId(1);
        orderDetailsEntity.setProductName("Java book");
        orderDetailsEntity.setQuantity(10);
        orderDetailsEntity.setUnitPrice(200);
        return  orderDetailsEntity;
    }
    private static OrderEntity createNewOrder(){
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setId(1);
        orderDetailsEntity.setOrderId(1);
        orderDetailsEntity.setProductName("Java book");
        orderDetailsEntity.setQuantity(10);
        orderDetailsEntity.setUnitPrice(200);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1);
        orderEntity.setOrderDate(LocalDate.parse("2022-25-05"));
        orderEntity.setCustomerName("Nguyen Hoa");
        orderEntity.setCustomerAddress("Ha Noi");
//        orderDetailsEntity.setOrder(orderEntity);
        return orderEntity;
    }
    public static void createNewOrderDetailsEntry(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1);

        OrderDetailsEntity orderDetailsEntity = createNewOrderDetail();

//        orderDetailsEntity.setOrder(orderEntity);
        orderDetailsRepository.save(orderDetailsEntity);
    }

//    public static void createNewOrderDetailsEntryWithNewOrder(){
//        OrderEntity orderEntity = createNewOrder();
//        orderRepository.save(orderEntity);
//
//        OrderDetailsEntity orderDetailsEntity = createNewOrderDetail();
//
//        orderDetailsEntity.setOrder(orderEntity);
//        orderDetailsRepository.save(orderDetailsEntity);
//    }
    //4
    public static void findAll(){
        List<OrderEntity> orderEntityList = orderRepository.findAll();
        if (orderEntityList != null){
            System.out.println("\nFind " + orderEntityList.size() + "order");
            for(OrderEntity orderEntity:orderEntityList){
                System.out.println(orderEntity.toString());
            }
        }
    }

    //5
    public static void findById(int id){
        OrderEntity orderEntity = orderRepository.findById(id);
        if(orderEntity != null){
            System.out.println("find by id");
            System.out.println(orderEntity.toString());
        }
    }
    //6
    public static void getOrderInCurrentMonth(){
        List<OrderEntity> orderEntityList = orderRepository.getOrderInCurrentMonth();
        if(orderEntityList != null){
            System.out.println("order in current month");
            for (OrderEntity order:orderEntityList){
                System.out.println(order.toString());
            }
        }
    }
    //7
    public static void getOrderMoreThan1000(){
        List<OrderEntity> orderEntityList = orderRepository.getOrderInCurrentMonth();
        if(orderEntityList != null){
            System.out.println("order have total > 1000");
            for (OrderEntity order:orderEntityList){
                System.out.println(order.toString());
            }
        }
    }
    //8
    public static void getOrderBuyJavaBook(){
        List<OrderEntity> orderEntityList = orderRepository.getOrderInCurrentMonth();
        if(orderEntityList != null){
            System.out.println("order buy Java book");
            for (OrderEntity order:orderEntityList){
                System.out.println(order.toString());
            }
        }
    }
}
