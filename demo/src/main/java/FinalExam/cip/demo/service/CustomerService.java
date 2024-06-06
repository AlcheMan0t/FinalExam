package FinalExam.cip.demo.service;

import FinalExam.cip.demo.dao.Customer;
import FinalExam.cip.demo.dao.CustomerRepo;
import FinalExam.cip.demo.dao.Order;
import FinalExam.cip.demo.dao.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderRepo orderRepo;
    public Customer create (Customer customer){
        return customerRepo.save(customer);
    }
    public Customer update (Long Id,Customer customer){
        Optional<Customer>optionalCustomer=customerRepo.findById(Id);
        if (optionalCustomer.isPresent()){
            Customer customer1= optionalCustomer.get();
            customer1.setFisrtName(customer.getFisrtName());
            customer1.setLastName(customer.getLastName());
            customer1.setEmail(customer.getEmail());
            return customerRepo.save(customer1);
        }else {
            return null;
        }
    }
    public void delete (Long Id){
        customerRepo.deleteById(Id);
    }
    public Customer getById (Long Id){
        Optional<Customer> optionalCustomer=customerRepo.findById(Id);
        return optionalCustomer.orElse(null);
    }
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }
    public Order addOrderToCustomer(Long customerId, Long orderId) {
        Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
        Optional<Order> optionalOrder = orderRepo.findById(orderId);
        if (optionalCustomer.isPresent() && optionalOrder.isPresent()) {
            Customer customer = optionalCustomer.get();
            Order order = optionalOrder.get();
            order.setCustomer(customer);
            return orderRepo.save(order);
        } else {
            throw new RuntimeException();
        }
    }
}
