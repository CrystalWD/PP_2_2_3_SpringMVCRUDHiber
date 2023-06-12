package model;

public class Car {
    private String model;
    private int series;
    private String racer;

    public Car(String model, int series, String racer) {
        this.model = model;
        this.series = series;
        this.racer = racer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getRacer() {
        return racer;
    }

    public void setRacer(String racer) {
        this.racer = racer;
    }
}
