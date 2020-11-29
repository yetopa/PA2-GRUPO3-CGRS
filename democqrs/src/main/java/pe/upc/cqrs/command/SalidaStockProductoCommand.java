package pe.upc.cqrs.command;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalidaStockProductoCommand {

	@TargetAggregateIdentifier
	private UUID id;
	private Long cantidadSale;
	
	
	public SalidaStockProductoCommand(UUID id, Long cantidadSale) {
		this.id = id;
		this.cantidadSale = cantidadSale;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Long getCantidadSale() {
		return cantidadSale;
	}
	public void setCantidadSale(Long cantidadSale) {
		this.cantidadSale = cantidadSale;
	}
	
	
}
