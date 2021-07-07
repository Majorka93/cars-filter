package ru.major;

public class CarsResourceFactory {
    
    public CarsResource create(String name) {
        if (name.equalsIgnoreCase("Drom")) {
            return new DromCarsResource();
        } else if (name.equalsIgnoreCase("Avito")) {
            return new AvitoCarsResource();
        } else if (name.equalsIgnoreCase("Irr")) {
            return new IrrCarsResource();
        } else {
            throw new IllegalArgumentException("Нет такого источника:" + name);
        }
    }
    
}
