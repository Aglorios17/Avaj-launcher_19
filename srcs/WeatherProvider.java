package srcs;

public class WeatherProvider {
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private WeatherProvider() {}
    public String getCurrentWeather(Coordinates p_coordinates){
        int sum = (p_coordinates.getHeight() + p_coordinates.getLatitude() + p_coordinates.getLongitude()) / 4;

//        System.out.println(sum);

        if (sum < 25) {
            return (weather[1]);
        } else if (sum < 50) {
            return (weather[0]);
        } else if (sum < 75) {
            return (weather[2]);
        } else {
            return (weather[3]);
        }
    }
    public static WeatherProvider getWeatherProvider() {
        WeatherProvider weather = new WeatherProvider();
        return weather;
    }
}
