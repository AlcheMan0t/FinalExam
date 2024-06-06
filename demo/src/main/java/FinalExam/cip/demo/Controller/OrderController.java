package FinalExam.cip.demo.Controller;

import FinalExam.cip.demo.dao.Order;
import FinalExam.cip.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping
    List<Order> findAll(){
        return orderService.getAllOrders();
    }
    @GetMapping("/{Id}")
    Order findById (@PathVariable("Id")Long Id){
        return orderService.getOrderById(Id);
    }
    @PostMapping
    Order create (@RequestBody Order order){
        return orderService.create(order);
    }
    @PutMapping("/{Id}")
    Order update (@PathVariable Long Id,@RequestBody Order order){
        return orderService.update(Id,order);
    }
    @DeleteMapping("/{Id}")
    void delete (@PathVariable("Id")Long Id){
        orderService.delete(Id);
    }
}
