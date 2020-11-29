package pe.upc.cqrs.command;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngresaStockProductoCommand {

	@TargetAggregateIdentifier
	private UUID id;
	private Long cantidadIngresa;
	
	
	public IngresaStockProductoCommand(UUID id, Long cantidadIngresa) {
		this.id = id;
		this.cantidadIngresa = cantidadIngresa;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Long getCantidadIngresa() {
		return cantidadIngresa;
	}
	public void setCantidadIngresa(Long cantidadIngresa) {
		this.cantidadIngresa = cantidadIngresa;
	}
	
	
	
}
