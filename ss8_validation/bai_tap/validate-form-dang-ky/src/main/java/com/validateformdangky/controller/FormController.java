package com.validateformdangky.controller;

import com.validateformdangky.dto.RegistrationFormDto;
import com.validateformdangky.model.RegistrationForm;
import com.validateformdangky.service.IRegistrationFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FormController {

    @Autowired
    private IRegistrationFormService registrationFormService;

    @GetMapping("")
    public ModelAndView list(@PageableDefault(value = 3) Pageable pageable) {
        Page<RegistrationForm> registrationForms = registrationFormService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("registrationForms", registrationForms);
        return modelAndView;
    }

    @GetMapping("/create-form")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("registrationFormDto", new RegistrationFormDto());
        return modelAndView;
    }

    @PostMapping("/create-form")
    public ModelAndView saveForm(@Valid @ModelAttribute RegistrationFormDto registrationFormDto,
                                 BindingResult bindingResult, Pageable pageable) {
        ModelAndView modelAndView;
        if (bindingResult.hasFieldErrors()) {
            modelAndView = new ModelAndView("/create");
            modelAndView.addObject("registrationFormDto", registrationFormDto);
            return modelAndView;
        }
        RegistrationForm registrationForm = new RegistrationForm();
        BeanUtils.copyProperties(registrationFormDto, registrationForm);
        this.registrationFormService.save(registrationForm);

        Page<RegistrationForm> registrationForms = registrationFormService.findAll(pageable);
        modelAndView = new ModelAndView("/list");
        modelAndView.addObject("registrationForms", registrationForms);

        return modelAndView;
    }
}
