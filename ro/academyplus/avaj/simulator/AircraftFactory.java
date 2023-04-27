package ro.academyplus.avaj.simulator;

public class AircraftFactory {
    private static int id = 1;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){

        if (p_type.equals("Baloon"))
            return new Baloon(id++, p_name, p_coordinates);
        else if (p_type.equals("Helicopter"))
            return new Helicopter(id++, p_name, p_coordinates);
        else if (p_type.equals("JetPlane"))
            return new JetPlane(id++, p_name, p_coordinates);
        else
            throw new IllegalArgumentException("Invalid aircraft type: " + p_type);
    }
}
