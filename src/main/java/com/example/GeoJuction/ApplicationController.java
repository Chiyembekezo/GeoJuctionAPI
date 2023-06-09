package com.example.GeoJuction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    
    @GetMapping("/index")
    public String home()
    {
        return "index";
    }

    @GetMapping("/company")
    public String company()
    {
        return "/company/index";
    }

    @GetMapping("/project")
    public String project()
    {
        return "/project/index";
    }    

    @GetMapping("/sample")
    public String sample()
    {
        return "/sample/index";
    }
    
}
