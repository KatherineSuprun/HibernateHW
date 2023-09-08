package dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    private Integer id;
    private String username;
    private Integer price;
    private Integer quantity;
}
