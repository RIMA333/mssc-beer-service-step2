package guru.springframework.msscbeerservice2.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msscbeerservice2.web.model.BeerDto;
import guru.springframework.msscbeerservice2.web.model.CustomerDto;

@Component
@ConfigurationProperties(value="sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

	public final String BEER_PATH_V1 = "/api/v1/beer/";
	public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
	private String apiHost;
	private final RestTemplate restTemplate;
	
    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
    //BEER
    
	public BeerDto getBeerDtoById(UUID uuid) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
	}
	
	public URI saveNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apiHost + BEER_PATH_V1 , beerDto);
	}
	
	public void updateBeer(UUID uuid, BeerDto beerDto) {
		restTemplate.put(apiHost + BEER_PATH_V1 +uuid.toString(), beerDto);
	}

	public void deleteBeer(UUID uuid) {
		restTemplate.delete(apiHost + BEER_PATH_V1 + uuid);
	}
	
	//CUSTOMER
	
	public CustomerDto getCustomerDtoById(UUID idCustomer) {
		return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + idCustomer.toString(), CustomerDto.class);
	}
	
	public URI saveNewCustomer(CustomerDto customerDto) {
		return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1 , customerDto);
	}
	
	public void updateCustomer(UUID idCustomer, CustomerDto customerDto) {
		restTemplate.put(apiHost + CUSTOMER_PATH_V1 +idCustomer.toString(), customerDto);
	}

	public void deleteCutomer(UUID idCustomer) {
		restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + idCustomer);
	}
	
	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
	
	
	
}
