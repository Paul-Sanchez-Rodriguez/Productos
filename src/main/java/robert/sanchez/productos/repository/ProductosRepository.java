package robert.sanchez.productos.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import robert.sanchez.productos.domain.model.Productos;

public interface ProductosRepository  extends ReactiveCrudRepository<Productos,Integer> {
}
