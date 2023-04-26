package srcs;

public interface Flyable {
    //protected WeatherTower weatherTower;
    public abstract void updateConditions();
    public void registerTower(WeatherTower[] p_tower);
}
