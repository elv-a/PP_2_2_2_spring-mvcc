package web.service;

import model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCarImpl implements ServiceCar {
    private final List<Car> list;

    public ServiceCarImpl() {
        list = new ArrayList<>();
        list.add(new Car("Bmw", "Black", 256));
        list.add(new Car("Ford", "Grey", 250));
        list.add(new Car("Ferrari", "Red", 289));
        list.add(new Car("Matiz", "Yellow", 222));
        list.add(new Car("Toyota", "Blue", 251));
    }

    @Override
    public List<Car> getCar(int number) {
        if (number == 0 || number > 5) return list;
        return list.stream().limit(number).collect(Collectors.toList());
    }
}
