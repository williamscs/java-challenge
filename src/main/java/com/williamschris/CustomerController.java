package com.williamschris;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class CustomerController {
    private HashMap<String, Customer> customerMap = new HashMap<>();
    private long customerIdGenerator = 1;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void addCustomer(@RequestBody Customer c) {
        c.setId(customerIdGenerator);
        customerMap.put(String.valueOf(customerIdGenerator++), c);
    }

    @RequestMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerMap.get(id);
    }

    @RequestMapping("/customer")
    public List<Customer> getCustomers(){
        return new ArrayList<>(customerMap.values());
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String id){
        customerMap.remove(id);
    }
}