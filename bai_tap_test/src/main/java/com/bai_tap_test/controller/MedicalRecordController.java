package com.bai_tap_test.controller;

import com.bai_tap_test.dto.MedicalRecordDto;
import com.bai_tap_test.dto.PatientDto;
import com.bai_tap_test.model.MedicalRecord;
import com.bai_tap_test.model.Patient;
import com.bai_tap_test.service.IMedicalRecordService;
import com.bai_tap_test.service.IPatientService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class MedicalRecordController {
    @Autowired
    private IMedicalRecordService medicalRecordService;
    @Autowired
    private IPatientService patientService;

    @ModelAttribute("patients")
    public Iterable<Patient> patients() {
        return this.patientService.findAll();
    }

    @GetMapping({"", "/search"})
    public ModelAndView list(@PageableDefault(value = 3) Pageable pageable,
                             @RequestParam(value = "medicalRecordCode", defaultValue = "", required = false) String medicalRecordCode,
                             @RequestParam(value = "fromDate", defaultValue = "1900-01-01", required = false) String fromDate,
                             @RequestParam(value = "toDate", defaultValue = "3000-01-01", required = false) String toDate) {
        Page<MedicalRecord> medicalRecords = this.medicalRecordService.findAllMedicalRecord(pageable, medicalRecordCode, fromDate, toDate);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("medicalRecords", medicalRecords);
        modelAndView.addObject("medicalRecordCode", medicalRecordCode);
        modelAndView.addObject("fromDate", fromDate);
        modelAndView.addObject("toDate", toDate);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("medicalRecordDto", new MedicalRecordDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String create(@Valid @ModelAttribute MedicalRecordDto medicalRecordDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        PatientDto patientDto = medicalRecordDto.getPatientDto();
//        patientDto.setPatientService(patientService);
//        patientDto.validate(patientDto,bindingResult);
//        if(bindingResult.hasFieldErrors()){
//            return "/create";
//        }
//        medicalRecordDto.setPatientDto(patientDto);
        medicalRecordDto.setMedicalRecordService(medicalRecordService);
        medicalRecordDto.validate(medicalRecordDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        MedicalRecord medicalRecord = new MedicalRecord();
        Patient patient = new Patient();
        BeanUtils.copyProperties(medicalRecordDto.getPatientDto(), patient);
        patientService.save(patient);
        BeanUtils.copyProperties(medicalRecordDto, medicalRecord);
        medicalRecord.setPatient(patient);
        medicalRecordService.save(medicalRecord);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/search";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") Long idMedicalRecord){
        MedicalRecord medicalRecord = medicalRecordService.findById(idMedicalRecord).orElse(null);
        medicalRecord.setDeleteFlag(true);
        medicalRecordService.save(medicalRecord);
        return "redirect:/search";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiple(@RequestParam String idMultiple) {
        String[] arr = idMultiple.split(",");
        for (int i = 0; i < arr.length; i++) {
            MedicalRecord medicalRecord = this.medicalRecordService.findById(Long.valueOf(arr[i])).orElse(null);
            if(medicalRecord!=null){
                medicalRecord.setDeleteFlag(true);
                this.medicalRecordService.save(medicalRecord);
            }
        }
        return "redirect:/search";
    }

}
