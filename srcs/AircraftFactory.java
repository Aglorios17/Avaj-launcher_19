package srcs;
import srcs.Baloon;
import srcs.jetPlane;
import srcs.Helicopter;
import srcs.Flyable;

public class AircraftFactory {
    public Flyable[] newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        Flyable[] new_aircraft;
        if (p_type == "Baloon")
            new_aircraft = new Baloon(11, p_name, p_coordinates);
        else if (p_type == "Helicopter")
            new_aircraft = new Helicopter(11, p_name, p_coordinates);
        else
            new_aircraft = new jetPlane(11, p_name, p_coordinates);
        return new_aircraft;
    }
}
