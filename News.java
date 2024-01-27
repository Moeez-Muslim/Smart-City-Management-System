package application;

public class News 
{
    private String title;
    private String description;

    // Parameterized Constructor
    public News(String title, String description) 
    {
        this.title = title;
        this.description = description;
    }

    // Setter methods
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    // Getter methods
    public String getTitle() 
    {
        return title;
    }

    public String getDescription() 
    {
        return description;
    }
    
    public void Display()
    {
    	System.out.println(this.title);
    	System.out.println(this.description);
    	System.out.println("\n");
    }
}

