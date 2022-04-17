package be.hogent.fifa_world_cup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //TODO autowire service implementation

    @GetMapping("/")
    public String showFifaStadiumForm(Model model) {

        return "fifaStadiumForm";
    }
}
