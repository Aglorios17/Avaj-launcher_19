package ro.academyplus.avaj.simulator;

import java.util.Arrays;

public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private WeatherProvider() {}
    public String getCurrentWeather(Coordinates p_coordinates){
        return weather[(p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) % 4];
    }
    public static WeatherProvider getWeatherProvider() {
        WeatherProvider weather = new WeatherProvider();
        return weather;
    }
    public void getActualWeather()
    {
        System.out.println("Actual weather : " + Arrays.toString(weather));
    }
}
