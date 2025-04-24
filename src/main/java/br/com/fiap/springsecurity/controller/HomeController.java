package br.com.fiap.springsecurity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal UserDetails userDetails, Model model) {      // já passou pelo springsec, já foi autenticado e irá dar os detalhes daquele usuário em seguida
        if(userDetails != null) {
            model.addAttribute("userName", userDetails.getUsername());
        }
        return "home";
    }
}

// a userDetails expoe as informações do usuário, como nome senha, autorizações, etc
