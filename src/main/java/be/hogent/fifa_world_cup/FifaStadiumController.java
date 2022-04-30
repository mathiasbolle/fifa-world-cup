package be.hogent.fifa_world_cup;

import domain.MatchCommand;
import domain.Wedstrijd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.VoetbalService;

@Controller
@RequestMapping("/fifa")
public class FifaStadiumController {
    @Autowired
    private VoetbalService voetbalService;

    @GetMapping
    public String showFifaStadium(Model model) {
        model.addAttribute("stadiumList", voetbalService.getStadiumList());
        model.addAttribute("stadiumSelection", new MatchCommand());
        return "fifaStadiumForm";
    }

    @GetMapping("/{id}")
    public String showFifaMatchById(@ModelAttribute(name = "stadiumSelection") MatchCommand nameStadium, @PathVariable("id") int id, Model model) {
        model.addAttribute("stadiumName", nameStadium.getStadiumName());
        System.out.println(nameStadium.getStadiumName());
        model.addAttribute("match_title", voetbalService.getWedstrijd(String.valueOf(id)).getWedstrijd().toString());
        model.addAttribute("available_tickets", voetbalService.getWedstrijd(String.valueOf(id)).getTickets());

        return "fifaStadiumResult";
    }

    @PostMapping
    public String onSubmit(@ModelAttribute(name = "stadiumSelection") MatchCommand nameStadium, Model model) {
        model.addAttribute("stadiumName", nameStadium.getStadiumName());
        model.addAttribute("wedstrijden",voetbalService.getWedstrijdenByStadium(nameStadium.getStadiumName()));
        System.out.println(nameStadium.getStadiumName());
        return "fifaStadiumResult";
    }
}
