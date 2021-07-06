import java.io.*;
import java.util.*;


public class FileCarsResource implements CarsResource {



    @Override
    public List<Car> findAllCars() throws FileNotFoundException {
        //List <Car> ImpData = new ArrayList<>();
        Map<String,Car> fileCarMap = new HashMap<>();
        try {
            String str = null;
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\s0w1n\\Desktop\\carsDB.txt"));

            while ((str = br.readLine()) != null) {
                String[] list = str.split(";");
                int i = Integer.parseInt(list[2].trim());
                int i1 = Integer.parseInt(list[3].trim());
                Car carFromFile = new Car(list[0], list[1], i, i1);
                fileCarMap.put(carFromFile.toString(),carFromFile);





            }
            br.close();
        } catch (IOException exc) {
            throw new IllegalArgumentException();
//            System.out.println("IO error!" + exc);
//            return new Car[0];
        }
        return new ArrayList<>(fileCarMap.values());

    }
}
