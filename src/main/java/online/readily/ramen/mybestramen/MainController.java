package online.readily.ramen.mybestramen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class MainController {
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザーの新規追加
     */
    @GetMapping(path = "/add-account")
    public @ResponseBody String addNewUser (@RequestParam String email,
                                            @RequestParam String name) {
        User n = new User();
        n.setEmail(email);
        n.setName(name);
        userRepository.save(n);
        return "redirect:/login";
    }
}
