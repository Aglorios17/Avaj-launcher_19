package srcs;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import srcs.AircraftFactory;
import srcs.Coordinates;

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
            {
                System.out.println("Arguments error occurred.");
                return ;
            }
            File myObj = new File("scenario.txt");
            Scanner myReader = new Scanner(myObj);
            Flyable[] arr_Aircraft;
            count = 0;
            while (myReader.hasNextLine()) {
                String arr[] = myReader.nextLine().split(" ");
                System.out.print("current line : ");
                System.out.println(arr[0]);
                if (isNumeric(arr[0]))
                {
                    System.out.println("debug : in number");
                    if (count == 1)
                        throw new Exception("Runs number error.");
                    count += 1;
                    runs = Integer.parseInt(arr[0]);

                }
                else if (arr[0].equals("Baloon") || arr[0].equals("Helicopter") || arr[0].equals("JetPlane"))
                {
                    System.out.println("debug : in aircraft");
                    int longitude = Integer.parseInt(arr[2]);
                    int latitude = Integer.parseInt(arr[3]);
                    int height = Integer.parseInt(arr[4]);
                    System.out.println("debug : coord : " + longitude + " "+ latitude +" "+ height);
                    if (longitude < 0 || latitude < 0 || height < 0)
                        throw new Exception("Coordinates error.");
                    if (height > 100)
                        height = 100;
                    Coordinates values = new Coordinates(longitude, latitude, height);

                }
                else
                    throw new Exception("Aircraft type error.");
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error file occurred.");
            return ;
          } catch (Exception e) {
            System.out.println("An error occurred.");
            System.out.println(e.getMessage());
          }
    }
}
