package com.sysco.onlineOrder.controller;

import com.sysco.onlineOrder.entity.Customer;
import com.sysco.onlineOrder.entity.CustomerAddress;
import com.sysco.onlineOrder.service.CustomerAddressInterface;
import com.sysco.onlineOrder.service.CustomerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping({"/v1/online-order"})
public class CustomerAddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerAddressController.class);

    @Autowired
    private CustomerAddressInterface customerAddressInterface;

    @GetMapping("/customer-address")
    public ResponseEntity<List<CustomerAddress>> getAllAddresses(){
        List<CustomerAddress> addresses = null;
        try {
            addresses = customerAddressInterface.getAllAddress();
        } catch (Exception ex) {
            LOGGER.error(Arrays.toString(ex.getStackTrace()));
        }
        return new ResponseEntity<List<CustomerAddress>>(addresses, HttpStatus.OK);
    }

    @GetMapping("/customer-address/{id}")
    public ResponseEntity <List<CustomerAddress>> getAddressById(@PathVariable("id") int addressId){
        List<CustomerAddress> customerAddress = null;
        try {
            customerAddress = customerAddressInterface.getAddressById(addressId);
        }
        catch (Exception ex){
            LOGGER.error(Arrays.toString(ex.getStackTrace()));
        }
        return new ResponseEntity<List<CustomerAddress>>(customerAddress, HttpStatus.OK);
    }

    @PostMapping("/customer-address")
    public ResponseEntity <CustomerAddress> addTheAddress(@RequestBody CustomerAddress customerAddress){
        CustomerAddress customerAddress1 = new CustomerAddress();

        try {
            customerAddress1 = customerAddressInterface.addAddress(customerAddress);
        }catch (Exception ex){
            ex.getMessage();
        }
        return  new ResponseEntity<CustomerAddress>(customerAddress1,HttpStatus.OK);
    }


}
