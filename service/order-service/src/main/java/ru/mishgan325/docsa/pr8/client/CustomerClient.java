package ru.mishgan325.docsa.pr8.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.mishgan325.docsa.pr8.dto.CustomerDto;
import ru.mishgan325.docsa.pr8.config.FeignConfig;


@FeignClient(name = "customer-service", configuration = FeignConfig.class)
public interface CustomerClient {

    @GetMapping("/customers/{id}")
    CustomerDto getCustomerById(@PathVariable Long id);

    @GetMapping("/customers/user/{userId}")
    CustomerDto getCustomerByUserId(@PathVariable Long userId);
}

