package ro.academyplus.avaj.simulator;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }
    public abstract long getid();
    public abstract String getname();
    public abstract Coordinates getcoordinates();
    public abstract String gettype();
}
