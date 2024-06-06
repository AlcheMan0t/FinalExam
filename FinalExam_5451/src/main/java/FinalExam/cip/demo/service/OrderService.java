package FinalExam.cip.demo.service;

import FinalExam.cip.demo.dao.Order;
import FinalExam.cip.demo.dao.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public Order create (Order order){
        return orderRepo.save(order);
    }
    public Order update (Long Id,Order order){
        Optional<Order>optionalOrder=orderRepo.findById(Id);
        if (optionalOrder.isPresent()){
            Order order1=optionalOrder.get();
            order1.setOrderNumber(order.getOrderNumber());
            order1.setDate(order.getDate());
            return orderRepo.save(order1);
        }
        else {
            return null;
        }
    }
    public void delete (Long Id){
        orderRepo.deleteById(Id);
    }
    public List<Order> getAllOrders (){
        return orderRepo.findAll();
    }
    public Order getOrderById(Long Id){
        Optional<Order>optionalOrder=orderRepo.findById(Id);
    return optionalOrder.orElse(null);
    }
}
