package srcs;
import srcs.WeatherTower;

public abstract class Flyable {
    protected WeatherTower WeatherTower;
    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower) {}
}
