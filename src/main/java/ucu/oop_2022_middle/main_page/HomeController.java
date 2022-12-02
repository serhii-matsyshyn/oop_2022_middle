package ucu.oop_2022_middle.main_page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String aName() {
        return "index.html";
    }
}
