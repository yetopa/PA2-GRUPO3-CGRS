package pe.upc.cqrs.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.upc.cqrs.command.IngresaStockProductoCommand;
import pe.upc.cqrs.command.RegistraProductoCommand;
import pe.upc.cqrs.command.SalidaStockProductoCommand;
import pe.upc.cqrs.dto.CantidadDTO;
import pe.upc.cqrs.dto.StockProductoDTO;
import pe.upc.cqrs.entity.StockProductoEntity;

@Service
@AllArgsConstructor
public class StockProductoCommandService {

	@Autowired
	private CommandGateway commandGateway;
	
	public CompletableFuture<StockProductoEntity> createStockProducto(StockProductoDTO stockDTO) {
		return this.commandGateway.send(new RegistraProductoCommand(UUID.randomUUID(), stockDTO.getStockInicial(),stockDTO.getNombreProducto()));
	}
	
	public CompletableFuture<String> ingresarStockProducto(String stockId, CantidadDTO cantidadDTO) {
		return this.commandGateway.send(new IngresaStockProductoCommand(UUID.fromString(stockId), cantidadDTO.getCantidad()));
	}
	
	public CompletableFuture<String> salidaStockProducto(String stockId, CantidadDTO cantidadDTO){
		return this.commandGateway.send(new SalidaStockProductoCommand(UUID.fromString(stockId),cantidadDTO.getCantidad()));
	}
}
