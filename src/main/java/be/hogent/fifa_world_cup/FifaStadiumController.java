package be.hogent.fifa_world_cup;

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
        return "fifaStadiumForm";
    }

    @GetMapping("/{id}")
    public String showFifaMatchById(@PathVariable("id") int id, Model model) {
        model.addAttribute("match_title", voetbalService.getWedstrijd(String.valueOf(id)).getWedstrijd().toString());
        model.addAttribute("available_tickets", voetbalService.getWedstrijd(String.valueOf(id)).getTickets());

        return "fifaStadiumResult";
    }

    @PostMapping
    public String onSubmit(@RequestParam(name = "selectedStadium") String nameStadium, Model model) {
        model.addAttribute("stadiumName", nameStadium);
        model.addAttribute("wedstrijden",voetbalService.getWedstrijdenByStadium(nameStadium));
        System.out.println(nameStadium);
        return "fifaStadiumResult";
    }
}
