package guru.springframework.msscbeerservice2.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbeerservice2.services.BeerService;
import guru.springframework.msscbeerservice2.web.model.BeerDto;

@Validated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	
	BeerService beerService;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeerById(@NotNull @PathVariable("beerId") UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity saveNewBeer(@Valid @NotNull @RequestBody BeerDto beerDto) {
		
		BeerDto newBeer = beerService.saveBeerDto(beerDto);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.add("Location", "/api/v1/beer"+newBeer.getId().toString());
		
		return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId,@Valid @RequestBody BeerDto beerDto){
		
		beerService.updateBeerDto(beerId, beerDto);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/{beerId}")
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerService.deleteBeerById(beerId);
	}	
	
}
