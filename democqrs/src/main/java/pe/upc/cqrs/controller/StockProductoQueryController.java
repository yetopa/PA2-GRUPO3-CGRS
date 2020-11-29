package pe.upc.cqrs.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.upc.cqrs.entity.StockProductoEntity;
import pe.upc.cqrs.service.StockProductoQueryService;

@RestController
@RequestMapping(value = "/stock")
@AllArgsConstructor
public class StockProductoQueryController {

	@Autowired
	private StockProductoQueryService productoQueryService;
	
	@GetMapping("/{stockId}")
	public 	CompletableFuture<StockProductoEntity> buscarPorId(@PathVariable("stockId") String stockId) {
		return this.productoQueryService.buscarPorId(stockId);
	}
	
	@GetMapping("/{stockId}/events")
	public List<Object> listarEventosPorStock(@PathVariable(value = "stockId") String stockId) {
		return this.productoQueryService.listarEventsPorStock(stockId);
	}
}
