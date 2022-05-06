package be.hogent.fifa_world_cup;

import be.hogent.fifa_world_cup.validation.Purchase;
import domain.MatchCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.VoetbalService;

import javax.validation.Valid;

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
        model.addAttribute("stadiumName", nameStadium);
        model.addAttribute("match_title", voetbalService.getWedstrijd(String.valueOf(id)).getWedstrijd().toString());
        model.addAttribute("available_tickets", voetbalService.getWedstrijd(String.valueOf(id)).getTickets());

        model.addAttribute("purchase", new Purchase());
        return "fifaStadiumResult";
    }

    @PostMapping
    public String onSubmit(@ModelAttribute(name = "stadiumSelection") MatchCommand nameStadium, Model model) {
        model.addAttribute("stadiumName", nameStadium.getStadiumName());
        model.addAttribute("wedstrijden",voetbalService.getWedstrijdenByStadium(nameStadium.getStadiumName()));
        System.out.println(nameStadium.getStadiumName());
        return "fifaStadiumResult";
    }
    @PostMapping("/{id}")
    public String onBuyTickets(@Valid Purchase purchase, BindingResult result, @PathVariable("id") int id) {
        //to pass model attributes to the next JSP.
        if (result.hasErrors()) {
            System.out.println(result);
            System.out.println(id);
            return String.format("redirect:/fifa/%d", id);
        }
        //model.addAttribute("stadiumSelection", new MatchCommand());
        //model.addAttribute("stadiumList", voetbalService.getStadiumList());
        return "redirect:/fifa";
    }
}
