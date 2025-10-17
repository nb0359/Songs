public class Song {
    private String artistName;
    private String trackName;
    private int releaseDate;
    private String genre;
    private int len;
    private double shakeTheAudience;
    private double obscene;
    private double danceability;
    private double loudness;
    private String topic;
    
    public Song(String artistName, String trackName, int releaseDate, 
                String genre, int len, double shakeTheAudience, 
                double obscene, double danceability, double loudness, 
                String topic) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.len = len;
        this.shakeTheAudience = shakeTheAudience;
        this.obscene = obscene;
        this.danceability = danceability;
        this.loudness = loudness;
        this.topic = topic;
    }
    
    public String getArtistName() {
        return artistName;
    }
    
    public String getTrackName() {
        return trackName;
    }
    
    public int getReleaseDate() {
        return releaseDate;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public int getLen() {
        return len;
    }
    
    public double getShakeTheAudience() {
        return shakeTheAudience;
    }
    
    public double getObscene() {
        return obscene;
    }
    
    public double getDanceability() {
        return danceability;
    }
    
    public double getLoudness() {
        return loudness;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public int getDecade() {
        return (releaseDate / 10) * 10;
    }
    
    
}