package ru.major;

import java.io.FileNotFoundException;
import java.util.List;

public class Dromru {

    public static void main(String[] args) throws FileNotFoundException {

        StringBuilder buf = new StringBuilder("Вы ищете авто:");
        outOnDisplay(buf, args[0]);
        outOnDisplay(buf, args[1]);
        outOnDisplay(buf, args[2]);
        outOnDisplay(buf, args[3]);
        outOnDisplay(buf, args[4]);

        System.out.println(buf);


        if (args.length == 5) {


            int engineFrom = parsing(getDefault(args[2], "0"), "двигатель ОТ");
            int engineTo = parsing(getDefault(args[3], "99999"), "двигатель ДО");
            int year = parsing(getDefault(args[4], "0"), "Год выпуска");


            Filter filter = new Filter(args[0], args[1], engineFrom, engineTo, year);

            CarsResource carsResource = new DromCarsResource();
            filterCars(carsResource, filter);


        } else {
            throw new IllegalArgumentException();
        }

    }


    public static void outOnDisplay(StringBuilder buf, String str) {
        if (!str.equals("")) {
            buf.append(" ").append(str);
        }
    }

    public static String getDefault(String str, String def) {

        if (str.isEmpty()) {
            return def;

        }
        return str;
    }

    public static int parsing(String args, String name) {


        try {

            return Integer.parseInt(args);


        } catch (NumberFormatException e) {
            System.out.println("Неправильно заполнена поле " + name + " " + args);
            System.exit(1);
        }
        return 0;


    }


    private static void filterCars(CarsResource carsResource, Filter filter) throws FileNotFoundException {
        CarFilter carFilter = new CarFilter();
        List<Car> allCars = carsResource.findAllCars();
        List<Car> carsFilteredByMarka = carFilter.filter(filter, allCars);


        for (Car item : carsFilteredByMarka) {
            System.out.println("ваш авто: " + item.toString());
        }
    }


}
