package guru.springframework.msscbeerservice2.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbeerservice2.web.model.BeerDto;
import guru.springframework.msscbeerservice2.web.model.CustomerDto;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerDtoById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }
    
    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }
    
    //CUSTOMER
    
	@Test
	void testGetCustomerDtoById() {
        CustomerDto dto = client.getCustomerDtoById(UUID.randomUUID());
        assertNotNull(dto);
	}

	@Test
	void testSaveNewBeerCustomerDto() {
        //given
		CustomerDto customerDto = CustomerDto.builder().name("CutomerNew").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
	}

	@Test
	void testUpdateBeerUUIDCustomerDto() {
        //given
		CustomerDto customerDto = CustomerDto.builder().name("New custumer").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
	}

	@Test
	void testDeleteCutomer() {
		client.deleteCutomer(UUID.randomUUID());
	}


}
