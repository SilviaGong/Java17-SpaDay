package org.launchcode.controllers;

import org.launchcode.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")

public class UserController {
    @GetMapping
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping("add")//Notice: here PostMapping annotation has the correct URL mapping. It should match the 'action' attribute with HTML form.
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if(user.getPassword().equals(verify)){
            model.addAttribute(user);
            return "user/index";
        }else{
            model.addAttribute("error","Your password should be match!");
            return "user/add"; //When you use return "redirect:/user/index";, it initiates a new GET request to the specified URL. If the controller mapping or view resolution is not set up correctly for the redirected URL (/user/index), it could result in a 404 error.
        }
    }
}
