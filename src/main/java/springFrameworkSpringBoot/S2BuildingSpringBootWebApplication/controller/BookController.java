package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.services.BookService;

/**
 * @Created 21 03 2023 - 11:45 AM
 * @Author Hazeem Hassan
 */


@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //read
    @RequestMapping("/books")
    public String getBooks(Model model)
    {
        model.addAttribute("books",bookService.findAll());
        return "books";
    }
}
