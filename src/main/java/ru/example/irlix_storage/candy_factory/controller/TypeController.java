package ru.example.irlix_storage.candy_factory.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.example.irlix_storage.candy_factory.model.Type;
import ru.example.irlix_storage.candy_factory.service.TypeService;

import java.util.List;

@Controller
@RequestMapping("/types")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;


    @GetMapping
    public String list(Model model) {
        List<Type> types = typeService.getAll();
        model.addAttribute("types", types);
        return "type/types";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("type", new Type());
        return "type/typeAdd";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Type type, BindingResult result) {
        if (result.hasErrors()) {
            return "type/typeAdd";
        }
        typeService.save(type);
        return "redirect:/types";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Type type = typeService.getById(id);
        model.addAttribute("type", type);
        return "type/updateType";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid @ModelAttribute Type type, BindingResult result) {
        if (result.hasErrors()) {
            return "type/updateType";
        }
        type.setId(id);
        typeService.save(type);
        return "redirect:/types";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,  RedirectAttributes redirectAttributes) {
        try {
            typeService.delete(id);
        } catch (DataIntegrityViolationException e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Нельзя удалить тип, так как существуют связанные сущности.");
        }

        return "redirect:/types";
    }
}

