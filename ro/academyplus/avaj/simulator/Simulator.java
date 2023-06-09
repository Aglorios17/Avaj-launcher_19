package ro.academyplus.avaj.simulator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private static int count = 0;
    private static int runs = 0;
    private static List<Flyable> flyables = new ArrayList<Flyable>();
    private static WeatherTower weatherTower = new WeatherTower();

    public static void main(String[] args) throws MyException, IOException{
        try {
            // redirect output
            PrintStream out = new PrintStream(new FileOutputStream("simulation.txt"));
            System.setOut(out);
            // PARSER
            if (args.length != 1)
                throw new MyException("Arguments error.");
    
            String filePath = new String(args[0]);
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            if (lines.size() <= 0)
                throw new MyException("Empty file error.");

            for (String line : lines) {
                if (line.isBlank() || line.trim().isEmpty())
                    continue;

                String arr[] = line.split(" ");

                if (count == 0)
                {
                    if (count == 1 || arr.length != 1)
                        throw new MyException("Runs number error.");
                    count += 1;
                    runs = Integer.parseInt(arr[0]);
                }
                else if (arr[0].equals("Baloon") || arr[0].equals("Helicopter") || arr[0].equals("JetPlane"))
                {
                    if (arr.length != 5)
                        throw new MyException("Aircraft arguments error.");

                    int longitude = Integer.parseInt(arr[2]);
                    int latitude = Integer.parseInt(arr[3]);
                    int height = Integer.parseInt(arr[4]);

                    if (longitude < 0 || latitude < 0 || height < 0)
                        throw new MyException("Coordinates error.");
                    if (height > 100)
                        height = 100;

                    Coordinates coor = new Coordinates(longitude, latitude, height);
                    AircraftFactory myFactory = new AircraftFactory();
                    flyables.add(myFactory.newAircraft(arr[0], arr[1], coor));

                }
                else
                    throw new MyException("Aircraft type error.");
            }
            
            // SIMULATOR
            /*
            System.out.println("Number of runs : " + runs);
            System.out.println("==========================");
            System.out.println("==== Start Simulation ====");
            System.out.println("==========================");
            */
            //weatherTower.actualWeather();
            for (Flyable aircraft : flyables)
            {
                weatherTower.register(aircraft);
                aircraft.registerTower(weatherTower);
            }
            for (int i = 1; i <= runs; i++)
            {
                //System.out.println("======== Run " + i + " =========");
                weatherTower.conditionChanged();
                //System.out.println("========================");
            }
            /*
            System.out.println("==========================");
            System.out.println("===== End Simulation =====");
            System.out.println("==========================");
            */
          } catch (MyException e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
          } catch (IOException e) {
			System.out.println("ERROR: I can't find " + args[0]);
          }catch (NumberFormatException e) {
            System.out.println("The string cannot be parsed as an integer.");
        }
    }
}
