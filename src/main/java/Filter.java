public class Filter {


    private String marka;
    private String model;
    private int engineFrom;
    private int engineTo;
    private int year;

    public Filter(String marka, String model, int engineFrom, int engineTo, int year) {
        this.marka = marka;
        this.model = model;
        this.engineFrom = engineFrom;
        this.engineTo = engineTo;
        this.year = year;
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

    public int getEngineFrom() {
        return engineFrom;
    }

    public int getEngineTo() {
        return engineTo;
    }
}
