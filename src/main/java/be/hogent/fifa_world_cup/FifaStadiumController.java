package be.hogent.fifa_world_cup;

import be.hogent.fifa_world_cup.validation.Purchase;
import be.hogent.fifa_world_cup.validator.PurchaseValidator;
import domain.MatchCommand;
import domain.Wedstrijd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.JpaStadionDao;
import service.JpaWedstrijdDao;
import service.JpaWedstrijdTicketDao;
import service.VoetbalService;

import javax.validation.Valid;

@Controller
@RequestMapping("/fifa")
public class FifaStadiumController {
    @Autowired
    private JpaStadionDao stadionDao;
    @Autowired
    private JpaWedstrijdTicketDao wedstrijdTicketDao;


    @Autowired
    private PurchaseValidator purchaseValidator;

    @Autowired
    private JpaWedstrijdDao wedstrijdDao;


    @GetMapping
    public String showFifaStadium(Model model, @RequestParam(name = "verkocht", required = false) String verkocht) {

        model.addAttribute("stadiumList", stadionDao.findAll());
        model.addAttribute("stadiumSelection", new MatchCommand());
        model.addAttribute("verkocht", verkocht);
        System.out.println(verkocht);
        return "fifaStadiumForm";
    }

    @GetMapping("/{id}")
    public String showFifaMatchById(@ModelAttribute(name = "stadiumSelection") MatchCommand nameStadium, @PathVariable("id") int id, Model model) {
        model.addAttribute("stadiumName", nameStadium);
        //model.addAttribute("match_title", voetbalService.getWedstrijd(String.valueOf(id)).getWedstrijd().toString());
        model.addAttribute("match_title", wedstrijdTicketDao.get(id).getWedstrijd().toString());
        model.addAttribute("available_tickets", wedstrijdTicketDao.getTicketsOfWedstrijdById(id).getTickets());
        model.addAttribute("purchase", new Purchase());

        if (wedstrijdTicketDao.getTicketsOfWedstrijdById(id).uitverkocht()) {
            return String.format("redirect:/fifa?verkocht=%s", 0);
        }
        System.out.println("test");
        return "fifaStadiumResult";
    }

    @PostMapping
    public String onSubmit(@ModelAttribute(name = "stadiumSelection") MatchCommand nameStadium, Model model) {
        System.out.println(wedstrijdTicketDao.getWedstrijdenByStadion(nameStadium.getStadiumName()));
        model.addAttribute("stadiumName", nameStadium.getStadiumName());
        model.addAttribute("wedstrijden",wedstrijdTicketDao.getWedstrijdenByStadion(nameStadium.getStadiumName()));
        System.out.println(nameStadium.getStadiumName());
        return "fifaStadiumResult";
    }
    @PostMapping("/{id}")
    public String onBuyTickets(@Valid Purchase purchase, BindingResult result, @PathVariable("id") int id, Model model) {
        //to pass model attributes to the next JSP.

        purchaseValidator.validate(purchase, result);
        System.out.println("test");
        if (result.hasErrors()) {
            model.addAttribute("match_title", wedstrijdTicketDao.get(id).getWedstrijd().toString());
            model.addAttribute("available_tickets", wedstrijdTicketDao.getTicketsOfWedstrijdById(id).getTickets());
            return "fifaStadiumResult";
        }
        model.addAttribute("stadiumSelection", new MatchCommand());
        model.addAttribute("stadiumList", stadionDao.findAll());

        return String.format("redirect:/fifa?verkocht=%s", wedstrijdDao.get(id).ticketsBestellen(purchase.getAmount_tickets()));
    }
}
