package dados.events;

public class Drought extends Event {

    private double drought;

    public Drought(String codigo, String data, double latitude, double longitude, double drought) {
        super(codigo, data, latitude, longitude);
        this.drought = drought;
    }

    public double getDrought() {
        return drought;
    }
}
