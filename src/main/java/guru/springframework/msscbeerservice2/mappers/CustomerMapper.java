package guru.springframework.msscbeerservice2.mappers;

import org.mapstruct.Mapper;

import guru.springframework.msscbeerservice2.domain.Customer;
import guru.springframework.msscbeerservice2.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {

	CustomerDto customerToCustomerDto(Customer customer);
	
	Customer customerDtoToCustomer(CustomerDto customerDto);
	
}
