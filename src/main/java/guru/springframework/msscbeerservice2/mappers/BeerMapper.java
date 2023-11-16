package guru.springframework.msscbeerservice2.mappers;

import org.mapstruct.Mapper;

import guru.springframework.msscbeerservice2.domain.BeerV2;
import guru.springframework.msscbeerservice2.web.model.BeerDtoV2;

@Mapper
public interface BeerMapper {

	BeerDtoV2 beerToBeerDtoV2(BeerV2 beer);
	
	BeerV2 beerDtoV2toBeerV2(BeerDtoV2 beerDtoV2);
}
