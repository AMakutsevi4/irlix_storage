package ru.example.irlix_storage.webApp.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.example.irlix_storage.webApp.model.Person;
import ru.example.irlix_storage.webApp.service.PersonService;

@Controller
@RequestMapping("/people")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public String listPeople(Model model) {
        model.addAttribute("people", personService.findAll());
        return "people/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("person", new Person());
        return "people/form";
    }

    @PostMapping
    public String savePerson(@Valid @ModelAttribute Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "people/form";
        }
        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Person person = personService.findById(id)
                .get();
        model.addAttribute("person", person);
        return "people/form";
    }

    @PostMapping("/update/{id}")
    public String updatePerson(@PathVariable Long id,
                               @Valid @ModelAttribute Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "people/form";
        }
        person.setId(id);
        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return "redirect:/people";
    }
}
