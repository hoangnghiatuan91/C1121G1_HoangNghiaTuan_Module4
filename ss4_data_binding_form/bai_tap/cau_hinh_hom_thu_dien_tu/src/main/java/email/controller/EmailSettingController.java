package email.controller;

import email.model.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/settings")
public class EmailSettingController {
    @GetMapping("")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("settings");
        modelAndView.addObject("emailSettings", new EmailSettings());
        modelAndView.addObject("languages", new String[]{"English", "Vietnamese", "Japanese", "Korean"});
        modelAndView.addObject("pageSize", new Integer[]{5, 10, 15, 25, 50, 100});
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("email") EmailSettings emailSettings, Model model){
        model.addAttribute("emailSettings",emailSettings);
        return "info";
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("emailSettings") EmailSettings emailSettings ){
        ModelAndView  modelAndView = new ModelAndView("settings");
        modelAndView.addObject("emailSettings",emailSettings);
        modelAndView.addObject("languages", new String[]{"English", "Vietnamese", "Japanese", "Korean"});
        modelAndView.addObject("pageSize", new Integer[]{5, 10, 15, 25, 50, 100});
        return modelAndView;
    }
}
