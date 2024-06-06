package FinalExam.cip.demo.Controller;

import FinalExam.cip.demo.dao.Customer;
import FinalExam.cip.demo.dao.CustomerRepo;
import FinalExam.cip.demo.dao.Order;
import FinalExam.cip.demo.dao.OrderRepo;
import FinalExam.cip.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    CustomerService customerService;
    @GetMapping
    List<Customer> findAll (){
        return customerService.getAllCustomers();
    }
    @GetMapping("/{Id}")
    Customer findById (@PathVariable("Id")Long Id){
        return customerService.getById(Id);
    }
    @PostMapping
    Customer create(@RequestBody Customer customer){
        return customerService.create(customer);
    }
    @PutMapping("/{Id}")
    Customer update (@PathVariable Long Id,@RequestBody Customer customer){
        return customerService.update(Id,customer);

    }
    @DeleteMapping("/{Id}")
    void delete (@PathVariable("Id")Long Id){
        customerService.delete(Id);
    }
    @PostMapping("/{customerId}/order/{orderId}")
    public ResponseEntity<Order> addOrderToCustomer(@PathVariable Long customerId, @PathVariable Long orderId) {
        try {
            Order addedorder=customerService.addOrderToCustomer(customerId,orderId);
            return ResponseEntity.ok(addedorder);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
