package exam.database.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue(strategy = IDENTITY)
    @Column(name = "orderitem_id")
    private Long id;
    private LocalDateTime orderDate;
    private int price;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public static OrderItem createOrderItem(Book book, int count, int price) {
        OrderItem orderItem = new OrderItem();
        orderItem.setBook(book);
        orderItem.setPrice(getTotalPrice(count, price));
        return orderItem;
    }

    private static int getTotalPrice(int count, int price) {
        return count * price;
    }

}
