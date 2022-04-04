package image.controller;

import image.model.ImageOfDay;
import image.service.ImageOfDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageOfDayController {

    @Autowired
    ImageOfDayService imageOfDayService;

    @GetMapping("")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<ImageOfDay> imageOfDayList = imageOfDayService.findAll();
        modelAndView.addObject("imageOfDay", new ImageOfDay((short) 50, "Em dep lam", "Tuan"));
        modelAndView.addObject("imageOfDayList", imageOfDayList);
        return modelAndView;
    }

    @PostMapping
    public String save (ImageOfDay imageOfDay) {
        imageOfDayService.save(imageOfDay);
        return "home";
    }

}
