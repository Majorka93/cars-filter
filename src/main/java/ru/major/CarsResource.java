package ru.major;

import java.io.FileNotFoundException;
import java.util.List;

public interface CarsResource {

    /**
     * Метод возвращает список всех автомобилей
     * @return
     */
    List<Car> findAllCars() throws FileNotFoundException;

}
