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

    @RequestMapping("/login")
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
        Iterator<User> u = userRepository.findAll().iterator();
        while (u.hasNext()) {
            User next = u.next();
            String e = next.getEmail();
            if(Objects.equals(e, email)) return "duplicated-email";
            System.out.println(e);
        }

        // 入力されたメールアドレスが存在しない場合、データベースに追加
        n.setEmail(email);
        n.setName(name);
        userRepository.save(n);

        return "redirect:/login";
    }

}
