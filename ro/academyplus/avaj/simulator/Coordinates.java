package ro.academyplus.avaj.simulator;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height){
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() { return this.longitude; }
    public int getLatitude() { return this.latitude; }
    public int getHeight() { return this.height; }

    public void setLongitude(int longitude) { this.longitude = longitude; }
    public void setLatitude(int latitude) { this.latitude = latitude; }
    public void setHeight(int height) { this.height = height > 100 ? 100 : height; }
}
