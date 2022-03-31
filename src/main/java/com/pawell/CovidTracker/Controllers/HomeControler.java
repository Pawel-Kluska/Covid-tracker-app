package com.pawell.CovidTracker.Controllers;

import com.pawell.CovidTracker.Models.LocationStats;
import com.pawell.CovidTracker.Services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeControler {

    @Autowired
    private CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/")
    public String getHome(Model model){
        List<LocationStats> locationStats = coronaVirusDataService.getAllStats();
        int allCases = locationStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int newCases = locationStats.stream().mapToInt(stat -> stat.getNewCases()).sum();
        model.addAttribute("locationStats", coronaVirusDataService.getAllStats());
        model.addAttribute("allCases", allCases);
        model.addAttribute("newCases", newCases);
        return "home";
    }
}
