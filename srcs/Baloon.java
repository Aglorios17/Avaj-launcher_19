package srcs;

public class Baloon extends Aircraft {
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions() {
        switch (weatherTower.getWeather(super.coordinates)){
            case "SUN":
                super.coordinates.setHeight(super.coordinates.getHeight() + 4);
                super.coordinates.setLongitude(super.coordinates.getLongitude() + 2);
                System.out.println("Baloon#"+ super.name +" (" + super.id + "):" + " I'm ballooning with joy in this sunny, sky-high paradise!");
                break;               
            case "RAIN":
                super.coordinates.setHeight(super.coordinates.getHeight() - 5);
                System.out.println("Baloon#"+ super.name +" (" + super.id + "):" + " I guess I picked the wrong day for an up-in-the-air car wash!");
                break;
            case "FOG":
                super.coordinates.setHeight(super.coordinates.getHeight() - 3);
                System.out.println("Baloon#"+ super.name +" (" + super.id + "):" + " I didn't sign up for this! I thought I was lighter than air, not fog!");
                break;
                case "SNOW":
                super.coordinates.setHeight(super.coordinates.getHeight() - 15);
                System.out.println("Baloon#"+ super.name +" (" + super.id + "):" + " Why did I think hot air rises in a snowstorm?");
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
    public String gettype() { return "Baloon"; }
}
