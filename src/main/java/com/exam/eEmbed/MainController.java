package com.exam.eEmbed;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    /**
        oEmbed 데이터를 검색할 수 있는 곳으로 redirect 해주는 곳.
     **/
    @GetMapping("/")
    public String main(){
        return "redirect:/oEmbed/";
    }
}
