package ru.example.irlix_storage.candy_factory.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.example.irlix_storage.candy_factory.model.Owner;
import ru.example.irlix_storage.candy_factory.service.OwnerService;

@Controller
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("owners", ownerService.getAll());
        return "owners";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "ownerAdd";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return "ownerAdd";
        }
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Owner owner = ownerService.getById(id).get();
        model.addAttribute("owner", owner);
        return "ownerAdd";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Owner owner = ownerService.getById(id).get();
        ownerService.delete(owner);
        return "redirect:/owners";
    }
}
