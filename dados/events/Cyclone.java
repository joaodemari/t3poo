package dados.events;

public class Cyclone extends Event {
	
    private double speed;
    private double precipitation;

    public Cyclone(String codigo, String data, double latitude, double longitude, double speed, double precipitation) {
        super(codigo, data, latitude, longitude);
        this.speed = speed;
        this.precipitation = precipitation;
    }

    public double getSpeed() {
        return speed;
    }

    public double getPrecipitation() {
        return precipitation;
    }
}
