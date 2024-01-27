package application;

public class AcademicInstitutions 
{
    private String type;
    private String name;
    private String location;
    private int capacity;

    // Parameterized Constructor
    public AcademicInstitutions(String type, String name, String location, int capacity) 
    {
        this.type = type;
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    // Setter methods
    public void setType(String type) 
    {
        this.type = type;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setLocation(String location) 
    
    {
        this.location = location;
    }

    public void setCapacity(int capacity) 
    {
        this.capacity = capacity;
    }

    // Getter methods
    public String getType() 
    {
        return type;
    }

    public String getName() 
    {
        return name;
    }

    public String getLocation() 
    {
        return location;
    }

    public int getCapacity() 
    {
        return capacity;
    }
    
    public void Display()
    {
    	System.out.println(this.name);
    	System.out.println(this.type);
    	System.out.println(this.location);
    	System.out.println("Capacity of " + this.capacity);
    	System.out.println("\n");
    }
}
