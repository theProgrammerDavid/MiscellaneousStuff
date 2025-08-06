package com.example.jpa_h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DemoController {

    @GetMapping("/error")
    public String error(){
        return "Oops, an error occurred";
    }

    @Autowired
    private CustomerRepository customerRepository;

    /**
     *
     * @param first Customer first name
     * @param last Customer last name
     * @return Success message
     */
    @PostMapping("/add")
    public String addCustomer(@RequestParam String first, @RequestParam String last){
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to the repository!";
    }

    /**
     *
     * @return
     */
    @GetMapping("/list")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }


}
