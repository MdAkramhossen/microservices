package com.logrex.student.feignclients;

import com.logrex.student.Response.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${address.service.url}", value = "address-feign-client",
        path = "/api/address")

public interface AddressFeignClients {

    @GetMapping("/getById/{id}")
    public AddressDTO getById(@PathVariable long id);
}