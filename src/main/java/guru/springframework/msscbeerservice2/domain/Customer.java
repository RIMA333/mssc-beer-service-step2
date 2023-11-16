package guru.springframework.msscbeerservice2.domain;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import guru.springframework.msscbeerservice2.web.model.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

	private UUID id;
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String name; 
	
}
