package pe.upc.cqrs.projection;

import java.util.Optional;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pe.upc.cqrs.entity.StockProductoEntity;
import pe.upc.cqrs.event.IngresaStockProductoEvent;
import pe.upc.cqrs.event.ProductoRegistradoEvent;
import pe.upc.cqrs.event.SalidaStockProductoEvent;
import pe.upc.cqrs.query.BuscarStockQuery;
import pe.upc.cqrs.repository.StockProductoRepository;

@Slf4j
@RequiredArgsConstructor
@Component
public class StockProductoProjection {

	@Autowired
	private StockProductoRepository stockProductoRepository;
	
	/*@Autowired
	private Repository<StockProductoAggregate> stockRepository;*/
	
	@EventHandler
	public void on(ProductoRegistradoEvent event) {
		StockProductoEntity stockProducto = new StockProductoEntity(event.getId(), event.getCantidadInicial(), event.getNombreProducto());
		this.stockProductoRepository.save(stockProducto);
	}
	
	@EventHandler
	public void on(IngresaStockProductoEvent event) throws NotFoundException{
		Optional<StockProductoEntity> optional = this.stockProductoRepository.findById(event.getId());
		if (optional.isPresent()) {
			StockProductoEntity entity = optional.get();
			entity.setCantidad(entity.getCantidad() + event.getCantidadIngresa());
			this.stockProductoRepository.save(entity);
		} else {
			throw new NotFoundException("No se encontro ningun registro para el ID: " + event.getId());
		}
	}
	
	@EventHandler
	public void on(SalidaStockProductoEvent event) throws NotFoundException{
		Optional<StockProductoEntity> optional = this.stockProductoRepository.findById(event.getId());
		if (optional.isPresent()) {
			StockProductoEntity entity = optional.get();
			entity.setCantidad(entity.getCantidad() - event.getCantidadSale());
			this.stockProductoRepository.save(entity);
		}else {
			throw new NotFoundException("No se encontro ningun registro para el ID: " + event.getId());
		}
	}
	
	@QueryHandler
	public StockProductoEntity handle(BuscarStockQuery buscarStockQuery) {
		return this.stockProductoRepository.findById(buscarStockQuery.getStockId()).orElse(null);
	}
	
	/*@QueryHandler
	public StockProductoAggregate handle(BuscarStockQuery buscarStockQuery) throws InterruptedException, ExecutionException{
		CompletableFuture<StockProductoAggregate> future = new CompletableFuture<StockProductoAggregate>();
		stockRepository.load(buscarStockQuery.getStockId().toString()).execute(future :: complete);
		return future.get();
	}*/
	
	
}
