package guru.springframework.msscbeerservice2.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbeerservice2.web.model.BeerDto;
import guru.springframework.msscbeerservice2.web.model.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(UUID.randomUUID())
				.beerName("Icnusa")
				.beerStyle(BeerStyleEnum.IPA)
				.build();
	}

	@Override
	public BeerDto getBeerNoParameter() {
		return BeerDto.builder()
				.beerName("Icnusa")
				.beerStyle(BeerStyleEnum.GOSE)
				.build();
	}

	@Override
	public BeerDto saveBeerDto(BeerDto beerDto) {
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeerDto(UUID beerId, BeerDto beerDto) {
		
		//TODO IMPLEMENTATION
		
	}

	@Override
	public void deleteBeerById(UUID beerId) {
		log.debug("Deleting a beer...");
	}
	
}
