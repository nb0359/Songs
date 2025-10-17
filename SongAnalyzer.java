import java.util.*;

public class SongAnalyzer {
    
    public static void main(String[] args) {
        
        ArrayList<Song> songs = ReadData.readSongsFromFile("songsANSI.csv");
        
        if (songs.isEmpty()) {
            System.out.println("No songs loaded. Please check the file.");
            return;
        }
        
        
        // ============================================================
        // 1. Total number of songs
        // ============================================================
        System.out.println("1. TOTAL NUMBER OF SONGS");
        System.out.println("   Total number of songs: " + songs.size());
        
        // ============================================================
        // 2. Songs from specific years
        // ============================================================
        System.out.println("\n2. SONGS FROM SPECIFIC YEARS");
        
        int count1982 = 0;
        int count2000 = 0;
        int count2015 = 0;
        
        for (Song song : songs) {
            int year = song.getReleaseDate();
            if (year == 1982) count1982++;
            if (year == 2000) count2000++;
            if (year == 2015) count2015++;
        }
        
        System.out.println("   Total songs from 1982: " + count1982);
        System.out.println("   Total songs from 2000: " + count2000);
        System.out.println("   Total songs from 2015: " + count2015);
        
        // ============================================================
        // 3. Songs with danceability > 0.80
        // ============================================================
        System.out.println("\n3. HIGH DANCEABILITY SONGS");
        
        int highDanceability = 0;
        for (Song song : songs) {
            if (song.getDanceability() > 0.80) {
                highDanceability++;
            }
        }
        System.out.println("   Songs with danceability > 0.80: " + highDanceability);
        
        // ============================================================
        // 4. Song with largest length
        // ============================================================
        System.out.println("\n4. SONG WITH LARGEST LENGTH");
        
        Song longestSong = songs.get(0);
        for (Song song : songs) {
            if (song.getLen() > longestSong.getLen()) {
                longestSong = song;
            }
        }
        System.out.println("   Artist: " + longestSong.getArtistName());
        System.out.println("   Track: " + longestSong.getTrackName());
        System.out.println("   Length: " + longestSong.getLen() + " seconds");
        System.out.println("   Year: " + longestSong.getReleaseDate());
        
        // ============================================================
        // 5. Song with lowest shakeability score
        // ============================================================
        System.out.println("\n5. SONG WITH LOWEST SHAKEABILITY SCORE");
        
        Song lowestShake = songs.get(0);
        for (Song song : songs) {
            if (song.getShakeTheAudience() < lowestShake.getShakeTheAudience()) {
                lowestShake = song;
            }
        }
        System.out.println("   Artist: " + lowestShake.getArtistName());
        System.out.println("   Track: " + lowestShake.getTrackName());
        System.out.println("   Shakeability: " + lowestShake.getShakeTheAudience());
        System.out.println("   Year: " + lowestShake.getReleaseDate());
        
        // ============================================================
        // 6. Loudest song (highest loudness rating)
        // ============================================================
        System.out.println("\n6. LOUDEST SONG");
        
        Song loudestSong = songs.get(0);
        for (Song song : songs) {
            if (song.getLoudness() > loudestSong.getLoudness()) {
                loudestSong = song;
            }
        }
        System.out.println("   Artist: " + loudestSong.getArtistName());
        System.out.println("   Track: " + loudestSong.getTrackName());
        System.out.println("   Loudness: " + loudestSong.getLoudness());
        System.out.println("   Year: " + loudestSong.getReleaseDate());
        
        // ============================================================
        // 7. Average obscenity level by decade
        // ============================================================
        System.out.println("\n7. AVERAGE OBSCENITY LEVEL BY DECADE");
        
        // Group songs by decade using a Map
        Map<Integer, ArrayList<Song>> decades = new TreeMap<>();
        for (Song song : songs) {
            int decade = song.getDecade();
            if (!decades.containsKey(decade)) {
                decades.put(decade, new ArrayList<>());
            }
            decades.get(decade).add(song);
        }
        
        // Calculate and print average for each decade
        for (Integer decade : decades.keySet()) {
            ArrayList<Song> decadeSongs = decades.get(decade);
            
            double sum = 0;
            for (Song song : decadeSongs) {
                sum += song.getObscene();
            }
            double average = sum / decadeSongs.size();
            
            System.out.printf("   %d-%d: %.6f (n=%d songs)\n", 
                decade, decade + 9, average, decadeSongs.size());
        }
        
        // ============================================================
        // 8. Songs with Michael Jackson and Whitney Houston
        // ============================================================
        System.out.println("\n8. ARTIST-SPECIFIC COUNTS");
        
        int michaelJacksonCount = 0;
        int whitneyHoustonCount = 0;
        
        for (Song song : songs) {
            String artist = song.getArtistName().toLowerCase();
            
            if (artist.contains("michael jackson")) {
                michaelJacksonCount++;
            }
            if (artist.contains("whitney houston")) {
                whitneyHoustonCount++;
            }
        }
        
        System.out.println("   Songs with Michael Jackson: " + michaelJacksonCount);
        System.out.println("   Songs with Whitney Houston: " + whitneyHoustonCount);
        
        System.out.println("\n================================================");
        System.out.println("=== ANALYSIS COMPLETE ===");
        System.out.println("================================================");
    }
}