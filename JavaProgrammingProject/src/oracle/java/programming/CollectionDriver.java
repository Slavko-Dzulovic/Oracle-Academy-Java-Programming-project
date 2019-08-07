package oracle.java.programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionDriver
{
    //TODO i don't know why this isn't working without "extends Product"
    public static void print(List<? extends Product> list)
    {
        System.out.println("\n\nBefore sorting: ");
        for(Product x: list)
            System.out.println(x);
    
        Collections.sort(list);
    
        System.out.println("\n\nAfter sorting: ");
        for(Object x: list)
            System.out.println(x);
        
    }
    
    
    public static void main(String[] args)
    {
        ArrayList<Product> ProductArrayList = new ArrayList<>();
    
        MoviePlayer moviePlayer = new MoviePlayer(
                "Something",
                new Screen("1920x1080", 60, 1),
                MonitorType.LCD);
    
        MoviePlayer moviePlayer1 = new MoviePlayer(
                "NameThatReallyIsn'tSomething",
                new Screen("1600x1200", 50, 2),
                MonitorType.LED);
        
        Product audioPlayer = new AudioPlayer("Sony", "mp3");
        Product audioPlayer1 = new AudioPlayer("Samsung", "mp3");
        
        ProductArrayList.add(audioPlayer);
        ProductArrayList.add(audioPlayer1);
        ProductArrayList.add(moviePlayer);
        ProductArrayList.add(moviePlayer1);
    
        System.out.println("\n\nBefore sorting: ");
        for(Product x: ProductArrayList)
            System.out.println(x);
    
        Collections.sort(ProductArrayList);
        
        System.out.println("\n\nAfter sorting: ");
        for(Product x: ProductArrayList)
            System.out.println(x);
        
           
    
    }
}




