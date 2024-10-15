package exam.database.controller;

import exam.database.dto.OrderItemRequestDto;
import exam.database.entity.Member;
import exam.database.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public String create(@RequestBody OrderItemRequestDto orderItemRequestDto, HttpSession session) {

        orderService.order(orderItemRequestDto, (Member) session.getAttribute("member"));
        return null;
    }
}
