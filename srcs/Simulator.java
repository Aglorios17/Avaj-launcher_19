package srcs;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Simulator {   
    public static void main(String[] args) {
        try {
            int count = 0;
            int runs = 0; 

            if (args.length != 1)
                throw new Exception("Arguments error.");
    
            String filePath = new String(args[0]);
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            ArrayList<Flyable[]> Flyables = new ArrayList<Flyable[]>();
    
            count = 0;
            for (String line : lines) {
                if (line.isBlank() || line.trim().isEmpty())
                    continue;

                String arr[] = line.split(" ");

                if (count == 0)
                {
                    if (count == 1 || arr.length != 1)
                        throw new Exception("Runs number error.");
                    count += 1;
                    runs = Integer.parseInt(arr[0]);
                }
                else if (arr[0].equals("Baloon") || arr[0].equals("Helicopter") || arr[0].equals("JetPlane"))
                {
                    if (arr.length != 5)
                        throw new Exception("Aircraft arguments error.");

                    int longitude = Integer.parseInt(arr[2]);
                    int latitude = Integer.parseInt(arr[3]);
                    int height = Integer.parseInt(arr[4]);

                    if (longitude < 0 || latitude < 0 || height < 0)
                        throw new Exception("Coordinates error.");
                    if (height > 100)
                        height = 100;

                    Coordinates coor = new Coordinates(longitude, latitude, height);
                    AircraftFactory myFactory = new AircraftFactory();
                    Flyables.add(myFactory.newAircraft(arr[0], arr[1], coor));

                }
                else
                    throw new Exception("Aircraft type error.");
            }
            System.out.println("Number of runs : " + runs);
            for (Flyable[] aircrafts : Flyables) {
                for (Flyable aircraft : aircrafts) {
                  System.out.println(aircraft);
                }
            }

          } catch (Exception e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
          }
    }
}
