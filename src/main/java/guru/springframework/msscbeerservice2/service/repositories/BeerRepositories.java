package guru.springframework.msscbeerservice2.service.repositories;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;

import guru.springframework.msscbeerservice2.domain.Beer;

public interface BeerRepositories extends PagingAndSortingRepository<Beer, UUID>{

}
