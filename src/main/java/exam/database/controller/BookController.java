package exam.database.controller;

import exam.database.entity.Book;
import exam.database.repository.BookRepository;
import exam.database.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @GetMapping("/books/{bookId}")
    public String detailBook(@PathVariable Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new NoSuchElementException("책을 찾을 수 없습니다."));
        model.addAttribute("book", book);
        return "/detail/book";
    }
}
