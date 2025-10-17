import java.io.*;
import java.util.*;


public class ReadData {
    public static ArrayList<Song> readSongsFromFile(String filename) {
        ArrayList<Song> songs = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                
                
                String[] values = line.split(":"); // Split by semi-colon
                
                // Make sure we have enough columns
                if (values.length >= 9) {
                    try {
                        // Parse each field
                        String artistName = values[0];
                        String trackName = values[1];
                        int releaseDate = Integer.parseInt(values[2].trim());
                        String genre = values[3];
                        int len = Integer.parseInt(values[4].trim());
                        double shakeTheAudience = Double.parseDouble(values[5].trim());
                        double obscene = Double.parseDouble(values[6].trim());
                        double danceability = Double.parseDouble(values[7].trim());
                        double loudness = Double.parseDouble(values[8].trim());
                        String topic = values.length > 9 ? values[9] : "";
                        
                        // Create Song object and add to list
                        Song song = new Song(artistName, trackName, releaseDate, 
                                           genre, len, shakeTheAudience, obscene, 
                                           danceability, loudness, topic);
                        songs.add(song);
                        
                    } catch (NumberFormatException e) {
                        // Skip rows with bad data
                        System.err.println("Skipping row with bad data: " + line);
                    }
                }
            }
            
            System.out.println("Successfully loaded " + songs.size() + " songs!");
            
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return songs;
    }
    
    public static void main(String[] args) {
        String filename = "songs20252026.csv";
        ArrayList<Song> songs = readSongsFromFile(filename);
        
        System.out.println("\n=== First 5 Songs ===");
        for (int i = 0; i < Math.min(5, songs.size()); i++) {
            Song s = songs.get(i);
            System.out.println(s);
            System.out.println("  Length: " + s.getLen() + "s");
            System.out.println("  Danceability: " + s.getDanceability());
            System.out.println("  Loudness: " + s.getLoudness());
            System.out.println();
        }
    }
}