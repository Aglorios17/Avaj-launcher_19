package srcs;

public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private WeatherProvider() {}
    public WeatherProvider(Coordinates p_coordinates) {
        getCurrentWeather(p_coordinates);
    }
    public String getCurrentWeather(Coordinates p_coordinates){
        // get coord
        return weather[0];
    }
    public static WeatherProvider getWeatherProvider() {
        WeatherProvider weather = new WeatherProvider();
        return weather;
    }
}
