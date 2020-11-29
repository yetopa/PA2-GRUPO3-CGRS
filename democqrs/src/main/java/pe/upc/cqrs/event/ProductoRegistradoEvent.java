package pe.upc.cqrs.event;

import java.util.UUID;

import lombok.Data;

@Data
public class ProductoRegistradoEvent {

	private UUID id;
	private Long cantidadInicial;
	private String nombreProducto;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Long getCantidadInicial() {
		return cantidadInicial;
	}
	public void setCantidadInicial(Long cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public ProductoRegistradoEvent(UUID id, Long cantidadInicial, String nombreProducto) {
		this.id = id;
		this.cantidadInicial = cantidadInicial;
		this.nombreProducto = nombreProducto;
	}
	
}
