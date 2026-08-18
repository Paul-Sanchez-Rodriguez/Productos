package robert.sanchez.productos.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import robert.sanchez.productos.domain.dto.ProductosRequestDto;
import robert.sanchez.productos.domain.dto.ProductosResponseDto;
import robert.sanchez.productos.domain.mapper.ProductosMapper;
import robert.sanchez.productos.exception.ResourceNotFoundException;
import robert.sanchez.productos.repository.ProductosRepository;
import robert.sanchez.productos.service.ProductosService;

import static robert.sanchez.productos.domain.mapper.ProductosMapper.toModel;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductosServiceImpl implements ProductosService {

    private final ProductosRepository productosRepository;

    @Override
    public Mono<ProductosResponseDto> findById(Integer id) {
        return this.productosRepository.findById(id)
                .map(productos -> ProductosMapper.toDto(productos));
    }

    @Override
    public Flux<ProductosResponseDto> findAll() {
        return this.productosRepository.findAll()
                .map(productos -> ProductosMapper.toDto(productos));
    }

    @Override
    public Mono<ProductosResponseDto> create(ProductosRequestDto request) {
        return this.productosRepository.save(toModel(request))
                .map(productos -> ProductosMapper.toDto(productos));
    }

    @Override
    public Mono<ProductosResponseDto> update(ProductosRequestDto request, Integer id) {
        return this.productosRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El id:" + id +"no fue encontrado")))
                .flatMap(productoEncontrado -> {

                    productoEncontrado.setName(request.getName());
                    productoEncontrado.setPrice(request.getPrice());
                    productoEncontrado.setDescription(request.getDescription());
                    productoEncontrado.setStock(request.getStock());
                    productoEncontrado.setActive(request.getActive());
                    productoEncontrado.setImage_url(request.getImage_url());

                    return this.productosRepository.save(productoEncontrado);
                })
                .map(productos -> ProductosMapper.toDto(productos));
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return null;
    }

    @Override
    public Mono<Void> restore(Integer id) {
        return null;
    }

    @Override
    public Flux<ProductosResponseDto> findAllInactive() {
        return null;
    }
}
