package srcs;

public class AircraftFactory {
    private static int id = 1;

    public Flyable[] newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        Flyable[] new_aircraft = new Flyable[1];

        if (p_type.equals("Baloon"))
            new_aircraft[0] = new Baloon(id++, p_name, p_coordinates);
        else if (p_type.equals("Helicopter"))
            new_aircraft[0] = new Helicopter(id++, p_name, p_coordinates);
        else if (p_type.equals("JetPlane"))
            new_aircraft[0] = new JetPlane(id++, p_name, p_coordinates);
        else
            throw new IllegalArgumentException("Invalid aircraft type: " + p_type);
        return new_aircraft;
    }
}
