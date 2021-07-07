package ru.major;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvitoCarsResource implements CarsResource {


    @Override
    public List<Car> findAllCars() throws FileNotFoundException {


        List<Car> result = new ArrayList<>();


        try {
            var doc = Jsoup.connect("https://www.avito.ru/moskva/avtomobili/audi?cd=1&radius=0").get();
            var cars = doc.select(".iva-item-content-m2FiN");
            for (var car : cars) {
                String title = car.select(".iva-item-titleStep-2bjuh").text();
                String[] splittitle = title.split(",");
                String marka = splittitle[0].split(" ")[0];
                String model = splittitle[0].replace(marka, "").trim();
                Integer year = Integer.parseInt(splittitle[1].trim());
                String engineTmp = car.select(".iva-item-autoParamsStep-14Mv3").get(0).text();
                String[] engineArray = engineTmp.split("\\(");
                String horsePower;
                if (engineArray.length > 1) {
                    horsePower = engineTmp.split("\\(")[1].split(" ")[0];
                } else {
                    horsePower = engineTmp.split(" ")[0];
                }

                result.add(new Car(marka, model, Integer.parseInt(horsePower), year));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
