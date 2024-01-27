package application;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBhandler 
{
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/smartcity";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "&Ronaldo7";

    // Load data into LinkedLists
    public static List<Tourism> loadTourismData() 
    {
        List<Tourism> tourismList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM TOURISM")) 
        {

            while (resultSet.next()) 
            {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");

                Tourism tourism = new Tourism(type, name, location);
                tourismList.add(tourism);
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return tourismList;
    }

    public static List<AcademicInstitutions> loadAcademicInstitutionsData() 
    {
    	List<AcademicInstitutions> academicInstitutionsList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM AcademicInstitutes")) 
        {

            while (resultSet.next()) 
            {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                String location = resultSet.getString("location");
                int capacity = resultSet.getInt("capacity");

                AcademicInstitutions academicInstitution = new AcademicInstitutions(type, name, location, capacity);
                academicInstitutionsList.add(academicInstitution);
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return academicInstitutionsList;
    }

    public static List<News> loadNewsData() 
    {
    	List<News> newsList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM NEWS")) 
        {
            while (resultSet.next()) 
            {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                News news = new News(title, description);
                newsList.add(news);
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return newsList;
    }
    
    public static List<Job> loadJobData() 
    {
        List<Job> jobList = new LinkedList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM JOBS")) 
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) 
            {
                String title = resultSet.getString("Title");
                String description = resultSet.getString("Description");

                Job job = new Job(title, description);
                jobList.add(job);
            }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return jobList;
    }


    // Insert query for each class
    public static void insertTourism(Tourism tourism) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TOURISM (type, name, location) VALUES (?, ?, ?)")) 
        {
            preparedStatement.setString(1, tourism.getType());
            preparedStatement.setString(2, tourism.getName());
            preparedStatement.setString(3, tourism.getLocation());

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void insertAcademicInstitutions(AcademicInstitutions academicInstitution) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO AcademicInstitutes (type, name, location, capacity) VALUES (?, ?, ?, ?)")) 
        {
            preparedStatement.setString(1, academicInstitution.getType());
            preparedStatement.setString(2, academicInstitution.getName());
            preparedStatement.setString(3, academicInstitution.getLocation());
            preparedStatement.setInt(4, academicInstitution.getCapacity());

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void insertNews(News news) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO NEWS (title, description) VALUES (?, ?)")) 
        {
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getDescription());

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void insertJob(Job job) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO JOBS (Title, Description) VALUES (?, ?)")) 
        {
            preparedStatement.setString(1, job.getTitle());
            preparedStatement.setString(2, job.getDescription());

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    // Delete query for each class
    public static void deleteTourism(int id) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM TOURISM WHERE ID = ?")) 
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void deleteAcademicInstitutions(int id) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM AcademicInstitutes WHERE ID = ?")) 
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void deleteNews(int id) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM NEWS WHERE ID = ?")) 
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void deleteJob(String title) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM JOBS WHERE Title = ?")) 
        {
            preparedStatement.setString(1, title);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update query for each class
    public static void updateTourism(String name, Tourism updatedTourism) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE TOURISM SET type = ?, location = ? WHERE name = ?")) 
        {
            preparedStatement.setString(1, updatedTourism.getType());
            preparedStatement.setString(2, updatedTourism.getLocation());
            preparedStatement.setString(3, name);

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void updateAcademicInstitutions(String name, AcademicInstitutions updatedAcademicInstitution) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE AcademicInstitutes SET type = ?, location = ?, capacity = ? WHERE name = ?")) 
        {
            preparedStatement.setString(1, updatedAcademicInstitution.getType());
            preparedStatement.setString(2, updatedAcademicInstitution.getLocation());
            preparedStatement.setInt(3, updatedAcademicInstitution.getCapacity());
            preparedStatement.setString(4, name);

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void updateNews(String title, News updatedNews) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE NEWS SET description = ? WHERE title = ?")) 
        {
            preparedStatement.setString(1, updatedNews.getDescription());
            preparedStatement.setString(2, title);

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public static void updateJob(String title, Job updatedJob) 
    {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE JOBS SET Title = ?, Description = ? WHERE Title = ?")) 
        {
            preparedStatement.setString(1, updatedJob.getTitle());
            preparedStatement.setString(2, updatedJob.getDescription());
            preparedStatement.setString(3, title);

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
