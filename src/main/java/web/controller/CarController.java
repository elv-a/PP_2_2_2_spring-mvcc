package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ServiceCar;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String carsAll(@RequestParam(value = "count", defaultValue = "5") int allCars, Model model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("Bmw", "Black", 256));
        list.add(new Car("Ford", "Grey", 250));
        list.add(new Car("Ferrari", "Red", 289));
        list.add(new Car("Matiz", "Yellow", 222));
        list.add(new Car("Toyota", "Blue", 251));
        list = ServiceCar.getCar(list, allCars);
        model.addAttribute("list", list);
        return "cars";
    }
}
