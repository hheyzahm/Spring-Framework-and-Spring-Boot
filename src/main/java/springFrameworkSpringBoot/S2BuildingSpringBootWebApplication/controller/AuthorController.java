package springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springFrameworkSpringBoot.S2BuildingSpringBootWebApplication.services.AuthorService;

/**
 * @Created 21 03 2023 - 11:45 AM
 * @Author Hazeem Hassan
 */
@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String  findAllAuthor(Model model){

        model.addAttribute("authors",authorService.findAllAuthors());
        return "author";
    }
}
