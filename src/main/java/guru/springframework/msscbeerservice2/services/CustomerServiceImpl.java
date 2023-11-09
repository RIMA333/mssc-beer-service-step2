package guru.springframework.msscbeerservice2.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbeerservice2.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.name("Sigfrido Sound")
				.build();
	}

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateCustomerDto(UUID customerId) {
		// TODO implementation
		log.debug("Updating...");
	}

	@Override
	public void deleteCustomerById(UUID beerId) {
		log.debug("Deleting...");	
	}


}
