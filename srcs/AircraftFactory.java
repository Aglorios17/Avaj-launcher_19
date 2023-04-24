package srcs;
import srcs.Coordinates;
import srcs.Flyable;

public class AircraftFactory {
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        return new Flyable();
    }
}
