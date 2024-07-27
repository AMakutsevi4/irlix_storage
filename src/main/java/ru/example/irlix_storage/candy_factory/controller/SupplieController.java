package ru.example.irlix_storage.candy_factory.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.example.irlix_storage.candy_factory.model.Supplie;
import ru.example.irlix_storage.candy_factory.service.OwnerService;
import ru.example.irlix_storage.candy_factory.service.SupplieService;

@Controller
@RequestMapping("/supplies")
@RequiredArgsConstructor
public class SupplieController {

    private final SupplieService supplieService;
    private final OwnerService ownerService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("supplies", supplieService.getAll());
        return "supplies/supplies";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("supplie", new Supplie());
        model.addAttribute("owners", ownerService.getAll());
        return "supplies/supplieAdd";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Supplie supplie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("owners", ownerService.getAll());
            return "supplies/supplieAdd";
        }
        supplieService.save(supplie);
        return "redirect:/supplies";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Supplie supplie = supplieService.getById(id).get();
        model.addAttribute("supplie", supplie);
        model.addAttribute("owners", ownerService.getAll());
        return "supplies/supplieAdd";
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplie(@PathVariable("id") Long id) {
        Supplie supplie = supplieService.getById(id).get();
        supplieService.delete(supplie);
        return "redirect:/supplies";
    }
}