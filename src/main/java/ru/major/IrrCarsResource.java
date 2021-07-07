package ru.major;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IrrCarsResource implements CarsResource {


    @Override
    public List<Car> findAllCars() throws FileNotFoundException {

        List<Car> result = new ArrayList<>();

        try {
            Document doc = Jsoup.connect("https://irr.ru/cars/passenger/used/").get();
            Elements cars = doc.select(".listing__itemInner");
            for (var car : cars) {
                String title = car.select(".js-productListingProductName").text();
                String[] splitTitle = title.split(" ");
                String marka = splitTitle[0].split(" ")[0];
                String model = splitTitle[1].trim();
                String year = car.select(".listing__itemColumn_param1").text();
                String engineTmp = car.select(".listing__itemParameter_subTitle").get(0).text();
                String[] engineArray = engineTmp.split("\\(");
                String horsePower = engineArray[1].split(" ")[0];
                result.add(new Car(marka,model,Integer.parseInt(horsePower),Integer.parseInt(year)));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
