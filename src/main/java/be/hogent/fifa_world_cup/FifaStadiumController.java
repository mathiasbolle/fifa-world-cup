package be.hogent.fifa_world_cup;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class FifaStadiumController {

    @GetMapping("/fifa")
    public String showFifaStadium(Model model) {
       return "fifaStadiumForm";
    }
}
