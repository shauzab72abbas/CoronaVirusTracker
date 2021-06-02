package com.example.coronavirustracker.models.controllers;

import com.example.coronavirustracker.models.LocationState;
import com.example.coronavirustracker.services.CoronoaVirusDataService;

@Controller
public class HomeController {

    @Autowired
    CoronoaVirusDataService coronoaVirusDataService;
    @GetMapping("/")
    public String Home(Model model){
       List<LocationState> allStats=coronoaVirusDataService.getAllstats();
       int totalReportedCases=allStats.stream().mapToInt(stat->stat.getLatestTotalCases()).sum();
        int totalNewCases=allStats.stream().mapToInt(stat->stat.setDiffFromPrevDay()).sum();
       model.addAttribute(s:"locationStats",allStats);
       model.addAttribute(s:"totalReportedCases",totalReportedCases);
        model.addAttribute(s:"totalNewCases",totalNewCases);
       return "home";
    }
}
