package pe.upc.cqrs.query;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuscarStockQuery {

	private UUID stockId;

	public BuscarStockQuery() {}
	public BuscarStockQuery(UUID stockId) {
		this.stockId = stockId;
	}

	public UUID getStockId() {
		return stockId;
	}

	public void setStockId(UUID stockId) {
		this.stockId = stockId;
	}
	
	
	
}
