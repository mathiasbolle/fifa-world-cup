package be.hogent.fifa_world_cup;

import be.hogent.fifa_world_cup.validation.Purchase;
import be.hogent.fifa_world_cup.validator.PurchaseValidator;
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

    @Autowired
    private PurchaseValidator purchaseValidator;


    @GetMapping
    public String showFifaStadium(Model model, @RequestParam(name = "verkocht", required = false) String verkocht) {
        model.addAttribute("stadiumList", voetbalService.getStadiumList());
        model.addAttribute("stadiumSelection", new MatchCommand());
        model.addAttribute("verkocht", verkocht);
        System.out.println(verkocht);
        return "fifaStadiumForm";
    }

    @GetMapping("/{id}")
    public String showFifaMatchById(@ModelAttribute(name = "stadiumSelection") MatchCommand nameStadium, @PathVariable("id") int id, Model model) {
        model.addAttribute("stadiumName", nameStadium);
        model.addAttribute("match_title", voetbalService.getWedstrijd(String.valueOf(id)).getWedstrijd().toString());
        model.addAttribute("available_tickets", voetbalService.getWedstrijd(String.valueOf(id)).getTickets());

        model.addAttribute("purchase", new Purchase());

        if (voetbalService.getWedstrijd(String.valueOf(id)).getTickets() == 0) {
            return String.format("redirect:/fifa?verkocht=%s", 0);
        }
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
    public String onBuyTickets(@Valid Purchase purchase, BindingResult result, @PathVariable("id") int id, Model model) {
        //to pass model attributes to the next JSP.
        purchaseValidator.validate(purchase, result);
        if (result.hasErrors()) {
            model.addAttribute("match_title", voetbalService.getWedstrijd(String.valueOf(id)).getWedstrijd().toString());
            model.addAttribute("available_tickets", voetbalService.getWedstrijd(String.valueOf(id)).getTickets());
            return "fifaStadiumResult";
        }
        model.addAttribute("stadiumSelection", new MatchCommand());
        model.addAttribute("stadiumList", voetbalService.getStadiumList());

        return String.format("redirect:/fifa?verkocht=%s", voetbalService.ticketsBestellen(String.valueOf(id), purchase.getAmount_tickets()));
    }
}
