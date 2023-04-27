package srcs;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Simulator {   
    public static void main(String[] args) {
        try {
            // PARSER
            if (args.length != 1)
                throw new Exception("Arguments error.");
    
            String filePath = new String(args[0]);
            List<String> lines = Files.readAllLines(Paths.get(filePath));

            int count = 0;
            int runs = 0; 
            List<Flyable> Flyables = new ArrayList<Flyable>();

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
            
            // SIMULATOR
            System.out.println("Number of runs : " + runs);
            for (Flyable aircrafts : Flyables)
                  System.out.println(aircrafts);
            System.out.println("==========================");
            System.out.println("==== Start Simulation ====");
            System.out.println("==========================");
            Tower T = new Tower();
            for (Flyable aircraft : Flyables)
                T.register(aircraft);
            for (int i = 1; i <= runs; i++)
            {
                System.out.println("======== Run " + i + " =========");
                for (int j = 0; j < Flyables.size(); j++)
                {
                        Flyables.get(j).updateConditions();
                        if (Flyables.get(j).getcoordinates().getHeight() <= 0)
                        {
                            T.unregister(Flyables.get(j));
                            Flyables.remove(Flyables.get(j--));
                        }
                }
                System.out.println("========================");
            }
            System.out.println("========================");
            System.out.println("==== End Simulation ====");
            System.out.println("========================");

          } catch (Exception e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
          }
    }
}
