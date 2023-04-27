package ro.academyplus.avaj.simulator;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(p_coordinates);
    }
    public void changeWeather() {
        conditionChanged();
    }
    public void actualWeather()
    {
        WeatherProvider.getWeatherProvider().getActualWeather();
    }
}
