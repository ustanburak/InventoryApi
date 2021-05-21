package inventoryapi.controller;

import inventoryapi.entities.Category;
import inventoryapi.repository.CategoryRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryRepository repo;

    @GetMapping("/categories")
    @ApiOperation(value = "List Categories")
    public String listCategories(Model model) {
        List<Category> listCategories = repo.findAll();
        model.addAttribute("listCategories", listCategories);

        return "categories";
    }

    @GetMapping("/categories/new")
    @ApiOperation(value = "Show New Category")
    public String showCategoryNewForm(Model model) {
        model.addAttribute("category", new Category());

        return "category_form";
    }

    @PostMapping("/categories/save")
    @ApiOperation(value = "Save Categories")
    public String saveCategory(Category category) {
        repo.save(category);

        return "redirect:/categories";
    }
}
