package guru.springframework.msscbeerservice2.services;

import java.util.UUID;

import guru.springframework.msscbeerservice2.web.model.BeerDto;

public interface BeerService {

	BeerDto getBeerById(UUID beerId);

	BeerDto getBeerNoParameter();

	BeerDto saveBeerDto(BeerDto beerDto);

	void updateBeerDto(UUID beerId, BeerDto beerDto);

	void deleteBeerById(UUID beerId);
}
