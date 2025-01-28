package web.controller;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ServiceCar;
import web.service.ServiceCarImpl;


import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    private ServiceCar serviceCar;

    @Autowired
    public CarController(ServiceCar serviceCar) {
        this.serviceCar = serviceCar;
    }

    @GetMapping("/cars")
    public String carsAll(@RequestParam(value = "count", defaultValue = "5")int allCars, Model model) {
        List<Car> list = serviceCar.getCar(allCars);
        model.addAttribute("list", list);
        return "cars";
    }
}

