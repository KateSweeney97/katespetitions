package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
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
    public String showPetition(@PathVariable String id, Model model) {
        Petition petition;
        for (Petition p : petitionList) {
            System.out.println(p.getId());
            System.out.println(p.getId().equals(id));
            if(p.getId().equals(id)) {
                petition = p;
                model.addAttribute("petition", petition);
                return "single_petition";
            }
        }
        return "create_petition";
    }

    @PostMapping("/{id}/sign")
    public String signPetition(@RequestParam(value = "id") String id, @RequestParam(value = "name") String name, @RequestParam(value = "email") String email) {
        Petition petition;
        for (Petition p : petitionList) {
            if(p.getId().equals(id)) {
                petition = p;
                petition.addSignature(name, email);
                break;
            }
        }
        return "redirect:/petitions";
    }

}

