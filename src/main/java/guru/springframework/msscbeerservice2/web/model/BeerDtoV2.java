package guru.springframework.msscbeerservice2.web.model;

import java.math.BigDecimal;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDtoV2 {

	private UUID id;
	private String beerName;
	private BeerStyleEnum beerStyle;
	private Long upc;
	private BigDecimal price;

}
