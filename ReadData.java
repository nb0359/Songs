import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadData{
    public void getData(){
        try{
            int count = 1;
            int longestName = 0;
            
            Scanner in = new Scanner(new File("songsANSI.csv"));

            in.nextLine();
            while (in.hasNext()) {
                String line = in.nextLine();
                String artist = line.split(";")[0];
                String title = line.split(";")[1];
                int year = Integer.parseInt(line.split(";")[2]);
                String genre = line.split(";")[3];
                int length = Integer.parseInt(line.split(";")[4]);
                double shakeability = Double.parseDouble(line.split(";")[5]);
                double obscene = Double.parseDouble(line.split(";")[6]);
                double danceability = Double.parseDouble(line.split(";")[7]);
                double loudness = Double.parseDouble(line.split(";")[8]);
                String topic = line.split(";")[9];


                songs[count] = new Song(artist,title,year,genre,length,shakeability,obscene,danceability,loudness,topic);
                
                System.out.println(count + ": " + line.split(";")[0]);
                count++;
                int length = line.length();
                if (line.length()>longestName){
                    length = longestName;
                    

                }
                else{
                    longestName = longestName;
                }



                


        }
        System.out.println("The longest name is: "+ longestName);
        System.out.println("The total songs are: "+count);
        System.out.println(songs[298].getTitle());
            
        in.close();

        }
        catch(IOException e){
            System.out.println("Error in file reading");
            
        }

        

    
    }
}


