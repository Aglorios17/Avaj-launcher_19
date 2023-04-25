package srcs;
import srcs.Baloon;
import srcs.JetPlane;
import srcs.Helicopter;
import srcs.Flyable;

public class AircraftFactory {
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        if (p_type == "Baloon")
            return new Baloon(11, p_name, p_coordinates);
        else if (p_type == "Helicopter")
            return new Helicopter(11, p_name, p_coordinates);
        else if (p_type == "JetPlane")
            return new JetPlane(11, p_name, p_coordinates);
        else
            return null;
    }
}
