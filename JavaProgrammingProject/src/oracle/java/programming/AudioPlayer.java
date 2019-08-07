package oracle.java.programming;

public class AudioPlayer extends Product implements MultimediaControl, java.lang.Comparable<Product>
{
    private String audioSpecification;
    private ItemType mediaType;

    public AudioPlayer(String name, String audioSpecification)
    {
        super(name);
        this.audioSpecification=audioSpecification;
        this.mediaType=ItemType.Audio;
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
        System.out.println("Playing previous song...");
    }

    @Override
    public void next()
    {
        System.out.println("Playing next song...");
    }
    
    
    
    //TODO sorting
    @Override
    public int compareTo(Product AP)
    {
        if(this.getName().compareTo(AP.getName())<0)
            return -1;
        if(this.getName().compareTo(AP.getName())==0)
            return 0;
        return 1;
    }
    
    
    @Override
    public String toString()
    {
        return super.toString()+
               "\nAudio Specification: "+ this.audioSpecification+
               "\nItem Type: "+ this.mediaType;
    }
    
    
}
