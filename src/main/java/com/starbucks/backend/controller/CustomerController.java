package com.starbucks.backend.controller;

import com.starbucks.backend.dto.CustomerDTO;
import com.starbucks.backend.dto.LoginDTO;
import com.starbucks.backend.entity.Customer;
import com.starbucks.backend.repository.CustomerRepository;
import com.starbucks.backend.response.LoginResponse;
//import com.starbucks.backend.payloadresponse.LoginMessage;
import com.starbucks.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path="/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        String id = customerService.addCustomer(customerDTO);
        return id;
    }

    @PostMapping(path="/login")
    public ResponseEntity<?> loginCustomer(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = customerService.loginCustomer(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
