package com.casestudy.controller;

import com.casestudy.dto.CustomerDto;
import com.casestudy.dto.ServicesDto;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.service.ServiceType;
import com.casestudy.model.service.Services;
import com.casestudy.service.service.IRentTypeService;
import com.casestudy.service.service.IServiceTypeService;
import com.casestudy.service.service.IServicesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private IServicesService servicesService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "serviceName", defaultValue = "", required = false) String serviceName,
                             @PageableDefault(size = 3) Pageable pageable) {
        Page<Services> services = servicesService.findAll(pageable, serviceName);
        ModelAndView modelAndView = new ModelAndView("/services/list");
        modelAndView.addObject("services", services);
        modelAndView.addObject("serviceName", serviceName);
        return modelAndView;
    }

    @GetMapping("/create/{typeId}")
    public String showForm(@PathVariable Integer typeId, Model model) {
        ServiceType serviceType = serviceTypeService.findById(Long.valueOf(typeId)).orElse(null);
        ServicesDto servicesDto = new ServicesDto();
        if (serviceType != null) {
            servicesDto.setServiceType(serviceType);
        }
        model.addAttribute("servicesDto", servicesDto);
//        model.addAttribute("serviceTypes", serviceTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());

        return "services/create";
    }

    @PostMapping("/save")
    public String createService(@Valid @ModelAttribute ServicesDto servicesDto,
                                BindingResult bindingResult, Model model){
        servicesDto.validate(servicesDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("serviceTypes", serviceTypeService.findAll());
            ServiceType serviceType = serviceTypeService.findById(servicesDto.getServiceType().getServiceTypeId()).orElse(null);
            if (serviceType != null) {
                servicesDto.setServiceType(serviceType);
            }
            model.addAttribute("rentTypes", rentTypeService.findAll());
            return "services/create";
        }
        Services services = new Services();
        BeanUtils.copyProperties(servicesDto,services);
        servicesService.save(services);
        return "redirect:/services";
    }
}
