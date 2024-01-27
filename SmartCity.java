package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;
import java.util.Scanner;

public class SmartCity extends Application 
{
	static List<Tourism> TourismList;
	static List<AcademicInstitutions> InstitutionList;
	static List<News> NewsList;
	static List<Job> JobList;
	static Scanner myObj;
	
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SmartCity.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 815, 600);

        primaryStage.setTitle("Smart City");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void loadMap()
    {
    	TourismList = DBhandler.loadTourismData();
    	
    	InstitutionList = DBhandler.loadAcademicInstitutionsData();
    	
    	NewsList = DBhandler.loadNewsData();
    	
    	JobList = DBhandler.loadJobData();
    }

    public static void main(String[] args) 
    {
    	loadMap();
        launch(args);
        
        myObj.close();
    }
}

