package org.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/petitions")
public class MyController {
    /*@GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }*/

    private List<Petition> petitionList = new ArrayList<>(); // In-memory list to store petitions

    @GetMapping("/create")
    public String showCreatePetitionForm(Model model) {
        model.addAttribute("petition", new Petition("", ""));
        return "create_petition";
    }

    @PostMapping("")
    public String createPetition(@ModelAttribute("petition") Petition petition) {
        petitionList.add(petition); // Add petition to the list
        return "redirect:/petitions";
    }

    @GetMapping("")
    public String showAllPetitions(Model model) {
        model.addAttribute("petitions", petitionList);
        return "all_petitions"; // Thymeleaf template to display all petitions
    }

    @GetMapping("/{id}")
    public String showPetition(@PathVariable int id, Model model) {
        Petition petition = petitionList.get(id);
        model.addAttribute("petition", petition);
        return "single_petition";
    }

    @PostMapping("/{id}/sign")
    public String signPetition(@PathVariable int id, @RequestParam String name, @RequestParam String email) {
        Petition petition = petitionList.get(id);
        petition.addSignature(name, email);
        return "redirect:/petitions/all";
    }
}

