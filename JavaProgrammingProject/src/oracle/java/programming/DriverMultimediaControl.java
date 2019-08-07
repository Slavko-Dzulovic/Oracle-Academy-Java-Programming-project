package oracle.java.programming;

public class DriverMultimediaControl
{
	public static void main(String args[])
	{
		MultimediaControl player=new AudioPlayer("Samsung", "FLAC");
		player.play();
        player.next();
        player.previous();
        player.stop();
        
        player=new MoviePlayer("Grundig", 
        						new Screen("800x600", 30, 1),
        						MonitorType.LED);
        player.play();
        player.next();
        player.previous();
        player.stop();
	}	
}
