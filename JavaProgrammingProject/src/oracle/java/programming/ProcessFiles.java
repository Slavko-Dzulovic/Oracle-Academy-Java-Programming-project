package oracle.java.programming;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProcessFiles
{
    private Path p=Paths.get("C:\\LineTests");
    private Path p2=Paths.get("TestResults.txt");
    private Path p3=p.resolve(p2);
    
    
    private void createDirectory() { new File(p.toString()).mkdirs(); }
    
    public void writeFile(EmployeeInfo emp) throws IOException
    {
        createDirectory();
        System.out.println("Opening file "+p3.toString()+"\n--- writing Employee history");
        File TestResults=new File(p3.toString());
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(TestResults, true));
    
        bufferedWriter.write(emp.toFile()+"\n");
        System.out.println("Closing file");
            
        bufferedWriter.close();
    }
    
    public void writeFile(ArrayList<Product> products) throws IOException
    {
        createDirectory();
        System.out.println("Opening file "+p3.toString()+"\n--- writing Product history");
        File TestResults=new File(p3.toString());
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(TestResults, true));

        for(Product p:products)
            bufferedWriter.write(p.toString()+"\n");
        System.out.println("Closing file");
            
        bufferedWriter.close();
    }
}
