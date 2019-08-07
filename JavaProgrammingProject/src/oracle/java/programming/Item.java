package oracle.java.programming;

import java.util.Date;

public interface Item
{
    String manufacturer="Oracl Production";

    void setProductionNumber(int prodNo);
    void setName(String name);
    String getName();
    Date getManufactureDate();
    int getSerialNumber();



}
