package srcs;

//import java.util.ArrayList;

public abstract class Flyable {
    //public ArrayList<Aircraft> AllAircraft;
    protected WeatherTower WeatherTower;
    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower) {}
}
