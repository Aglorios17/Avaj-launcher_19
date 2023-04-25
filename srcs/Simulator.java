package srcs;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import srcs.AircraftFactory;
import srcs.Coordinates;

public class Simulator {
    public static void main(String[] args) {
        try {
//            System.out.println(args.length);
//            System.out.println(args[0]);
            if (args.length != 1)
            {
                System.out.println("Arguments error occurred.");
                return ;
            }
            File myObj = new File("scenario.txt");
            Scanner myReader = new Scanner(myObj);
            Flyable[] arr_Aircraft;
            while (myReader.hasNextLine()) {
                String arr[] = myReader.nextLine().split(" ");
                System.out.println(arr[0]);
                if (arr[0] == "Baloon" || arr[0] == "Helicopter" || arr[0] == "JetPlane")
                {
                    int longitude = Integer.parseInt(arr[2]);
                    int latitude = Integer.parseInt(arr[3]);
                    int height = Integer.parseInt(arr[4]);
                    if (longitude > 0 || latitude > 0 || height < 0 || height < 100)
                    {
                        System.out.println("Coordinates error.");
                        return ;
                    }
                    Coordinates values = new Coordinates(longitude, latitude, height);
                }
                else
                {
                    System.out.println("Aircraft type error.");
                    return ;
                }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
}
