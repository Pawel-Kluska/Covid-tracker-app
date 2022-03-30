package com.pawell.CovidTracker.Controllers;

import com.pawell.CovidTracker.Services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {

    @Autowired
    private CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        return "home";
    }
}
