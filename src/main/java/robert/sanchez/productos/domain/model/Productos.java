package robert.sanchez.productos.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(schema = "public", name = "productos")
public class Productos {

    @Id
    @Column("idproducto")
    private Integer idproducto;

    private String name;

    private BigDecimal price;

    private String description;

    private Integer stock;

    private Boolean active;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private String image_url;

    public Productos(Integer idproducto, String name, BigDecimal price, String description, Integer stock, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt, String image_url) {
        this.idproducto = idproducto;
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.image_url = image_url;
    }

    public Productos(String name, BigDecimal price, String description, Integer stock, Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt, String image_url) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.image_url = image_url;
    }
}
