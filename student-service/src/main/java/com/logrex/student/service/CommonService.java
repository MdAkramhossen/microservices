package com.logrex.student.service;

import com.logrex.student.Response.AddressDTO;
import com.logrex.student.feignclients.AddressFeignClients;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommonService {

    Logger logger = Logger.getLogger(CommonService.class.getName());
    long count = 1;
    @Autowired
    AddressFeignClients addressFeignClients;
    @CircuitBreaker(name = "addressService",fallbackMethod = "fallbackGetAddressById")
    public AddressDTO getAddressDTO (long id) {

        logger.info("count = "+count);
        count ++;
        AddressDTO address = addressFeignClients.getById(id);

        return  address;
    }

    public AddressDTO fallbackGetAddressById (long id,Throwable throwable) {
        logger.info("Error = "+throwable.getMessage());
        AddressDTO addressDTO = new AddressDTO();


        addressDTO.setId(id);
        return addressDTO;
    }
}
