package guru.springframework.msscbeerservice2.service.bootstrap;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.msscbeerservice2.domain.Beer;
import guru.springframework.msscbeerservice2.service.repositories.BeerRepositories;

@Component
public class BeerLoader implements CommandLineRunner {

	private final BeerRepositories beerRepositories;
	
	public BeerLoader(BeerRepositories beerRepositories) {
		this.beerRepositories = beerRepositories;
	}

	@Override
	public void run(String... args) throws Exception {
		loadBeerObject();
		
	}

	private void loadBeerObject() {
		if(beerRepositories.count()==0) {
			beerRepositories.save(Beer.builder()
					.beerName("Natro Azzurro")
					.beerStyle("IPA")
					.mindOnHand(12)
					.quantityToBrew(200)
					.upc(489521638L)
					.price(new BigDecimal("20.54"))
					.build());

			beerRepositories.save(Beer.builder()
					.beerName("Icnusa")
					.beerStyle("Blonde")
					.mindOnHand(10)
					.quantityToBrew(190)
					.upc(389521218L)
					.price(new BigDecimal("15.83"))
					.build());
			
			System.out.println("#### BIRRE COUNT: "+beerRepositories.count());
		
		}
		
	}

	
	
}
