package oracle.java.programming;

public class DriverAudio
{
    public static void main(String[] args)
    {
        AudioPlayer player=new AudioPlayer("Sony", "mp3");
        player.play();
        player.next();
        player.previous();
        player.stop();

        System.out.println(player);
    }
}
