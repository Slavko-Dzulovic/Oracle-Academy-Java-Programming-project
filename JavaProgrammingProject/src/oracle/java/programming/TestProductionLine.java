package oracle.java.programming;

import java.io.IOException;
import java.util.ArrayList;

public class TestProductionLine
{
    public static void main(String[] args)
    {
        EmployeeInfo empInfo=new EmployeeInfo();
        ProcessFiles processFiles=new ProcessFiles();
        ArrayList<Product> arrayList=new ArrayList<>();
        
        try
        {
            processFiles.writeFile(empInfo);
        } catch(IOException e)
        {
            System.out.println("Error writing Employee info to file!");
        }
        
        //Writing ArrayList of Products
        arrayList.add(new AudioPlayer("Audio Player Name", "mp3"));
        arrayList.add(new MoviePlayer("Movie Player Name",
                                        new Screen("1920x1080",60, 2),
                                        MonitorType.LED));
        
        try
        {
            processFiles.writeFile(arrayList);
        } catch(IOException e)
        {
            System.out.println("Error writing Employee info to file!");
        }
    
        
        System.out.println(empInfo.toString());
        
    }
}
