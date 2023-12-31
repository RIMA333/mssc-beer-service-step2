package web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msscbeerservice2.web.controller.BeerController;
import guru.springframework.msscbeerservice2.web.model.BeerDto;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void testGetBeerById() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"+UUID.randomUUID().toString())
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
		
	}

	@Test
	void testSaveNewBeer() throws Exception{
		
		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJason = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(post("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJason))
				.andExpect(status().isCreated());
		
	}

	@Test
	void testUpdateBeerById() throws Exception{
		
		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJason = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(put("/api/v1/beer/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJason))
				.andExpect(status().isNoContent());
		
	}

}
