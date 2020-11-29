package pe.upc.cqrs.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.upc.cqrs.entity.StockProductoEntity;

@Repository
public interface StockProductoRepository extends JpaRepository<StockProductoEntity, UUID>{

}
