package robert.sanchez.productos.domain.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import robert.sanchez.productos.domain.dto.ProductosRequestDto;
import robert.sanchez.productos.domain.dto.ProductosResponseDto;
import robert.sanchez.productos.domain.model.Productos;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductosMapper {

    public static Productos toModel(ProductosRequestDto dto){
        return new Productos(
                dto.getName(),
                dto.getPrice(),
                dto.getDescription(),
                dto.getStock(),
                dto.getActive(),
                dto.getCreatedAt(),
                dto.getUpdatedAt(),
                dto.getImage_url()
        );
    }

    public static Productos toModel(Integer id, ProductosRequestDto dto){
        return new Productos(
                id,
                dto.getName(),
                dto.getPrice(),
                dto.getDescription(),
                dto.getStock(),
                dto.getActive(),
                dto.getCreatedAt(),
                dto.getUpdatedAt(),
                dto.getImage_url()
        );
    }

    public static ProductosResponseDto toDto(Productos model){
        return new ProductosResponseDto(
                model.getIdproducto(),
                model.getName(),
                model.getPrice(),
                model.getDescription(),
                model.getStock(),
                model.getActive(),
                model.getCreatedAt(),
                model.getUpdatedAt(),
                model.getImage_url()
        );
    }
}
