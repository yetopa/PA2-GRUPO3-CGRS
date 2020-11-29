package pe.upc.cqrs.aggregate;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pe.upc.cqrs.command.IngresaStockProductoCommand;
import pe.upc.cqrs.command.RegistraProductoCommand;
import pe.upc.cqrs.command.SalidaStockProductoCommand;
import pe.upc.cqrs.event.IngresaStockProductoEvent;
import pe.upc.cqrs.event.ProductoRegistradoEvent;
import pe.upc.cqrs.event.SalidaStockProductoEvent;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class StockProductoAggregate {

	@AggregateIdentifier
	private UUID id;
	private Long cantidad;
	private String nombreProducto;

	
	public StockProductoAggregate() {}
	
	@CommandHandler
	public StockProductoAggregate(RegistraProductoCommand command) {
		AggregateLifecycle.apply(new ProductoRegistradoEvent(command.getId(), command.getCantidadInicial(), command.getNombreProducto()));
	}
	
	
	@EventSourcingHandler
	public void on(ProductoRegistradoEvent event) {
		this.id = event.getId();
		this.cantidad = event.getCantidadInicial();
		this.nombreProducto = event.getNombreProducto();
				
	}
	
	
	@CommandHandler
	public void handle(IngresaStockProductoCommand command) {
		AggregateLifecycle.apply(new IngresaStockProductoEvent(command.getId(), command.getCantidadIngresa()));
	}
	
	@EventSourcingHandler
	public void on(IngresaStockProductoCommand command) {
			this.cantidad = this.cantidad + command.getCantidadIngresa();
	}
	
	
	@CommandHandler
    public void handle(SalidaStockProductoCommand command) {
		AggregateLifecycle.apply(new SalidaStockProductoEvent(command.getId(), command.getCantidadSale()));
	}
	
	@EventSourcingHandler
    public void on(SalidaStockProductoCommand command) {
		this.cantidad = this.cantidad - command.getCantidadSale();
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
