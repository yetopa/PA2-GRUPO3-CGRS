package pe.upc.cqrs.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockProductoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private UUID id;
	private Long cantidad;
	private String nombreProducto;
	
	
	
	public StockProductoEntity() {}

	public StockProductoEntity(UUID id, Long cantidad, String nombreProducto) {
		this.id = id;
		this.cantidad = cantidad;
		this.nombreProducto = nombreProducto;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	
	
}
