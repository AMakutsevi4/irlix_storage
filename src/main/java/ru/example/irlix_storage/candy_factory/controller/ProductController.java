package ru.example.irlix_storage.candy_factory.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.example.irlix_storage.candy_factory.model.Product;
import ru.example.irlix_storage.candy_factory.service.ProductService;
import ru.example.irlix_storage.candy_factory.service.TypeService;



@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;
    private final TypeService typeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("supplierNames", productService.productSupplyMap());
        model.addAttribute("allTypes", typeService.getAll());
        return "product/products";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("supplies", productService.getAllSupplies());
        model.addAttribute("allTypes", typeService.getAll());
        return "product/productAdd";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("supplies", productService.getAllSupplies());
            model.addAttribute("allTypes", typeService.getAll());
            logger.debug("Обнаружены ошибки проверки: {}", result.getAllErrors());
            return "product/productAdd";
        }
        logger.debug("Сохранение продукта: {}", product);
        productService.save(product);
        logger.debug("Продукт успешно сохранен");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("supplies", productService.getAllSupplies());
        model.addAttribute("allTypes", typeService.getAll());
        return "product/productUpdate";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute Product product,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("supplies", productService.getAllSupplies());
            model.addAttribute("allTypes", typeService.getAll());
            return "product/productUpdate";
        }
        product.setId(id);
        product.setTypes(productService.getAllTypes(product));
        productService.update(product);
        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.delete(productService.getById(id));
        return "redirect:/products";
    }
}
