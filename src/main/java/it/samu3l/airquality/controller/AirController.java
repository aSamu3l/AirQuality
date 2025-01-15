package it.samu3l.airquality.controller;

import it.samu3l.airquality.service.IAirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class AirController {
    @Autowired
    private IAirService airService;

    @RequestMapping("all")
    public String all(Model model, @RequestParam(value = "room", required = false) String room) {
        if (room != null)
            model.addAttribute("measurements", airService.getAllByRoom(room));
        else
            model.addAttribute("measurements", airService.getAll());

        return "index";
    }

    @RequestMapping("")
    public String today(Model model, @RequestParam(value = "room", required = false) String room) {
        if (room != null)
            model.addAttribute("measurements", airService.getTodayMeasurementsByRoom(room));
        else
            model.addAttribute("measurements", airService.getTodayMeasurements());

        return "index";
    }
}
