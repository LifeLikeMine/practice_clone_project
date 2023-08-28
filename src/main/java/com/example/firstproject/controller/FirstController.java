package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") // 도메인 경로 xxxxx/hi
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "김범수");
        return "greetings"; // templates/greetings.mustache 연결
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "김범수");
        return "goodbye";
    }
}
