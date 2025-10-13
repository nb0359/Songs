# Songs

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadData{
    public void getData(){
        try{
            int count = 1;
            int longestName = 0;
            
            Scanner in = new Scanner(new File("songsANSI.csv"));

            while (in.hasNext()) {
                String line = in.nextLine();
                System.out.println(count + ": " + line.split(",")[0]);
                count++;
                int length = line.length();
                if (line.length()>longestName){
                    length = longestName;
                    

                }
                else{
                    longestName = longestName;
                }
                System.out.println(longestName);
        }

        in.close();

        }
        catch(IOException e){
            System.out.println("Error in file reading");
            
        }

        

    
    }
}
