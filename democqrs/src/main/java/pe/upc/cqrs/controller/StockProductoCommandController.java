package pe.upc.cqrs.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.upc.cqrs.dto.CantidadDTO;
import pe.upc.cqrs.dto.StockProductoDTO;
import pe.upc.cqrs.entity.StockProductoEntity;
import pe.upc.cqrs.service.StockProductoCommandService;

@RestController
@RequestMapping(value = "/stock")
@AllArgsConstructor
public class StockProductoCommandController {

	@Autowired
	private StockProductoCommandService commandService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CompletableFuture<StockProductoEntity> createStock(@RequestBody StockProductoDTO stockDTO){
		return this.commandService.createStockProducto(stockDTO);
	}
	
	@PutMapping(value = "/ingreso/{stockId}")
	public CompletableFuture<String> ingresoStock(@PathVariable(value = "stockId") String stockId, @RequestBody CantidadDTO cantidadDTO){
		return this.commandService.ingresarStockProducto(stockId, cantidadDTO);
	}
	
	@PutMapping(value = "/salida/{stockId}")
	public CompletableFuture<String> salidaStock(@PathVariable(value = "stockId") String stockId, @RequestBody CantidadDTO cantidadDTO){
		return this.commandService.salidaStockProducto(stockId, cantidadDTO);
	}
	
}
