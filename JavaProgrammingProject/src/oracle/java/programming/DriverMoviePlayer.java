package oracle.java.programming;

public class DriverMoviePlayer
{
    public static void main(String[] args)
    {
        MoviePlayer moviePlayer = new MoviePlayer(
                "Movie Player 1",
                new Screen("1920x1080", 60, 1),
                MonitorType.LCD);
        
        MoviePlayer moviePlayer1 = new MoviePlayer("Movie Player 2",
                                                    new Screen("1600x1200", 50,2),
                                                    MonitorType.LED);
    }
}
