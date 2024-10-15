package exam.database.controller;

import exam.database.dto.MemberRequestDto;
import exam.database.entity.Book;
import exam.database.entity.Member;
import exam.database.service.BookService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookService bookService;

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        //모든 책 다 띄우기
        List<Book> books = bookService.findBooks();
        model.addAttribute("book", books);
        return "/home";
    }
}
