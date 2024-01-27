package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.Scanner;

public class SmartCityController 
{
    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button searchButton;

    // Add the corresponding methods for each button press
    @FXML
    private void handleAddButton() 
    {
    	SmartCity.myObj  = new Scanner(System.in);
    	System.out.println("What do you want to add?");
        System.out.println("1. Tourist attraction");
        System.out.println("2. Academic Institution");
        System.out.println("3. News");
        System.out.println("4. Job");
        System.out.print("Enter Choice: ");
        int choice = SmartCity.myObj.nextInt();
        
        switch (choice)
		{
		case 1:
		{
			System.out.print("Enter type of the tourist attraction (restaurant, park, landmark): ");
			String type = SmartCity.myObj.next();
			System.out.print("Enter name of the tourist attraction: ");
			String name = SmartCity.myObj.next();
			System.out.print("Enter location of the tourist attraction: ");
			String location = SmartCity.myObj.next();
			SmartCity.TourismList.add(new Tourism(type, name, location));
			DBhandler.insertTourism(new Tourism(type, name, location));
			
			System.out.print("Added Successfully!");
			break;
		}
		case 2:
		{
			System.out.print("Enter type of the academic institution (school, college, university, library): ");
			String type = SmartCity.myObj.next();
			System.out.print("Enter name of the academic institution: ");
			String name = SmartCity.myObj.next();
			System.out.print("Enter location of the academic institution: ");
			String location = SmartCity.myObj.next();
			System.out.print("Enter capacity of the academic institution: ");
			int capacity = SmartCity.myObj.nextInt();
			
			SmartCity.InstitutionList.add(new AcademicInstitutions(type, name, location, capacity));
			DBhandler.insertAcademicInstitutions(new AcademicInstitutions(type, name, location, capacity));
			
			System.out.print("Added Successfully!");
			break;
		}
		case 3:
		{
			System.out.print("Enter news title: ");
			String title = SmartCity.myObj.next();
			System.out.print("Enter news description: ");
			String description = SmartCity.myObj.next();
			SmartCity.NewsList.add(new News(title, description));
			DBhandler.insertNews(new News(title, description));
			
			System.out.print("Added Successfully!");
			break;
		}
		case 4:
		{
			System.out.print("Enter job title: ");
			String title = SmartCity.myObj.next();
			System.out.print("Enter job description: ");
			String description = SmartCity.myObj.next();
			SmartCity.JobList.add(new Job(title, description));
			DBhandler.insertJob(new Job(title, description));
			
			System.out.print("Added Successfully!");
			break;
		}
		default:
			System.out.println("Invalid Choice!");
		}
        
    }

    @FXML
    private void handleDeleteButton() 
    {
    	SmartCity.myObj  = new Scanner(System.in);
    	System.out.println("What do you want to delete?");
        System.out.println("1. Tourist attraction");
        System.out.println("2. Academic Institution");
        System.out.println("3. News");
        System.out.println("4. Job");
        System.out.print("Enter Choice: ");
        int choice = SmartCity.myObj.nextInt();
        
        switch (choice)
		{
		case 1:
		{
			System.out.print("Enter name of tourist attraction: ");
			String name = SmartCity.myObj.next();
			
			for(Tourism T: SmartCity.TourismList)
	    	{
	    		if(T.getName().equals(name))
	    		{
	    			SmartCity.TourismList.remove(T);
	    			DBhandler.deleteTourism(SmartCity.TourismList.indexOf(T));
	    			System.out.print("Removed Successfully!");
	    			
	    			return;
	    		}
	    	}
			
			System.out.print("Not found!");
			break;
		}
		case 2:
		{
			System.out.print("Enter name of institute: ");
			String name = SmartCity.myObj.next();
			
			for(AcademicInstitutions A: SmartCity.InstitutionList)
	    	{
	    		if(A.getName().equals(name))
	    		{
	    			SmartCity.InstitutionList.remove(A);
	    			DBhandler.deleteAcademicInstitutions(SmartCity.InstitutionList.indexOf(A));
	    			System.out.print("Removed Successfully!");
	    			
	    			return;
	    		}
	    	}
			
			System.out.print("Not found!");
			break;
		}
		case 3:
		{
			System.out.print("Enter news title: ");
			String name = SmartCity.myObj.next();
			
			for(News N: SmartCity.NewsList)
	    	{
	    		if(N.getTitle().equals(name))
	    		{
	    			SmartCity.NewsList.remove(N);
	    			DBhandler.deleteNews(SmartCity.NewsList.indexOf(N));
	    			System.out.print("Removed Successfully!");
	    			
	    			return;
	    		}
	    	}
			
			System.out.print("Not found!");
			break;
		}
		case 4:
		{
			System.out.print("Enter job title: ");
			String name = SmartCity.myObj.next();
			
			for(Job J: SmartCity.JobList)
	    	{
	    		if(J.getTitle().equals(name))
	    		{
	    			SmartCity.JobList.remove(J);
	    			DBhandler.deleteJob(name);
	    			System.out.print("Removed Successfully!");
	    			
	    			return;
	    		}
	    	}
			
			System.out.print("Not found!");
			break;
		}
		default:
			System.out.println("Invalid Choice!");
		}
    }

