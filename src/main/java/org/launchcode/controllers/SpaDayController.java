package org.launchcode.controllers;

import org.launchcode.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
public class SpaDayController {

    @GetMapping
    public String displayClientForm (Model model) {
        model.addAttribute("title","Display");
        return "serviceSelection";
    }

    @PostMapping
    public String processClientForm(@RequestParam String skintype, @RequestParam String manipedi, Model model) {
        Client newClient = new Client(skintype, manipedi);
        newClient.setAppropriateFacials(skintype);
        model.addAttribute("client" , newClient);

        return "menu";
    }
}
