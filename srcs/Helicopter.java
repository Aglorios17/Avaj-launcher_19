package srcs;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions() {
        switch (WeatherProvider.getWeatherProvider().getCurrentWeather(super.coordinates)){
            case "SUN":
                super.coordinates.setHeight(super.coordinates.getHeight() + 2);
                super.coordinates.setLongitude(super.coordinates.getLongitude() + 10);
                System.out.println("Helicopter#"+ super.name +" (" + super.id + "):" + " I'm feeling so fly, I think I'll go for a rotor-cruise!");
                break;               
            case "RAIN":
                super.coordinates.setLongitude(super.coordinates.getLongitude() + 5);
                System.out.println("Helicopter#"+ super.name +" (" + super.id + "):" + " I guess it's raining cats and helicopters now!");
                break;
            case "FOG":
                super.coordinates.setLongitude(super.coordinates.getLongitude() + 1);
                System.out.println("Helicopter#"+ super.name +" (" + super.id + "):" + " Looks like I need to switch on my roto-lights!");
                break;
            case "SNOW":
                super.coordinates.setHeight(super.coordinates.getHeight() - 12);
                System.out.println("Helicopter#"+ super.name +" (" + super.id + "):" + " Why did I think flying in a winter wonderland was a good idea?");
                break;
        }
    }
    @Override
    public long getid() { return super.id; }
    @Override
    public String getname() { return super.name; }
    @Override
    public Coordinates getcoordinates() { return super.coordinates; }
    @Override
    public String gettype() { return "Helicopter"; }
}
