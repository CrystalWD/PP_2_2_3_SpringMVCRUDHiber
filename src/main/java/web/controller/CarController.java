package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarServiceImp;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/car")
    public String printCar(@RequestParam (value = "count",required = false) Integer count,
                           Model model) {
        if(count == null){
            return "car";
        } else if (count>5) {
            count = 5;
        }
        model.addAttribute("cars", new CarServiceImp().getCarList(count));
        return "car";
    }

}
