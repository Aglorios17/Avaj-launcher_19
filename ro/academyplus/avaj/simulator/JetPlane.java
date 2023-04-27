package ro.academyplus.avaj.simulator;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions() {
        switch (weatherTower.getWeather(super.coordinates)){
            case "SUN":
                super.coordinates.setHeight(super.coordinates.getHeight() + 2);
                super.coordinates.setLatitude(super.coordinates.getLatitude() + 10);
                System.out.println("JetPlane#"+ super.name +" (" + super.id + "):" + " I'm feeling supersonic, gotta love the sunny skies!");
                break;               
            case "RAIN":
                super.coordinates.setLatitude(super.coordinates.getLatitude() + 5);
                System.out.println("JetPlane#"+ super.name +" (" + super.id + "):" + " I hope the rain doesn't wash off my new coat of paint!");
                break;
            case "FOG":
                super.coordinates.setLatitude(super.coordinates.getLatitude() + 1);
                System.out.println("JetPlane#"+ super.name +" (" + super.id + "):" + " I feel like a fish in a cloud-filled aquarium up here!");
                break;
            case "SNOW":
                super.coordinates.setHeight(super.coordinates.getHeight() - 7);
                System.out.println("JetPlane#"+ super.name +" (" + super.id + "):" + " I'm a JetPlane, not a SnowPlane!");
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
    public String gettype() { return "JetPlane"; }
}
