package online.readily.ramen.mybestramen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class PageController {
    @RequestMapping(value = "/")
    String index(Model model) {
        model.addAttribute("time", LocalDateTime.now());
        return "index";
    }

    @RequestMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/mypage")
    String mypage(Model model) {
        model.addAttribute("email", "hoge@hoge.hoge");
        return "mypage";
    }

}
