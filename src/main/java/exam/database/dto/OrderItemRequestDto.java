package exam.database.dto;

import exam.database.entity.Book;
import exam.database.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDto {

    private Long bookId;
    private int quantity;
    private int price;

}
