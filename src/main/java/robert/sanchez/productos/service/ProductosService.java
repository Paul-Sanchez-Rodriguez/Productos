package robert.sanchez.productos.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import robert.sanchez.productos.domain.dto.ProductosRequestDto;
import robert.sanchez.productos.domain.dto.ProductosResponseDto;

@Service
public interface ProductosService {

    Mono<ProductosResponseDto> findById(Integer id);
    Flux<ProductosResponseDto> findAll();
    Mono<ProductosResponseDto> create(ProductosRequestDto request);
    Mono<ProductosResponseDto> update(ProductosRequestDto request, Integer id);
    Mono<Void> delete(Integer id);
    Mono<Void> restore(Integer id);
    Flux<ProductosResponseDto> findAllInactive();
}
