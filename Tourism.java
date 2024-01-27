package application;

public class Tourism 
{
    private String type;
    private String name;
    private String location;

    public Tourism()
	{
		
	}
    
    Tourism(String type, String name, String location)
    {
    	this.type = type;
    	this.name = name;
    	this.location = location;
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
    
    public void Display()
    {
    	System.out.println(this.name);
    	System.out.println(this.type);
    	System.out.println(this.location);
    	System.out.println("\n");
    }
}
