package pe.upc.cqrs.command;

import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistraProductoCommand {

	@TargetAggregateIdentifier
	private UUID id;
	private Long cantidadInicial;
	private String nombreProducto;
	
	
	public RegistraProductoCommand(UUID id, Long cantidadInicial, String nombreProducto) {
		this.id = id;
		this.cantidadInicial = cantidadInicial;
		this.nombreProducto = nombreProducto;
	}
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
	

	
}
