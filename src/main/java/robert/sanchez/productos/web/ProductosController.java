package robert.sanchez.productos.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import robert.sanchez.productos.domain.dto.ProductosRequestDto;
import robert.sanchez.productos.domain.dto.ProductosResponseDto;
import robert.sanchez.productos.service.ProductosService;

@Slf4j
@RestController
@RequestMapping(value = "/v1", produces = "application/json")
@RequiredArgsConstructor
public class ProductosController {

    private final ProductosService productosService;

    @GetMapping()
    public Flux<ProductosResponseDto> findAll(){
        return this.productosService.findAll()
                .doOnComplete(() -> log.info("GET /productos - finalizado"))
                .doOnError(error ->
                        log.error("GET /productos - error", error)
                );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<ProductosResponseDto> createProducto(@RequestBody ProductosRequestDto dto) {

        log.info("POST /productos - iniciando creación de producto");

        dto.setActive(true);

        return this.productosService.create(dto)
                .doOnSuccess(producto ->
                        log.info(
                                "POST /productos - producto creado correctamente. id={}",
                                producto.getIdproducto()
                        )
                )
                .doOnError(error ->
                        log.error(
                                "POST /productos - error creando producto: {}",
                                error.getMessage(),
                                error
                        )
                );
    }

    @PutMapping(value = "/{id}")
    public Mono<ProductosResponseDto> update(@RequestBody ProductosRequestDto dto, @PathVariable Integer id){
        return this.productosService.update(dto,id)
                .doOnSuccess(producto ->
                        log.info(
                                "PUT /productos - producto actualizado correctamente. id={}",
                                producto.getIdproducto()
                        )
                )
                .doOnError(error ->
                        log.error(
                                "PUT /productos - error actualizando producto: {}",
                                error.getMessage(),
                                error
                        )
                );
    }

    @GetMapping(value = "/{id}")
    public Mono<ProductosResponseDto> findByid(@PathVariable Integer id){
        return this.productosService.findById(id)
                .doOnSuccess(producto ->
                        log.info(
                                "GET /productos - producto encontrado con el id={}",
                                producto.getIdproducto()
                        )
                )
                .doOnError(error ->
                        log.error(
                                "GET /productos  error buscando producto: {}",
                                error.getMessage(),
                                error
                        )
                );
    }
}
