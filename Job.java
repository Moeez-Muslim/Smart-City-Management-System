package application;

public class Job {
    private String title;
    private String description;

    // Default constructor
    public Job() {
    }

    // Parameterized constructor
    public Job(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void Display()
    {
    	System.out.println(this.title);
    	System.out.println(this.description);
    	System.out.println("\n");
    }
}

