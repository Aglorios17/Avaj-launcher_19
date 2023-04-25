package srcs;

public class WeatherProvider {
    private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
    private WeatherProvider() {}
    public String getCurrentWeather(Coordinates p_coordinates){
        // get coord
        return weather[0];
    }
}
