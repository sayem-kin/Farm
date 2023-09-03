package com.mottakin.main.controller;

import com.mottakin.main.model.Crop;
import com.mottakin.main.service.impl.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {
    @Autowired
    private CropService cropService;
    @GetMapping("/crops")
    public String listCrops(Model model)
    {
        model.addAttribute("crops",cropService.getAllCrops());
        return "crops.html";
    }
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("allFields", cropService.getAllFields());
        return "home.html";
    }
    @PostMapping("/save")
    public String saveObj(Crop crop) {
        cropService.saveCrop(crop);
        return "redirect:/home";
    }
}
