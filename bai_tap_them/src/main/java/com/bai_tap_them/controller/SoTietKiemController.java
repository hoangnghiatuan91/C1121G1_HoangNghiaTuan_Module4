package com.bai_tap_them.controller;

import com.bai_tap_them.dto.SoTietKiemDto;
import com.bai_tap_them.model.KhachHang;
import com.bai_tap_them.model.SoTietKiem;
import com.bai_tap_them.service.IKhachHangService;
import com.bai_tap_them.service.ISoTietKiemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class SoTietKiemController {

    @Autowired
    ISoTietKiemService soTietKiemService;

    @Autowired
    IKhachHangService khachHangService;

    @ModelAttribute("khachHangs")
    public List<KhachHang> khachHangs() {
        return khachHangService.findAll();
    }

    @GetMapping("/create-so")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("sotietkiem/create");
        modelAndView.addObject("soTietKiemDto", new SoTietKiemDto());
        return modelAndView;
    }

    @PostMapping("/create-so")
    public ModelAndView saveSoTietKiem(@Valid @ModelAttribute SoTietKiemDto soTietKiemDto,
                                       BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("sotietkiem/create");
            return modelAndView;
        }

        SoTietKiem soTietKiem = new SoTietKiem();
        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);
        KhachHang khachHang = new KhachHang();
        khachHang.setId(soTietKiemDto.getKhachHang().getId());
        soTietKiem.setKhachHang(khachHang);

        soTietKiemService.save(soTietKiem);
        ModelAndView modelAndView = new ModelAndView("sotietkiem/create");
        modelAndView.addObject("soDto",soTietKiemDto);
        modelAndView.addObject("message", "Tạo mới thành công");
        return modelAndView;
    }

    @GetMapping("/so")
    public ModelAndView listSoTietKiem(@PageableDefault(value = 3) Pageable pageable,
                                       @RequestParam(name = "searchName") Optional<String> searchName) {
        String searchNameValue = searchName.orElse("");
        Page<SoTietKiem> soTietKiems = soTietKiemService.findAll(searchNameValue,pageable);
        ModelAndView modelAndView = new ModelAndView("/sotietkiem/list");
        modelAndView.addObject("soTietKiems", soTietKiems);
        modelAndView.addObject("searchNameValue", searchNameValue);
        return modelAndView;
    }

    @GetMapping("/edit-so/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        SoTietKiem soTietKiem = soTietKiemService.findById(id);
        SoTietKiemDto soTietKiemDto = new SoTietKiemDto();
        BeanUtils.copyProperties(soTietKiem,soTietKiemDto);
            ModelAndView modelAndView = new ModelAndView("sotietkiem/edit");
            modelAndView.addObject("soTietKiemDto", soTietKiemDto);
            return modelAndView;
    }

    @PostMapping("/edit-so")
    public ModelAndView updateBlog(@Valid @ModelAttribute SoTietKiemDto soTietKiemDto,
                                   BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("sotietkiem/edit");
            return modelAndView;
        }

        SoTietKiem soTietKiem = new SoTietKiem();
        BeanUtils.copyProperties(soTietKiemDto, soTietKiem);
        KhachHang khachHang = new KhachHang();
        khachHang.setId(soTietKiemDto.getKhachHang().getId());
        soTietKiem.setKhachHang(khachHang);

        soTietKiemService.save(soTietKiem);
        ModelAndView modelAndView = new ModelAndView("sotietkiem/edit");
        modelAndView.addObject("soTietKiemDto",soTietKiemDto);
        modelAndView.addObject("message", "Sửa thành công");
        return modelAndView;
    }

    @GetMapping("/delete-so/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        SoTietKiem soTietKiem = soTietKiemService.findById(id);
//        SoTietKiemDto soTietKiemDto = new SoTietKiemDto();
//        BeanUtils.copyProperties(soTietKiem,soTietKiemDto);
        ModelAndView modelAndView = new ModelAndView("sotietkiem/delete");
        modelAndView.addObject("soTietKiem", soTietKiem);
        return modelAndView;
    }


    @PostMapping("/delete-so")
    public String deleteSoTietKiem(@ModelAttribute SoTietKiem soTietKiem) {
       soTietKiemService.remove(soTietKiem.getId());
        return "redirect:/so";
    }

//    @GetMapping("/view-blog/{id}")
//    public ModelAndView view(@PathVariable Integer id) {
//        Blog blog = blogService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("/blog/view");
//        modelAndView.addObject("blog", blog);
//        return modelAndView;
//    }
}
