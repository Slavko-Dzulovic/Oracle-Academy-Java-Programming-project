package oracle.java.programming;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ViewFileInfo
{
    public static void main(String[] args)
    {
        Path p=Paths.get("C:\\LineTests\\TestResults.txt");
        String line;
        System.out.println("Trying to read file--- "+p.toString());
        
        try(BufferedReader bReader=new BufferedReader(new FileReader(p.toString())))
        {
            while((line=bReader.readLine())!=null)
                System.out.println(line);
        }
        
        catch(FileNotFoundException e)
        {
            System.out.println("File "+p.toString()+" not found...");
        }
        catch(IOException e)
        {
            System.out.println("Error reading from file!");
        }
    }
    
}
