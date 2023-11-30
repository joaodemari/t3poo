package dados.events;

public class Earthquake extends Event {

    private double magnitude;

    public Earthquake(String codigo, String data, double latitude, double longitude, double magnitude) {
        super(codigo, data, latitude, longitude);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    @Override
    public String toString() {
        return super.toString() + "; Magnitude: " + magnitude;
    }
}
