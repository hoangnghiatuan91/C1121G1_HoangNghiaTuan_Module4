package com.baitaptest2.controller;

import com.baitaptest2.dto.ProductDto;
import com.baitaptest2.model.Category;
import com.baitaptest2.model.Color;
import com.baitaptest2.model.Product;
import com.baitaptest2.service.ICategoryService;
import com.baitaptest2.service.IColorService;
import com.baitaptest2.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IColorService colorService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @ModelAttribute("colors")
    public Iterable<Color> colors(){
        return colorService.findAll();
    }

    @GetMapping({"","/search"})
    public ModelAndView list(@PageableDefault(value = 3) Pageable pageable,
                             @RequestParam(value = "productName",defaultValue = "",required = false)String productName,
                             @RequestParam(value = "price",defaultValue = "",required = false) String price,
                             @RequestParam(value = "categoryName",defaultValue = "",required = false) String category,
                             @RequestParam(value = "colorName",defaultValue = "",required = false) String color){
        Page<Product>products = productService.findAllProduct(productName,price,category,color,pageable);
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("products",products);
        modelAndView.addObject("productName",productName);
        modelAndView.addObject("price",price);
        modelAndView.addObject("category",category);
        modelAndView.addObject("color",color);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("productDto", new ProductDto());
        return modelAndView;
    }
    @PostMapping("/save")
    public String create(@Valid @ModelAttribute ProductDto productDto,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.save(product);
        redirectAttributes.addFlashAttribute("callSuccessModal", true);
        return "redirect:/search";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") Long id){
        Product product = productService.findById(id).orElse(null);
        product.setDeleteFlag(true);
        productService.save(product);
        return "redirect:/search";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiple(@RequestParam String idMultiple) {
        String[] arr = idMultiple.split(",");
        for (int i = 0; i < arr.length; i++) {
            Product product = this.productService.findById(Long.valueOf(arr[i])).orElse(null);
            if(product!=null){
                product.setDeleteFlag(true);
                this.productService.save(product);
            }
        }
        return "redirect:/search";
    }
}
