package com.exam.eEmbed.controller;

import com.exam.eEmbed.service.OEmbedService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/oEmbed")
@Controller
@RequiredArgsConstructor
public class OEmbedController {
    private final OEmbedService oEmbedService;
    @GetMapping("/search")
    public String showSearch(){
        return "oEmbed";
    }
    @PostMapping("/search")
    @ResponseBody
    public JSONObject search(String url){
        JSONObject jsonObject = oEmbedService.urlConnector(url);
        return jsonObject;
    }
}
