package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {
    @RequestMapping("/")
    public String showMainpage(){
        return "condiments";
    }

    @GetMapping("/condiment")
    public String resultMenu(@RequestParam(value = "condiment",required = false,defaultValue = "Tích zô chứ e zai")
                                         String[] listCondiment, Model model){

            model.addAttribute("listCondiment", listCondiment);
        return "condiments";
    }
}
