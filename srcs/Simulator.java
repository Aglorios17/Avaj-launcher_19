package srcs;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
import srcs.AircraftFactory;

public class Simulator {   
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    public static void main(String[] args) {
        try {
            int count = 0;
            int runs = 0; 
            if (args.length != 1)
                throw new Exception("Arguments error.");
            File myObj = new File(args[0]);
            Scanner myReader = new Scanner(myObj);
            ArrayList<Flyable> ArrAircraft;
            count = 0;
            while (myReader.hasNextLine()) {
                String arr[] = myReader.nextLine().split(" ");
                //System.out.println("current line : " + arr[0] + " lenght arr : " + arr.length);
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
                    //System.out.println("debug : in aircraft");
                    int longitude = Integer.parseInt(arr[2]);
                    int latitude = Integer.parseInt(arr[3]);
                    int height = Integer.parseInt(arr[4]);
                    //System.out.println("debug : coord : " + longitude + " "+ latitude +" "+ height);
                    if (longitude < 0 || latitude < 0 || height < 0)
                        throw new Exception("Coordinates error.");
                    if (height > 100)
                        height = 100;
                    Coordinates coor = new Coordinates(longitude, latitude, height);
                    //ArrAircraft.add(newAircraft(arr[0], arr[1], coor));

                }
                else
                    if (arr[0] != "")
                        throw new Exception("Aircraft type error.");
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error file occurred.");
          } catch (Exception e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
          }
    }
}
