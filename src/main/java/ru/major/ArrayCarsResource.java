package ru.major;

import java.util.*;

public class ArrayCarsResource implements CarsResource {


    @Override
    public List<Car> findAllCars() {
        List<Car> carList = new LinkedList<>();
        carList.add(new Car("Audi", "RS7", 600, 2011));
        carList.add(new Car("Audi", "RS7", 600, 2011));
        carList.add(new Car("Audi", "RS7", 600, 2011));
        carList.add(new Car("Bmw", "m5", 599, 2011));
        carList.add(new Car("Toyota", "Camry", 999, 2011));
        carList.add(new Car("Hyudai", "accent", 10, 2011));
        carList.add(new Car("Lexus", "ES500", 450, 2011));
        carList.add(new Car("Mazda", "CX5", 150, 2010));
        carList.add(new Car("Lada", "Largus", 90, 2010));
        carList.add(new Car("Renault", "Duster", 100, 2010));
        carList.add(new Car("Ford", "Focus", 105, 2010));
        carList.add(new Car("Volvo", "CX90", 250, 2010));
        carList.add(new Car("Volvo", "CX60", 200, 2010));
        carList.add(new Car("Volvo", "CX90", 200, 2010));
        carList.add(new Car("Bmw", "m5", 11, 2010));
        carList.add(new Car("Bmw", "m5", 11, 2010));
        carList.add(new Car("Bmw", "m5", 11, 2010));
        carList.add(new Car("Bmw", "m5", 11, 2010));
        carList.add(new Car("Bmw", "m5", 11, 2010));
        carList.add(new Car("Bmw", "m5", 300, 2011));
        carList.add(new Car("Bmw", "m5", 300, 2011));
        carList.add(new Car("Bmw", "m5", 300, 2011));

        carList.get(0);
        Map<String, Car> carMap = new HashMap<>();
        for (var car : carList) {
            carMap.put(car.toString(), car);
        }

        return new ArrayList<>(carMap.values());
    }
    List <String> list = new LinkedList<>();
}

