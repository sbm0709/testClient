package com.demo.controller;



import com.demo.dto.ShopDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
public class MainController {

    @GetMapping("/client")
    public void home(){}

    @PostMapping("/getinfo")
    @ResponseBody
    public String getinfo(
            @RequestBody ShopDTO shopDTO,
            Model model
            ){


        return null;
    }

    @GetMapping("/info")
    public void info(){}




}
