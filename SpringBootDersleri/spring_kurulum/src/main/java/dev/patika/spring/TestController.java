package dev.patika.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/")
public class TestController {
    @GetMapping("/")
    public String home() {
        return "Anasayfa";
    }

    @GetMapping("/user/{userId}")
    public String getUser(@PathVariable("userId") int user_id) {
        return "USER ID : " + user_id;
    }

    @GetMapping("/user/{userId}/{userName}")
    public String getUser(@PathVariable("userId") int user_id, @PathVariable("userName") String uName) {
        return "USER ID : " + user_id + " USER NAME : " + uName;
    }
}