    @FXML
    private void handleUpdateButton() 
    {
        SmartCity.myObj = new Scanner(System.in);
        System.out.println("What do you want to update?");
        System.out.println("1. Tourist attraction");
        System.out.println("2. Academic Institution");
        System.out.println("3. News");
        System.out.println("4. Job");
        System.out.print("Enter Choice: ");
        int choice = SmartCity.myObj.nextInt();

        switch (choice) 
        {
            case 1: 
            {
                System.out.print("Enter name of tourist attraction to update: ");
                String name = SmartCity.myObj.next();

                for (Tourism T : SmartCity.TourismList) 
                {
                    if (T.getName().equals(name)) 
                    {
                        System.out.print("Enter new location for the tourist attraction: ");
                        String newLocation = SmartCity.myObj.next();
                        T.setLocation(newLocation);
                        DBhandler.updateTourism(name, T);
                        System.out.println("Updated Successfully!");

                        return;
                    }
                }

                System.out.print("Not found!");
                break;
            }
            case 2: 
            {
                System.out.print("Enter name of institute to update: ");
                String name = SmartCity.myObj.next();

                for (AcademicInstitutions A : SmartCity.InstitutionList) 
                {
                    if (A.getName().equals(name)) 
                    {
                        System.out.print("Enter new capacity for the academic institution: ");
                        int newCapacity = SmartCity.myObj.nextInt();
                        A.setCapacity(newCapacity);
                        DBhandler.updateAcademicInstitutions(name, A);
                        System.out.println("Updated Successfully!");

                        return;
                    }
                }

                System.out.print("Not found!");
                break;
            }
            case 3: 
            {
                System.out.print("Enter news title to update: ");
                String title = SmartCity.myObj.next();

                for (News N : SmartCity.NewsList) 
                {
                    if (N.getTitle().equals(title)) 
                    {
                        // Perform the update logic, for example:
                        System.out.print("Enter new description for the news: ");
                        String newDescription = SmartCity.myObj.next();
                        N.setDescription(newDescription);
                        DBhandler.updateNews(title, N);
                        System.out.println("Updated Successfully!");

                        return;
                    }
                }

                System.out.print("Not found!");
                break;
            }
            case 4: 
            {
                System.out.print("Enter job title to update: ");
                String title = SmartCity.myObj.next();

                for (Job J : SmartCity.JobList) 
                {
                    if (J.getTitle().equals(title)) 
                    {
                        // Perform the update logic, for example:
                        System.out.print("Enter new description for the job: ");
                        String newDescription = SmartCity.myObj.next();
                        J.setDescription(newDescription);
                        DBhandler.updateJob(title, J);
                        System.out.println("Updated Successfully!");

                        return;
                    }
                }

                System.out.print("Not found!");
                break;
            }
            default:
                System.out.println("Invalid Choice!");
        }
    }


    @FXML
    private void handleSearchButton() 
    {	
    	SmartCity.myObj  = new Scanner(System.in);
    	System.out.println("What do you want to search?");
        System.out.println("1. Tourist attraction");
        System.out.println("2. Academic Institution");
        System.out.println("3. News");
        System.out.println("4. Job");
        System.out.print("Enter Choice: ");
        int choice = SmartCity.myObj.nextInt();
        
        switch (choice)
		{
		case 1:
		{
			for(Tourism T: SmartCity.TourismList)
	    	{
	    		T.Display();
	    	}
			break;
		}
		case 2:
		{
			for(AcademicInstitutions A : SmartCity.InstitutionList)
	    	{
	    		A.Display();
	    	}
			break;
		}
		case 3:
		{
			for(News N : SmartCity.NewsList)
	    	{
	    		N.Display();
	    	}
			break;
		}
		case 4:
		{
			for(Job J : SmartCity.JobList)
	    	{
	    		J.Display();
	    	}
			break;
		}
		default:
			System.out.println("Invalid Choice!");
		}
    }
}
