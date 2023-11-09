package guru.springframework.msscbeerservice2.services;

import java.util.UUID;

import guru.springframework.msscbeerservice2.web.model.CustomerDto;

public interface CustomerService {

	CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	void updateCustomerDto(UUID customerId);
	
	void deleteCustomerById(UUID beerId);

}
