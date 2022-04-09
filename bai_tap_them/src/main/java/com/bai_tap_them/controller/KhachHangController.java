package com.bai_tap_them.controller;

import com.bai_tap_them.model.KhachHang;
import com.bai_tap_them.service.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class KhachHangController {

    @Autowired
    IKhachHangService khachHangService;

    @GetMapping("/khachhang")
    public ModelAndView listCategories() {
        List<KhachHang> khachHangs = khachHangService.findAll();
        ModelAndView modelAndView = new ModelAndView("/khachhang/list");
        modelAndView.addObject("khachHangs", khachHangs);
        return modelAndView;
    }

    @GetMapping("/create-khachhang")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/khachhang/create");
        modelAndView.addObject("khachhang", new KhachHang());
        return modelAndView;
    }

    @PostMapping("/create-khachhang")
    public ModelAndView saveKhachHang(@ModelAttribute("category") KhachHang khachHang) {
        khachHangService.save(khachHang);

        ModelAndView modelAndView = new ModelAndView("/khachhang/create");
        modelAndView.addObject("khachhang", new KhachHang());
        modelAndView.addObject("message", "Tạo mới thành công");
        return modelAndView;
    }

    @GetMapping("/edit-khachhang/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        KhachHang khachHang = khachHangService.findById(id);

            ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
            modelAndView.addObject("khachHang", khachHang);
            return modelAndView;

    }

    @PostMapping("/edit-khachhang")
    public ModelAndView updateKhachHang(@ModelAttribute("khachHang") KhachHang khachHang) {
        khachHangService.save(khachHang);
        ModelAndView modelAndView = new ModelAndView("/khachhang/edit");
        modelAndView.addObject("khachHang", khachHang);
        modelAndView.addObject("message", "Update thành công");
        return modelAndView;
    }

    @GetMapping("/delete-khachhang/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        KhachHang khachHang = khachHangService.findById(id);

            ModelAndView modelAndView = new ModelAndView("/khachhang/delete");
            modelAndView.addObject("khachHang", khachHang);
            return modelAndView;

    }

    @PostMapping("/delete-khachhang")
    public String deleteKhachHang(@ModelAttribute("khachHang") KhachHang khachHang) {
        khachHangService.remove(khachHang.getId());
        return "redirect:/khachhang";
    }


}
