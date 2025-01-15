package it.samu3l.airquality.controller.api;

import it.samu3l.airquality.model.AirDTO;
import it.samu3l.airquality.service.IAirService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirApiController {
    @Autowired
    private IAirService airService;

    @Value("${api.token}")
    private String apiToken;

    public AirApiController() {
    }

    @PostMapping("/add")
    public String add(@RequestBody AirDTO airDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.equals(apiToken)) {
            return "Unauthorized";
        }
        return airService.add(airDTO).toString();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id, HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.equals(apiToken)) {
            return "Unauthorized";
        }
        return airService.delete(id).toString();
    }
}
