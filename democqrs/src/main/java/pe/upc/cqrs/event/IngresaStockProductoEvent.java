package pe.upc.cqrs.event;

import java.util.UUID;

import lombok.Value;

@Value
public class IngresaStockProductoEvent {

	private UUID id;
	private Long cantidadIngresa;
	
	
	
	public IngresaStockProductoEvent(UUID id, Long cantidadIngresa) {
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
