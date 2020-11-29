package pe.upc.cqrs.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.upc.cqrs.entity.StockProductoEntity;
import pe.upc.cqrs.query.BuscarStockQuery;

@Service
@AllArgsConstructor
public class StockProductoQueryService {

	@Autowired
	private QueryGateway queryGateway;
	@Autowired
	private EventStore eventStore;
	
	public CompletableFuture<StockProductoEntity> buscarPorId(String stockId){
		return this.queryGateway.query(new BuscarStockQuery(UUID.fromString(stockId) ), ResponseTypes.instanceOf(StockProductoEntity.class));
	}
	
	public List<Object> listarEventsPorStock(String stockId){
		return this.eventStore.readEvents(UUID.fromString(stockId).toString()).asStream().map(Message::getPayload).collect(Collectors.toList());
	}
}
