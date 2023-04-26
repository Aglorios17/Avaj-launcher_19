package srcs;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(p_coordinates);
    }
    public void changeWeather() {}
}
