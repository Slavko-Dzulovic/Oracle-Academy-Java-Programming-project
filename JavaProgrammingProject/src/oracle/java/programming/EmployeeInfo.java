package oracle.java.programming;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeInfo
{
    private Scanner in;
    private StringBuilder name;
    private String code;
    private String deptId;
    private Pattern p;
    
    public EmployeeInfo()
    {
        this.in=new Scanner(System.in);
        
        p=Pattern.compile("[A-Z][a-z]{3}[0-9]{2}");
        setName();
        createEmployeeCode(this.name);
        setDeptId();
        
        in.close();
    }
    
    
    //Getters
    public String getCode()
    {
        return this.code;
    }
    public StringBuilder getName()
    {
        return this.name;
    }
    private String getId()
    {
        return this.deptId;
    }
    
    
    //Name and Employee Code
    private void setName()
    {
        this.name=new StringBuilder(inputName());
    }
    
    private String inputName()
    {
        System.out.println("Enter employee name: ");
        return in.nextLine();
    }
    
    private boolean checkName(StringBuilder name)
    {
        String strName=name.toString();
        for(int i=0;i<strName.length();i++)
            if(strName.charAt(i)==' ')
                return true;
        return false;
        //return strName.matches("[A-Z][a-z]*\\\\u0020{1}[A-Z][a-z]*");
    }
    
    private void createEmployeeCode(StringBuilder name)
    {
        System.out.println("Parsing name: \""+this.name+"\"...");
        int firstSpace=0;
        if(checkName(name))
        {
            for(int i=0;i<name.length();i++)
                if(name.charAt(i)==' ')
                {
                    firstSpace=i;
                    break;
                }
            this.code=name.charAt(0)+name.substring(firstSpace+1, name.length());
        }
        else this.code="guest";
    }
    
    
    
    //DeptID
    public String getDeptId()
    {
        System.out.println("\nEnter employee's department code: ");
        return in.nextLine();
    }
    
    private void setDeptId()
    {
        String ID=getDeptId();
        if(validId(ID))
            this.deptId=ID;
        else this.deptId="None01";
    }
    
    private boolean validId(String id)
    {
        return id.matches(p.toString());
    }
    
    
    public String reverseString(String id)
    {
        if(validId(this.deptId))
        {
            if(id.isEmpty())
                return id;
            return reverseString(id.substring(1))+id.charAt(0);
        }
        return "10enoN";
    }
    
    
    
    @Override
    public String toString()
    {
        return "\nEmployee data: " +
               "\n\tName: "+this.name+
               "\n\tCode: "+this.code+
               "\n\tDepartment ID: "+this.deptId;
    }
    
    public String toFile()
    {
        return "\nEmployee data: " +
               "\n\tName: "+this.name+
               "\n\tCode: "+this.code+
               "\n\tDepartment ID: " +reverseString(this.deptId)+ " - (encrypted)";
        //po zahtevima projekta, deptId u fajlu treba da bude sacuvano kao reverzni string
    }
    
    
    
    
    
}
