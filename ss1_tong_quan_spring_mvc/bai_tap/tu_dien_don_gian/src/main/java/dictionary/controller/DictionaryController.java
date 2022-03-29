package dictionary.controller;

import dictionary.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    ITranslateService translateService;

    @GetMapping("")
    public String showForm(){
        return "index";
    }


    @PostMapping("dictionary")
    public String translate(@RequestParam String english, Model model){
        Map<String,String> dictionaryMap = translateService.storeDictionary();
        String result = dictionaryMap.get(english);
        if(result == null){
            model.addAttribute("message","Not found");
            return "index";
        }else {
            model.addAttribute("result",result);
            return "dictionary";
        }
    }
}
