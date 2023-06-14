package MVC.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import MVC.service.CarServiceImp;

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
