package guru.springframework.msscbeerservice2.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbeerservice2.services.CustomerService;
import guru.springframework.msscbeerservice2.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
		
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK); 
	}
	
	@PostMapping //POST - CREATE NEW CUSTOMER
	public ResponseEntity handlePost(@Valid @RequestBody CustomerDto customerDto) {
		
		CustomerDto saveCustomerDto = customerService.saveNewCustomer(customerDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "/api/v1/customer/"+saveCustomerDto.getId().toString());
		
		
		return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	public void handleUpdate(@PathVariable("customerId") UUID customerId,@Valid @RequestBody CustomerDto customerDto) {
		
		customerService.updateCustomerDto(customerId);
		
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomerById(@PathVariable("beerId") UUID beerId) {
		
		customerService.deleteCustomerById(beerId);
	} 
	
	
}
