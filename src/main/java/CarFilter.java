import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarFilter {



    public List<Car> filter(Filter filter, List<Car> cars) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car item : cars) {
            boolean markaEqual = filter.getMarka().isEmpty() || item.getMarka().equals(filter.getMarka());
            boolean modelEqual = filter.getModel().isEmpty() || item.getModel().equals(filter.getModel());
            boolean engineEqual = item.getEngine() >= filter.getEngineFrom() && item.getEngine() <= filter.getEngineTo();
            boolean yearEqual = filter.getYear() == 0 || item.getYear() == filter.getYear();
            if (modelEqual && markaEqual && engineEqual && yearEqual) {
                filteredCars.add(item);
            }

        }
        return filteredCars;
    }


}
