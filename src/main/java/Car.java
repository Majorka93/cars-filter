public class Car {

    private String marka;
    private String model;
    private int engine;
    private int year;

    private String transmission;

    private String carcase;

    public Car(String marka, String model, int engine, int year) {
        this.marka = marka;
        this.model = model;
        this.engine = engine;
        this.year = year;
//        this.transmission = transmission;
//        this.carcase = carcase;


    }

    public int getYear() {
        return year;
    }


    public String getMarka() {

        return marka;
    }

    public String getModel() {

        return model;
    }

    public int getEngine() {

        return engine;
    }

    @Override
    public String toString() {
        return getMarka() + " " + getModel() + " " + getEngine() + " " + getYear();
    }
}
