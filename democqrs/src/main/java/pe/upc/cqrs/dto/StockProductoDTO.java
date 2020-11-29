package pe.upc.cqrs.dto;

import lombok.Value;

@Value
public class StockProductoDTO {

	private  Long stockInicial;
	private  String nombreProducto;
	
	public Long getStockInicial() {
		return stockInicial;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	
}
