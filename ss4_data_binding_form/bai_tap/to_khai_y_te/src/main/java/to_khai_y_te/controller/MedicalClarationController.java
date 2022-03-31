package to_khai_y_te.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import to_khai_y_te.model.MedicalDeclaration;
import to_khai_y_te.service.MedicalDeclarationService;

@Controller
public class MedicalClarationController {
    @Autowired
    MedicalDeclarationService medicalDeclarationService;

    @GetMapping ("")
    public ModelAndView showForm () {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("medicalDeclaration", new MedicalDeclaration());
        modelAndView.addObject("genderArray", new String[] {"Nam", "Nữ", "Khác"});
        modelAndView.addObject("travelInfoArray", new String[]{"Máy bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        modelAndView.addObject("booleanArray", new Boolean[] {true, false});
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        medicalDeclaration.setIdForm((int) (Math.random()*10000));
        medicalDeclarationService.save(medicalDeclaration);
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        model.addAttribute("message", "Đã tạo tờ khai y tế thành công");
        return "info";
    }

    @GetMapping ("/{idForm}/edit")
    public String edit (@PathVariable int idForm, Model model) {
        model.addAttribute("medicalDeclaration", medicalDeclarationService.findById(idForm));
        model.addAttribute("genderArray", new String[] {"Nam", "Nữ", "Khác"});
        model.addAttribute("travelInfoArray", new String[]{"Máy bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        model.addAttribute("booleanArray", new Boolean[] {true, false});
        return "edit";
    }

    @PostMapping ("/update")
    public String update (MedicalDeclaration medicalDeclaration, Model model) {
        medicalDeclarationService.update(medicalDeclaration.getIdForm(), medicalDeclaration);
        model.addAttribute("message", "Đã cập nhật tờ khai y tế thành công");
        return "info";
    }
}
