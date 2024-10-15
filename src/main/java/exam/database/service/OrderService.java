package exam.database.service;

import exam.database.dto.OrderItemRequestDto;
import exam.database.entity.Book;
import exam.database.entity.Member;
import exam.database.entity.Order;
import exam.database.entity.OrderItem;
import exam.database.repository.BookRepository;
import exam.database.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    /**
     * 일반 주문
     */
    public void order(OrderItemRequestDto orderItemRequestDto, Member member) {

        Book findBook = bookRepository.findById(orderItemRequestDto.getBookId()).orElseThrow(() -> {
            throw new NoSuchElementException("존재하지 않는 책입니다.");
        });

        OrderItem.createOrderItem(findBook,
                orderItemRequestDto.getQuantity(),
                orderItemRequestDto.getPrice());
//        Order.createOrder(member, );
    }
}
