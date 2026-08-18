package robert.sanchez.productos.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductosResponseDto {

    private static final long serialVersionUID = 8222253670338491507L;
    private Integer idproducto;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String image_url;
}
