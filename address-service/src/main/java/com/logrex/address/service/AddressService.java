package com.logrex.address.service;

import com.logrex.address.dto.AddressResponse;

import com.logrex.address.entity.Address;
import com.logrex.address.repository.AddressRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepo addressRepo;

//    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
//
//        Address address = new Address();
//        address.setStreet(createAddressRequest.getStreet());
//        address.setCity(createAddressRequest.getCity());
//
//        addressRepository.save(address);
//
//        return new AddressResponse(address);
//
//    }

    public AddressResponse getById (long id) {

        logger.info("Inside getById " + id);

        Address address = addressRepo.findById(id).get();
      AddressResponse addressResponse = new AddressResponse();
      addressResponse.setAddressId(address.getId());
      addressResponse.setCity(address.getCity());
      addressResponse.setStreet(address.getStreet());


        return addressResponse;
    }

}
