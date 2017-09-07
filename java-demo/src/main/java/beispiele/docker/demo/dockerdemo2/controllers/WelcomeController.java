package beispiele.docker.demo.dockerdemo2.controllers;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private final static Faker faker = new Faker();

    @GetMapping("/")
    public String welcome(Model model) {

        model.addAttribute("fact", faker.chuckNorris().fact());
        model.addAttribute("author", "Chuck Norris");

        return "welcome";
    }
}
