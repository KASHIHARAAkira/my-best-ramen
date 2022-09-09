package online.readily.ramen.mybestramen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Objects;

@Controller
public class PageController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/")
    String index(Model model) {
        model.addAttribute("time", LocalDateTime.now());
        return "index";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping("/signup")
    String signup() {return "signup";}

    @RequestMapping("/mypage")
    String mypage(Model model) {
        model.addAttribute("email", "hoge@hoge.hoge");
        return "mypage";
    }

    /**
     * ユーザーの新規追加
     */
    @PostMapping(path = "/add-account")
    String addNewUser (@RequestParam String email,
                       @RequestParam String name) {

        User n = new User();

        // 入力されたメールアドレスが既に存在するか確認する
        User u = userRepository.findByEmail(email);
        if (u == null) {
            n.setEmail(email);
            n.setName(name);
            userRepository.save(n);

            return "redirect:/login";
        } else {
            return "duplicated-email";
        }
    }

    /**
     * ログイン
     */
    @PostMapping(path = "/login")
    String processLogin(@RequestParam String email,
                        @RequestParam String name) {
        System.out.println(email + "," + name);

        User n = new User();

        Iterator<User> u = userRepository.findAll().iterator();

        User a = userRepository.findByNameAndEmail(name, email);
        if (a != null) {
            System.out.println(a.getEmail() + "," + a.getName());
        } else {
            System.out.println("🚨");
        }
        return "redirect:/";
    }

}
