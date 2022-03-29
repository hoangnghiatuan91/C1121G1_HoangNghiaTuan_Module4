package converter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import converter.service.ConvertService;

public class ConvertController {
    @Autowired
    ConvertService convertService;
    @GetMapping("/")
    public String showIndex(){
        return "index";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam int usd, Model model){
        int vnd = convertService.convertUSDToVND(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "convert";
    }

}
