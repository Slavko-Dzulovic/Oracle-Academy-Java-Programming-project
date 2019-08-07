package oracle.java.programming;

public class MoviePlayer extends Product implements MultimediaControl, java.lang.Comparable<Product>
{
    private Screen screen;
    private MonitorType type;
    
    public MoviePlayer(String name, Screen screen, MonitorType type)
    {
        super(name);
        this.screen=screen;
        this.type=type;
    }
    
    @Override
    public void play()
    {
        System.out.println("Playing");
    }
    
    @Override
    public void stop()
    {
        System.out.println("Stopped playing");
    }
    
    @Override
    public void previous()
    {
        System.out.println("Playing previous movie...");
    }
    
    @Override
    public void next()
    {
        System.out.println("Playing next movie...");
    }
    
    
    //TODO sorting
    @Override
    public int compareTo(Product MP)
    {
        if(this.getName().compareTo(MP.getName())<0)
            return -1;
        if(this.getName().compareTo(MP.getName())==0)
            return 0;
        return 1;
    }
    
    @Override
    public String toString()
    {
        return super.toString()+
                "\nScreen: "+ this.screen+
                "\nMonitor Type: "+ this.type;
    }
    
}
