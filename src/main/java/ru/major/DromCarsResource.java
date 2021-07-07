package ru.major;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DromCarsResource implements CarsResource {

//    https://auto.drom.ru/audi/all/?minyear=2012&maxyear=2021

    @Override
    public List<Car> findAllCars() throws FileNotFoundException {

        List<Car> result = new ArrayList<>();

        try {
//            var doc = Jsoup.connect("https://irr.ru/cars/passenger/bmw/").get();
//            var cars = doc.select(".listing__item");
            Document doc = Jsoup.connect("https://auto.drom.ru/bmw/all/?minyear=2016&maxyear=2021").get();
            Elements cars = doc.select(".css-1psewqh");
            for (var car : cars){
                String title = car.select(".css-1svsmzw").text();
                String[] splitTitle = title.split(",");
                String marka = splitTitle[0].split(" ")[0];
                String model = splitTitle[0].replace(marka, "").trim();
                Integer year = Integer.parseInt(splitTitle[1].trim());
                String engineTmp = car.select(".css-6af2p9").get(0).text();
                String[] engineArray = engineTmp.split("\\(");
                String horsePower;
                if (engineArray.length > 1) {
                    horsePower = engineTmp.split("\\(")[1].split(" ")[0];
                } else {
                    horsePower = engineTmp.split(" ")[0];
                }

                result.add(new Car(marka, model, Integer.parseInt(horsePower), year));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
