package pe.upc.cqrs.event;

import java.util.UUID;

import lombok.Value;

@Value
public class SalidaStockProductoEvent {

	private UUID id;
	private Long cantidadSale;
	
	public SalidaStockProductoEvent(UUID id, Long cantidadSale) {
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
