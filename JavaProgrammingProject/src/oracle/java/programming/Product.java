package oracle.java.programming;

import java.util.Date;
import java.util.List;

public abstract class Product implements Item, Comparable<Product>
{
    private String name;
    private int serialNumber;
    private String manufacturer="Oracl Production";
    private Date manufacturedOn;

    private static int currentProductionNumber=0;

    public Product(String name)
    {
        this.name=name;
        this.serialNumber=currentProductionNumber;
        currentProductionNumber++;
        this.manufacturedOn=new Date();
    }
    
    
    //TODO extra step 17
    public static void printType(List<? extends Product> list, Object o)
    {
    
    }
    
    
    
    @Override
    public void setProductionNumber(int prodNo)
    {
        Product.currentProductionNumber=prodNo;
    }

    static public int getProductionNumber()
    {
    	return Product.currentProductionNumber;
    }
    
    @Override
    public void setName(String name)
    {
        this.name=name;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public Date getManufactureDate()
    {
        return this.manufacturedOn;
    }

    @Override
    public int getSerialNumber()
    {
        return this.serialNumber;
    }
    
    
    @Override
    public int compareTo(Product P)
    {
        if(this.name.compareTo(P.name)<0)
            return -1;
        if(this.name.compareTo(P.name)==0)
            return 0;
        return 1;
    }
    
    @Override
    public String toString()
    {
        return "\nManufacturer: "+ this.manufacturer+
               "\nSerial Number: "+ this.serialNumber+
               "\nDate: "+ this.manufacturedOn+
               "\nName: "+ this.name;
    }
}
