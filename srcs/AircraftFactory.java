package srcs;
import java.util.Random;

public class AircraftFactory {
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates){

        long generateid = new Random().nextLong();
        if (p_type == "Baloon")
            return new Baloon(generateid, p_name, p_coordinates);
        else if (p_type == "Helicopter")
            return new Helicopter(generateid, p_name, p_coordinates);
        else if (p_type == "JetPlane")
            return new JetPlane(generateid, p_name, p_coordinates);
        else
            return null;
    }
}
