package inventoryapi.controller;

import inventoryapi.entities.Brand;
import inventoryapi.entities.Category;
import inventoryapi.repository.BrandRepository;
import inventoryapi.repository.CategoryRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/brands/new")
    @ApiOperation(value = "Show Create New Brand")
    public String showCreateNewBrandForm(Model model) {
        List<Category> listCategories = categoryRepository.findAll();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", new Brand());

        return "brand_form";
    }

    @PostMapping("brands/save")
    @ApiOperation(value = "Save Brand")
    public String saveBrand(Brand brand) {
        brandRepository.save(brand);

        return "redirect:/brands";
    }

    @GetMapping("/brands")
    @ApiOperation(value = "List Brand")
    public String listBrands(Model model) {
        List<Brand> listBrands = brandRepository.findAll();
        model.addAttribute("listBrands", listBrands);

        return "brands";
    }

    @GetMapping("/brands/edit/{id}")
    @ApiOperation(value = "Show Edit Brand")
    public String showEditBrandForm(@PathVariable("id") Integer id, Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        Brand brand = brandRepository.findById(id).get();

        model.addAttribute("listCategories", listCategories);
        model.addAttribute("brand", brand);

        return "brand_form";
    }
}
