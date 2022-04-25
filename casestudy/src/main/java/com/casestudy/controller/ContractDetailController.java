package com.casestudy.controller;

import com.casestudy.dto.ContractDetailDto;
import com.casestudy.dto.ContractDto;
import com.casestudy.model.contract.AttachService;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.contract.ContractDetail;
import com.casestudy.model.employee.Division;
import com.casestudy.service.contract.IAttachServiceService;
import com.casestudy.service.contract.IContractDetailService;
import com.casestudy.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @ModelAttribute("contracts")
    public Iterable<Contract> contracts(){
        return this.contractService.findAll();
    }

    @ModelAttribute("attachServices")
    public Iterable<AttachService> attachServices(){
        return this.attachServiceService.findAll(); }

    @GetMapping("")
    public ModelAndView list(@PageableDefault(size = 3) Pageable pageable) {
        Page<ContractDetail> contractDetails = contractDetailService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/contract-detail/list");
        modelAndView.addObject("contractDetails", contractDetails);
        return modelAndView;
    }



    @GetMapping("/create")
    public String createContractDetail(Model model){
        model.addAttribute("contractDetailDto",new ContractDetailDto());
        return "contract-detail/create";
    }

    @PostMapping("/save")
    public String createContract(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "contract-detail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.save(contractDetail);
        return "redirect:/contract-detail";
    }
}
